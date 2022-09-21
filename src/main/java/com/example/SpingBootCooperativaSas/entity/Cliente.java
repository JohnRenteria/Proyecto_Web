package com.example.SpingBootCooperativaSas.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Clientes")
public class Cliente   {
    @Id
    private String documento;
    @Column(nullable = false, length = 30)
    private String  nombre;
    @Column(nullable = false,length = 30 )
    private String apellido;
    @Column(nullable = false, length = 25,unique = true)
    private String correo;
    @Column(nullable = false, length = 15)
    private String celular;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "cliente")
    private Set<Creditos> creditos;
    //private Set<Creditos> creditos = new HashSet<Creditos>();


    public Cliente(String documento, String nombre, String apellido, String correo, String celular) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
    }

    public Cliente() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }



}
