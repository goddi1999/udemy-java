package org.example;
import java.util.HashSet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class VocabularyViewModel {
   @FXML
   private Button submitButton;
   
   @FXML
   private Label submitLabel;

   @FXML
   private TextField englishTextField;
   
   @FXML
   private TextField germanTextField;
   
   HashSet<Vocabulary> vocabularyList = new HashSet<>();
   
   public void handleOnSaveVocabulary(){
        String  germanWord = germanTextField.getText();
        String englishWord = englishTextField.getText();
    
        Vocabulary vocabularyItem = new Vocabulary(germanWord, englishWord);
        vocabularyList.add(vocabularyItem);


    }


}
