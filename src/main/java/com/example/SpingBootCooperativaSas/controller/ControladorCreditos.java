package com.example.SpingBootCooperativaSas.controller;


import com.example.SpingBootCooperativaSas.entity.Creditos;
import com.example.SpingBootCooperativaSas.service.SrvicioImpCredito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api")
@RestController
public class ControladorCreditos {

    @Autowired
    private SrvicioImpCredito sic;


    @GetMapping
    public List<Creditos> listar(){

        return sic.listarCreditos();
    }


    @PostMapping("/prestamo/{documento}/creditosos")
    public Creditos insertar(@PathVariable String documento ,@Validated @RequestBody Creditos creditos) {

       return sic.guardarCredisto(documento,creditos);



    }





}
