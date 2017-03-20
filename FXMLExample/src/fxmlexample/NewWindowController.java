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
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
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
import javafx.scene.control.cell.PropertyValueFactory;
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
    ObservableList<Laureate> everyoneList = FXCollections.observableArrayList();
    ObservableList<Laureate> anotherList = FXCollections.observableArrayList();
    @FXML private ListView choices;
    @FXML private ToggleGroup gender;
    @FXML private Label yearlabel, yearTolabel;
    @FXML private RadioButton male, female;
    @FXML private TableView<Laureate> table;
    @FXML private TextField fieldText;
    @FXML private Slider date, dateTo, age;
    @FXML private ComboBox comboField;
    @FXML private TableColumn<Laureate, String> genderCol, ageCol, yearCol, categoryCol, bornDateCol,
            diedDateCol, bornCountryCol, diedCountryCol, bornCityCol,
            diedCityCol, firstnameCol, surnameCol;
    
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
      for (Object each: table.getColumns()){
          TableColumn col = (TableColumn)each;
          if(transfer.contains(col.getText())){
              col.setVisible(true);
          }
      }
    }
    public void inputData(){
        table.getColumns().get(0).setVisible(false);
        table.getColumns().get(0).setVisible(true);
        table.getItems().clear();
        table.getItems().addAll(everyoneList);  
    }
    public void fillList() throws IOException, IOException, MalformedURLException, ParseException, IllegalArgumentException, IllegalAccessException{
        everyoneList.clear();
        fetchData();
    }
    public void newSearch() throws IOException, MalformedURLException, ParseException, IllegalArgumentException, IllegalAccessException {
        fillList();
        inputData();
    }
    public void addSearch() throws IOException, IOException, MalformedURLException, ParseException, IllegalArgumentException, IllegalAccessException{
        Set<Laureate> list = new HashSet<>();
        Set<Laureate> list2 = new HashSet<>();
        for (Laureate each : everyoneList){
            list.add(each);
        }
        fillList();
        for (Laureate each : everyoneList){
            list2.add(each);
        }
        list.retainAll(list2);
        everyoneList.clear();
        for (Laureate each : list){
            everyoneList.add(each);
        }
        
        inputData();
    }
    public void fetchData() throws MalformedURLException, IOException, ParseException, IllegalArgumentException, IllegalAccessException{
        String url = "http://api.nobelprize.org/v1/";
        url += getInput();
        
        URL nobelUrl = new URL(url);
        URLConnection con = nobelUrl.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        JSONParser parser = new JSONParser();

        inputLine = in.readLine();
        
        JSONObject thing = (JSONObject) parser.parse(inputLine);
        JSONArray list = (JSONArray)thing.get("laureates");
        for (Object each : list){
            Laureate person = new Laureate((JSONObject)each);
            person.setLaureate();
            if ("firstname".equals(choices.getSelectionModel().getSelectedItem())){
                if(person.getFirstname().contains(fieldText.getText())){
                    everyoneList.add(person);
                }
            } else if ("surname".equals(choices.getSelectionModel().getSelectedItem())){
                if(person.getSurname().contains(fieldText.getText())){
                    everyoneList.add(person);
                }
            } else {
                everyoneList.add(person);
            }
            
        }
    }
    private String getInput() {
        String returnValue = "";
        if("category".equals(choices.getSelectionModel().getSelectedItem())||
                "year".equals(choices.getSelectionModel().getSelectedItem())||
                "numberOfLaureates".equals(choices.getSelectionModel().getSelectedItem())  ){
            returnValue += "prize.json?";
        }
        else {
            returnValue += "laureate.json?";
        }
        if ("gender".equals(choices.getSelectionModel().getSelectedItem())){
            returnValue += "gender=" + gender.getSelectedToggle().getUserData();
        }
        else if("bornIn".equals(choices.getSelectionModel().getSelectedItem())){
            returnValue += "bornDate=" + Math.round(date.getValue()) + "&bornDateTo=" + Math.round(dateTo.getValue());
        }
        else if ("diedIn".equals(choices.getSelectionModel().getSelectedItem())){
            returnValue += "diedDate=" + Math.round(date.getValue()) + "&diedDateTo=" + Math.round(dateTo.getValue());
        }
        else if ("firstname".equals(choices.getSelectionModel().getSelectedItem())){
            ;
        }
        else if ("surtname".equals(choices.getSelectionModel().getSelectedItem())){
            ;
        }
        else if ("diedCity".equals(choices.getSelectionModel().getSelectedItem())){
            returnValue += "diedCity=" + fieldText.getText();
        }
        else if ("bornCity".equals(choices.getSelectionModel().getSelectedItem())){
            returnValue += "bornCity=" + fieldText.getText();
        }
        else if ("diedCountry".equals(choices.getSelectionModel().getSelectedItem())){
            returnValue += "diedCountry=" + fieldText.getText();
        }
        else if ("bornCountry".equals(choices.getSelectionModel().getSelectedItem())){
            returnValue += "bornCountry=" + fieldText.getText();
        }
        return returnValue;
    }   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choices.getItems().setAll(content);
        male.setToggleGroup(gender);
        male.setUserData("male");
        female.setUserData("female");
        female.setToggleGroup(gender);
        
        genderCol.setCellValueFactory(new PropertyValueFactory("gender"));
        yearCol.setCellValueFactory(new PropertyValueFactory("year"));
        categoryCol.setCellValueFactory(new PropertyValueFactory("category"));
        bornDateCol.setCellValueFactory(new PropertyValueFactory("bornDate"));
        diedDateCol.setCellValueFactory(new PropertyValueFactory("diedDate"));
        bornCountryCol.setCellValueFactory(new PropertyValueFactory("bornCountry"));
        diedCountryCol.setCellValueFactory(new PropertyValueFactory("diedCountry"));
        bornCityCol.setCellValueFactory(new PropertyValueFactory("bornCity"));
        diedCityCol.setCellValueFactory(new PropertyValueFactory("diedCity"));
        firstnameCol.setCellValueFactory(new PropertyValueFactory("firstname"));
        surnameCol.setCellValueFactory(new PropertyValueFactory("surname"));
        
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
    



