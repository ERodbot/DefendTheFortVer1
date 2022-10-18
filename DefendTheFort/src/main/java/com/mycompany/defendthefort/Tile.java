/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort;

import javax.swing.JButton;

/**
 *
 * @author em000
 */
public class Tile {
    JButton button;
    Personaje personaje;
    private final int ancho = 35;
    private final int alto = 35;
    
    Tile(){
        JButton button = new JButton();
        button.setSize(ancho, alto);
        this.button = button;  
    }
    
    public void setCharacter(){
        
    }
}
