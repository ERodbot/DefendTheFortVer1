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
public class DefensaBloque extends Entity{
    
    
    
    
    DefensaBloque(String nombre, int vida, int cantidadGolpes, int nivel, int campos, int nivelAparicion, Tablero grid){
        super(nombre,vida,cantidadGolpes,nivel,campos,nivelAparicion, grid);
        
    }

    @Override
    public void atacar() {
        return;
    }

    @Override
    public Tile determineObjective() {
       return null;
    }

   @Override
    public void mover(){
        
    }
    
}

