package org.reutlingenuniversity.yourproject;


public class Card {

    String question = "";
    String answer = "";


    boolean validateUserInput(String userInputValue){
        boolean isValidUserInput =true;
        if(userInputValue.length() == 0){
            isValidUserInput = false;                    
        }
        return isValidUserInput;
    }

    String getQuestion(){
        return question;
    }
    String getAnswer(){
        return answer;
    }
    
}