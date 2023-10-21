package io.meighen.presenter.repository;

import io.meighen.presenter.entity.Module;
import io.meighen.presenter.entity.ModuleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleInfoReposirory extends JpaRepository<ModuleInfo, Long> {
}
