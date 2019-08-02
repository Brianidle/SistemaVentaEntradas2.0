package com.sistemaVentaEntrada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaVentaEntrada.modelo.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
