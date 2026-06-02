package com.sapana.auth.repository;

import com.sapana.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}
