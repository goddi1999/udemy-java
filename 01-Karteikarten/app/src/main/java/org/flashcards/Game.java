package org.flashcards;

import java.util.ArrayList;
import java.util.Scanner;


public class  Game {
    // einen Score der korrekt beantworteten Karten 

    Integer score = 0;
    // Liste aller Karten speichern
    ArrayList<Card> cardsList = new ArrayList<>();
    
    Scanner userInput = new Scanner(System.in);
    
    public void logAllCards(){
        for(Card card : cardsList){
            System.err.println("Q: " + card.getQuestion() );
            System.err.println("A: " + card.getAnswer() );
        }
    }


    public void  play(Scanner scanner){
        // Die gespeicherten Fragen werden nacheinander abgefragt.
        for (Card card : cardsList) {
            String currentCardQuestion = card.getQuestion();
            String currentCardAnswer=  card.getAnswer();
            
        // Der Benutzer gibt eine Antwort ein, die mit der gespeicherten Antwort verglichen wird.
            System.out.println("Q: " + currentCardQuestion);   

            String userAnswer = scanner.nextLine();

            boolean isAnswerCorrect =  userAnswer.contentEquals(currentCardAnswer);
        
        // Richtige Antworten erhöhen den Score u 1
            if(isAnswerCorrect){
               score = score + 1;
            } 
        }
        // Am Ende wird der erreichte Score als Nachricht ausgegeben.
        System.out.println("Du hast den Score: " + score + " erreicht");   

    }

    public void  play2(Scanner scanner, ArrayList<Card> cardList){
        // Die gespeicherten Fragen werden nacheinander abgefragt.

        for (int i = 0; i < cardList.size() -  1 ;i ++){

            Card card =  cardList.get(i);
            String currentCardQuestion = card.getQuestion();
            String currentCardAnswer=  card.getAnswer();

            // Der Benutzer gibt eine Antwort ein, die mit der gespeicherten Antwort verglichen wird.
            System.out.println("Q: " + currentCardQuestion);
            String userAnswer = scanner.nextLine();

            boolean isAnswerCorrect =  userAnswer.contentEquals(currentCardAnswer);
        
            // Richtige Antworten erhöhen den Score u 1
            if(isAnswerCorrect){
               score = score + 1;
            } 
        }
        // Am Ende wird der erreichte Score als Nachricht ausgegeben.
        System.out.println("2 Du hast den Score: " + score + " erreicht");   




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

            System.out.println("\nflashcard saved... Question: " + currentCard.getQuestion() + " " + "Answer: "  + currentCard.getAnswer() + "\n");

            System.out.println("Do you want to add a new card? (y/n)");
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