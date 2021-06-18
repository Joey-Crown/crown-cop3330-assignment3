/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex41;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/* Exercise 41 - Name Sorter
Alphabetizing the contents of a file, or sorting its contents, is a great way to get comfortable manipulating a file in
your program.

Create a program that reads in the following list of names from a file called `exercise41_input.txt` and sorts the list
alphabetically:

Ling, Mai
Johnson, Jim
Zarnecki, Sabrina
Jones, Chris
Jones, Aaron
Swift, Geoffrey
Xiong, Fong

Then print the sorted list to a file called `exercise41_output.txt` that looks like the following example output.

Example Output

Total of 7 names
-----------------
Johnson, Jim
Jones, Aaron
Jones, Chris
Ling, Mai
Swift, Geoffrey
Xiong, Fong
Zarnecki, Sabrina

Constraint

Don't hard-code the number of names.

Challenges

Implement this program by reading in the names from the user, one at a time, and printing out the sorted results to a file.
Use the program to sort data from a large data set (e.g. census data) and use a profiler to analyze its performance.
 */
public class App {

    /*pseudocode :
        execute in order:

        App method populateList()
            - read from file line by line use delimiter to split last name and first name
            - loop through file and write to list of objects of class 'Name'
            - use method getNameFromFile() in class Name
                - takes line number
                - -open file `exercise41_output.txt`
                - returns line from file
            - use delimiter to split last name and first name
            - create object Name w/ method addName()
        class 'Name' has 2 fields, first + last name
            - class method 'addName()' object constructor
            - class method 'printName()' for printing an object

        method sortList() in class App sorts list by last name
            - use comparator method to sort of class property 'lastName'
        method printAllNames() in class App
            - loops through List and uses printName() method to print all names
     */

   static List<Name> names = new ArrayList<Name>();

    public static void main(String[] args) {
        if(!populateListFromFile("src/main/java/ex41/exercise41_output.txt"))
            System.out.println("Problem getting names from file");
        sortList();
        printAllNames();
    }

    // opens file and then calls getNameFromFile to get file line
    // calls addName() to create object from file line and adds to list
    public static boolean populateListFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner readFile = new Scanner(file);

            while(readFile.hasNextLine()) {
                String nameStr = Name.getNameFromFile(readFile);
                Name newName = Name.addName(names, nameStr);
                if (newName == null) {
                    return false; // return false in case of null object
                } else names.add(newName);
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
        return true;
    }

    // use comparator method to sort list of names by last name
    public static void sortList() {
        Comparator<Name> sortLastName = new Comparator<Name>() {
            public int compare(Name obj1, Name obj2) {
                if (obj1.lastName.equals(obj2.lastName)) { // if last names are equal then sort by first name
                    return obj1.firstName.compareTo(obj2.firstName);
                }
                else return obj1.lastName.compareTo(obj2.lastName);
            }
        };
        names.sort(sortLastName);
    }

    // prints information about list and all list entries using printName()
    public static void printAllNames() {
        System.out.println("Total of " + names.size() + " names");
        System.out.println("-----------------");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(Name.printName(names.get(i)));
        }
    }


}
