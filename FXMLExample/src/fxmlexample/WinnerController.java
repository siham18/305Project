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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Siham
 */
public class WinnerController implements Initializable {

    @FXML
    private ImageView pic4;
    @FXML private Text name;
    //@FXML private Text namef;
    @FXML public LaureatesClass laur;
    @FXML public PrizesClass prize;
    JsonObject singleton;
    public static int ID;
    /**
     * Initializes the controller class.
     */
    
    public void fill(){
        singleton = Singleton.getInstance();
        laur = singleton.getLaur(singleton.getLastId());
        System.out.println(" -- " + singleton.ID.size() + " -- ");
        prize = singleton.getPrize(laur);
        //String names= laur.firstname;
        //namef.setText(names);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        fill();
        if(prize!= null){
        ImageCl image = new ImageCl(prize.category, ""+prize.year, laur.surname);
        String im = image.getURL();
        Image image2 = new Image(im);
        System.out.println(im);
        pic4.setImage(image2);
        }
        else{
            System.out.println("GETS NULL FOR PRIZES");
        }
    }
}
