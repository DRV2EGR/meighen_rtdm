package io.meighen.presenter.repository;

import java.util.Optional;

import io.meighen.presenter.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Role repository.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
