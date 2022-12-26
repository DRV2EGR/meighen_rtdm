package io.meighen.presenter.repository;

import io.meighen.presenter.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Refresh token repository.
 */
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}
