/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

import org.json.simple.JSONObject;

/**
 *
 * @author Graham
 */
public class Laureate {
    String firstname;
    String bornCountry;
    String gender;
    String surname;
    String bornCity;
    String diedCountry;
    String diedCity;
    String born;
    String died;
    String motivation;
    
    String affiliation;
    
    public Laureate(JSONObject obj){
        firstname = (String)obj.get("firstname");
        bornCountry = (String)obj.get("bornCountry");
        gender = (String)obj.get("gender");
        surname = (String)obj.get("surname");
        bornCity = (String)obj.get("bornCity");
        diedCountry = (String)obj.get("diedCountry");
        diedCity = (String)obj.get("diedCity");
        born = (String)obj.get("born");
        died = (String)obj.get("died");
        motivation = (String)obj.get("motivation");
        
    }
    public String firstname(){
        return firstname;
    }
    public String surname(){
        return surname;
    }
    public String bornCountry(){
        return bornCountry;
    }
    public String bornCity(){
        return bornCity;
    }
    public String diedCountry(){
        return diedCountry;
    }
    public String diedCity(){
        return diedCity;
    }
    public String bornDate(){
        return born;
    }
    public String diedDate(){
        return died;
    }
    public String motivation(){
        return motivation;
    }
    public String gender(){
        return gender;
    }
    public String affiliation(){
        return affiliation;
    }
}
