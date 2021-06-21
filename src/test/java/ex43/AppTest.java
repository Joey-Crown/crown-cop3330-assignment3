/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex43;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void createWebsite() {
        Website website = new Website("awesomeco", "Joe Crown", "y", "y");
        Assertions.assertTrue(App.createWebsite("src/test/java/ex43", website));
    }
}