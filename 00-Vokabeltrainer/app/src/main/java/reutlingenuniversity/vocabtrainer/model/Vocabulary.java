package reutlingenuniversity.vocabtrainer.model;

import java.util.Objects;


public class Vocabulary {
    private  String germanWord;
    private  String englishWord;

    public Vocabulary(){

    }

    public Vocabulary(String germanWord,String englishWord ){
        this.germanWord = germanWord;
        this.englishWord = englishWord;
    }

    public String getGermanWord() {
        return germanWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setGermanWord(String germanWord) {
    this.germanWord = germanWord;
    }
    
    public void setEnglishWord(String englishWord) {
    this.englishWord = englishWord;
    }

  
    @Override 
    public String toString(){
        return getGermanWord()  + " " + getEnglishWord() + "\n";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Vocabulary vocabularyObject = (Vocabulary) object;

        return Objects.equals(germanWord, vocabularyObject.germanWord)
                && Objects.equals(englishWord, vocabularyObject.englishWord);
    }

    @Override
    public int hashCode(){
        return Objects.hash(germanWord, englishWord);
    }
}