/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex44;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductListTest {

    @Test
    void getProductsFromJson() {
        Assertions.assertEquals(null, ProductList.getProductsFromJson("/fakefile.json"));

    }
}