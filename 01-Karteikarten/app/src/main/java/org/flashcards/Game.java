import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.flashcards.Card;


public class  Game {
    
    // einen Score der korrekt beantworteten Karten 
    HashMap<Number, Card> scoredCardsHashMap = new HashMap<>();

    // Liste aller Karten speichern
    ArrayList<Card> cardsList = new ArrayList<>();
   

   public void setUp(Scanner scanner){

    boolean nextCard = true;
    while(nextCard){
        System.out.println("Enter card question:");
        String question = scanner.nextLine();

        // Implement retrieval of answer and adding of card to card list
        System.out.println("Enter the answer for the question: " + question);
        String answer = scanner.nextLine();


        System. out.println("Do you want to add a new card? (y/n)");
        String input = scanner.nextLine();  
        // Implement follow up logic
    }

    

   }
}