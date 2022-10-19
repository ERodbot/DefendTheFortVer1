/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort;
import com.mycompany.defendthefort.Entity;
import com.mycompany.defendthefort.Tablero;
import com.mycompany.defendthefort.Tile;



/**
 *
 * @author em000
 */
public class DefensaAereo extends Entity{
    
    
    
    
    DefensaAereo(String nombre, int vida, int cantidadGolpes, int nivel, int campos, int nivelAparicion, Tablero grid){
        super(nombre,vida,cantidadGolpes,nivel,campos,nivelAparicion, grid);
        
    }

    @Override
    public void atacar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Tile determineObjective() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}

