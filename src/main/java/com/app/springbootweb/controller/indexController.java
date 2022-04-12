package com.app.springbootweb.controller;

import com.app.springbootweb.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class indexController {
    @GetMapping({"/index","/","/home",""})
    public String index(Model model){
        model.addAttribute("titulo","Hola spring framework");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario("alexis","rojas","Alexis@alexis.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){


        model.addAttribute("titulo", "Lista de Estudiantes");

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarusuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("alexis","rojas","Alexis@alexis.com"));
        usuarios.add(new Usuario("alexis2","rojas2","Alexis@alexis.com2"));
        usuarios.add(new Usuario("alexis3","rojas3","Alexis@alexis.com3"));

        return  usuarios;

    }
}
