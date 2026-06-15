package org.flashcards;

import java.util.ArrayList;
import java.util.Scanner;


public class  Game {
    // einen Score der korrekt beantworteten Karten 
    Integer score = 0;
    // Liste aller Karten speichern
    ArrayList<Card> cardsList = new ArrayList<>();
    
    public void logAllCards(){
        for(Card card : cardsList){
            System.err.println("Q: " + card.getQuestion());
            System.err.println("A: " + card.getAnswer());
        }

    }

    public void play(Scanner scanner){
        System.out.println("\nTHE GAME STARTS.. HERE WE GO :) \n");

        Integer totalRounds = cardsList.size();
        Integer currentRound = 0;

        while(currentRound < totalRounds ){
            String cardQuestion =  cardsList.get(currentRound).getQuestion();
            String cardAnswer =  cardsList.get(currentRound).getAnswer();
            System.out.println("Question number: " + currentRound + ": " + cardQuestion);
           
            // Der Benutzer gibt eine Antwort ein, die mit der gespeicherten Antwort verglichen wird.
            String userAnswer = scanner.nextLine();

            if(userAnswer.equals(cardAnswer)){
                // Richtige Antworten erhöhen den Score + 1
                System.out.println("correct answer");
                    score = score + 1;
            }

            currentRound = currentRound + 1;
            System.out.println("updated round ->" + currentRound);
        }
        // Am Ende wird der erreichte Score als Nachricht ausgegeben.
        System.out.println("Du hast den Score: " + score + " erreicht");   
    }



   public void setup(Scanner scanner){
        boolean nextCard = true;
        
        while(nextCard){
            System.out.println("Enter card question: ");
            String question = scanner.nextLine();

            // Implement retrieval of answer and adding of card to card list
            System.out.println("Enter the answer for the question: " + question);
            String answer = scanner.nextLine();

            Card currentCard = new Card(question, answer);

            cardsList.add(currentCard);

            System.out.println("\nflashcard saved... Question: " + currentCard.getQuestion() + " " + "Answer: "  + currentCard.getAnswer() + "\n");

            System.out.println("Do you want to add a new card? (y/n) (type n or any other key then (n) to terminate...");
            String input = scanner.nextLine();  


            // Implement follow up logic
            if(input.equals("n")){
                nextCard = false;
                logAllCards();

            } else {
                nextCard = input.equals("y");
            }
        }
   }



}