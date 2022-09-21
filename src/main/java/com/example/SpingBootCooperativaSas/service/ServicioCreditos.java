package com.example.SpingBootCooperativaSas.service;


import com.example.SpingBootCooperativaSas.entity.Creditos;

import java.util.List;

public interface ServicioCreditos {


    public List<Creditos> listarCreditos();
    public Creditos guardarCredisto(String documento, Creditos creditos);
}
