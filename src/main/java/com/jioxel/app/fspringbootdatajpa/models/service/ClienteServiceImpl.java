package com.jioxel.app.fspringbootdatajpa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jioxel.app.fspringbootdatajpa.models.dao.IClienteDao;
import com.jioxel.app.fspringbootdatajpa.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
     @Autowired
     private IClienteDao clienteDao;

     @Override
     @Transactional(readOnly = true) //indicamos que solo es para consulta, solo lectura
     public List<Cliente> findAll() {
          // TODO Auto-generated method stub
          return (List<Cliente>) clienteDao.findAll();
     }

     @Override
     @Transactional//indicamos que solo es para consulta, solo lectura
     public void save(Cliente cliente) {
          clienteDao.save(cliente);
     }

     @Override
     @Transactional(readOnly = true) //indicamos que solo es para consulta, solo lectura
     public Cliente findOne(Long id) {
          return clienteDao.findById(id).orElse(null);
     }

     @Override
     @Transactional //indicamos que solo es para consulta, solo lectura
     public void delete(Long id) {
          clienteDao.deleteById(id);
     }
     
}
