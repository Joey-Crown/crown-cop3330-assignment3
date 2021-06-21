/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void addName() {
        Assertions.assertEquals("Joseph", Name.addName("Crown, Joseph").firstName);
        Assertions.assertEquals("Crown", Name.addName("Crown, Joseph").lastName);
    }

    @Test
    void getNameFromFile() throws FileNotFoundException {
        File file = new File("src/main/java/ex41/exercise41_output.txt");
        Scanner readFile = new Scanner(file);
        Assertions.assertEquals("Ling, Mai", Name.getNameFromFile(readFile));

    }

    @Test
    void printName() {
        Name name = new Name("Joseph", "Crown");
        Assertions.assertEquals("Crown, Joseph", Name.printName(name));
    }
}