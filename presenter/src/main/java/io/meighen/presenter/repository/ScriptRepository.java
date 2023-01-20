package io.meighen.presenter.repository;

import io.meighen.presenter.entity.Script;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScriptRepository extends JpaRepository<Script, Long> {
    Page<Script> findAllByOrderByName(Pageable pageable);
    Page<Script> findAllByOrderByDateCreationAsc(Pageable pageable);
    Page<Script> findAllByNameContainingOrderByDateCreationAsc(String name, Pageable pageable);
    Page<Script> findAllByOrderByDateModificationAsc(Pageable pageable);
    Page<Script> findAllByNameContainingOrderByDateModificationAsc(String name, Pageable pageable);
    Page<Script> findAllByNameContaining(String name, Pageable pageable);
    @Query("select script from Script script order by script.lastModifier.firstName asc")
    Page<Script> findAllOrderByLastModifier_FirstNameAsc(Pageable pageable);
    Page<Script> findAllByNameContainingOrderByLastModifier_FirstNameAsc(String lastModifier_firstName, Pageable pageable);

    Script findByUuid(String uuid);
}
