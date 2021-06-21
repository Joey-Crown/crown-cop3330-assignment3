/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex41;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Name {
    String firstName;
    String lastName;

    public Name(String first, String last) {
        firstName = first;
        lastName = last;
    }

    // takes string and splits it into first + last name
    public static Name addName(String name) {
        String [] strArr = name.split(", ");

        Name obj = new Name(strArr[1], strArr[0]);

        if (!obj.firstName.isEmpty() && !obj.lastName.isEmpty())
            return obj;
        else return null;
    }

    // reads line from file and returns it as a string
    public static String getNameFromFile(Scanner readFile) {
            String name = readFile.nextLine();
            return name;
    }

    // returns string in format "lastname, firstname"
    public static String printName(Name name) {
        return (name.lastName + ", " + name.firstName);
    }

}
