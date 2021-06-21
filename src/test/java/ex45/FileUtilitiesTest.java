/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex45;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilitiesTest {

    @Test
    void readFromFile() {

        Assertions.assertEquals(null, FileUtilities.readFromFile("/fakefile.txt"));
        Assertions.assertTrue(!FileUtilities.readFromFile("src/main/java/ex45/exercise45_input.txt").isEmpty());
    }

    @Test
    void writeToFile() {
        String path = "src/main/java/ex45/exercise45_input.txt";
        Assertions.assertEquals("File output successful, 'utilize' replaced with 'use'.",
                FileUtilities.writeToFile(FileUtilities.readFromFile(path), "src/test/java/ex45/test.txt"));
        Assertions.assertEquals("Error writing to file.",
                FileUtilities.writeToFile(FileUtilities.readFromFile(path), "/test.txt"));
    }

    @Test
    void createFile() {
        Assertions.assertEquals("File successfully created.",
                FileUtilities.createFile("src/test/java/ex45/test.txt"));
        Assertions.assertEquals("Error creating file.",
                FileUtilities.createFile("/test.txt"));
        Assertions.assertEquals("File already created.",
                FileUtilities.createFile("src/test/java/ex45/testtext.txt"));

    }
}