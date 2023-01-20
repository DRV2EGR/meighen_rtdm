package io.meighen.presenter.repository;

import io.meighen.presenter.entity.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    Page<Module> findAllByOrderByName(Pageable pageable);
    Page<Module> findAllByOrderByDateCreationAsc(Pageable pageable);
    Page<Module> findAllByNameContainingOrderByDateCreationAsc(String name, Pageable pageable);
    Page<Module> findAllByOrderByDateModificationAsc(Pageable pageable);
    Page<Module> findAllByNameContainingOrderByDateModificationAsc(String name, Pageable pageable);

    Page<Module> findAllByNameContaining(String name, Pageable pageable);
    @Query("select module from Module module order by module.lastModifier.firstName asc")
    Page<Module> findAllOrderByLastModifier_FirstNameAsc(Pageable pageable);
    Page<Module> findAllByNameContainingOrderByLastModifier_FirstNameAsc(String lastModifier_firstName, Pageable pageable);

    Module findByUuid(String uuid);
}
