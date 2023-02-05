package io.meighen.service_bulder.repository;

import io.meighen.service_bulder.entity.Script;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScriptRepository extends JpaRepository<Script, Long> {
    Script findScriptByName(String name);
}
