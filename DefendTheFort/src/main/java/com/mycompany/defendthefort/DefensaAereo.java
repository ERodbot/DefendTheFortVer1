/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort;
import com.mycompany.defendthefort.Entity;

import com.mycompany.defendthefort.Grid;
import com.mycompany.defendthefort.Tile;
import javax.swing.ImageIcon;



/**
 *
 * @author em000
 */
public class DefensaAereo extends Entity{
    
    
    int range = 1;
    
    DefensaAereo(String nombre, int vida, int cantidadGolpes, int nivel, int campos, int nivelAparicion, Grid grid,  ImageIcon movementfilePath, ImageIcon attackfilePath){
        super(nombre,vida,cantidadGolpes,nivel,campos,nivelAparicion, grid, movementfilePath, movementfilePath);
        
    }

    @Override
    public void atacar() {
        Tile objective = determineObjective();
        if(objective!=null && !this.getFlyingEntities().contains(objective)){
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
        System.out.println("ataco con" + cantidadGolpes + "dejando al objetivo con vida: " + objective.personaje.getLife());
    }

    @Override
    public Tile determineObjective() {
        for(int i = getLocationY()-range; i<getLocationY()+range+1; i++){
            for(int j = getLocationX()-range; j<this.getLocationX()+range+1; j++){
                Tile[][] matrix = this.getGrid().getMatrix();
                if(i<matrix.length && i>=0 && j<matrix[0].length && j>=0 && matrix[i][j].personaje!=null){  
                    if(this.getDefenses().contains(matrix[i][j].personaje)){
                        return matrix[i][j];
                    }
                }         
            }
        }
        return null;
    }
        
    @Override
    public void mover(){
        grid.matrix[posx][posy].button.setIcon(attacking);
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
        DefensaBloque clonedEntity =  new DefensaBloque(nombre, vida, nivel, campos, nivelAparicion, grid,  moving, attacking);
        return clonedEntity;
    }
        
 }

    
    


