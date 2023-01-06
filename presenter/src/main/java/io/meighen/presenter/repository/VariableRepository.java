package io.meighen.presenter.repository;

import io.meighen.presenter.entity.Variable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VariableRepository extends JpaRepository<Variable, Long> {
    Page<Variable> findAllByOrderByName(Pageable pageable);
    Page<Variable> findAllByOrderByDateCreationAsc(Pageable pageable);
    Page<Variable> findAllByNameContainingOrderByDateCreationAsc(String name, Pageable pageable);
    Page<Variable> findAllByOrderByDateModificationAsc(Pageable pageable);
    Page<Variable> findAllByNameContainingOrderByDateModificationAsc(String name, Pageable pageable);

    Page<Variable> findAllByNameContaining(String name, Pageable pageable);
    @Query("select var from Variable var order by var.lastModifier.firstName asc")
    Page<Variable> findAllOrderByLastModifier_FirstNameAsc(Pageable pageable);
    Page<Variable> findAllByNameContainingOrderByLastModifier_FirstNameAsc(String lastModifier_firstName, Pageable pageable);

    Variable findByUuid(String uuid);
}
