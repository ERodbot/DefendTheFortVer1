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
public class DefensaBloque extends Entity{
    
    
    
    
    DefensaBloque(String nombre, int vida, int nivel, int campos, int nivelAparicion, Grid grid,  ImageIcon movementfilePath, ImageIcon attackfilePath){
        super(nombre,vida,0,nivel,campos,nivelAparicion, grid, movementfilePath, movementfilePath);
        setRange(1);
    }

    @Override
    public void atacar() {
        Entity objective = determineObjective(getRange());
        if(objective!=null && !this.getFlyingEntities().contains(objective)){
            objective.substractLife(cantidadGolpes);
            objective.getRegister().getAttackers().add(this);
            objective.getRegister().getDamageReceived().add(this.cantidadGolpes);
            this.getRegister().getAttacked().add(objective);
            this.getRegister().getDamageDone().add(this.cantidadGolpes);
            System.out.println("ataco con" + cantidadGolpes + "dejando al objetivo con vida: " + objective.getLife());
            if(objective.getLife() <= 0){
                objective.thread.isrunning = false;
                objective.morir();
                objective = null;
            }
        }
      
    }
    

    @Override
  public void morir() {
       ImageIcon grave;
       grave = ImageManager.resize(grid.matrix[posy][posx].button, "C:\\Images\\grave.png");
       grid.matrix[posy][posx].button.setIcon(grave);
       System.out.println("me mori xC soy defensa: "+ nombre);
       this.thread.isrunning = false;
       grid.matrix[posy][posx].personaje = null;
       
    }

    
    @Override
    public Entity clone(){
        DefensaBloque clonedEntity =  new DefensaBloque(nombre, vida, nivel, campos, nivelAparicion, grid,  moving, attacking);
        return clonedEntity;
    }
    
    
        
    
}
    


