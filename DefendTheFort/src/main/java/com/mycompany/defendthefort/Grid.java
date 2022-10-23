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
    int currentCapacity;
    
     public Grid() {
        generarBotones();
        this.nivel = 1;
        generarBotones();
        generarZombies();
    }
    
     
    public void generarBotones(){
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                matrix[i][j] = new Tile();
                matrix[i][j].setLocation(i,j);
                matrix[i][j].button.setIcon(new ImageIcon("C:\\Images\\grass.png"));
 
//Pasar esto a una funcion en la pantalla principal;                
//                pnlPrincipal.add(matrix[i][j].button);
//                matrix[i][j].button.setOpaque(rootPaneCheckingEnabled);
//                matrix[i][j].button.setLocation(i*ancho, alto*j);
            }            
        }
    }
    
    
    public void generarZombies(){
        Random rand = new Random();
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if (i == 0 || i == 24 || j == 0 || j == 24){
                    if (zombieCapacity == 0)
                        return;
                    int random;
                    random = rand.nextInt(96);
                    if (random == 10||random == 9||random == 8||random == 7 
                      ||random == 6 ||random == 5||random == 4||random == 3){
                        matrix[i][j].personaje = new ZombieContacto("ZombieContacto",100,3,1,1,1, this);
                        threadArray.add(matrix[i][j].personaje.thread);
                        zombies.add(matrix[i][j].personaje);
                        matrix[i][j].personaje.setDefenses(defenses);
                        matrix[i][j].personaje.setZombies(zombies);
                        matrix[i][j].personaje.setFlyingEntities(flyingEntities);
                        matrix[i][j].personaje.setLocation(i, j);
                        System.out.println(i + "-" + j);
                        matrix[i][j].button.setText(".");
                        zombieCapacity=-2;
                    }
                }
            }
        }
        
        matrix[0][5].personaje = new ZombieContacto("ZombieContacto",100,3,1,1, 1, this);
        matrix[0][5].personaje.setLocation(0, 5);
        matrix[0][5].button.setBackground(Color.red);
        matrix[0][6].personaje = new DefensaContacto("DefensaContacto",100,3,1,1, 1, this);
        matrix[0][6].personaje.setLocation(0, 6);
        matrix[0][6].button.setBackground(Color.red);
        
        zombies.add(matrix[0][5].personaje);
        defenses.add(matrix[0][6].personaje);
        matrix[0][5].personaje.setZombies(zombies);
        matrix[0][5].personaje.setDefenses(defenses);
        matrix[0][6].personaje.setZombies(zombies);
        matrix[0][6].personaje.setDefenses(defenses);
    }
    
    public void SimulacionCochina(){
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if (i == 0 || i == 24 || j == 0 || j == 24){
                    if (matrix[i][j].personaje != null)
                        matrix[i][j].personaje.thread.start();
                }
            }
        }    
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

    public int getCurrentCapacity() {
        return currentCapacity;
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

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }


}