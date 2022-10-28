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
    
    
    
    DefensaChoque(String nombre, int vida, int cantidadGolpes, int nivel, int campos, int nivelAparicion, Grid grid,  ImageIcon movementfilePath, ImageIcon attackfilePath){
        super(nombre,vida,cantidadGolpes,nivel,campos,nivelAparicion, grid, movementfilePath, movementfilePath);
        setRange(1);
    }
    
    @Override
    public void atacar() {
        Entity objective = determineObjective(getRange());
        if(objective!=null && !this.getFlyingEntities().contains(objective)){
            objective.substractLife(cantidadGolpes);
            objective.getRegister().getAttackers().add(this);
            objective.getRegister().getDamageReceived().add(this.cantidadGolpes);
            this.getRegister().getAttacked().add(objective);
            this.getRegister().getDamageDone().add(this.cantidadGolpes);
            System.out.println("ataco con" + cantidadGolpes + "dejando al objetivo con vida: " + objective.getLife());
            if(objective.getLife() <= 0){
                objective.thread.isrunning = false;
                objective.morir();
                objective = null;
            }
        }
    }
   
  @Override
  public void morir() {
       ImageIcon grave;
       grave = ImageManager.resize(grid.matrix[posy][posx].button, "C:\\Images\\grave.png");
       grid.matrix[posy][posx].button.setIcon(grave);
       System.out.println("me mori xC soy defensa");
       this.thread.isrunning = false;
       grid.matrix[posy][posx].personaje = null;
       
    }

    
    @Override
    public Entity clone(){
        DefensaContacto clonedEntity =  new DefensaContacto(nombre, vida, cantidadGolpes, nivel, campos, nivelAparicion, grid,  moving, attacking);
        return clonedEntity;
    }
    
}
