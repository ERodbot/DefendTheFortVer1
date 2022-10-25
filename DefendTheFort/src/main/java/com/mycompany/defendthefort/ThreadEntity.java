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
    }
    
    @Override
    public void run(){
        entity.getGrid().getMatrix()[entity.posy][entity.posx].button.setIcon(entity.moving);
        System.out.println(entity.nombre);
        while(entity.getLife() > 0){
            try {
                sleep(1000);
                if (entity.determineObjective() != null){
                    while(entity.determineObjective()!=null && entity.determineObjective().personaje.getLife() >0){
//                        System.out.println(entity.nombre + " esta atacando");
                        entity.atacar();
                        sleep(1000);
                    }
//                    System.out.println(entity.nombre + " deberia dejar de atacar");
                }
//                System.out.println(entity.nombre + "moviendose");
                entity.mover(); 
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadEntity.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        ImageIcon grave = ImageManager.resize(grid.matrix[entity.posy][entity.posx].button, "C:\\Images\\grave.png");
        grid.matrix[entity.posy][entity.posx].button.setIcon(grave);
    }
}