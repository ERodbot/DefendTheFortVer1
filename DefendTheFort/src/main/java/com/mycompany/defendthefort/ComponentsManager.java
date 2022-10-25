 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.defendthefort;

/**
 *
 * @author sebas
 */

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray; //Escribir el JSON
import org.json.simple.JSONObject; //Leer el JSON
import org.json.simple.parser.JSONParser; //Leer el JSON
import org.json.simple.parser.ParseException; 



public class ComponentsManager {
 
    public ComManGUI GUI;
    
    JSONArray enemigos = new JSONArray();
        
    JSONArray defensas = new JSONArray();
    
    ComponentsManager(){
        
    }
    
    public void writeEntity(String nombre, String tipo, String path, int vida, int nivel, int golpes, int espacios,int opcion){
        
        JSONObject entity = new JSONObject();
        
        entity.put("nombre", nombre);
        entity.put("tipo", tipo);
        entity.put("path", path);
        entity.put("vida", vida);
        entity.put("nivel", nivel);
        entity.put("golpes", golpes);
        entity.put("espacios", espacios);
        
        if (opcion == 0){
            enemigos.add(entity);       
        
            try(FileWriter file = new FileWriter("enemigos.json")){
                file.write(enemigos.toJSONString());
                file.flush();
            }catch(IOException e ){
                e.toString();
            }
            return;
        }
        defensas.add(entity);       
        
        try(FileWriter file = new FileWriter("defensas.json")){
            file.write(defensas.toJSONString());
            file.flush();
        }catch(IOException e ){
            e.toString();
        }
    }
    
}
