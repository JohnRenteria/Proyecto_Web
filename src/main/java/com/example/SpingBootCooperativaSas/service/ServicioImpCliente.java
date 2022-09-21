package com.example.SpingBootCooperativaSas.service;


import com.example.SpingBootCooperativaSas.entity.Cliente;
import com.example.SpingBootCooperativaSas.repository.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class ServicioImpCliente implements ServicioCliente {
    @Autowired
    private RepositorioCliente repositorioCliente;

    @Override
    public List<Cliente> listarClientes() {
        return repositorioCliente.findAll();
    }

   @Override
    public Cliente guardarClientes(Cliente cliente) {
        return repositorioCliente.save(cliente);
    }

    @Override
    public Cliente consultaClientesPorId(String documento) {
        return repositorioCliente.findById(documento).get() ;
    }

    @Override
    public Cliente actualizarClientes(Cliente cliente) {
        return repositorioCliente.save(cliente);
    }

    //@Override
    //public void eliminarClientes(Integer documento) {
     //   repositorioCliente.deleteById(documento);
   // }


    @Override
    public void eliminarClientesId(String documento) {
        repositorioCliente.deleteById(documento);


    }

    @Override
    public Cliente actualizarPorId(String doc , Map<Object,Object> objectMap){
        Cliente cli=repositorioCliente.findById(doc).get();
        objectMap.forEach((key,value)->{
            Field field= ReflectionUtils.findField(Cliente.class,(String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, cli,value);
        });
        return  repositorioCliente.save(cli);
    }


}
