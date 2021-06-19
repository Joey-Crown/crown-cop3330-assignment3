/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex46;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
    use split method to split up string by ' ' into words

     */

    public static void main(String[] args) {
        String path = "src/main/java/ex46/exercise46_input.txt";
        String data = readFile(path);
        if (data != null) {

        }
    }

    public static String readFile(String path){
        File file = new File(path);
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            System.out.println("Epic fail");
        }
        return null;
    }

    public static void wordCounter(String data){

    }
}
