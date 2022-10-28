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
    public boolean isrunning;
    
    ThreadEntity(Entity entity,Grid tablero){
        this.entity = entity;
        this.grid = tablero;
        this.isrunning = true;
        entity.getGrid().getMatrix()[entity.posy][entity.posx].button.setIcon(entity.moving);
    }
    
    @Override
    public void run(){             //si encuentra una entidad para de moverse hasta matarla/morir a manos de ella, sino, se mueve
        while(isrunning){ 
            if(entity.getLife()<0)
                isrunning = false;
            try {
                sleep(1000);
//                System.out.println(entity.vida + "---" + entity.nombre);
                if (entity.determineObjective(entity.getRange()) != null){
                    entity.getGrid().getMatrix()[entity.posy][entity.posx].button.setIcon(entity.attacking);
                    while(entity.determineObjective(entity.getRange())!=null && entity.determineObjective(entity.getRange()).getLife()>=0){
                        if(entity.getLife()<0)
                            isrunning = false;
                        entity.atacar();
                        sleep(1000);
                        }
                    }
                
                if(grid.getZombies().contains(entity))
                    entity.mover(12,12); 
                if(entity.getLife()<0)
                    isrunning = false;
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadEntity.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
            System.out.println("PARO MI THREAD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}