/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex46;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void mapToWordList() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("test", 6);
        map.put("more", 3);
        map.put("testing", 7);
        List<Word> words = Word.mapToWordList(map);
        Assertions.assertEquals(6, words.get(0).frequency);
        Assertions.assertEquals(3, words.get(1).frequency);
        Assertions.assertEquals(7, words.get(2).frequency);

    }

    @Test
    void sortList() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("test", 6);
        map.put("more", 3);
        map.put("testing", 7);
        List<Word> words = Word.mapToWordList(map);
        words = Word.sortList(words);
        Assertions.assertEquals(7, words.get(0).frequency);
        Assertions.assertEquals(6, words.get(1).frequency);
        Assertions.assertEquals(3, words.get(2).frequency);
    }

    @Test
    void printWordFrequency() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("test", 6);
        List<Word> words = Word.mapToWordList(map);
        Assertions.assertEquals("test: ******\n", Word.printWordFrequency(words));

    }

    @Test
    void barGraphBuilder() {
        Assertions.assertEquals("******", Word.barGraphBuilder(6));
    }
}