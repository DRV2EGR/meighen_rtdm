package io.meighen.service_bulder.repository;

import io.meighen.service_bulder.entity.Module;
import io.meighen.service_bulder.entity.TemplateCreateDeployment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateCreateDeploymentRepository extends JpaRepository<TemplateCreateDeployment, Long> {
}
