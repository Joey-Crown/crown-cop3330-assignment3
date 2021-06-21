/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex46;

import java.util.*;

public class Word {

    String word;
    int frequency;

    public Word(String word, int frequency){
        this.word = word;
        this.frequency = frequency;
    }

    // iterates through map to store key and value as a list of objects 'Word'
    public static List<Word> mapToWordList(Map<String, Integer> wordMap){
        List<Word> wordList = new ArrayList<Word>();
        for (Map.Entry<String, Integer> word : wordMap.entrySet()) {
            wordList.add(new Word(word.getKey(), word.getValue()));
        }
        return wordList;
    }

    // sorts list by word frequency
    public static List<Word> sortList(List<Word> wordList) {

        // comparator sorts by word frequency in descending order
        Comparator<Word> compareFrequency = new Comparator<Word>() {
            public int compare(Word o1, Word o2) {
                return o2.frequency - o1.frequency;
            }
        };
        wordList.sort(compareFrequency);

        return wordList;
    }

    // uses a string builder to create a printable bar graph of words + frequencies
    public static String printWordFrequency(List<Word> wordList){
        StringBuilder barGraph = new StringBuilder();

        for (int i = 0; i < wordList.size(); i++) {
            barGraph.append(wordList.get(i).word + ": ");
            barGraph.append(barGraphBuilder(wordList.get(i).frequency) + "\n");
        }

        return barGraph.toString();
    }

    // converts word frequency to asterisks('*') to build 'bars' of the graph
    // e.g. word of frequency 3 returns string "***"
    public static String barGraphBuilder(int frequency){
        String bar = new String();
        for (int i = 0; i < frequency; i++) {
            bar += "*";
        }

        return bar;
    }
}
