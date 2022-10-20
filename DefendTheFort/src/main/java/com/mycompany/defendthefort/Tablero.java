package com.mycompany.defendthefort;

import java.util.ArrayList;
import javax.swing.JButton;
import java.util.Random;

public final class Tablero extends javax.swing.JFrame {

    public Nivel nivel;
    public final Tile[][] matriz = new Tile[25][25];
    private final int ancho = 35;
    private final int alto = 35;
    public int zombieCapacity = 20;
    
    public Tablero() {
        nivel = new Nivel(1);
        initComponents();
        generarBotones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir2 = new javax.swing.JButton();
        pnlPrincipal = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnSalir3 = new javax.swing.JButton();

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
                    .addComponent(btnSalir3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        for(Tile[] tileRow: matriz){
            for(Tile tileColumn: tileRow){
                if (tileColumn.personaje!=null){
                    System.out.println("Encontrado en: " + tileColumn.personaje.getLocationX() + "-" + tileColumn.personaje.getLocationY());
                    while(tileColumn.personaje.getLife()>0){
                        tileColumn.personaje.atacar();
                        System.out.println(tileColumn.personaje.determineObjective().personaje.getLife());
                    }
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
                        matriz[i][j].personaje.setDefenses(nivel.getDefenses());
                        matriz[i][j].personaje.setZombies(nivel.getZombies());
                        matriz[i][j].personaje.setFlyingEntities(nivel.getFlyingEntities());
                        matriz[i][j].personaje.setLocation(i, j);
                        System.out.println(j + "-" + i);
                        matriz[i][j].button.setText(".");
                        zombieCapacity=-2;
                        nivel.getZombies().add(matriz[i][j].personaje);
                    }
                }
            }
        }
        
        matriz[1][1].personaje = new ZombieContacto("ZombieContacto",3,30,1,1, 1, this);
        matriz[1][1].personaje.setLocation(0, 0);
        matriz[1][1].button.setText("E");
        matriz[2][2].personaje = new DefensaContacto("DefensaContacto",3,30,1,1, 1, this);
        matriz[1][1].personaje.setLocation(2, 2);
        matriz[2][2].button.setText("E");
    }
    
    public void generarBotones(){
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                matriz[i][j] = new Tile();
                matriz[i][j].setLocation(j,i);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnSalir3;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
