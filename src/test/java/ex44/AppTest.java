/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex44;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void compareString() {
        App.listOfProducts = ProductList.getProductsFromJson("src/main/java/ex44/exercise44_input.json");
        Assertions.assertEquals("Thing", App.compareString("Thing").name);
        Assertions.assertNotEquals("Doodad", App.compareString("Thing").name);
    }
}