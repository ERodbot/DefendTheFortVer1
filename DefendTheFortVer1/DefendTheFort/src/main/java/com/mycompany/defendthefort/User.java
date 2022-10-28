package com.mycompany.defendthefort;

import java.io.Serializable;

public class User implements Serializable{
    private String ID;
    private String password;
    
 
    
    
    public User(String ID, String password){
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

}
