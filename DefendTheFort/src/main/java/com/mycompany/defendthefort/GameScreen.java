/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.defendthefort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.SwingConstants.LEFT;
import javax.swing.border.Border;

/**
 *
 * @author em000
 */
public class GameScreen extends javax.swing.JFrame {

    public ComponentsManager CM;  
    int level = 0;
    private ArrayList<Grid> levelGrid = new ArrayList<Grid>();
    public  ArrayList<Entity> defenses = new ArrayList<Entity>();
    public  ArrayList<Entity> zombies = new ArrayList<Entity>();
    public  ArrayList<Entity> flyingEntities = new ArrayList<Entity>();
    final int ancho = 35, alto = 35;
    
    /**
     * Creates new form GameScreen
     */
    public GameScreen() {
        initComponents();
        CM = new ComponentsManager(this);
        for(int i = 0; i<10; i++){
            levelGrid.add(new Grid(i+1));
            System.out.println(i+1);
        }
        initializaPossibleZombies();
        initializaPossibleDefenses();
        Dimension preferredSize = new Dimension(293, 720+(120*defenses.size()-720));
        pnlDefenses.setPreferredSize(preferredSize);
        CM.readToAdd();
        
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContent = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tpnlContent = new javax.swing.JTabbedPane();
        pnlInitialScreen = new javax.swing.JPanel();
        btnInitializeGmae = new javax.swing.JButton();
        pnlGame = new javax.swing.JPanel();
        scrollDefenses = new javax.swing.JScrollPane();
        pnlDefenses = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnOpciones = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 1200));

        pnlContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pnlContent.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 30));

        btnInitializeGmae.setText("Empezar Partida");
        btnInitializeGmae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInitializeGmaeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInitialScreenLayout = new javax.swing.GroupLayout(pnlInitialScreen);
        pnlInitialScreen.setLayout(pnlInitialScreenLayout);
        pnlInitialScreenLayout.setHorizontalGroup(
            pnlInitialScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInitialScreenLayout.createSequentialGroup()
                .addGap(387, 387, 387)
                .addComponent(btnInitializeGmae, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(641, Short.MAX_VALUE))
        );
        pnlInitialScreenLayout.setVerticalGroup(
            pnlInitialScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInitialScreenLayout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(btnInitializeGmae, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1442, Short.MAX_VALUE))
        );

        tpnlContent.addTab("tab1", pnlInitialScreen);

        scrollDefenses.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlDefenses.setPreferredSize(new java.awt.Dimension(293, 2000));

        javax.swing.GroupLayout pnlDefensesLayout = new javax.swing.GroupLayout(pnlDefenses);
        pnlDefenses.setLayout(pnlDefensesLayout);
        pnlDefensesLayout.setHorizontalGroup(
            pnlDefensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );
        pnlDefensesLayout.setVerticalGroup(
            pnlDefensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2000, Short.MAX_VALUE)
        );

        scrollDefenses.setViewportView(pnlDefenses);

        btnStart.setText("EMPEZAR PARTIDA");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnPause.setText("PAUSAR");

        btnOpciones.setText("OPCIONES");

        javax.swing.GroupLayout pnlGameLayout = new javax.swing.GroupLayout(pnlGame);
        pnlGame.setLayout(pnlGameLayout);
        pnlGameLayout.setHorizontalGroup(
            pnlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameLayout.createSequentialGroup()
                .addContainerGap(891, Short.MAX_VALUE)
                .addGroup(pnlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnPause, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollDefenses, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlGameLayout.setVerticalGroup(
            pnlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameLayout.createSequentialGroup()
                .addComponent(scrollDefenses, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1032, Short.MAX_VALUE))
        );

        tpnlContent.addTab("tab2", pnlGame);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1679, Short.MAX_VALUE)
        );

        tpnlContent.addTab("tab3", jPanel1);

        pnlContent.add(tpnlContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1200, 1710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1216, 911));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    

    
    
    private void btnInitializeGmaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInitializeGmaeActionPerformed
        // TODO add your handling code here:
        Grid currentLevel = levelGrid.get(level);
        addPosibleDefensesScreen();
        placeButtons(currentLevel.getMatrix());
        tpnlContent.setSelectedIndex(1);
    }//GEN-LAST:event_btnInitializeGmaeActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        Grid currentLevel = levelGrid.get(level);
        currentLevel.generarZombies(zombies);
        currentLevel.SimulacionCochina();
        
    }//GEN-LAST:event_btnStartActionPerformed

    
    public void initializaPossibleZombies(){
        Grid currentGrid = levelGrid.get(level);
        ImageIcon attacking = ImageManager.resize(currentGrid.getMatrix()[0][0].button, "C:\\Images\\zombies.png");
        ImageIcon moving = attacking;
        System.out.println("hello");
        Entity zombieContacto = new ZombieContacto("ZombieContacto",100,10,1,5,1, currentGrid, moving, attacking);
        Entity zombieContactoFuerte = new ZombieContacto("zombieContactoFuerte",200,20,1,5,1, currentGrid, moving, attacking);
        Entity zombieChoque = new ZombieChoque("zombieChoque",150,15,1,5,1, currentGrid, moving, attacking);
        Entity zombieMedio = new ZombieMedio("zombieMedio",100,15,1,2,1, currentGrid, moving, attacking);
        Entity zombieMedioConEsteroides = new ZombieContacto("zombieMedioConEsteroides",100,10,1,4,1, currentGrid, moving, attacking);
        Entity zombieAereo = new ZombieAereo("zombieAereo",30,20,1,3,1, currentGrid, moving, attacking);
        Entity zombieAereo2 = new ZombieAereo("zombieAereo2",90,25,1,3,1, currentGrid, moving, attacking);
        zombies.add(zombieContacto);
        zombies.add(zombieContactoFuerte);
        zombies.add(zombieChoque);
        zombies.add(zombieMedio);
        zombies.add(zombieMedioConEsteroides);
        zombies.add(zombieAereo);
        zombies.add(zombieAereo2);
              
    }
    
    public void initializaPossibleDefenses(){
        Grid currentGrid = levelGrid.get(level);
        ImageIcon attacking = ImageManager.resize(currentGrid.getMatrix()[0][0].button, "C:\\Images\\zombies.png");
        ImageIcon moving = attacking;
        System.out.println("hello");
        Entity DefensaAereo = new DefensaAereo("DefensaAerea",100,10,1,2,1, currentGrid, moving, attacking);
        Entity DefensaContactoFuerte = new DefensaContacto("DefensaContactoFuerte",150,20,1,0,1, currentGrid, moving, attacking);
        Entity DefensaContacto = new DefensaContacto("DefensaContacto",150,10,1,1,1, currentGrid, moving, attacking);
        Entity DefensaMedio = new DefensaBloque("DefensaMedio",100,3,1,1,currentGrid, moving, attacking);
        Entity DefensaMedioConEsteroides = new DefensaMedio("DefensaMedioConEsteroides",100,10,1,5,1, currentGrid, moving, attacking);
        Entity DefensaAereo2 = new DefensaAereo("DefensaAereo2",30,5,1,5,1, currentGrid, moving, attacking);
        Entity DefensaBloque = new DefensaBloque("DefensaBloque",150,1,4,1, currentGrid, moving, attacking);
        defenses.add(DefensaAereo);
        defenses.add(DefensaContactoFuerte);
        defenses.add(DefensaContacto);
        defenses.add(DefensaMedio);
        defenses.add(DefensaMedioConEsteroides);
        defenses.add(DefensaAereo2);
        defenses.add(DefensaBloque);
              
    }
    
    
    public void addPosibleDefensesScreen(){
        Grid currentLevel = levelGrid.get(level);
        for(int i = 0; i<defenses.size();i++){
           Entity EntityDefense = defenses.get(i);
           SelectedDefense defense = new SelectedDefense(EntityDefense, currentLevel);
           JLabel lbldefense = defense.getLabelDefense();
           pnlDefenses.add(lbldefense);
           int posy = i*lbldefense.getHeight();
           lbldefense.setLocation(0, posy);
        }      
    }
    
    
    
    public void placeButtons(Tile[][] matrix){
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                pnlGame.add(matrix[i][j].button, 2);
                matrix[i][j].button.setOpaque(rootPaneCheckingEnabled);
                matrix[i][j].button.setLocation(i*ancho, alto*j);
            }
        }
    }
    
    public Grid getCurrentLevel(){
        return levelGrid.get(level);
    }
    
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInitializeGmae;
    private javax.swing.JButton btnOpciones;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnStart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlDefenses;
    private javax.swing.JPanel pnlGame;
    private javax.swing.JPanel pnlInitialScreen;
    private javax.swing.JScrollPane scrollDefenses;
    private javax.swing.JTabbedPane tpnlContent;
    // End of variables declaration//GEN-END:variables
}