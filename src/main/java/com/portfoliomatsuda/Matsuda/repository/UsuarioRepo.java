package com.portfoliomatsuda.Matsuda.repository;

import com.portfoliomatsuda.Matsuda.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<User, Long> {
}
