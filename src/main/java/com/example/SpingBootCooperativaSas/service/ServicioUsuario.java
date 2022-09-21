package com.example.SpingBootCooperativaSas.service;

import com.example.SpingBootCooperativaSas.entity.Usuario;
import com.example.SpingBootCooperativaSas.repository.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service

public class ServicioUsuario {
    private RepositorioUsuario repositorioUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }
    public Usuario guardarUsuario(Usuario usuario){
        return this.repositorioUsuario.save(usuario);
    }
    public Usuario buscarPorEmail(String email){
        return this.repositorioUsuario.findByEmail(email);
    }
    public Usuario obtenerUsuario(Map<String,Object> datoUsuario){
        String email=(String) datoUsuario.get("email");
        Usuario usuario=buscarPorEmail(email);
        if(usuario==null){
            String nombre=(String) datoUsuario.get("nickname");
            String imagen=(String) datoUsuario.get("picture");
            String correo=(String) datoUsuario.get("email");
            Usuario usu=new Usuario(correo,imagen,nombre);
            return guardarUsuario(usu);
        }
        System.out.print(usuario.getEmail());
        return usuario;
    }
}
