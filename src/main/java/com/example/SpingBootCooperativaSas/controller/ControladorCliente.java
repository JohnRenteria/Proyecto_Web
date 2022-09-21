package com.example.SpingBootCooperativaSas.controller;


import com.example.SpingBootCooperativaSas.entity.Cliente;
import com.example.SpingBootCooperativaSas.entity.Usuario;
import com.example.SpingBootCooperativaSas.service.ServicioImpCliente;
import com.example.SpingBootCooperativaSas.service.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@Controller
//@RequestMapping("/cliente")
public class ControladorCliente {
    @Autowired
    private ServicioUsuario servicioUsuario;
    @Autowired
    private ServicioImpCliente sic;

    public ControladorCliente(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal OidcUser principal) {
        if(principal!=null) {
            Usuario usuario=this.servicioUsuario.obtenerUsuario(principal.getClaims());
            System.out.print(principal.getClaims());
            model.addAttribute("usuario",usuario);
        }
        return "index";
    }

    @GetMapping("cliente")
    public String listar(Model modelo){
        modelo.addAttribute("clientes",sic.listarClientes());
        return ("taclientes");
    }




    @GetMapping("cliente/nuevo")
    public String formularioregistro(Model modelo){
        modelo.addAttribute("clienteinsertar",new Cliente());
        return "frmcliente";
    }



    @PostMapping("cliente/guarda")
    public String insertar(Cliente cli){
        sic.guardarClientes(cli);
        return "redirect:/cliente";
    }


    @GetMapping("cliente/actualizar/{dato}")
    public  String  formularioActualizar(@PathVariable("dato") String dato,Model modelo){
        Cliente cliente=sic.consultaClientesPorId(dato);
        modelo.addAttribute("clienteactualizar",cliente);
        return "frmactualizar";
    }




    @PostMapping("cliente/actualizar")
    public String actualizar( Cliente cli){
        sic.actualizarClientes(cli);
        return "redirect:/cliente";
    }




    @GetMapping("cliente/eliminar/{id}")
    public String eliminarpoId(@PathVariable("id") String id){
        sic.eliminarClientesId(id);
        return ("redirect:/cliente");
    }







}
