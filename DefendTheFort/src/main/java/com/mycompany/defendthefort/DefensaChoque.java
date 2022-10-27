/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort;

import javax.swing.ImageIcon;

/**
 *
 * @author em000
 */
public class DefensaChoque extends Entity{
    
    int range = -1;
    
    DefensaChoque(String nombre, int vida, int cantidadGolpes, int nivel, int campos, int nivelAparicion, Grid grid,  ImageIcon movementfilePath, ImageIcon attackfilePath){
        super(nombre,vida,cantidadGolpes,nivel,campos,nivelAparicion, grid, movementfilePath, movementfilePath);
        
    }
    
    @Override
    public void atacar() {
        Tile objective = determineObjective();
        if(objective!=null && !this.getFlyingEntities().contains(objective.personaje)){
            if(objective.personaje==null)
                return;
            objective.personaje.substractLife(cantidadGolpes);
            objective.personaje.getRegister().getAttackers().add(this);
            objective.personaje.getRegister().getDamageReceived().add(this.cantidadGolpes);
            this.getRegister().getAttacked().add(objective.personaje);
            this.getRegister().getDamageDone().add(this.cantidadGolpes);
            if(objective.personaje.getLife() <= 0)
                objective.personaje.morir();
        }
    }

    @Override
    public Tile determineObjective() {
        for(int i = getLocationY()-range; i<getLocationY()+range+1; i++){
            for(int j = getLocationX()-range; j<this.getLocationX()+range+1; j++){
                Tile[][] matrix = this.getGrid().getMatrix();
                if(i<matrix.length && i>=0 && j<matrix[0].length && j>=0 && matrix[i][j].personaje!=null){  
                    if(this.getZombies().contains(matrix[i][j].personaje)){
                        return matrix[i][j];
                    }
                }         
            }
        }
        return null;
    }
   


   @Override
    public void mover(){
        
    }
 

    @Override
  public void morir() {
       ImageIcon grave;
       grave = ImageManager.resize(grid.matrix[posy][posx].button, "C:\\Images\\grave.png");
       grid.matrix[posy][posx].button.setIcon(grave);
       System.out.println("me mori xC soy defensa");
       grid.matrix[posy][posx].personaje = null;
    }

    
    @Override
    public Entity clone(){
        DefensaContacto clonedEntity =  new DefensaContacto(nombre, vida, cantidadGolpes, nivel, campos, nivelAparicion, grid,  moving, attacking);
        return clonedEntity;
    }
    
}