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
 * @author sebas
 */
public class DefensaMedio extends Entity{
    
    
    int range = 5;
    
    DefensaMedio(String nombre, int vida, int cantidadGolpes, int nivel, int campos, int nivelAparicion, Tablero grid){
        super(nombre,vida,cantidadGolpes,nivel,campos,nivelAparicion, grid);  
    }

    public void atacar() {
        Tile objective = determineObjective();
        if(objective!=null && !this.getFlyingEntities().contains(objective)){
        objective.personaje.substractLife(cantidadGolpes);
        if(objective.personaje.getLife() < 0)
            objective.personaje.morir();
        }
    }

    @Override
    public Tile determineObjective() {
        for(int i = getLocationY()-range; i<getLocationY()+range; i++){
            for(int j = getLocationX()-range; j<this.getLocationX()+range; i++){
                Tile[][] matrix = this.getGrid().getMatrix();
                if(i<matrix.length && i>=0 && j<matrix[0].length && j>=0){
                    if(matrix[i][j].personaje!=null && this.getDefenses().contains(matrix[i][j].personaje))
                        return matrix[i][j];
                }           
            }
        }
        return null;
    }

    @Override
    public void mover(){
        
    }
    
}