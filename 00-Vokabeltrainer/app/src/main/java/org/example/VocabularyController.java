package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        String currentUserInput = deleteVocabularyTextField.getText();
    }

    private void addVocabularyToList(String germanWord, String englishWord){

        if(germanWord.isEmpty() ||englishWord.isEmpty()){
            System.out.println("input field is empty, not adding");
            return;
        }
        Vocabulary vocabularyItem = new Vocabulary(germanWord, englishWord);

        if (!vocabularyList.contains(vocabularyItem)) {
            vocabularyList.add(vocabularyItem);
            System.out.println("item added : " + vocabularyItem.toString()+ "\n");
            cleanUpTextFields();

        } else {
            System.out.println("Duplicate, not adding");
        }
    }

    public void cleanUpTextFields(){
        germanTextField.setText("");
        englishTextField.setText("");
    }

}
