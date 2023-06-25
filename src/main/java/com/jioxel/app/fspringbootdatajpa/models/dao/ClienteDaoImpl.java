package com.jioxel.app.fspringbootdatajpa.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jioxel.app.fspringbootdatajpa.models.entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao{
     @PersistenceContext
     private EntityManager em;

     @Transactional(readOnly = true) //indicamos que solo es para consulta, solo lectura
     @Override
     public List<Cliente> findAll() {
          return em.createNamedQuery("from Cliente").getResultList();
     }
     
}
