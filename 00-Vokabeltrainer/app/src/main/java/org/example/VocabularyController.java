package org.example;

import java.util.HashSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class VocabularyController {
   private HashSet<Vocabulary> vocabularyList = new HashSet<>();
   private Vocabulary vocabulary;

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
   public void handleOnSaveVocabulary(ActionEvent event){
    updateVocabularyList();
   }

    private void updateVocabularyList(){
        String  germanWord = germanTextField.getText();
        String englishWord = englishTextField.getText();
    
        Vocabulary vocabularyItem = new Vocabulary(germanWord, englishWord);
        vocabularyList.add(vocabularyItem);

        System.out.println("item added : " + vocabularyItem.toString());
        cleanUpTextFields();
    }

    private void cleanUpTextFields(){
        germanTextField.setText("");
        englishTextField.setText("");
    }

}
