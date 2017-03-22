/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Siham
 */
public class ImageCl {
    
    public String year;
    public String name;
    public String category;
    public String Beginning;
    
    ImageCl(String c, String y, String n){
        this.Beginning = "https://www.nobelprize.org//nobel_prizes/";
        this.year = y;
        this.category = c;
        this.name = n;
    }
    
    public String getURL(){
        String url;
        url = this.Beginning  +this.category +
                "/laureates/" + this.year + "/" + this.name + "_postcard.jpg";
        
        //URL url2 = new URL(url);
        return url;
    }
    
    public void getLaureateInfo(){
        
    
    }
}
