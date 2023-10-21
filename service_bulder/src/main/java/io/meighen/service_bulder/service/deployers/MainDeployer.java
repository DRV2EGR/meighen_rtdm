package io.meighen.service_bulder.service.deployers;

import io.meighen.service_bulder.docker.BuildImage;
import io.meighen.service_bulder.kubernetes.MyKuber.CreateDeployment;
import io.meighen.service_bulder.kubernetes.MyKuber.CreateService;
import io.meighen.service_bulder.repository.ModuleInfoReposirory;
import io.meighen.service_bulder.repository.ModuleRepository;
import io.meighen.service_bulder.entity.TemplateCreateDeployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainDeployer {
    private static final Logger logger = LoggerFactory.getLogger(MainDeployer.class);

    @Autowired
    BuildImage buildImage;

    @Autowired
    CreateDeployment createDeployment;

    @Autowired
    CreateService createService;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    ModuleInfoReposirory moduleInfoReposirory;

    public void deploy(String name) {
//        try {
//            buildImage.build(name);
//            logger.info("Service " + name + " built!");
//        } catch (Exception e) {
//            logger.error("Service " + name + " not built!", e.getCause());
//        }

        createDeployment.create(name, "host.minikube.internal:31000/"+name, 8080);
        createService.create(name);
    }

    public TemplateCreateDeployment build(String name) {
        try {
            TemplateCreateDeployment t = buildImage.build(name);
            logger.info("Service " + name + " built!");
            return t;
        } catch (Exception e) {
            logger.error("Service " + name + " not built!", e.getCause());
            return null;
        }
    }
}
