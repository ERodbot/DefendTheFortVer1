package com.mycompany.defendthefort;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import java.util.Random;

public final class Tablero extends javax.swing.JFrame {

    public int nivel;
    public final Tile[][] matriz = new Tile[25][25];
    private final int ancho = 35,  alto = 35;
    public int zombieCapacity = 20 + (nivel-1)*5;
    private  ArrayList<Entity> zombies = new ArrayList();
    private  ArrayList<Entity> defenses = new ArrayList();
    private  ArrayList<Entity> flyingEntities = new ArrayList();
    int currentCapacity;
    
    
    
    public Tablero() {
        initComponents();
        generarBotones();
        this.nivel = 1;
        generarZombies();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir2 = new javax.swing.JButton();
        pnlPrincipal = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnSalir3 = new javax.swing.JButton();
        scrollDefenses = new javax.swing.JScrollPane();
        defensesPnl = new javax.swing.JPanel();

        btnSalir2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setBackground(new java.awt.Color(0, 102, 51));
        pnlPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setToolTipText("");

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSalir.setText("Pausar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnSalir3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSalir3.setText("Salir");
        btnSalir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout defensesPnlLayout = new javax.swing.GroupLayout(defensesPnl);
        defensesPnl.setLayout(defensesPnlLayout);
        defensesPnlLayout.setHorizontalGroup(
            defensesPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );
        defensesPnlLayout.setVerticalGroup(
            defensesPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
        );

        scrollDefenses.setViewportView(defensesPnl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(btnSalir3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(scrollDefenses))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollDefenses))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        for(Tile[] tileRow: matriz){
            for(Tile tileColumn: tileRow){
                if (tileColumn.personaje!=null){
                    System.out.println("Encontrado en: " + tileColumn.personaje.getLocationY() + "-" + tileColumn.personaje.getLocationX());
                    if(tileColumn.personaje.determineObjective()!=null){
//                        System.out.println("Objetivo encontrado, a atacar!");
                        while(tileColumn.personaje.determineObjective().personaje.getLife()>0){
//                            System.out.println("!!!!!!!!!!!!!!!!!!!YESSSS");
                            tileColumn.personaje.atacar();
                            System.out.println(tileColumn.personaje.determineObjective().personaje.getLife());
                        }
                    }
//                    System.out.println("se movio");
                    tileColumn.personaje.mover();
                }      
            }  
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void btnSalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir3ActionPerformed
    
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
                        matriz[i][j].personaje = new ZombieContacto("ZombieContacto",100,3,1,1,1, this);
                        zombies.add(matriz[i][j].personaje);
                        matriz[i][j].personaje.setDefenses(defenses);
                        matriz[i][j].personaje.setZombies(zombies);
                        matriz[i][j].personaje.setFlyingEntities(flyingEntities);
                        matriz[i][j].personaje.setLocation(i, j);
                        System.out.println(i + "-" + j);
                        matriz[i][j].button.setText(".");
                        zombieCapacity=-2;
                    }
                }
            }
        }
        
        matriz[0][5].personaje = new ZombieContacto("ZombieContacto",100,3,1,1, 1, this);
        matriz[0][5].personaje.setLocation(0, 5);
        matriz[0][5].button.setBackground(Color.red);
        matriz[0][6].personaje = new DefensaContacto("DefensaContacto",100,3,1,1, 1, this);
        matriz[0][6].personaje.setLocation(0, 6);
        matriz[0][6].button.setBackground(Color.red);
        
        zombies.add(matriz[0][5].personaje);
        defenses.add(matriz[0][6].personaje);
        matriz[0][5].personaje.setZombies(zombies);
        matriz[0][5].personaje.setDefenses(defenses);
        matriz[0][6].personaje.setZombies(zombies);
        matriz[0][6].personaje.setDefenses(defenses);
    }
    
    public void generarBotones(){
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                matriz[i][j] = new Tile();
                matriz[i][j].setLocation(i,j);
                pnlPrincipal.add(matriz[i][j].button);
                matriz[i][j].button.setOpaque(rootPaneCheckingEnabled);
                matriz[i][j].button.setLocation(i*ancho, alto*j);
            }            
        }
    }
    
    public Tile[][] getMatrix(){
        return matriz;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
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

    public int getLevel() {
        return nivel;
    }
    
    public void addCurrentCapacity(int capacityCost){
        this.currentCapacity+=capacityCost;
    }
    

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnSalir3;
    private javax.swing.JPanel defensesPnl;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JScrollPane scrollDefenses;
    // End of variables declaration//GEN-END:variables
}
