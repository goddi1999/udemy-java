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

    public void addToCounter(String input){
        if(wordMap.containsKey(input)){
            int currentWordCount = wordMap.get(input);
            wordMap.put(input, currentWordCount +1 );
        }else {
            wordMap.put(input, 1);
        }

    }

    public void getWordCounts(){
        for (Map.Entry<String, Integer> wordObject : wordMap.entrySet()) {
            System.out.println("word: " + wordObject.getKey() + " " + "count: " + wordObject.getValue());
        }
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

}