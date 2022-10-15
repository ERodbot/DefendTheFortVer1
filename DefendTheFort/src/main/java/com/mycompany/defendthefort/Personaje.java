package com.mycompany.defendthefort;

public abstract class Personaje {
    public String nombre;
    public int vida;
    public int cantidadGolpes;
    public int nivel;
    public int campos;
    public int nivelAparicion;   
    
    public Personaje(String nombre, int vida, int cantidadGolpes, int nivel, int campos, int nivelAparicion){
        this.nombre = nombre;
        this.vida = vida;
        this.cantidadGolpes = cantidadGolpes;
        this.nivel = nivel;
        this.campos = campos;
        this.nivelAparicion = nivelAparicion;
    
    }
    
    public abstract void atacar();
    public abstract void morir();
}

