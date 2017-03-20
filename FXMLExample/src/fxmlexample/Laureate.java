/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

import java.lang.reflect.Field;
import org.json.simple.JSONArray;
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
    String bornDate;
    String diedDate;
    String motivation;
    String year;
    String category;
    String share;
    
    String affiliation;
    
    public Laureate(JSONObject obj){
        firstname = (String)obj.get("firstname");
        bornCountry = (String)obj.get("bornCountry");
        gender = (String)obj.get("gender");
        surname = (String)obj.get("surname");
        bornCity = (String)obj.get("bornCity");
        diedCountry = (String)obj.get("diedCountry");
        diedCity = (String)obj.get("diedCity");
        bornDate = (String)obj.get("born");
        diedDate = (String)obj.get("died");
        motivation = (String)((JSONObject)((JSONArray)(obj.get("prizes"))).get(0)).get("motivation");
        year = (String)((JSONObject)((JSONArray)(obj.get("prizes"))).get(0)).get("year");
        category = (String)((JSONObject)((JSONArray)(obj.get("prizes"))).get(0)).get("category");
        share = (String)((JSONObject)((JSONArray)(obj.get("prizes"))).get(0)).get("share");
        affiliation = (String)((JSONObject)((JSONArray)(obj.get("prizes"))).get(0)).get("affiliation");
        
    }
    @Override
    public int hashCode(){
        int hashCode = 1;
        hashCode += 1 * this.firstname.length();
        hashCode += 2 * this.bornCountry.length();
        hashCode += 3 * this.gender.length();
        hashCode += 4 * this.surname.length();
        hashCode += 4 * this.bornCity.length();
        hashCode += 5 * this.diedCountry.length();
        hashCode += 6 * this.diedCity.length();
        hashCode += 31 * this.motivation.length();
        hashCode += 19 * this.category.length();
        hashCode += 23 * this.affiliation.length();
        return hashCode;
    }
    @Override
    public boolean equals(Object o){
        boolean equality = true;
        if(! (o instanceof Laureate)) return false;

        Laureate p = (Laureate) o;
        if (!this.firstname.equals(p.getFirstname()))
            return false;
        if (!this.surname.equals(p.getSurname()))
            return false;
        if (!this.bornCountry.equals(p.getBornCountry()))
            return false;
        if (!this.bornCity.equals(p.getBornCity()))
            return false;
        if (!this.diedCountry.equals(p.getDiedCountry()))
            return false;
        if (!this.diedCity.equals(p.getDiedCity()))
            return false;
        if (!this.gender.equals(p.getGender()))
            return false;
        if (!this.bornDate.equals(p.getBornDate()))
            return false;
        if (!this.diedDate.equals(p.getDiedDate()))
            return false;
        if (!this.motivation.equals(p.getMotivation()))
            return false;
        if (!this.year.equals(p.getYear()))
            return false;
        if (!this.category.equals(p.getCategory()))
            return false;
        if (!this.share.equals(p.getShare()))
            return false;
        if (!this.affiliation.equals(p.getAffiliation()))
            return false;
        return equality;
    }
    public void setLaureate() throws IllegalArgumentException, IllegalAccessException{
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f : fields){
            if (f.get(this)==null)
                f.set(this, "***");
        }
    }
    public String getShare(){
        return share;
    }
    public String getCategory(){
        return category;
    }
    public String getYear(){
        return year;
    }
    public String getFirstname(){
        return firstname;
    }
    public String getSurname(){
        return surname;
    }
    public String getBornCountry(){
        return bornCountry;
    }
    public String getBornCity(){
        return bornCity;
    }
   
    public String getDiedCountry(){
        return diedCountry;
    }
    public String getDiedCity(){
        return diedCity;
    }
    public String getBornDate(){
        return bornDate;
    }
    public String getDiedDate(){
        return diedDate;
    }
    public String getMotivation(){
        return motivation;
    }
    public String getGender(){
        return gender;
    }
    public String getAffiliation(){
        return affiliation;
    }
}
