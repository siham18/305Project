/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * FXML Controller class
 *
 * @author Graham
 */
public class NewWindowController implements Initializable{
    @FXML private ListView choices;
    @FXML private ToggleGroup gender;
    @FXML private Label yearlabel, yearTolabel;
    @FXML private RadioButton male, female;
    @FXML private TableView table;
    @FXML private TextField fieldText;
    @FXML private Slider date, dateTo, age;
    @FXML private ComboBox comboField;
    
    ObservableList<String> content = FXCollections.observableArrayList(
            "gender", "age", "year", "category", "bornIn", "diedIn", 
            "bornCountry", "diedCountry", "bornCity", "diedCity", "firstname", "surname");
    
    @FXML void newPage (ActionEvent event) throws IOException {
        Parent queryResult = FXMLLoader.load(getClass().getResource("fxml_example.fxml"));
        Scene newScene = new Scene(queryResult);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }
    public void fillValue(){
        choices.getSelectionModel().getSelectedItem();
    }
    public void setChoices(ObservableList<String> transfer){
        int i =0;
        for (String each: transfer){
            TableColumn col = (TableColumn)table.getColumns().get(i);
            col.setText(each);
            i++;
        }
    }
    
    public void fetchData() throws MalformedURLException, IOException, ParseException{
        String url = "http://api.nobelprize.org/v1/laureate.json?";
        //url = url + choices.getSelectionModel().getSelectedItem();
        //url = url + "=";
        
        //url = url + fieldValue.getText();
        //if(fieldValueTo.isVisible())
            //url = url + "&yearTo=" + fieldValueTo;
        
        URL nobelUrl = new URL(url);
        URLConnection con = nobelUrl.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        JSONParser parser = new JSONParser();

        inputLine = in.readLine();
        
        
        JSONObject thing = (JSONObject) parser.parse(inputLine);
        JSONArray list = (JSONArray)thing.get("laureates");
        System.out.println(list.size());
        //JSONObject rawr = (JSONObject)list.get(0);
        //Laureate try1 = new Laureate(rawr);
        //System.out.println(try1.firstname());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choices.getItems().setAll(content);
        male.setToggleGroup(gender);
        female.setToggleGroup(gender);
        date.valueProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2){
                yearlabel.setText(String.valueOf((int) date.getValue()));
            }
        });
         dateTo.valueProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2){
                yearTolabel.setText(String.valueOf((int) dateTo.getValue()));
            }
        });
        choices.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if ("category".equals(newValue)){
                comboField.getItems().clear();
                comboField.getItems().addAll("physics", "english", "others");
            }
            if ("bornCountry".equals(newValue) || "diedCountry".equals(newValue) || 
                    "bornCity".equals(newValue) || "diedCity".equals(newValue)||
                    "surname".equals(newValue) || "firstname".equals(newValue)){
                fieldText.setVisible(true);
            }
            else {
                fieldText.setVisible(false);
            }
            if (!"gender".equals(newValue)){
                male.setVisible(false);
                female.setVisible(false);
            }
            else{
                male.setVisible(true);
                female.setVisible(true);
            }
            if ("age".equals(newValue)){
                age.setVisible(true);
            }
            else{
                age.setVisible(false);
            }
            if ("bornIn".equals(newValue) || "diedIn".equals(newValue)){
                date.setVisible(true);
                dateTo.setVisible(true);
                yearlabel.setVisible(true);
                yearTolabel.setVisible(true);
                yearlabel.setText(Double.toString(date.getValue()));
                yearTolabel.setText(Double.toString(dateTo.getValue()));
            }
            else{
                date.setVisible(false);
                dateTo.setVisible(false);
                yearlabel.setVisible(false);
                yearTolabel.setVisible(false);
            }
            if ("category".equals(newValue)){
                comboField.setVisible(true);
            }
            else {
                comboField.setVisible(false);
            }
            if ("year".equals(newValue)){
                date.setVisible(true);
                dateTo.setVisible(true);
            }
        }
        });
        
         
        
        
        }
}    
    

