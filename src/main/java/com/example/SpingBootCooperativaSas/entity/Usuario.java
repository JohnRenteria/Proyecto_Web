package com.example.SpingBootCooperativaSas.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Usuario {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name="email")
    private String email;

    @Column(name="imagen")
    private String imagen;

    @Column(name="nonusuario")
    private String nonusuario;

    public Usuario(String email, String imagen, String nonusuario) {
        this.id = id;
        this.email = email;
        this.imagen = imagen;
        this.nonusuario = nonusuario;
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNonusuario() {
        return nonusuario;
    }

    public void setNonusuario(String nonusuario) {
        this.nonusuario = nonusuario;
    }
}
