package io.meighen.service_bulder.service.consumers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.meighen.service_bulder.entity.Module;
import io.meighen.service_bulder.entity.ModuleInfo;
import io.meighen.service_bulder.repository.ModuleRepository;
import io.meighen.service_bulder.repository.TemplateCreateDeploymentRepository;
import io.meighen.service_bulder.service.builders.Builder_SQL;
import io.meighen.service_bulder.service.builders.Template;
import io.meighen.service_bulder.service.deployers.MainDeployer;
import io.meighen.service_bulder.service.producers.KafkaProducer;
import io.meighen.service_bulder.entity.TemplateCreateDeployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @Autowired
    Builder_SQL builderSql;

    @Autowired
    MainDeployer mainDeployer;

    @Autowired
    Template template;

    @Autowired
    KafkaProducer kafkaProducer;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    TemplateCreateDeploymentRepository templateCreateDeploymentRepository;

    TemplateCreateDeployment findMaxBuildOf(List<TemplateCreateDeployment> events) {
        if (events == null || events.isEmpty()) {
            return null;
        }

        Comparator<TemplateCreateDeployment> buildAgeComparator = Comparator
                .comparing(TemplateCreateDeployment::getDateModification);

        return events.stream()
                .max(buildAgeComparator)
                .get();
    }

    @KafkaListener(topics = "create_topic",
            groupId = "group_id")
    public void consumeBuildDeploy(String message) throws IOException, URISyntaxException {
        // Print statement
        System.out.println("message = " + message);

        Module module = moduleRepository.findByUuid(message);
//        String name = builderSql.build(module.getBody());

        TemplateCreateDeployment temp = findMaxBuildOf(module.getTemplateCreateDeployment()); // mainDeployer.build(name.toLowerCase());

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        kafkaProducer.createDeployment(
                ow.writeValueAsString(temp)
        );

    }

    @KafkaListener(topics = "build_topic",
            groupId = "group_id")
    public void consumeOnlyBuild(String message) throws IOException, URISyntaxException {
        // Print statement
        System.out.println("message = " + message);
        Module module = moduleRepository.findByUuid(message);

        if (!(module.getModuleInfo().getStatus().equals("validated") ||
                (module.getModuleInfo().getStatus().equals("deployed") && module.getModuleInfo().getState() < 1) ||
                (module.getModuleInfo().getStatus().equals("built") && module.getModuleInfo().getState() < 1))) {
            System.err.println("Module " + module.getUuid() + " has not built!");
            return;
        }

        String name = builderSql.build(module.getBody());

        TemplateCreateDeployment temp = mainDeployer.build(name.toLowerCase());
        LocalDateTime localDateTime = LocalDateTime.now();
        temp.setDateCreation(localDateTime);
        temp.setDateModification(localDateTime);
        temp.setUuid(String.valueOf(UUID.randomUUID()));
        temp.setLastModifier(null); // Technical user

        // Внимание, хардкод!
        // Сделано исключительно для локального запуска.
        temp.setRegistry_host("host.minikube.internal:31000"); // TODO: изменить при выкатке на другой реджистри

        templateCreateDeploymentRepository.save(temp);

        List list = module.getTemplateCreateDeployment();
        if (list == null)
            list = new ArrayList();
        list.add(temp);
        module.setTemplateCreateDeployment(list);

        ModuleInfo moduleInfo = module.getModuleInfo();
        moduleInfo.setStatus("built");
        moduleInfo.setState(1);

        moduleRepository.save(module);
    }

    @KafkaListener(topics = "test_topic",
            groupId = "group_id")
    public void consumeTest(String message) throws URISyntaxException, IOException {
        // Print statement
        System.out.println("message = " + message);
//        mainDeployer.deploy(message.toLowerCase());
        template.execute();
    }
}