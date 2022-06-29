/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenA.controller;
import com.examenA.entity.Conciertos;
import com.examenA.service.IConciertosService;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**

 * @author Andra Mckenzie Araya
 */
@Controller//definimos que es tipo controller
public class ConciertosController {

    @Autowired
    private IConciertosService ConciertosService;

    @GetMapping("/Conciertos")
    public String index(Model model) {
        List<Conciertos> listaConciertos = ConciertosService.getAllConciertos();
        model.addAttribute("titulo", "Lista de conciertos");
        model.addAttribute("Conciertos", listaConciertos);
        return "Conciertos";
    }

   
    @GetMapping("/ConciertosN")
    public String crearConciertos(Model model) {
        model.addAttribute("Conciertos", new Conciertos());
        return "crear";
    }

    
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Conciertos Conciertos) {
       ConciertosService.saveConciertos(Conciertos);
        return "redirect:/Conciertos";
    }

    @GetMapping("/editConciertos/{id}")
    public String editarConciertos(@PathVariable("id") Long idConciertos, Model model) {
       Conciertos Conciertos = ConciertosService.getConciertosById(idConciertos);
       List<Conciertos> listaConciertos = ConciertosService.getAllConciertos(); 
       model.addAttribute("Conciertos", Conciertos);
        model.addAttribute("Conciertos", listaConciertos);
        return "crear";
    }

    @GetMapping("/delete/{id}")
    public String eliminarConciertos(@PathVariable("id") Long idConciertos) {
        ConciertosService.delete(idConciertos);
        return "redirect:/Conciertos";
    }

}