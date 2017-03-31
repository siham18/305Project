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
    //public ArrayList<Laureates> laureates = new ArrayList<>();
     
    public boolean getLaureate(String fname){
        for(int i = 0; i < this.laureates.size(); i++){
            if(this.laureates.get(i).firstname.equals(fname))
                return true;
        }
        return false;
    }
    
     public ArrayList<Integer> listOfID(){
        
         ArrayList<Integer> list =  new ArrayList<>();
         for(int i =0; i< this.laureates.size(); i++){
             list.add(this.laureates.get(i).id);
         }
         return list;
     }
    
    public ArrayList <LaureatesClass> getLaureateList(ArrayList <LaureatesClass> list){
        //System.out.println("In func");
        for(int i = 0; i < this.laureates.size(); i++){
           list.add(this.laureates.get(i));
           System.out.println(this.laureates.get(i).firstname);
        }
        
        return list;
    }
}
