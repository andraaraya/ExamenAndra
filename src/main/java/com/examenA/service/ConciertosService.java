/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenA.service;
import com.examenA.entity.Conciertos;
import com.examenA.repository.ConciertosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andra Mckenzie Araya
 */
@Service
public class ConciertosService implements IConciertosService { 
    
    @Autowired
    private ConciertosRepository ConciertosRepository;

    @Override
    public List<Conciertos> getAllConciertos() {
        return (List<Conciertos>) ConciertosRepository.findAll();
    }

    @Override
    public Conciertos getConciertosById(long id) {
         return ConciertosRepository.findById(id).orElse(null);
    }

    @Override
    public void saveConciertos(Conciertos Conciertos) {
         ConciertosRepository.save(Conciertos);
    }

    @Override
    public void delete(long id) {
        ConciertosRepository.deleteById(id);
    }
}
