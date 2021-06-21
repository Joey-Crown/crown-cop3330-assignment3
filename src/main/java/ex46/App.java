/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex46;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Exercise 46 - Word Frequency Finder
Knowing how often a word appears in a sentence or block of text is helpful for creating word clouds and other types of
word analysis. And it’s more useful when running it against lots of text.

Create a program that reads in a file named `exercise46_input.txt` and counts the frequency of words in the file. Then
construct a histogram displaying the words and the frequency, and display the histogram to the screen.

Example Output

Given the text file `exercise46_input.txt` with this content

badger badger badger
badger mushroom
mushroom snake badger badger
badger

the program would produce the following output:

badger:   *******
mushroom: **
snake:    *

Constraint

Ensure that the most used word is at the top of the report and the least used words are at the bottom.

Challenges

Use a graphical program and generate bar graphs.
Test the performance of your calculation by providing a very large input file, such as Shakespeare's Macbeth. Tweak your
 algorithm so that it performs the word counting as fast as possible.
Write the program in another language and compare the processing times of the two implementations.
*/
public class App {

    /*
    pseudocode:
    Open file and read file to string
    use split method to split up string by ' ' into an array wof strings
    Loop through the array, creating a hash map where the key is the word, and the value is the word frequency
    iterate through hash map to create a list of objects of class 'Word'
    Sort list of Words using comparator that sorts in descending order by word frequency
    Print words and frequency, replacing the number of word instances with an asterisk('*') for every instance
     */

    static List<Word> words;

    public static void main(String[] args) {
        String path = "src/main/java/ex46/exercise46_input.txt";    // path to input file
        String data = readFile(path);                               // read file and store all words to a string
        if (data != null) {
            Map<String, Integer> wordMap = wordCounter(data);       // create map of key: word and value: frequency
            words = Word.mapToWordList(wordMap);                    // convert map to list for easier sorting
            words = Word.sortList(words);                           // sort list of Word objects by frequency
            System.out.println(Word.printWordFrequency(words));     // print all words and frequencies in 'bar graph' format
        }
    }

    // reads file and stores all text data in a string
    public static String readFile(String path){
        File file = new File(path);
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            System.out.println("Failure reading file.");
        }
        return null;
    }

    // converts string of words into string array
    // creates a hash map of word frequency Map<word, frequency>
    public static Map<String, Integer> wordCounter(String data){
        data = data.replaceAll("\n", " "); // formatting string for splitting into array
        data = data.replaceAll("\r", "");
        String[] wordArray = data.split(" ");

        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        for (int i = 0; i < wordArray.length; i++) {

            if (wordMap.containsKey(wordArray[i])) {
                wordMap.put(wordArray[i], wordMap.get(wordArray[i]) + 1);
            } else {
                wordMap.put(wordArray[i], 1);
            }
        }

        return wordMap;
    }

}
