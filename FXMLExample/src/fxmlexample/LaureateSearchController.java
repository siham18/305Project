/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * FXML Controller class
 *
 * @author Siham
 */
public class LaureateSearchController implements Initializable{

    ObservableList<String> names = FXCollections.observableArrayList(
            "physics", "peace", "literature", "economics", "medicine", "chemistry");
    
    @FXML private TextField year;
    @FXML private TextField Fname;
    @FXML private TextField Lname;
    @FXML private AnchorPane Pane;
    @FXML public ChoiceBox Dropdown;
    @FXML public ChoiceBox FirstN;
    @FXML private Button back;
    @FXML private Button search;
    @FXML private Button open;
    @FXML private ListView<String> list;
    public String chosenY;
    public String chosenN;
    public String chosenC;
    @FXML ListView<String> listView;
    private JsonObject singleton;
    @FXML private TableView <LaureatesClass> tableView;
    @FXML private TableColumn <LaureatesClass, String> name, lastname, motivation;
    
    //Sets the Dropdown and gets access to the JsonObject 
    @FXML public void initialize(URL urll, ResourceBundle rb){
       Dropdown.setItems(names);
       Dropdown.setValue("peace");
       singleton = Singleton.getInstance();  
    }
    
    //Parse and check for proper input.
    public void listv(){
        
       if(year.getText().trim().isEmpty() || year.getText() == null || 
             year.getText().length() > 4 || year.getText().length() < 4){
           chosenY = null;
       }
       else{
            chosenY = year.getText();
       }
       if(Fname.getText().trim().isEmpty() || Fname.getText() == null){
           chosenN = null;
       }
       else{
           chosenN = Fname.getText();
       }
      chosenC = Dropdown.getValue().toString();
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
        Parent root1 = (Parent) fxmll.load();
        Stage stage = new Stage();
        String temp = listView.getSelectionModel().getSelectedItems().toString();
        System.out.println(temp);
        
        int tempp = singleton.searchId(temp);
        singleton.addId(tempp);
        System.out.println(tempp);
        stage.setScene(new Scene(root1));  
        stage.show();
    }
      
      @FXML public void getValues(ActionEvent event) throws Exception{
          listv();
          
          //System.out.println(chosenC + ":" + chosenN + ":" + chosenY + ":" + singleton.prizes.size());
          ArrayList <LaureatesClass> laur = singleton.getLaureateList(chosenN, chosenY, chosenC);
          System.out.println(laur.size());
          singleton.addId(928);
          ObservableList <String> everyoneList = FXCollections.observableArrayList();
          
          for(int i = 0; i < laur.size(); i++){
            everyoneList.add(laur.get(i).firstname + " " + laur.get(i).surname);
          }
          //System.out.println(singleton.searchId("[Christian Lous]"));
          //tableView.getItems().clear();
          listView.setItems(everyoneList);
    }
}