/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort;
import com.mycompany.defendthefort.Entity;
import com.mycompany.defendthefort.Grid;
import com.mycompany.defendthefort.Tile;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author sebas
 */
public class ZombieContacto extends Entity{
    
    int range = 1;
    
    
    
    ZombieContacto(String nombre, int vida, int cantidadGolpes, int nivel, int campos, int nivelAparicion, Grid grid,  ImageIcon movementfilePath, ImageIcon attackfilePath){
        super(nombre,vida,cantidadGolpes,nivel,campos,nivelAparicion, grid, movementfilePath, movementfilePath); 
    }


   @Override
  public void morir() {
       ImageIcon grave;
       grave = ImageManager.resize(grid.matrix[posy][posx].button, "C:\\Images\\grave.png");
       grid.matrix[posy][posx].button.setIcon(grave);
       System.out.println("me mori xC soy zombie");
       grid.matrix[posy][posx].personaje = null;
    }


    @Override
    public void atacar() {
        Tile objective = determineObjective();
        if(objective == null)
            return;
        if(objective!=null && !this.getFlyingEntities().contains(objective.personaje)){
            objective.personaje.substractLife(cantidadGolpes);
            objective.personaje.getRegister().getAttackers().add(this);
            objective.personaje.getRegister().getDamageReceived().add(this.cantidadGolpes);
            this.getRegister().getAttacked().add(objective.personaje);
            this.getRegister().getDamageDone().add(this.cantidadGolpes);
            if(objective.personaje.getLife() <= 0){
                objective.personaje.morir();
                objective.personaje = null;
            }  
        }
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
        int dify = posx - 12; //13 POSICION DEL ARBOL DE LA VIDA (-1 por el index empezado en 0)
        int difx = posy - 12; //13 POSICION DEL ARBOL DE LA VIDA (-1 por el index empezado en 0)
        ImageIcon groundIcon = ImageManager.resize(grid.matrix[posx][posy].button, "C:\\Images\\ground.png");
        ImageIcon zombieIcon = ImageManager.resize(grid.matrix[posx][posy].button, "C:\\Images\\zombies.png");
                    
        
        if ( difx < 0 && dify < 0){ //diagonal izquierda abajo (movimiento hacia)
            grid.matrix[posy][posx].personaje = null;
            grid.matrix[posy][posx].button.setIcon(groundIcon) ;
            grid.matrix[++posy][++posx].personaje = this;
            grid.matrix[posy][posx].button.setIcon(attacking) ; 
            return;
        }
        if ( difx < 0 && dify > 0){ //diagonal derecha abajo
            grid.matrix[posy][posx].personaje = null;
            grid.matrix[posy][posx].button.setIcon(groundIcon) ;
            grid.matrix[++posy][--posx].personaje = this;
            grid.matrix[posy][posx].button.setIcon(zombieIcon) ;
            return;
        }
        if ( difx > 0 && dify < 0){ //diagonal izquierda arriba
            grid.matrix[posy][posx].personaje = null;
            grid.matrix[posy][posx].button.setIcon(groundIcon) ;
            grid.matrix[--posy][++posx].personaje = this;
            grid.matrix[posy][posx].button.setIcon(zombieIcon) ;
            return;
        }
        if ( difx > 0 && dify > 0){ //diagonal derecha arriba
            grid.matrix[posy][posx].personaje = null;
            grid.matrix[posy][posx].button.setIcon(groundIcon) ;
            grid.matrix[--posy][--posx].personaje = this;
            grid.matrix[posy][posx].button.setIcon(zombieIcon) ; 
            return;
        }
        if ( difx == 0 && dify < 0){ //abajo
            grid.matrix[posy][posx].personaje = null;
            grid.matrix[posy][posx].button.setIcon(groundIcon) ; 
            grid.matrix[posy][++posx].personaje = this;
            grid.matrix[posy][posx].button.setIcon(zombieIcon) ;
            return;
        }
        if ( difx == 0 && dify > 0){ //arriba
            grid.matrix[posy][posx].personaje = null;
            grid.matrix[posy][posx].button.setIcon(groundIcon) ;
            grid.matrix[posy][--posx].personaje = this;
            grid.matrix[posy][posx].button.setIcon(zombieIcon) ;
            return;
        }
        if ( difx < 0 && dify == 0){ //izquierda
            grid.matrix[posy][posx].personaje = null;
            grid.matrix[posy][posx].button.setIcon(groundIcon) ;
            grid.matrix[++posy][posx].personaje = this;
            grid.matrix[posy][posx].button.setIcon(zombieIcon) ;
            return;
        }
        if ( difx > 0 && dify == 0){ //derecha
            grid.matrix[posy][posx].personaje = null;
            grid.matrix[posy][posx].button.setIcon(groundIcon) ;
            grid.matrix[--posy][posx].personaje = this;
            grid.matrix[posy][posx].button.setIcon(zombieIcon) ;
            return;
        }   
    }
    
    @Override
    public Entity clone(){
        ZombieContacto clonedEntity =  new ZombieContacto(nombre, vida, cantidadGolpes, nivel, campos, nivelAparicion, grid,  moving, attacking);
        return clonedEntity;
    }
}