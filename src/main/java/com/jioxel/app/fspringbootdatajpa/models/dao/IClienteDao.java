package com.jioxel.app.fspringbootdatajpa.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.jioxel.app.fspringbootdatajpa.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
