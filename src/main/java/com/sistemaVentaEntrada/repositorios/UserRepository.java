package com.sistemaVentaEntrada.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.sistemaVentaEntrada.modelo.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
