package com.rhuan.gerenciamento_clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rhuan.gerenciamento_clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}