package org.flashcards;

public class Card {
    String question = "";
    String answer = "";

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Card(String question, String answer){
        this.question = question;
        this.answer = answer;
    }


    public Boolean validateUserInput(String userInput){
        return userInput.length() >= 0;
    }


}