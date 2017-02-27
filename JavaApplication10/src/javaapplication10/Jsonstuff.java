/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Jsonstuff{
    
    public static void main(String[] args) throws Exception {
    URL url = new URL("http://api.nobelprize.org/v1/prize.json?");
    
    
    URLConnection con = url.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    JSONParser parser = new JSONParser();
    
    
    inputLine = in.readLine();
    
    JSONObject obj = new JSONObject((Map)parser.parse(inputLine));
    JSONArray obj2 = (JSONArray)obj.get("prizes");
    JSONObject obj3 = (JSONObject)obj2.get(1);
    JSONArray obj4 = (JSONArray)obj3.get("laureates");
    JSONObject obj5 = (JSONObject)obj4.get(0);
    
    
    System.out.println(obj);
    System.out.println(obj2);
    System.out.println(obj3);
    System.out.println(obj4);
    System.out.println(obj5.get("firstname"));
}
}

/*   String answer = obj.getJSONObject("prizes");
    
    JSONArray obj2 = (JSONArray)obj.get("prizes");
    JSONObject obj3 = (JSONObject)obj2.get(0);
    
    System.out.println(obj3.get("laureates"));
    in.close();*/
