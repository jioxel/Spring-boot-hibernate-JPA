package com.jioxel.app.fspringbootdatajpa.models.dao;

import java.util.List;

import com.jioxel.app.fspringbootdatajpa.models.entity.Cliente;

public interface IClienteDao {
     public List<Cliente> findAll();
     public void save(Cliente cliente);
}
