package com.main.repository;

import com.main.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Students, Integer> {
    Optional<Students> findByUsername(String username);
}
