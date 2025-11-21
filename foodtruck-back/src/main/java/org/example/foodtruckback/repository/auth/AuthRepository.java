package org.example.foodtruckback.repository.auth;

import org.example.foodtruckback.common.constants.auth.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
}
