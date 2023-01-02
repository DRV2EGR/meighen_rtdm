package io.meighen.presenter.repository;

import java.util.List;

import io.meighen.presenter.entity.User;
import io.meighen.presenter.entity.objects.Module;
import io.meighen.presenter.entity.objects.Script;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    Page<Module> findAllByOrderByName(Pageable pageable);
    Page<Module> findAllByOrderByDateCreation(Pageable pageable);
    Page<Module> findAllByNameContainingOrderByDateCreation(String name, Pageable pageable);
    Page<Module> findAllByOrderByDateModification(Pageable pageable);
    Page<Module> findAllByNameContainingOrderByDateModification(String name, Pageable pageable);

    Page<Module> findAllByNameContaining(String name, Pageable pageable);
    Page<Module> findAllByLastModifier_FirstName(String lastModifier_firstName, Pageable pageable);

    Module findByUuid(String uuid);
}
