/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Siham
 */
public class LaureateSearchController implements Initializable {

    @FXML
    private TextField year;
    @FXML
    private TextField Fname;
    @FXML
    private AnchorPane Pane;
    @FXML
    private ComboBox<?> Dropdown;
    @FXML
    private Button back;
    @FXML
    private Button search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
