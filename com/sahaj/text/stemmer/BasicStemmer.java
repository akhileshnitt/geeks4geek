package com.sahaj.text.stemmer;

import com.sahaj.text.util.StopWordUtil;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BasicStemmer extends Stemmer {


    @Override
    String removeStopWords(String input) {
        return Arrays.stream(input.split(" ")).filter(e-> !StopWordUtil.isStopWord(e)).collect(Collectors.joining(" "));
    }

    @Override
    String tokenize(String input) {
        //TODO
        System.out.println("BasicStemmer does not implement tokenization");
        return input;
    }

    @Override
    String lemmatize(String input) {
        //TODO
        System.out.println("BasicStemmer does not implement lemmatization");
        return input;
    }

    public static void main(String[] args) {
        String s = "Zebras are several species of African equids (horse family) united by their distinctive black and white stripes.";
        BasicStemmer basicStemmer = new BasicStemmer();
        String temp = basicStemmer.removeStopWords(s);
        System.out.println(temp);
    }
}
