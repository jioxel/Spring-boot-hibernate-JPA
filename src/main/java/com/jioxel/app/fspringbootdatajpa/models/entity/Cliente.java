package com.jioxel.app.fspringbootdatajpa.models.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "clientes") //indica el nombre de la tabla
public class Cliente implements Serializable{

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementable
     private Long id;

     private String nombre;
     private String apellido;
     private String email;

     @Column(name = "create_at") //Indica el nombre de la columna de la tabla
     @Temporal(TemporalType.DATE) //formato de como se va a guardar
     private Date createAt;

     private static final long serialVersionUID = 1L;

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public String getApellido() {
          return apellido;
     }

     public void setApellido(String apellido) {
          this.apellido = apellido;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public Date getCreateAt() {
          return createAt;
     }

     public void setCreateAt(Date creareAt) {
          this.createAt = creareAt;
     }

     public static long getSerialversionuid() {
          return serialVersionUID;
     }

}
