/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex44;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProductList extends Product{

    ArrayList<Product> products;

    // ProductList constructor
    public ProductList(ArrayList<Product> list, String string, double dollars, int amount) {
        super(string, dollars, amount);
        products = list;
    }

    // reads .json input file and returns a ProductList object
    public static ProductList getProductsFromJson(String filePath) {
        try {
            Gson gson = new Gson();

            // initialize Reader to read file text
            Reader readFromFile = Files.newBufferedReader(Paths.get(filePath));

            // Gson uses Reader to parse .json file info and create a ProductList object
            ProductList list = gson.fromJson(readFromFile, ProductList.class);
            return list;
        } catch (IOException e) {
            System.out.println("Error reading from file");
        }

        return null;
    }


}
