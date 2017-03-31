/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Siham
 */
public class Singleton {
    
    public static JsonObject singleton = null;
    public static Image image2;
    public static Image image1;
   
    
    static public JsonObject Singleton() throws Exception{
    URL url = new URL("http://api.nobelprize.org/v1/prize.json");
    JsonObject json = new JsonObject();
    URLConnection con = url.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    JSONParser parser = new JSONParser();
    inputLine = in.readLine(); 
    
    //-------------------------------------------------
    URL url2 = new URL("http://api.nobelprize.org/v1/laureate.json");
    JsonObject json2 = new JsonObject();
    URLConnection con2 = url2.openConnection();
    BufferedReader in2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
    String inputLine2;
    inputLine2 = in2.readLine();

    //-------------------------------------------------
    URL url3 = new URL("http://api.nobelprize.org/v1/country.json");
    JsonObject json3 = new JsonObject();
    URLConnection con3 = url3.openConnection();
    BufferedReader in3 = new BufferedReader(new InputStreamReader(con3.getInputStream()));
    String inputLine3;
    inputLine3 = in3.readLine();
    
    //-------------------------------------------------------
    String im = "http://blog.univ-reunion.fr/blogpapang/files/2016/10/nobelprizes.jpg";
    image2 = new Image(im);
    
        
    String imm = "https://www.nobelprize.org/images/literature.jpg";
    image1 = new Image(imm);
    
    //-----------------------------------------------------------
    Gson g = new GsonBuilder().setPrettyPrinting().create();
    
    JsonObject p = g.fromJson(inputLine2,JsonObject.class);
    JsonObject p2 = g.fromJson(inputLine, JsonObject.class);
    JsonObject p3 = g.fromJson(inputLine3, JsonObject.class);
    
    JsonObject jsonObj = new JsonObject();
    jsonObj.laureates = p.laureates;
    jsonObj.prizes = p2.prizes;
    jsonObj.countries = p3.countries;
    return jsonObj;
    }
    
    public static JsonObject getInstance(){
        if(singleton == null)
            try {
                singleton = Singleton();
        } catch (Exception ex) {
            System.out.println("\n--------Something wrong with Singleton!!!------- \n " + ex);
        }
        
        return singleton;
    }
    
}
