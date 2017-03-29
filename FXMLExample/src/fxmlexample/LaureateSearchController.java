/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.cell.ComboBoxListCell;
import org.json.simple.parser.JSONParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * FXML Controller class
 *
 * @author Siham
 */
public class LaureateSearchController implements Initializable{

    ObservableList<String> names = FXCollections.observableArrayList("physics", "peace", "literature", "economics", 
                "medicine", "chemistry");
    @FXML private TextField year;
    @FXML private TextField Fname;
    @FXML private AnchorPane Pane;
    @FXML public ChoiceBox Dropdown;
    @FXML private Button back;
    @FXML private Button search;
    @FXML private Button open;
    @FXML private ListView<String> list;
    private String chosenY;
    private String chosenN;
    private String chosenC;
    private URL url2;
    private URL url;
    private JsonObject p;
    private JsonObject p2;
    @FXML private TableView tableView;
    @FXML private TableColumn <ObservableList<String>, String> name;
    @FXML private TableColumn <ObservableList<String>,String> info;


    @FXML
    public void initialize(URL urll, ResourceBundle rb){
       Dropdown.setItems(names);
       Dropdown.setValue("Peace");
       try{
       FillJson();} 
       catch (Exception ex) {
            Logger.getLogger(LaureateSearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void FillJson() throws Exception{
       url2 = new URL("http://api.nobelprize.org/v1/laureate.json");
       url = new URL("http://api.nobelprize.org/v1/prize.json");
       
       JsonObject json2 = new JsonObject();
       URLConnection con2 = url2.openConnection();
       BufferedReader in2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
       String inputLine;
    
       inputLine = in2.readLine();
       
       
       URLConnection con = url.openConnection();
       BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
       String inputLine2;
    
       inputLine2 = in.readLine();
       
       Gson g = new GsonBuilder().setPrettyPrinting().create();
       Gson g2 = new GsonBuilder().setPrettyPrinting().create();
       p = g.fromJson(inputLine, JsonObject.class);
       p2 = g2.fromJson(inputLine2, JsonObject.class);
    
    }
    
    
    @FXML public void listv(ActionEvent event)throws Exception{
       if(year.getText().trim().isEmpty() || year.getText() == null){
           chosenY = null;
       }
       else{
            chosenY = year.getText();
       }
       if(Fname.getText().trim().isEmpty() || Fname.getText() == null){
           chosenN = "";
       }
       else{
           chosenN = Fname.getText();
       }
      // chosenC = Dropdown.getValue().toString();
    }
    
    @FXML public void back(ActionEvent event) throws Exception{
    
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("Front.fxml"));
        Parent queryResult = (Parent)fxml.load();
        
        Scene newScene = new Scene(queryResult);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
     
      @FXML public void openLaureate(ActionEvent event) throws Exception{

        FXMLLoader fxmll = new FXMLLoader(getClass().getResource("winner.fxml"));
        Parent queryResult = (Parent)fxmll.load();
        
        Scene newScene = new Scene(queryResult);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
      @FXML public void getValues(ActionEvent event) throws Exception{
       
          
          if(year.getText().trim().isEmpty() || year.getText() == null){
           chosenY = "";
       }
       else{
            chosenY = year.getText();
       }
       if(Fname.getText().trim().isEmpty() || Fname.getText() == null){
           chosenN = "";
       }
       else{
           chosenN = Fname.getText();
       }
         chosenC = Dropdown.getValue().toString();
        ArrayList <LaureatesClass> lists = new ArrayList <>();
        
        for(int i = 0; i < p2.prizes.size(); i++){
            String year2 = "" + p2.prizes.get(i).year;
            //System.out.println(year2 +" /" + chosenY);
            if(chosenC.equals(p2.prizes.get(i).category) && chosenY.equals(year2)){
           for(int j = 0; j < p2.prizes.get(i).laureates.size(); j++){
            lists.add(p2.prizes.get(i).laureates.get(j));
   
           }}}
        
        //list = p2.getLaureates(chosenN, chosenY, chosenC);
        
        
        /*
        for(int i = 0; i < p2.prizes.size(); i++){
             
               for(int j = 0; j < p2.prizes.get(i).numberOfLaureates; j++){
                  list.add(p2.prizes.get(i).laureates.get(j));
                }
              
       }*/
       
       System.out.println(":" + p2.prizes.size() + ":" + lists.size());
        
       for(int i = 0; i < lists.size(); i++){
         System.out.println(lists.get(i).firstname + ":" + lists.get(i).motivation +" " + p.prizes.size());
        }
       
      }
}
