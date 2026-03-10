package com.authentication.simple_authetication.repository;

import com.authentication.simple_authetication.model.entity.Users;
import com.authentication.simple_authetication.model.projection.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {

    @Query(value = """
            select u.username as username, u."password" as passwordd, u."role" as roleName
            from users u where u.username = :username and u.password = :password
            """, nativeQuery = true)
    UserView getUserDataByUsernameAndPassword(String username, String password);

    Optional<Users> findByUsername(String username);
}
