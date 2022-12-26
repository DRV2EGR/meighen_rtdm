package io.meighen.guarder.repository;

import io.meighen.guarder.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Refresh token repository.
 */
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}
