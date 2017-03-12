/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Graham
 */
public class Prizes {
    String year;
    String category;
    JSONArray laureates;
    public Prizes(JSONObject obj){
        year = (String)obj.get("year");
        category = (String)obj.get("category");
        laureates = (JSONArray)obj.get("laureates");
    }
    public String year(){
        return year;
    }
    public String category(){
        return category;
    }
    public JSONArray laureates(){
        return laureates;
    }
}
