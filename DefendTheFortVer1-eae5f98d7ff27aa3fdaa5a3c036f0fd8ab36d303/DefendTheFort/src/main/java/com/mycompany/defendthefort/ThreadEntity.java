/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author sebas
 */
public class ThreadEntity extends Thread {
    
    public Entity entity;
    public Grid grid;
    
    ThreadEntity(Entity entity,Grid tablero){
        this.entity = entity;
        this.grid = tablero;
        entity.getGrid().getMatrix()[entity.posy][entity.posx].button.setIcon(entity.moving);
    }
    
    @Override
    public void run(){             //si encuentra una entidad para de moverse hasta matarla/morir a manos de ella, sino, se mueve
        while(entity.vida > 0){  
            try {
                sleep(1700);
//                System.out.println(entity.vida + "---" + entity.nombre);
                if (entity.determineObjective() != null){
                    entity.getGrid().getMatrix()[entity.posy][entity.posx].button.setIcon(entity.attacking);
                    while(entity.determineObjective()!=null && entity.determineObjective().personaje.getLife()>0){
                        entity.atacar();
                        sleep(1000);
                        }
                    }
                if(entity.vida>0)
                    entity.mover(); 
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadEntity.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        ImageIcon grave = ImageManager.resize(grid.matrix[entity.posy][entity.posx].button, "C:\\Images\\grave.png");
        grid.matrix[entity.posy][entity.posx].button.setIcon(grave);
    }
}