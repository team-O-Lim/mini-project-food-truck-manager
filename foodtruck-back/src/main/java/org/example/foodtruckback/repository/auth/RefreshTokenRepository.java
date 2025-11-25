package org.example.foodtruckback.repository.auth;

import org.example.foodtruckback.common.constants.auth.Auth;
import org.example.foodtruckback.entity.auth.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
}
