/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort.Defensas;
import com.mycompany.defendthefort.Personaje;



/**
 *
 * @author em000
 */
public class DefensaContacto extends Personaje{
    
    
    
    
    DefensaContacto(String nombre, int vida, int cantidadGolpes, int nivel, int campos, int nivelAparicion){
        super(nombre,vida,cantidadGolpes,nivel,campos,nivelAparicion);
        
    }

    @Override
    public void atacar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void morir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

