/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex42;
/* Exercise 42 - Parsing a Data File
Sometimes data comes in as a structured format that you have to break down and turn into records so you can process
them. CSV, or comma-separated values, is a common standard for doing this.

Construct a program that reads in the following data file (you will need to create this data file yourself; name it
`exercise42_input.txt`):

Ling,Mai,55900
Johnson,Jim,56500
Jones,Aaron,46000
Jones,Chris,34500
Swift,Geoffrey,14200
Xiong,Fong,65000
Zarnecki,Sabrina,51500

Process the records and display the results formatted as a table, evenly spaced, as shown in the example output.

Example Output

Last      First     Salary
--------------------------
Ling      Mai       55900
Johnson   Jim       56500
Jones     Aaron     46000
Jones     Chris     34500
Swift     Geoffrey  14200
Xiong     Fong      65000
Zarnecki  Sabrina   51500

Constraints

Write your own code to parse the data. Don't use a CSV parser.

Challenges

Make each column one space longer than the longest value in the column.
Format the salary as currency with dollar signs and commas.
Sort the results by salary from highest to lowest.
Rework your program to use a CSV parsing library and compare the results.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    /*
    pseudocode:
    create object Salary with properties first name, last name, and salary
    loop through the file to read each line and then split it up based on the comma, adding each string to an array
    use array to create new object with that data, being sure to convert salary to an integer
    use a method to print out data in tabular format
     */

    static List<Salary> salaries = new ArrayList<Salary>();

    public static void main(String[] args) {
        getSalaryFromFile("src/main/java/ex42/exercise42_input.txt"); // takes file dir and populates list
        printSalaryData(); //prints salary data
    }

    // takes file name and calls Salary.addSalary() for every line of the file
    // adds returned Salary object to List 'salaries'
    public static void getSalaryFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner readFile = new Scanner(file);
            while(readFile.hasNextLine()) {
                salaries.add(Salary.addSalary(readFile));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    // loops length of list 'salaries' and calls Salaries.printSalary which returns formatted string
    public static void printSalaryData() {
        System.out.println("Last      First     Salary");
        System.out.println("--------------------------");
        for (int i = 0; i < salaries.size(); i++) {
            System.out.println(Salary.printSalary(salaries.get(i)));
        }
    }
}
