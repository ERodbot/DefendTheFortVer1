/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author em000
 */
public class SelectedDefense {
    
    
    private JLabel labelDefense;
    private Entity defense;
    private Entity grid;
    
    //crea un label con la imagen de la defensa y lo coloca en el scroll panel para el usuario poder seleccionarla
    SelectedDefense(Entity entiy, Grid grid){
        String txt = "<html>Nombre: " + entiy.nombre + "<br>Campos: " + entiy.campos + "<br>Vida: " + entiy.vida + "<br>Golpes/ps: " + entiy.cantidadGolpes + "</html>";
        labelDefense = new JLabel(entiy.moving);
        labelDefense.setText(txt);
        labelDefense.setHorizontalTextPosition(JLabel.CENTER);
        labelDefense.setVerticalTextPosition(JLabel.BOTTOM);
        Border border = BorderFactory.createLineBorder(Color.black, 2);
        labelDefense.setBorder(border);
        labelDefense.setBackground(Color.white);
        labelDefense.setSize(275, 120);
        labelDefense.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    //carga en el tablero una entidad seleccionada al hacerle click
                    grid.setEntityLoaded(entiy);
                    System.out.println("loaded:" + grid.getEntityLoaded().nombre);
                }

        });
        this.defense = entiy;
    }

    public void setLabelDefense(JLabel labelDefense) {
        this.labelDefense = labelDefense;
    }

    public void setDefense(Entity defense) {
        this.defense = defense;
    }

    public void setGrid(Entity grid) {
        this.grid = grid;
    }

    public JLabel getLabelDefense() {
        return labelDefense;
    }

    public Entity getDefense() {
        return defense;
    }

    public Entity getGrid() {
        return grid;
    }
    
    
    
    
    
    
}
