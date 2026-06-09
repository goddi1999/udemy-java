package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class VocabularyController {
    private  ObservableList<Vocabulary> vocabularyList = FXCollections.observableArrayList();

    @FXML
    private Button submitButton;
    
    @FXML
    private Label submitLabel;

    @FXML
    private TextField englishTextField;

    @FXML
    private TextField germanTextField;
    
    @FXML
    private Label vocabularyLabel;

    @FXML
    private Button deleteButton;
    
    @FXML
    private Label deleteVocabularyItemLabel;
    
    @FXML
    private TextField deleteVocabularyTextField;

    @FXML
    private TableView<Vocabulary> vocabularyTable;

    @FXML
    private TableColumn<Vocabulary, String> germanColumn;

    @FXML
    private TableColumn<Vocabulary, String> englishColumn;
    
    @FXML 
    private Label statusLabel;
    
    @FXML 
    private Label allVocabularyLabel;

    @FXML 
    private ListView<Vocabulary> allVocabulary;

    
    @FXML
    private void initialize() {
        System.out.println("controller running bind fxml to java....");

        germanColumn.setCellValueFactory(new PropertyValueFactory<>("germanWord"));
        englishColumn.setCellValueFactory(new PropertyValueFactory<>("englishWord"));

        vocabularyTable.setItems(vocabularyList); 
    }
    
    @FXML
    public void handleOnSaveVocabulary(ActionEvent event){
        String  germanWord = germanTextField.getText().trim();
        String englishWord = englishTextField.getText().trim();

        addVocabularyToList(germanWord, englishWord);

    }

    @FXML
    public void handleOnDeleteVocabulary(ActionEvent event){
        String currentUserInput = deleteVocabularyTextField.getText().trim();
        System.out.println("user input: " + currentUserInput);

        boolean isDeleted = deleteVocabularyItem(currentUserInput);

       if(isDeleted){
            statusLabel.setText("successfully deleted!");
            statusLabel.setStyle("-fx-text-fill: green;");  
            cleanUpTextFields();      
       }else {
            statusLabel.setText("could not be deleted entry not found");
            statusLabel.setStyle("-fx-text-fill: red;");
       }
    }


    private boolean deleteVocabularyItem(String userInput){
        Vocabulary itemToDelete = null;
        boolean isDeleted = false;
        
        if(userInput.isEmpty()){
            return isDeleted;
       }


       // isDeleted =  vocabularyList.removeIf(vocabularyItem -> ( 
        //     vocabularyItem.getEnglishWord().equals(userInput)|| 
        //     vocabularyItem.getGermanWord().equals(userInput)
        // ));


        for (Vocabulary vocabularyItem : vocabularyList) {
           if   (
                vocabularyItem.getEnglishWord().equals(userInput)|| 
                vocabularyItem.getGermanWord().equals(userInput)
            ){
                isDeleted = true;
                itemToDelete = vocabularyItem;
            } 
        }

        if (itemToDelete != null && isDeleted) {
            vocabularyList.remove(itemToDelete);
        }

       return isDeleted;
    }

     

    private void addVocabularyToList(String germanWord, String englishWord){
        if(germanWord.isEmpty() ||englishWord.isEmpty()){
            statusLabel.setText("one input field is empty!");
            statusLabel.setStyle("-fx-text-fill: red;");
            System.out.println("input field is empty, not adding");
            return;
        }
        Vocabulary vocabularyItem = new Vocabulary(germanWord, englishWord);

        if (!vocabularyList.contains(vocabularyItem)) {
            vocabularyList.add(vocabularyItem);
            System.out.println("item added : " + vocabularyItem.toString()+ "\n");
            statusLabel.setText("item added !");
            statusLabel.setStyle("-fx-text-fill: green;");
            cleanUpTextFields();

        } else {
            System.out.println("Duplicate, not adding");
            statusLabel.setText("Duplicate, not adding!");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }

    public void cleanUpTextFields(){
        germanTextField.setText("");
        englishTextField.setText("");
        deleteVocabularyTextField.setText("");
    }

}
