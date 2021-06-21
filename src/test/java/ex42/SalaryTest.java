/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex42;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SalaryTest {

    @Test
    void addSalary() throws FileNotFoundException {
        File file = new File("src/main/java/ex42/exercise42_input.txt");
        Scanner readFile = new Scanner(file);
        Assertions.assertEquals("Ling", Salary.addSalary(readFile).lastName);
        Assertions.assertEquals("Jim", Salary.addSalary(readFile).firstName);
        Assertions.assertEquals(46000, Salary.addSalary(readFile).salary);
    }

    @Test
    void printSalary() {
        Salary salary = new Salary("Mai", "Ling", 55900);
        Assertions.assertEquals("Ling     |Mai      |55900 ", Salary.printSalary(salary));
    }
}