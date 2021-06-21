/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex42;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void getSalaryFromFile() {
        Assertions.assertTrue(App.getSalaryFromFile("src/main/java/ex42/exercise42_input.txt"));
        Assertions.assertFalse(App.getSalaryFromFile("src/main/java/ex42/doesnt_exist.txt"));
    }
}