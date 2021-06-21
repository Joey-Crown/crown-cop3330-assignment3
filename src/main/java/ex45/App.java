/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex45;
/* Exercise 45 - Word Finder
There will be times when you'll need to read in one file, modify it, and then write a modified version of that file to
a new file.

Given an input file named `exercise45_input.txt`, read the file and look for all occurrences of the word utilize.
Replace each occurrence with use. Write the modified file to a new file.

Example Output
Given the input file of

One should never utilize the word "utilize" in writing. Use "use" instead.
For example, "She uses an IDE to write her Java programs" instead of "She
utilizes an IDE to write her Java programs".

The program should generate

One should never use the word "use" in writing. Use "use" instead.
For example, "She uses an IDE to write her Java programs" instead of "She
uses an IDE to write her Java programs".

Constraints

Prompt for the name of the output file.
Write the output to a new file.

Challenges

Modify the program to track the number of replacements and report that to the screen when the program finishes.
Create a configuration file that maps “bad” words to “good” words and use this file instead of a hard-coded value.
Modify the program so it can handle every file a folder of files instead of a single file.

 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class App extends FileUtilities{

    /*
    pseudocode:
    Ask user for output file name and store it as a string
    open input file and write all content to a string variable
    use replaceAll command to change 'utilize' to 'use'
    get the path of the current directory and add "/user_input"
    create file
    write the edited string to the file
     */

    public static void main(String[] args) {
        String path = "src/main/java/ex45/exercise45_input.txt";    // input file path
        String outputFile = "src/main/java/ex45/" + getUserInput(); // user named output file
        System.out.println(createFile(outputFile));                 // create output file
        String find = readFromFile(path);                           // read file into string
        if (find != null) {
            System.out.println(writeToFile(find, outputFile));      // replace words and output to file
        }
    }


    // gets user input for name of output file
    public static String getUserInput(){
        Scanner input = new Scanner(System.in);

        //input output file name
        System.out.print("What is the name of the output file? ");
        return input.nextLine();
    }

}
