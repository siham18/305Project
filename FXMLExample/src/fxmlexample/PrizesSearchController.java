/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

import fxmlexample.Prizes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
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
import javafx.stage.Stage;
import org.json.simple.JSONArray;


/**
 * FXML Controller class
 *
 * @author kimelkins
 */
public class PrizesSearchController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML Button back;
    @FXML ComboBox catagory;
    @FXML TextField yearFrom;
    @FXML TextField yearTo;
    @FXML Button open;
    @FXML Button search;
    @FXML ComboBox numLau;
    @FXML ListView<String> list;
    @FXML private TableColumn <ObservableList<String>, String> prizeCat;
    @FXML private TableColumn <ObservableList<String>, String> name;
    @FXML private TableColumn <ObservableList<String>, String> yearAwarded;
    @FXML private TableColumn <ObservableList<String>, String> numSharing;
    //ObservableList<String> namesOfCategories = FXCollections.observableArrayList("Physics", "Peace", "Literature", "Economics", 
     //           "Medicine", "Chemistry");
    //ObservableList<String> lauSharing = FXCollections.observableArrayList("1", "2","3","4");
    private String chosenYearTo;
    private String chosenYearFrom;
    private String chosenCategory;
    private String chosenNumLau;
    private JsonObject p;
    private JsonObject p2;
    //private Singleton data;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        // Initializes the category combobox
        numLau.getItems().clear();
        numLau.getItems().addAll("Physics", "Peace", "Literature", "Economics", 
                "Medicine", "Chemistry");
        catagory.setValue("Physics");
        
        //intializes the numLau combobox
        numLau.getItems().clear();
        numLau.getItems().addAll("1", "2","3","4");
        numLau.setValue("1");
        
        
        // Gets the selected option from the category combobox
       catagory.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                
                //Gets the selected value in the category combobox
                if(newValue != null){
                    switch(newValue){
                        case "Physics": 
                            System.out.println("Selected Category: Physics");
                            break;
                        case "Medicine": 
                            System.out.println("Selected Category: Medicine");
                            break;
                        
                        case "Peace": 
                            System.out.println("Selected Category: Peace");
                            break;
                        
                        case "Chemistry": 
                            System.out.println("Selected Category: Chemistry");
                            break;
                        
                        case "Literature": 
                            System.out.println("Selected Category: Literature");
                            break;
                          
                        case "Economics": 
                            System.out.println("Selected Category: Economics");
                            break;
                           
                        default: 
                            System.out.println("Default");
                            break;
                    }
                }
                
            }
        });
       
       //Gets the selected option from the numLau combobox
       numLau.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                
                //Gets the selected value in the category combobox
                if(newValue != null){
                    switch(newValue){
                        case "1": 
                            System.out.println("Selected Category: 1");
                            break;
                        case "2": 
                            System.out.println("Selected Category: 2");
                            break;
                        
                        case "3": 
                            System.out.println("Selected Category: 3");
                            break;
                        
                        case "4": 
                            System.out.println("Selected Category: 4");
                            break;
                        
                        default: 
                            System.out.println("Default");
                            break;
                    }
                }
                
            }
        });
        
        
        
    } 
    
    /**
     * Brings the user back to the home screen 
     * @param event the mouse click
     * @throws Exception
     */
    @FXML public void back(ActionEvent event) throws Exception{
        
       
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("Front.fxml"));
        Parent queryResult = (Parent)fxml.load();
        
        Scene newScene = new Scene(queryResult);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
    
    /**
     *
     * @param event the mouse click
     * @throws Exception
     */
    @FXML public void search(ActionEvent event) throws Exception{
       
       
        
       
       
   }
}
