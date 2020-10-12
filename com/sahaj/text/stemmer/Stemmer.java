package com.sahaj.text.stemmer;

public abstract  class Stemmer {

    /**
     * remove stops words like 'a','the', 'then','what' etc
     * @param input
     * @return
     */
    abstract String removeStopWords(String input);


    abstract String tokenize(String input);

    /**
     * example :
     * Caresesses -> Caress
     * Ponies -> Poni
     * cats -> cat
     * @param input
     * @return  stemmed ouput
     */
    abstract String lemmatize(String input);

    /**
     * apply alog to get stem sentence
     *
     * Algo step -
     * 1. convert input to lowercase
     * 2. remove stop words
     * 3. tokenize input
     * 4. perform lemmatization
     *
     * @param input
     * @return stemmed ouput
     */
    public String stem(String input){

        String toLower = input.toLowerCase();

        String removeStopWords = removeStopWords(toLower);

        String tokenized = tokenize(removeStopWords);

        return lemmatize(tokenized);


    }
}
