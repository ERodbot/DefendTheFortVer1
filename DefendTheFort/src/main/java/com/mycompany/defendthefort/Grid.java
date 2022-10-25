package com.mycompany.defendthefort;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import java.util.Random;
import com.mycompany.defendthefort.Entity;
import javax.swing.ImageIcon;

public class Grid{

    public int nivel;
    public final Tile[][] matrix = new Tile[25][25];
    private final int ancho = 35,  alto = 35;
    public int zombieCapacity = 20 + (nivel-1)*5;
    private  ArrayList<Entity> zombies = new ArrayList<Entity>();
    private  ArrayList<Entity> defenses = new ArrayList<Entity>();
    private  ArrayList<Entity> flyingEntities = new ArrayList<Entity>();
    private ArrayList<ThreadEntity> threadArray = new ArrayList();
    private int defenseCapacity = 20 + (nivel-1)*5;
    private final int zombieMaxCapacity = 20 + 5*(nivel-1);
    private final int defenseMaxCapacity = 20 + 5*(nivel-1);
    private Entity entityLoaded;


     public Grid(int level){
        generarBotones();
        this.nivel = level;
        generarBotones();
    }
    
     
    public void generarBotones(){
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                matrix[i][j] = new Tile(this);
                matrix[i][j].setLocation(i,j);
                matrix[i][j].button.setIcon(new ImageIcon("C:\\Images\\grass.png"));
                matrix[i][j].button.setBorderPainted( false );
 
//Pasar esto a una funcion en la pantalla principal;                
//                pnlPrincipal.add(matrix[i][j].button);
//                matrix[i][j].button.setOpaque(rootPaneCheckingEnabled);
//                matrix[i][j].button.setLocation(i*ancho, alto*j);
            }            
        }
    }
    
    
    public void generarZombies(ArrayList<Entity> possibleZombies){
        Random rand = new Random();
        ImageIcon attacking = ImageManager.resize(matrix[0][0].button, "C:\\Images\\zombies.png");
        ImageIcon moving = ImageManager.resize(matrix[0][0].button, "C:\\Images\\zombies.png");
        Entity zombie = new ZombieContacto("ZombieContacto",100,3,1,1,1, this, moving, attacking);
        while(zombieCapacity > 0){
            int i  = rand.nextInt(0,24);
            int j = rand.nextInt(0,24);
            if(!(i == 0 || i == 24 || j == 0 || j == 24))
                continue;
            if(matrix[i][j].personaje != null){
                continue;
            }
            if (zombieCapacity == 0)
                return;
            int zombieToGenerate  = rand.nextInt(possibleZombies.size()-1);
            zombie = possibleZombies.get(zombieToGenerate).clone();
            int correctPositions = rand.nextInt(96);
            if (correctPositions == 10||correctPositions == 9||correctPositions == 8||correctPositions == 7 ||correctPositions == 6 ||correctPositions == 5||correctPositions == 4||correctPositions == 3){
                matrix[i][j].personaje = zombie;
                threadArray.add(matrix[i][j].personaje.thread);
                zombies.add(matrix[i][j].personaje);
                try{
                   ZombieAereo aereo= (ZombieAereo)matrix[i][j].personaje;
                   flyingEntities.add((Entity)aereo);
                }catch(ClassCastException e){
                    System.out.println("");
                    
                }
                matrix[i][j].personaje.setLocation(i, j);
                zombieCapacity-=zombie.campos;
            }
        }
        
        
    }

    public void actualizeObjectives(){
        for(Entity defenseEntity: defenses){
            defenseEntity.setFlyingEntities(flyingEntities);
            defenseEntity.setDefenses(defenses);
            defenseEntity.setZombies(zombies);
        }
        for(Entity zombieEntity: zombies){
            zombieEntity.setFlyingEntities(flyingEntities);
            zombieEntity.setDefenses(defenses);
            zombieEntity.setZombies(zombies);
        }
        for(Entity flyingEntity: flyingEntities){
            flyingEntity.setFlyingEntities(flyingEntities);
            flyingEntity.setDefenses(defenses);
            flyingEntity.setZombies(zombies);
        }
    }
    
        
    public void SimulacionCochina(){
        actualizeObjectives();
        if(zombieCapacity <= 0)
            for(ThreadEntity entity: threadArray)
               entity.start();
    }   
            
            
    public void setThreadArray(ArrayList<ThreadEntity> threadArray) {
        this.threadArray = threadArray;
    }

    public void setEntityLoaded(Entity entityLoaded) {
        this.entityLoaded = entityLoaded;
    }

    public ArrayList<ThreadEntity> getThreadArray() {
        return threadArray;
    }

    public Entity getEntityLoaded() {
        return entityLoaded;
    }    

    public int getNivel() {
        return nivel;
    }

    public Tile[][] getMatrix() {
        return matrix;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getZombieCapacity() {
        return zombieCapacity;
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

    public int getDefenseCapacity() {
        return defenseCapacity;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setZombieCapacity(int zombieCapacity) {
        this.zombieCapacity = zombieCapacity;
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

    public void setDefenseCapacity(int defenseCapacity) {
        this.defenseCapacity = defenseCapacity;
    }
    
    public int getZombieMaxCapacity() {
        return zombieMaxCapacity;
    }

    public int getDefenseMaxCapacity() {
        return defenseMaxCapacity;
    }


}