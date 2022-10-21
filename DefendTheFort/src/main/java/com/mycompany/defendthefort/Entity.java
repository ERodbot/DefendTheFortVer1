package com.mycompany.defendthefort;

import java.util.ArrayList;

public abstract class Entity {
    public String nombre;
    public int vida;
    public int cantidadGolpes, nivel, campos, nivelAparicion, posx, posy;   
    public Tablero grid;
    private  ArrayList<Entity> zombies = new ArrayList();
    private  ArrayList<Entity> defenses = new ArrayList();
    private  ArrayList<Entity> flyingEntities = new ArrayList();

    public void setZombies(ArrayList<Entity> zombies) {
        this.zombies = zombies;
    }

    public void setDefenses(ArrayList<Entity> defenses) {
        this.defenses = defenses;
    }

    public void setFlyingEntities(ArrayList<Entity> flyingEntities) {
        this.flyingEntities = flyingEntities;
    }

    public ArrayList<Entity> getZombies() {
        return zombies;
    }

    public ArrayList<Entity> getDefenses() {
        return defenses;
    }

    public ArrayList<Entity> getFlyingEntities() {
        return flyingEntities;
    }
   
    
    public Entity(String nombre, int vida, int cantidadGolpes, int nivel, int campos, int nivelAparicion, Tablero grid){
        this.nombre = nombre;
        this.vida = vida;
        this.cantidadGolpes = cantidadGolpes;
        this.nivel = nivel;
        this.campos = campos;
        this.nivelAparicion = nivelAparicion;
        this.grid = grid;   
    }
    public abstract void mover();
    public abstract void atacar();
    public abstract Tile determineObjective();
    
    
    public void setLocation(int y, int x){
        this.posx = x;
        this.posy = y;
    }
    public int getLocationX(){
        return posx; 
    }
    public int getLocationY(){
         return posy;
    }
    
    public Tablero getGrid(){
        return grid;
    }
    
    public int getLife(){
      return vida;  
    }

    public void setLife(int life){
      this.vida = life;  
    } 
    
    public void substractLife(int life){
      this.vida -= life;  
    }      
            
    public abstract void morir();
        
    
}

