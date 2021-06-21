/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex42;

import java.util.Scanner;

public class Salary {
    String firstName;
    String lastName;
    int salary;

    //constructor for Salary class
    public Salary(String first, String last, int dollars) {
        firstName = first;
        lastName = last;
        salary = dollars;
    }

    //takes Scanner that reads file and writes line to string
    //splits string by commas into string array, convert string of numbers to int
    // creates new Salary object and returns it
    public static Salary addSalary(Scanner readFile) {
        String data = readFile.nextLine();
        String[] strArr = data.split(",");
        int dollars = Integer.parseInt(strArr[2]);
        Salary newSalary = new Salary(strArr[1], strArr[0], dollars);
        return newSalary;
    }

    public static String printSalary(Salary salary) {
        return String.format("%-9s|%-9s|%-6d", salary.lastName, salary.firstName, salary.salary);
    }
}
