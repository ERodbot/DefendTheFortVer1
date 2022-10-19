package com.mycompany.defendthefort;

public abstract class Entity {
    public String nombre;
    public int vida;
    public int cantidadGolpes, nivel, campos, nivelAparicion, posx, posy;   
    public Tablero grid;
    
   
    
    public Entity(String nombre, int vida, int cantidadGolpes, int nivel, int campos, int nivelAparicion, Tablero grid){
        this.nombre = nombre;
        this.vida = vida;
        this.cantidadGolpes = cantidadGolpes;
        this.nivel = nivel;
        this.campos = campos;
        this.nivelAparicion = nivelAparicion;
        this.grid = grid;   
    }
    public abstract void atacar();
    public abstract Tile determineObjective();
    
    
    public void setLocation(int x, int y){
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
            
    public void morir(){
        
    }
    public void mover(){
        
    }
}

