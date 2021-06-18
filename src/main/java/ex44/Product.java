/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex44;

public class Product {

    String name;
    double price;
    int quantity;

    public Product(String string, double dollars, int amount) {
        name = string;
        price = dollars;
        quantity = amount;
    }

    // creates formatted string output
    public static String printProduct(Product product) {
        return String.format( "Name: " + product.name + "\n"
                            + "Price: %.2f\n"
                            + "Quantity: " + product.quantity,
                            product.price);
    }

}



