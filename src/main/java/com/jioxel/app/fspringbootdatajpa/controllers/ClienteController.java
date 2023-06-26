package com.jioxel.app.fspringbootdatajpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jioxel.app.fspringbootdatajpa.models.entity.Cliente;
import com.jioxel.app.fspringbootdatajpa.models.service.IClienteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@SessionAttributes("cliente")
public class ClienteController {

     @Autowired
     private IClienteService clienteService;

     @RequestMapping(value = "listar",method = RequestMethod.GET)
     public String listar(Model model){
          model.addAttribute("title", "Listado de clientes");
          model.addAttribute("clientes", clienteService.findAll());
          return "listar";
     }

     @GetMapping("/form")
     public String crear(Model model){
          Cliente cliente = new Cliente();

          model.addAttribute("cliente", cliente);
          model.addAttribute("title", "Formulario de Cliente");
          return "form";
     }
     @GetMapping("/form/{id}")
     public String editar(@PathVariable(value="id") Long id, Model model){
          Cliente cliente = null;
          if(id>0){
               cliente = clienteService.findOne(id);
          }else{
               return "redirect:/listar";
          }
          model.addAttribute("title", "Editar cliente");
          model. addAttribute("cliente", cliente);
          return "form";
     }
     @PostMapping("/form")
     public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
          if(result.hasErrors()){
               model.addAttribute("title", "Formulario de Cliente");
               return "form";
          }
          clienteService.save(cliente);
          status.setComplete();
          return "redirect:listar";
     }
     @GetMapping("/eliminar/{id}")
     public String eliminar(@PathVariable(value="id") Long id){
          if(id > 0){
               clienteService.delete(id);
          }
          return "redirect:/listar";
     }
}
