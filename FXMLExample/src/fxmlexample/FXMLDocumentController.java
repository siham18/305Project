/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Siham
 */
public class FXMLDocumentController implements Initializable {

    @FXML private AnchorPane died;
    @FXML private ImageView JP;
    @FXML private Text fullName;
    @FXML private Text fullName1;
    @FXML private TextField born;
    @FXML private Text fullName11;
    @FXML private Text fullName111;
    @FXML private TextField timeOfTheAward;
    @FXML private Text fullName112;
    @FXML private TextField Motivation;
    @FXML private Text fullName1121;
    @FXML private Text fullName11211;
    @FXML private TextField field;
    @FXML private TextField sharePrize;
    @FXML private Text fullName112111;
    @FXML private TextArea work;
    @FXML private Button back;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageCl image = new ImageCl("physics", "1935", "chadwick");
        String im = image.getURL();
        Image image2 = new Image(im);
        System.out.println(im);
        JP.setImage(image2);
        
        // TODO
    }
}
