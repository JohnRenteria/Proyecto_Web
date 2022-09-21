package com.example.SpingBootCooperativaSas.repository;

import com.example.SpingBootCooperativaSas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, String> {
    Usuario findByEmail(String email);
}
