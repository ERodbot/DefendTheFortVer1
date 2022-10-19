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
public class ZombieContacto extends Entity{
    
    int range;
    
    
    
    ZombieContacto(String nombre, int vida, int cantidadGolpes, int nivel, int campos, int nivelAparicion, Tablero grid){
        super(nombre,vida,cantidadGolpes,nivel,campos,nivelAparicion, grid);
        range = 1;
    }


    @Override
    public void morir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void atacar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Tile determineObjective() {
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public void mover(){
        int difx = posx - 12; //13 POSICION DEL ARBOL DE LA VIDA (-1 por el index empezado en 0)
        int dify = posy - 12; //13 POSICION DEL ARBOL DE LA VIDA (-1 por el index empezado en 0)
        
        if ( difx < 0 && dify < 0){ //diagonal izquierda abajo (movimiento hacia)
            grid.matriz[posx][posy].personaje = null;
            grid.matriz[++posx][++posy].personaje = this;
        }
        if ( difx < 0 && dify > 0){ //diagonal derecha abajo
            grid.matriz[posx][posy].personaje = null;
            grid.matriz[++posx][--posy].personaje = this;
        }
        if ( difx > 0 && dify < 0){ //diagonal izquierda arriba
            grid.matriz[posx][posy].personaje = null;
            grid.matriz[--posx][++posy].personaje = this;
        }
        if ( difx > 0 && dify > 0){ //diagonal derecha arriba
            grid.matriz[posx][posy].personaje = null;
            grid.matriz[--posx][--posy].personaje = this;
        }
        if ( difx == 12 && dify < 0){ //derecha 
            grid.matriz[posx][posy].personaje = null;
            grid.matriz[posx][++posy].personaje = this;
        }
        if ( difx == 0 && dify > 0){ //izquierda
            grid.matriz[posx][posy].personaje = null;
            grid.matriz[posx][--posy].personaje = this;
        }
        if ( difx < 0 && dify == 0){ //arriba
            grid.matriz[posx][posy].personaje = null;
            grid.matriz[++posx][posy].personaje = this;
        }
        if ( difx > 0 && dify == 0){ //abajo
            grid.matriz[posx][posy].personaje = null;
            grid.matriz[--posx][posy].personaje = this;
        }
        
        
        
    }
}