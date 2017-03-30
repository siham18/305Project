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
    private Text name;
    public LaureatesClass laur;
    public PrizesClass prize;
    JsonObject singleton;
    /**
     * Initializes the controller class.
     */
    
    public void fill(){
        singleton = Singleton.getInstance();
        laur = singleton.getLaur(928);
        prize = singleton.getPrize(laur);
        //System.out.println(prize.category + ":" + prize.year + ":" + laur.firstname);
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        fill();
        System.out.println(prize.category + ":" + prize.year + ":" + laur.firstname);
        ImageCl image = new ImageCl(prize.category, ""+prize.year, laur.surname);
        String im = image.getURL();
        Image image2 = new Image(im);
        System.out.println(im);
        pic4.setImage(image2);
       
    }
    
    /*
    @FXML
    public void goBack(ActionEvent event)throws Exception{
       
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("LaureateSearch.fxml"));
        Parent queryResult = (Parent)fxml.load();
        
        Scene newScene = new Scene(queryResult);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
    */
    
}
