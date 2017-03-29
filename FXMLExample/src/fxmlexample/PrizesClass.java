/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;
import java.util.ArrayList;
/**
 *
 * @author Siham
 */
public class PrizesClass {
    
    public int year;
    public int yearTo;
    public String category;
    public  ArrayList<LaureatesClass> laureates = new ArrayList<>();
    public int numberOfLaureates;
    //public ArrayList<Laureates> laureates = new ArrayList<>();
     
    public boolean getLaureate(String fname){
        for(int i = 0; i < this.numberOfLaureates; i++){
            if(this.laureates.get(i).firstname.equals(fname))
                return true;
        }
        
        return false;
    }
}
