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