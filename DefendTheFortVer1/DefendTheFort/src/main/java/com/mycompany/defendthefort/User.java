package com.mycompany.defendthefort;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
    private String ID;
    private String password;
    private ArrayList<GameScreen> games = new ArrayList();
    private Menu menu;
    
 
    
    
    public User(String ID, String password){
        menu = new Menu(this);
        this.ID = ID;
        this.password = password; 
         
    }  

    @Override
    public String toString() {
        return "";
    }
    
    @Override
    public User clone(){
        User usuario = new User(this.ID, this.password);
        return usuario;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setContraseña(String password) {
        this.password = password;
    }

    public String getID() {
        return ID;
    }


    public String getPassword() {
        return password;
    }

    public ArrayList<GameScreen> getGames() {
        return games;
    }

    public void setGames(ArrayList<GameScreen> games) {
        this.games = games;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    
    
}
