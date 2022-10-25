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
        entity.getGrid().getMatrix()[entity.posy][entity.posx].button.setIcon(entity.moving);
        while(entity.getLife() > 0){
            try {
                sleep(1000);
                if (entity.determineObjective() != null){
                    while(entity.determineObjective()!=null && entity.determineObjective().personaje.getLife() >0){
                        System.out.println(entity.nombre + " esta atacando");
                        entity.atacar();
                        sleep(1000);
                    }
                    System.out.println(entity.nombre + " deberia dejar de atacar");
                }
                entity.mover(); 
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadEntity.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        entity.morir();
    }
}