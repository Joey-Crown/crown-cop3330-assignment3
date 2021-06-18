/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex44;
/* Exercise 44 - Product Search
Pulling data from a file into a complex data structure makes parsing much simpler. Many programming languages support
the JSON format, a popular way of representing data.

Create a program that takes a product name as input and retrieves the current price and quantity for that product. The
product data is in a data file in the JSON format  and looks like this (you will create this file as `exercise44_input.json`):

{
    "products" : [
        {"name": "Widget", "price": 25.00, "quantity": 5 },
        {"name": "Thing", "price": 15.00, "quantity": 5 },
        {"name": "Doodad", "price": 5.00, "quantity": 10 }
    ]
}
Print out the product name, price, and quantity if the product is found. If no product matches the search, state that
no product was found and start over.

Example Output

What is the product name? iPad
Sorry, that product was not found in our inventory.
What is the product name? Galaxy
Sorry, that product was not found in our inventory.
What is the product name? Thing
Name: Thing
Price: 15.00
Quantity: 5

Constraints

The file is in the JSON format. Use a JSON parser to pull the values out of the file
(e.g. https://github.com/google/gson).
If no record is found, prompt again.

Challenges

Ensure that the product search is case insensitive.
When a product is not found, ask if the product should be added. If yes, ask for the price and the quantity, and save
it in the JSON file. Ensure the newly added product is immediately available for searching without restarting the program.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    /*
    pseudocode:
    .json input file is formatted as an object containing an array of objects
        - Product class will encapsulate the properties of each object in array 'products'
        - ProductList class will encapsulate the array 'products' as it's own object for parsing with gson
    Use Gson to grab product info and create objects upon start of program
    add products to list
    enter loop and get user input
    check name property through list
    if product name matches existing product --> print product info and exit loop
    if product doesn't exist --> continue to ask user for input
    exit program
    */

    static ProductList listOfProducts;

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/java/ex44/exercise44_input.json"; // file path to .json file

        //generates ProductList object from .json input file
        listOfProducts = ProductList.getProductsFromJson(filePath);

        if (listOfProducts != null) {
            // get user input
            String productName = userInput();

            // take user input and find product of matching name
            Product search = compareString(productName, listOfProducts);

            // print result
            System.out.println(Product.printProduct(search));

        } else {
            // output in case of null listOfProducts
            System.out.println("Product list is empty");
        }

    }

    // gets user input for product name
    public static String userInput() {
        Scanner input = new Scanner(System.in);

        //input product name
        System.out.print("What is the product name? ");
        return input.nextLine();
    }

    // compares user given name to the existing list of products and returns a match if found
    // calls userInput() again if there is no match and continues looping
    public static Product compareString(String productName, ProductList products) {
        while (true) {
            for (int i = 0; i < listOfProducts.products.size(); i++) {
                if (productName.equals(listOfProducts.products.get(i).name)) {
                    return listOfProducts.products.get(i);
                }
            }
            System.out.println("Sorry, that product was not found in our inventory.");
            productName = userInput();
        }
    }



}
