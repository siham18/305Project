/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.util.Callback;

/**
 *
 * @author Graham
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ChoiceBox choices;
    @FXML
    private ListView results;
    @FXML
    private ObservableList<String> content = FXCollections.observableArrayList();
    
 
    @FXML
    private void list(ActionEvent event) {
        choices.getItems().add("rawr");
        content.add("rawr");
        results.setItems(content);
  }
    
    /*@FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
