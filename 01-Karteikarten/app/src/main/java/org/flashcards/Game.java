package org.flashcards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class  Game {
    // einen Score der korrekt beantworteten Karten 
    HashMap<Number, Card> scoredCardsHashMap = new HashMap<>();

    // Liste aller Karten speichern
    ArrayList<Card> cardsList = new ArrayList<>();
    
    Scanner userInput = new Scanner(System.in);
    
    public void logAllCards(){
        for(Card card : cardsList){
            System.err.println("Q: " + card.getQuestion() );
            System.err.println("A: " + card.getAnswer() );
        }
    }
    
    public void setUp(Scanner scanner){
        boolean nextCard = true;
        
        while(nextCard){
            System.out.println("Enter card question:");
            String question = scanner.nextLine();

            // Implement retrieval of answer and adding of card to card list
            System.out.println("Enter the answer for the question: " + question);
            String answer = scanner.nextLine();

            Card currentCard = new Card(question, answer);

            cardsList.add(currentCard);

            System.err.println("flashcard saved... Question: " + currentCard.getQuestion() + " " + "Answer: "  + currentCard.getAnswer());

            System. out.println("Do you want to add a new card? (y/n)");
            String input = scanner.nextLine();  


            // Implement follow up logic
            if(input.contentEquals("n")){
                nextCard = false;
                logAllCards();

            } else if (input.contentEquals("y")){
                setUp(userInput);
            }
        }

    

   }
}