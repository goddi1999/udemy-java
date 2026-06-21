package reutlingenuniversity.vocabtrainer.viewmodel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import reutlingenuniversity.vocabtrainer.model.Vocabulary;

public class VocabularyController {
    private  ObservableList<Vocabulary> vocabularyList = FXCollections.observableArrayList();
    public enum Direction {
        DE,
        EN
    }
    private Direction direction = Direction.DE;   
      

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
    private Button loadFileButton;

    @FXML
    private TextField loadFileTextField;

    @FXML
    private Label loadFileLabel;

    @FXML
    private Button trainButton;

    @FXML
    private TextField trainTextField;

    @FXML
    private Label randomWord;

    @FXML
    private Label trainFeedbackLabel;

    @FXML
    private TabPane vocabTab;

    @FXML
    private Tab trainTab;


    @FXML 
    private Button changeDirection;

    @FXML
    private Button nextWord;


    @FXML
    private void handleChangeDirection(){
        trainTextField.setText("");
        direction = direction == Direction.DE ? Direction.EN : Direction.DE;
        System.out.println("change direction to ...." + direction);

        String randomWordByIndex = getRandomWordFromVocabularyList(vocabularyList, direction);
        randomWord.setText(randomWordByIndex);
    }


    @FXML
    private void handleOnLoadFile() {
        String filePath = loadFileTextField.getText().trim();
        if (filePath.isEmpty()) {
            showError("Please enter a file path.");
            return;
        }

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            statusLabel.setText("File not found!");
            statusLabel.setStyle("-fx-text-fill: red;");
            showError("File not found: " + filePath);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",", 2);
                if (parts.length != 2) {
                    continue;
                }

                String germanWord = parts[0].trim();
                String englishWord = parts[1].trim();
                if (germanWord.isEmpty() || englishWord.isEmpty()) {
                    continue;
                }

                Vocabulary vocabularyItem = new Vocabulary(germanWord, englishWord);
                if (!vocabularyList.contains(vocabularyItem)) {
                    vocabularyList.add(vocabularyItem);
                }
            }

            if (line == null) {
                statusLabel.setText("Done successfully load");
                statusLabel.setStyle("-fx-text-fill: green;");
            }

        } catch (FileNotFoundException e) {
            statusLabel.setText("Error loading file!");
            statusLabel.setStyle("-fx-text-fill: red;");
            showError("File not found: " + filePath);
        } catch (IOException e) {
            statusLabel.setText("Error loading file!");
            statusLabel.setStyle("-fx-text-fill: red;");
            showError("Error reading file: " + e.getMessage());
        }
    }

    
    @FXML
    private void handleNextWord(){
        String randomWordByIndex = getRandomWordFromVocabularyList(vocabularyList, direction);
        System.out.println("direction" + direction + " " + randomWordByIndex);
        randomWord.setText(randomWordByIndex);
    }

    
    @FXML
    private void initialize() {
        System.out.println("controller running bind fxml to java....");

        germanColumn.setCellValueFactory(new PropertyValueFactory<>("germanWord"));
        englishColumn.setCellValueFactory(new PropertyValueFactory<>("englishWord"));

        vocabularyTable.setItems(vocabularyList); 

        // render random first vocabulary on Tab view
        vocabTab.getSelectionModel()
        .selectedIndexProperty()
        .addListener((obs, oldTabIndex, newTabIndex)-> {
            // System.err.println("obs: " +  obs);
            // System.err.println("oldTab: " +  oldTab);
            // System.err.println("newTab: " +  newTab);
        
            int listLength =  vocabularyList.size();
            if((int)newTabIndex ==  2 && listLength > 0 ){
                String randomWordByIndex = getRandomWordFromVocabularyList(vocabularyList, direction);
                randomWord.setText(randomWordByIndex);
            }      
        });
    }

    @FXML
    private void handleOnSaveFile() {
        String filePath = loadFileTextField.getText().trim();
        if (filePath.isEmpty()) {
            showError("Please enter a file path.");
            return;
        }

        if (vocabularyList.isEmpty()) {
            statusLabel.setText("Nothing to save!");
            statusLabel.setStyle("-fx-text-fill: red;");
            showError("No vocabulary entries to save.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (Vocabulary vocabularyItem : vocabularyList) {
                writer.write(vocabularyItem.getGermanWord()
                        + ","
                        + vocabularyItem.getEnglishWord());
                writer.newLine();
            }
            statusLabel.setText("Vocabulary saved successfully!");
            statusLabel.setStyle("-fx-text-fill: green;");
        } catch (IOException e) {
            statusLabel.setText("Error saving file!");
            statusLabel.setStyle("-fx-text-fill: red;");
            showError("Error saving file: " + e.getMessage());
        }
    }
    
    @FXML
    public void handleOnSaveVocabulary(ActionEvent event){
        String  germanWord = germanTextField.getText().trim();
        String englishWord = englishTextField.getText().trim();

        addVocabularyToList(germanWord, englishWord);

    }

    @FXML
    public void handleCheckAnswer(ActionEvent event){
        // get the current input value 
        String currentUserInput = trainTextField.getText().trim();  

        if(currentUserInput.isEmpty()){
            return; 
        }

        // compare it user input with current vocabulary
        System.out.println("direction" + direction + " " + currentUserInput);

        if(compareUserInputWithCurrentVocabulary(currentUserInput, direction))
            {
                trainFeedbackLabel.setText("Correct well done !");
                trainFeedbackLabel.setStyle("-fx-text-fill: green;");  
                

            }else {
                trainFeedbackLabel.setText("not correct");
                trainFeedbackLabel.setStyle("-fx-text-fill: red;");
            }
    }

    @FXML
    public void handleOnDeleteVocabulary(ActionEvent event){
        String currentUserInput = deleteVocabularyTextField.getText().trim();
        System.out.println("user input: " + currentUserInput);

        boolean isDeleted = deleteVocabularyItem(currentUserInput);
        System.out.println("isDeleted: " + isDeleted);

       if(isDeleted){
            statusLabel.setText("successfully deleted!");
            statusLabel.setStyle("-fx-text-fill: green;");  
            cleanUpTextFields();      
       }else {
            statusLabel.setText("could not be deleted entry not found");
            statusLabel.setStyle("-fx-text-fill: red;");
       }
    }

    public void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private String getRandomWordFromVocabularyList(
        ObservableList<Vocabulary> vocabularyList, 
        Direction direction
    ){   
        if (vocabularyList.isEmpty()) {
            return "";
        }

        int listLength =  vocabularyList.size();
        int randomIndex = (int)(Math.random() * (listLength));

        String  currentRandomWord =  direction == Direction.DE ?  
                vocabularyList.get(randomIndex).getGermanWord(): 
                vocabularyList.get(randomIndex).getEnglishWord();

        return currentRandomWord;
    }


    private boolean compareUserInputWithCurrentVocabulary (String userInput,  Direction direction){
        boolean isEqual = false;

        for (Vocabulary vocabularyItem : vocabularyList) {
            if   (
                    vocabularyItem.getEnglishWord().equals(userInput)|| 
                    vocabularyItem.getGermanWord().equals(userInput)
                ){
                    String word  = direction == Direction.EN ?  
                    vocabularyItem.getGermanWord(): 
                    vocabularyItem.getEnglishWord();
                    isEqual = userInput.equals(word);
                } 
            }
            return isEqual;
    }

    private boolean deleteVocabularyItem(String userInput){
        Vocabulary itemToDelete = null;
        boolean isDeleted = false;
        
        if(userInput.isEmpty()){
            return isDeleted;
       }

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
