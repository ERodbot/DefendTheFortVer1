package com.mycompany.defendthefort;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException; 

public class ComponentsManager {
 
    public GameScreen GS;
    
    public ComManGUI GUI;
    
    JSONArray enemigos = new JSONArray();
        
    JSONArray defensas = new JSONArray();
    
    ComponentsManager(){
        
    }
    
    ComponentsManager(GameScreen GS){   
      
        this.GS = GS; //El component manager servirá en función de un GameScreen
        
    }
    
    public void writeEntity(String nombre, String tipo, String path, int vida, int nivel, int golpes, int espacios,int opcion){
        
        //Tomando en cuenta los parámetros conseguidos del GUI, se escribirá el objeto JSON en el JSONArray en enemigos.json/defensas.json
        
        JSONObject entity = new JSONObject(); //Entidad a escribir
        
        //Poner key,value en el JSONObject
        entity.put("nombre", nombre);
        entity.put("tipo", tipo);
        entity.put("path", path);
        entity.put("vida", vida);
        entity.put("nivel", nivel);
        entity.put("golpes", golpes);
        entity.put("espacios", espacios);
        
        if (opcion == 0){ //Entidad es un enemigo
            enemigos.add(entity);  //se añade el nuevo JSONObject en el atributo enemigos (JSONArray)       
        
            try(FileWriter file = new FileWriter("enemigos.json")){
                file.write(enemigos.toJSONString()); //se escribe el JSONArray actualizado
                file.flush(); //se cierra el archivo
            }catch(IOException e ){
                e.toString();
            }
            return;
        }
        //Entidad es una defensa
        defensas.add(entity);  //se añade el nuevo JSONObject en el atributo defensas (JSONArray)     
        
        try(FileWriter file = new FileWriter("defensas.json")){
            file.write(defensas.toJSONString()); //se escribe el JSONArray actualizado
            file.flush(); //se cierra el archivo
        }catch(IOException e ){
            e.toString();
        }
    }
    
    public void readToAdd(){
            
        //Se leen los enemigos/defensas/flying entities para agregarlos a los ArrayList correspondientes
        
            JSONParser jsonParser = new JSONParser();
            
            try (FileReader reader = new FileReader("enemigos.json")){
                Object obj1 = jsonParser.parse(reader);
                
                JSONArray enemigosObj = (JSONArray) obj1;
                
                for (Object enemigo : enemigosObj) {
                    JSONObject enemigoAux = (JSONObject)enemigo;
                    String path   = (String) enemigoAux.get("path");
                    String tipo   = (String) enemigoAux.get("tipo");
                    String nombre = (String) enemigoAux.get("nombre");
                    int vida      = Math.toIntExact((long)enemigoAux.get("vida"));
                    int golpes    = Math.toIntExact((long)enemigoAux.get("golpes"));
                    int nivel     = Math.toIntExact((long)enemigoAux.get("nivel"));
                    int espacios  = Math.toIntExact((long)enemigoAux.get("espacios"));
                    if ("ZombieContacto".equals(tipo))
                        GS.zombies.add(new ZombieContacto(nombre,vida,golpes,nivel,espacios,nivel,GS.getCurrentLevel(),new ImageIcon(path),new ImageIcon(path)));
                    if ("ZombieMedio".equals(tipo))
                        GS.zombies.add(new ZombieMedio(nombre,vida,golpes,nivel,espacios,nivel,GS.getCurrentLevel(),new ImageIcon(path),new ImageIcon(path)));
                    if ("ZombieAereo".equals(tipo)){
                        ZombieAereo aerial = new ZombieAereo(nombre,vida,golpes,nivel,espacios,nivel,GS.getCurrentLevel(),new ImageIcon(path),new ImageIcon(path));
                        GS.zombies.add(aerial);
                        GS.flyingEntities.add(aerial);        
                    }
                    if ("ZombieChoque".equals(tipo))
                        GS.zombies.add(new ZombieChoque(nombre,vida,golpes,nivel,espacios,nivel,GS.getCurrentLevel(),new ImageIcon(path),new ImageIcon(path)));
                    
                }
                
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            catch(ParseException e ){
                e.printStackTrace();
            }
       
            try (FileReader reader = new FileReader("defensas.json")){
                Object obj2 = jsonParser.parse(reader);
                
                JSONArray defensasObj = (JSONArray) obj2;
                
                for (Object defensa : defensasObj) {
                    JSONObject defensaAux = (JSONObject)defensa;
                    String path = (String) defensaAux.get("path");
                    String tipo = (String) defensaAux.get("tipo");
                    String nombre = (String) defensaAux.get("nombre");
                    int vida      = Math.toIntExact( (long)defensaAux.get("vida"));
                    int golpes    = Math.toIntExact( (long)defensaAux.get("golpes"));
                    int nivel     = Math.toIntExact( (long)defensaAux.get("nivel"));
                    int espacios  = Math.toIntExact( (long)defensaAux.get("espacios"));
                    if ("DefensaContacto".equals(tipo))
                        GS.defenses.add(new DefensaContacto(nombre,vida,golpes,nivel,espacios,nivel,GS.getCurrentLevel(),new ImageIcon(path),new ImageIcon(path)));
                    if ("DefensaChoque".equals(tipo))
                        GS.defenses.add(new DefensaChoque(nombre,vida,golpes,nivel,espacios,nivel,GS.getCurrentLevel(),new ImageIcon(path),new ImageIcon(path)));
                    if ("DefensaAereo".equals(tipo)){
                        DefensaAereo aerial = new DefensaAereo(nombre,vida,golpes,nivel,espacios,nivel,GS.getCurrentLevel(),new ImageIcon(path),new ImageIcon(path));
                        GS.zombies.add(aerial);
                        GS.flyingEntities.add(aerial);
                    }        
                    if ("DefensaMultiple".equals(tipo))
                        GS.defenses.add(new DefensaMultiple(nombre,vida,golpes,nivel,espacios,nivel,GS.getCurrentLevel(),new ImageIcon(path),new ImageIcon(path)));
                    if ("DefensaBloque".equals(tipo))
                        GS.defenses.add(new DefensaBloque(nombre,vida,nivel,espacios,nivel,GS.getCurrentLevel(),new ImageIcon(path),new ImageIcon(path)));
                    if ("DefensaMedio".equals(tipo))
                        GS.defenses.add(new DefensaMedio(nombre,vida,golpes,nivel,espacios,nivel,GS.getCurrentLevel(),new ImageIcon(path),new ImageIcon(path)));
                    
                    System.out.println("Zombies, defensas y entidades aéreas en los archivos JSON agregadas exitosamente");
                    
                }
                
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            catch(ParseException e ){
                e.printStackTrace();
            }            
    }
}
