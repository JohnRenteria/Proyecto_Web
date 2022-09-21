package com.example.SpingBootCooperativaSas.service;

import com.example.SpingBootCooperativaSas.entity.Cliente;
import com.example.SpingBootCooperativaSas.entity.Creditos;
import com.example.SpingBootCooperativaSas.repository.RepositorioCliente;
import com.example.SpingBootCooperativaSas.repository.RepositorioCreditos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SrvicioImpCredito {
    @Autowired
    private RepositorioCreditos rc;

    @Autowired
    private RepositorioCliente rcli;

    /*public SrvicioImpCredito(RepositorioCreditos rc, RepositorioCliente rcli) {
        this.rc = rc;
        this.rcli = rcli;
    }*/


    public List<Creditos> listarCreditos() {


        return rc.findAll();
    }




    public Creditos guardarCredisto(String documento, Creditos creditos) {

        return rcli.findById(documento)
                .map(cliente->{
                    creditos.setCliente(cliente);
                    return  rc.save(creditos);

                }).get();
    }
}
