//package com.mycompany.defendthefort;
//
//import java.awt.Color;
//import java.util.ArrayList;
//import javax.swing.JButton;
//import java.util.Random;
//
//public final class G{
//
//    public int nivel;
//    public final Tile[][] matriz = new Tile[25][25];
//    private final int ancho = 35,  alto = 35;
//    public int zombieCapacity = 20 + (nivel-1)*5;
//    private  ArrayList<Entity> zombies = new ArrayList();
//    private  ArrayList<Entity> defenses = new ArrayList();
//    private  ArrayList<Entity> flyingEntities = new ArrayList();
//    int currentCapacity;
//    
//    
//    
//    public void generarZombies(){
//        Random rand = new Random();
//        for (int i = 0; i < 25; i++) {
//            for (int j = 0; j < 25; j++) {
//                if (i == 0 || i == 24 || j == 0 || j == 24){
//                    if (zombieCapacity == 0)
//                        return;
//                    int random;
//                    random = rand.nextInt(96);
//                    if (random == 10||random == 9||random == 8||random == 7 
//                      ||random == 6 ||random == 5||random == 4||random == 3){
//                        matriz[i][j].personaje = new ZombieContacto("ZombieContacto",100,3,1,1,1, this);
//                        zombies.add(matriz[i][j].personaje);
//                        matriz[i][j].personaje.setDefenses(defenses);
//                        matriz[i][j].personaje.setZombies(zombies);
//                        matriz[i][j].personaje.setFlyingEntities(flyingEntities);
//                        matriz[i][j].personaje.setLocation(i, j);
//                        System.out.println(i + "-" + j);
//                        matriz[i][j].button.setText(".");
//                        zombieCapacity=-2;
//                    }
//                }
//            }
//        }
//        
//        matriz[0][5].personaje = new ZombieContacto("ZombieContacto",100,3,1,1, 1, this);
//        matriz[0][5].personaje.setLocation(0, 5);
//        matriz[0][5].button.setBackground(Color.red);
//        matriz[0][6].personaje = new DefensaContacto("DefensaContacto",100,3,1,1, 1, this);
//        matriz[0][6].personaje.setLocation(0, 6);
//        matriz[0][6].button.setBackground(Color.red);
//        
//        zombies.add(matriz[0][5].personaje);
//        defenses.add(matriz[0][6].personaje);
//        matriz[0][5].personaje.setZombies(zombies);
//        matriz[0][5].personaje.setDefenses(defenses);
//        matriz[0][6].personaje.setZombies(zombies);
//        matriz[0][6].personaje.setDefenses(defenses);
//    }
//
//
//}