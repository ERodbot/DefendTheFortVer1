/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebas
 */
public class ThreadEntity extends Thread {
    
    public Entity entity;
    public Grid tablero;
    
    ThreadEntity(Entity entity,Grid tablero){
        this.entity = entity;
        this.tablero = tablero;
    }
    
    @Override
    public void run(){
        while(entity.vida != 0 ){
            try {
                sleep(1000);
                entity.mover();
                if (entity.determineObjective() != null){
                    while (entity.determineObjective().personaje.getLife() > 0){
                        sleep(500);
                        entity.atacar();
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadEntity.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
}
}