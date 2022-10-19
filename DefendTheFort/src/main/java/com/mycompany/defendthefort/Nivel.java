/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort;

import java.util.ArrayList;

public class Nivel {
    private  ArrayList<Entity> zombies = new ArrayList();
    private  ArrayList<Entity> defenses = new ArrayList();
    private  ArrayList<Entity> flyingEntities = new ArrayList();
    private Tablero grid;
    private int level;
    int maxCapacity;
    int currentCapacity;

    public Nivel(int level) {
        this.level = level;
        currentCapacity = 0;
        maxCapacity = 20 + (level-1)*5;
        
    }

    public void setZombies(ArrayList<Entity> zombies) {
        this.zombies = zombies;
    }

    public void setDefenses(ArrayList<Entity> defenses) {
        this.defenses = defenses;
    }

    public void setFlyingEntities(ArrayList<Entity> flyingEntities) {
        this.flyingEntities = flyingEntities;
    }

    public void setGrid(Tablero grid) {
        this.grid = grid;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public Tablero getGrid() {
        return grid;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public int getLevel() {
        return level;
    }
    
    public void addCurrentCapacity(int capacityCost){
        this.currentCapacity+=capacityCost;
    }
    
}
