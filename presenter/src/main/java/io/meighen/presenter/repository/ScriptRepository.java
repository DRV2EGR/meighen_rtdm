package io.meighen.presenter.repository;

import io.meighen.presenter.entity.objects.Module;
import io.meighen.presenter.entity.objects.Script;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScriptRepository extends JpaRepository<Script, Long> {
    Page<Script> findAllByOrderByName(Pageable pageable);
    Page<Script> findAllByOrderByDateCreation(Pageable pageable);
    Page<Script> findAllByNameContainingOrderByDateCreation(String name, Pageable pageable);
    Page<Script> findAllByOrderByDateModification(Pageable pageable);
    Page<Script> findAllByNameContainingOrderByDateModification(String name, Pageable pageable);
    Page<Script> findAllByNameContaining(String name, Pageable pageable);
    Page<Script> findAllByLastModifier_FirstName(String lastModifier_firstName, Pageable pageable);
}
