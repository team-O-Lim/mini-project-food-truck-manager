package org.example.foodtruckback.repository.user;

import org.example.foodtruckback.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
        select distinct u
        from User u
        left join fetch u.userRoles ur
        left join fetch ur.role r
        where u.name = :name
    """)
    Optional<User> findWithRoleByName(@Param("name") String name);

    Optional<User> findByName(String loginId);
}
