package com.example.SpingBootCooperativaSas.repository;

import com.example.SpingBootCooperativaSas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCliente extends JpaRepository<Cliente, String> {
}
