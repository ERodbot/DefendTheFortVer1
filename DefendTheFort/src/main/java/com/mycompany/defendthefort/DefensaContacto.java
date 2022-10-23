/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort;
import com.mycompany.defendthefort.Entity;
import com.mycompany.defendthefort.Grid;
import com.mycompany.defendthefort.Tile;
import javax.swing.ImageIcon;



/**
 *
 * @author em000
 */
public class DefensaContacto extends Entity{
    
    
    int range = 1;
    
    DefensaContacto(String nombre, int vida, int cantidadGolpes, int nivel, int campos, int nivelAparicion, Grid grid){
        super(nombre,vida,cantidadGolpes,nivel,campos,nivelAparicion, grid);
        
    }

       @Override
    public void atacar() {
        Tile objective = determineObjective();
        if(objective!=null && !this.getFlyingEntities().contains(objective)){
            objective.personaje.substractLife(cantidadGolpes);
            objective.personaje.getRegister().getAttackers().add(this);
            objective.personaje.getRegister().getDamageReceived().add(this.cantidadGolpes);
            this.getRegister().getAttacked().add(objective.personaje);
            this.getRegister().getDamageDone().add(this.cantidadGolpes);
            if(objective.personaje.getLife() < 0)
                objective.personaje.morir();
        }
        System.out.println("ataco con" + cantidadGolpes + "dejando al objetivo con vida: " + objective.personaje.getLife());
    }

    @Override
    public Tile determineObjective() {
        for(int i = getLocationY()-range; i<getLocationY()+range+1; i++){
//            System.out.println("locationy: " + i);
            for(int j = getLocationX()-range; j<this.getLocationX()+range+1; j++){
//                System.out.println("locationx: " + j);
                Tile[][] matrix = this.getGrid().getMatrix();
//                System.out.println("got matrix");
                if(i<matrix.length && i>=0 && j<matrix[0].length && j>=0){  
                    if(matrix[i][j].personaje!=null){
//                        System.out.println("found object at: " + i + "-" + j);
                        if(this.getZombies().contains(matrix[i][j].personaje)){
                            System.out.println("got objt");
                            return matrix[i][j];
                        }
                    }         
                }
            }
        }
        System.out.println("got objtNull");
        return null;
    }
   


   @Override
    public void mover(){
        return;
    }

    @Override
    public void morir() {
       grid.matrix[posx][posy].button.setIcon(new ImageIcon("C:\\Images\\grave.png"));
       System.out.println("me mori xC soy defensa");
    }
    
}

