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
public class JsonObject {
   
   public ArrayList<PrizesClass> prizes = new ArrayList<>();
   public  ArrayList<LaureatesClass> laureates = new ArrayList<>();
   public ArrayList<CountryClass> country = new ArrayList<>();
   
   public void getPrizesAtYear(int year){
       int size = this.prizes.size();
       for(int i=0; i< size; i++){
           if (this.prizes.get(i).year == year){
                System.out.print("\n");
               System.out.print(this.prizes.get(i).year + ": " + this.prizes.get(i).category
               + " , ");
              for(int j = 0; this.prizes.get(i).laureates.size() > j; j++)
                  
                  System.out.print(this.prizes.get(i).laureates.get(j).firstname + ", ");
           }
       }
   }
   
   public ArrayList<LaureatesClass> getLaureates(String fn, String year, String Category){
       ArrayList <LaureatesClass> list = new ArrayList <>();
       
       
       
       if(fn.isEmpty()){
           if(year.isEmpty()){
            for(int i = 0; i < this.prizes.size(); i++){
             if(this.prizes.get(i).category.equals(Category)){
               for(int j = 0; j < this.prizes.get(i).numberOfLaureates; j++){
                  list.add(this.prizes.get(i).laureates.get(j));
                }
              }
            }
           return list;
           }
           else{
               for(int p = 0; p < this.prizes.size(); p++){
              String year2 = "" + this.prizes.get(p).year;
             if(this.prizes.get(p).category.equals(Category) && year2.equals(year)){
               for(int g = 0; g < this.prizes.get(g).numberOfLaureates; g++){
                  list.add(this.prizes.get(g).laureates.get(g));
                    }
                }
               }
               return list;
            }
           }
       else{
           if(year.isEmpty()){
               for(int i = 0; i < this.prizes.size(); i++){
             if(this.prizes.get(i).category.equals(Category) && 
                     this.prizes.get(i).getLaureate(fn)){
               for(int j = 0; j < this.prizes.get(i).numberOfLaureates; j++){
                  if(this.prizes.get(i).laureates.get(j).firstname.equals(fn)) 
                  list.add(this.prizes.get(i).laureates.get(j));
                }
             }
            }
            return list;   
           }
           else{
               for(int k = 0; k < this.prizes.size(); k++){
                   String year2 = "" + this.prizes.get(k).year;
                   for(int d = 0; d < this.prizes.get(k).numberOfLaureates; d++){
                   if(this.prizes.get(k).category.equals(Category) && year2 == year && 
                           this.prizes.get(k).getLaureate(fn))
                       list.add(this.prizes.get(k).laureates.get(k));
               }}
           }
       }    
       return list;
    }
}
