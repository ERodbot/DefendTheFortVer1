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
       System.out.println("me mori xC");
    }

    @Override
    public void atacar() {
        Tile objective = determineObjective();
        if(objective!=null && !this.getFlyingEntities().contains(objective)){
            objective.personaje.substractLife(cantidadGolpes);
            if(objective.personaje.getLife() < 0)
                objective.personaje.morir();
        }
        System.out.println("ataco con" + cantidadGolpes + "dejando al objetivo con vida: " + objective.personaje.getLife());
    }

    @Override
    public Tile determineObjective() {
        for(int i = getLocationY()-range; i<getLocationY()+range+1; i++){
            System.out.println("locationy: " + i);
            for(int j = getLocationX()-range; j<this.getLocationX()+range+1; j++){
                System.out.println("locationx: " + j);
                Tile[][] matrix = this.getGrid().getMatrix();
                System.out.println("got matrix");
                if(i<matrix.length && i>=0 && j<matrix[0].length && j>=0){  
                    if(matrix[i][j].personaje!=null && this.getDefenses().contains(matrix[i][j].personaje))
                        System.out.println("got objt");
                        return matrix[i][j];
                }         
            }
        }
        System.out.println("got objtNull");
        return null;
        
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