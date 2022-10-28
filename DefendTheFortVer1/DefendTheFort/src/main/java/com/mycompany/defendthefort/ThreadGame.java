package com.mycompany.defendthefort;


import com.mycompany.defendthefort.GameScreen;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author em000
 */
public class ThreadGame extends Thread {
    GameScreen game;
    boolean winner = false;
    
    ThreadGame(GameScreen game){
        this.game = game;
        
    }
    
    @Override
    public void run(){
        Entity treeOfLife = game.getCurrentLevel().getTreeOfLife().personaje;
        while(treeOfLife.getLife()>0){
            if(game.getCurrentLevel().getZombies().size() == 0){
                game.getCurrentLevel().endGame();
                winner = !winner;
            }
            System.out.print(game.getCurrentLevel().getZombies().size());
        }
        game.getCurrentLevel().endGame();
        Object[] options = {"Continuar", "Cancelar"};
        String txt = "VICTORIA";
        if(!winner){
            txt = "DERROTA";
        }
        int choice = JOptionPane.showOptionDialog(null, txt, "Continuar al siguiente nivel",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, "Metric");
        if(choice == 0 ){
            game.setLevel(game.getLevel()+1);
            game.placeButtons(game.getCurrentLevel().getMatrix());
            game.levelUpEntities();
            game.getPnlDefenses().removeAll();
            game.addPosibleDefensesScreen();
        }else{
           game.getTpnlContent().setSelectedIndex(0);    
        }
//      game.getGameThread().start();
        System.out.println("Finished");
        
    }
    
    
    
}
