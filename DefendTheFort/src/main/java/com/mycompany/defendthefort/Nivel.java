/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort;

import java.util.ArrayList;

public class Nivel {
    private Entity[] zombies;
    private Entity[] defenses;
    private  Entity[] flyingEntities;
    private Tablero grid;
    public int level;

    public Nivel(int level) {
        this.level = level;
        this.zombies = new Entity[20 + (level-1)*level];
        this.defenses = new Entity[20 + (level-1)*level];
        this.flyingEntities = new Entity[20 + (level-1)*level];
    }
}
