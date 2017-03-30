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
   public ArrayList<CountryClass> countries = new ArrayList<>();
   private JsonObject js;
   
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
   
   public LaureatesClass getLaur(int ID){
       js = Singleton.getInstance();
       for(int i = 0; i < js.laureates.size(); i++){
           if(js.laureates.get(i).id == ID){
               return js.laureates.get(i);
           }
       }
       return null;
   }
   
   public PrizesClass getPrize(LaureatesClass lau){
       js = Singleton.getInstance();
      for(int i = 0; i < js.prizes.size(); i++){
           for(int j = 0; j< js.prizes.get(i).laureates.size(); j++)
           if(js.prizes.get(i).laureates.get(j).id == lau.id){
               return js.prizes.get(i);
           }
       }
       return null;
   
   }
   
   public ArrayList<LaureatesClass> getLaureateList(String fn, String year, String Category){
       js = Singleton.getInstance();
       int len = js.prizes.size();
       
       ArrayList <LaureatesClass> list = new ArrayList <>();
       if(year == null && fn == null){
           for(int i = 0; i < len; i++){
               if(js.prizes.get(i).category.equals(Category)){
                   list = js.prizes.get(i).getLaureateList(list);
               }
           }
           return list;
       }
       
       if(fn == null){
            for(int i = 0; i < len; i++){
           String year2 = "" + this.prizes.get(i).year;
           if(js.prizes.get(i).category.equals(Category) && year2.equals(year)){
                   list = js.prizes.get(i).getLaureateList(list);
               }
            }
            return list;
       }
       /*
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
       }    */
       return list;
    }
}
