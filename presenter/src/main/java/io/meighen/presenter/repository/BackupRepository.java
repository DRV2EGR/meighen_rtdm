package io.meighen.presenter.repository;

import io.meighen.presenter.entity.Backup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackupRepository extends JpaRepository<Backup, Long> {
    Backup findByUuid(String uuid);
}
