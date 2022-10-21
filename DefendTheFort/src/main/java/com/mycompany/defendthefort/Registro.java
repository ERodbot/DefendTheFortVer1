/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author em000
 */
public class Registro {
    String ID;
    private  ArrayList<Entity> attackers = new ArrayList();
    private ArrayList damageReceived = new ArrayList();
    private  ArrayList<Entity> attacked = new ArrayList();
    private ArrayList damageDone = new ArrayList();
    private Entity entity;
    private final int startingLife;
    private int finalLife;
    
    
    Registro(Entity entity){
        this.ID = new Random().nextInt(999999999)/new Random().nextInt(999999999)+"";
        startingLife = entity.getLife();  
    }

    public String getID() {
        return ID;
    }

    public ArrayList<Entity> getAttackers() {
        return attackers;
    }

    public ArrayList getDamageReceived() {
        return damageReceived;
    }

    public ArrayList<Entity> getAttacked() {
        return attacked;
    }

    public ArrayList getDamageDone() {
        return damageDone;
    }

    public Entity getEntity() {
        return entity;
    }

    public int getStartingLife() {
        return startingLife;
    }

    public int getFinalLife() {
        return finalLife;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setAttackers(ArrayList<Entity> attackers) {
        this.attackers = attackers;
    }

    public void setDamageReceived(ArrayList damageReceived) {
        this.damageReceived = damageReceived;
    }

    public void setAttacked(ArrayList<Entity> attacked) {
        this.attacked = attacked;
    }

    public void setDamageDone(ArrayList damageDone) {
        this.damageDone = damageDone;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void setFinalLife(int finalLife) {
        this.finalLife = finalLife;
    }
    
    
    
    
    
}
