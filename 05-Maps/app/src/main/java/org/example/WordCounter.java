package  org.example; 

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private int count;
    private String word;

    private HashMap<String, Integer> wordMap = new HashMap<>();

    public WordCounter(){

    }
    public WordCounter(String word, int count){
        this.word = word;
        this.count = count;

    }

    public String getWord(){
        return word;
    }

    public int getCount(){

        return count; 
    }

    public void setWord(String word){
        this.word = word;
    }

    public void setCount(int count){
        this.count = count;
    }

    // Fügt ein Wort zum Zähler hinzu und erhöht die Häufigkeit des Wortes
    // Beispiel: Bei der Eingabe "Test" wird Test: 1 gespeichert, bei erneuter Eingabe des Wortes wird Test: 2 gespeichert

    public void addToCounter(String input){
        if(wordMap.containsKey(input)){
            int currentWordCount = wordMap.get(input);
            wordMap.put(input, currentWordCount + 1 );
        }else {
            wordMap.put(input, 1);
        }

    }

    // Gibt die gespeicherten Wörter und deren Häufigkeiten zurück
   public Map<String, Integer> getWordCounts() {
    return wordMap;
}

    public int getTotalWords() {
        int total = 0;
        for (int count : wordMap.values()) {
            total += count;
        }
        return total;
    }

    public String getMostFrequentWord(){
        String maxWord = "";
        int maxCount = 0 ;
          for (Map.Entry<String, Integer> wordObject : wordMap.entrySet()) {
            int currentWordCount =  wordObject.getValue();
            String currentWord = wordObject.getKey();
            if(maxCount < currentWordCount){
                maxCount = currentWordCount;
                maxWord = currentWord;
            }
        }

        return maxWord;

    }

    public String getLeastFrequentWord(){
        String minWord = "";
        int minWordCount = Integer.MAX_VALUE;
          for (Map.Entry<String, Integer> wordObject : wordMap.entrySet()) {
            int currentWordCount =  wordObject.getValue();
            String currentWord = wordObject.getKey();

            if(
                currentWordCount < minWordCount || 
                (currentWordCount == minWordCount && currentWord.compareTo(minWord) > 0))
                {
                minWordCount = currentWordCount;
                minWord = currentWord;
            }

        }
        return minWord;
    }

    @Override
    public String  toString(){
        return "word: " + getWord() + " " + "count: " + getCount();
    }

}