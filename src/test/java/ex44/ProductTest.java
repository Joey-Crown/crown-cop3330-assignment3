/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex44;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void printProduct() {
        Assertions.assertEquals("Name: NewThing\n" + "Price: 20.00\n" + "Quantity: 8",
                Product.printProduct( new Product("NewThing", 20.00, 8)));
    }
}