/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenA.service;
import com.examenA.entity.Conciertos;
import java.util.List;
/**
 *
 * @author Andra Mckenzie Araya
 */
public interface IConciertosService {
    public List<Conciertos> getAllConciertos();
    public Conciertos getConciertosById (long id);
    public void saveConciertos(Conciertos Conciertos);
    public void delete (long id);
}
