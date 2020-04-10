package com.rostenross.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import com.rostenross.springboot.app.models.entity.Cliente;
import com.rostenross.springboot.app.models.entity.Factura;
import com.rostenross.springboot.app.models.entity.Producto;
import com.rostenross.springboot.app.models.service.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {
    @Autowired
    private IClienteService clienteService;
    
    @GetMapping("/form/{clienteId}")
    public String crear(@PathVariable (value="clienteId") Long clienteId, 
            Map<String, Object> model, 
            RedirectAttributes flash){

        Cliente cliente= clienteService.findOne(clienteId);
        if (cliente == null) {
            flash.addFlashAttribute("error","El cliente no existe en la base de datos!!");
            return "redirect:/listar";
        }
        Factura factura= new  Factura();
        factura.setCliente(cliente);
        model.put("fatura", factura);
        model.put("titulo", "Crear Factura");

        return "factura/form";
    }
    
    @GetMapping(value="/cargar-producto/{term}", produces={"aplication/json"})
    public @ResponseBody List<Producto> cargarProductos(@PathVariable String term){
        return clienteService.findByNombre(term);
    }
}