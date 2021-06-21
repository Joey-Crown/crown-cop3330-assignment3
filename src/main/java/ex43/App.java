/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex43;

import java.io.File;
import java.util.Scanner;

/* Exercise 43 - Website Generator
Programming languages can create files and folders too.

Create a program that generates a website skeleton with the following specifications:

Prompt for the name of the site.
Prompt for the author of the site.
Ask if the user wants a folder for JavaScript files.
Ask if the user wants a folder for CSS files.
Generate an index.html file that contains the name of the site inside the <title> tag and the author in a <meta> tag.

Example Output

Site name: awesomeco
Author: Max Power
Do you want a folder for JavaScript? y
Do you want a folder for CSS? y
Created ./website/awesomeco
Created ./website/awesomeco/index.html
Created ./website/awesomeco/js/
Created ./website/awesomeco/css/
The user should then find these files and directories created in the working directory of your program.

Challenges

Implement this in a scripting language on Windows, OSX, and Linux.
Implement this as a web application that provides the specified site as a zip file.
 */
public class App {

    /*
    pseudocode:
    create object of class Website with properties name, author, js, css
    use object properties to determine what properties will get made
    use method createWebsite() that uses conditional statements based on object properties to create files
    have each file creation in a separate method in class Website
     */
    public static void main(String[] args) {
        Website website = userInput();
        if(createWebsite("src/main/java/ex43", website)) {
            System.out.println("Website successfully created.");
        } else {
            System.out.println("Failed to create website. Check console for errors.");
        }
    }

    public static boolean createWebsite(String websiteDir, Website website) {
        String directory = websiteDir + "/website/" + website.siteName;
        File file = new File(directory);
        boolean status = true;      // variable set to false upon error

        // creates direct and if successful creates 'index.html' + css/js folders
        if(Website.createWebsiteDirectory(file)) {
            System.out.println("Created ./website/" + website.siteName);

            Website.createWebsiteHTML(directory, website);
            System.out.println("Created ./website/" + website.siteName + "/index.html");

            if(website.js.equals("y")) {
                if(Website.createWebsiteJS(directory)) {
                    System.out.println("Created ./website/" + website.siteName + "/js");
                }
                else {
                    System.out.println("Failed to create JavaScript directory");
                    status = false;
                }
            }
            if(website.css.equals("y")) {
                if(Website.createWebsiteCSS(directory)) {
                    System.out.println("Created ./website/" + website.siteName + "/css");
                }
                else {
                    System.out.println("Failed to create CSS directory");
                    status = false;
                }
            }

        } else {
            System.out.println("Failed to create website directory");
            status = false;
        }

        return status;
    }

    // takes user input and creates Website object
    public static Website userInput() {
        Scanner input = new Scanner(System.in);

        //input website name
        System.out.print("Site name: ");
        String name = input.nextLine();

        // input author
        System.out.print("Author: ");
        String siteAuthor = input.nextLine();

        // input y/n for javascript
        System.out.print("Do you want a folder for JavaScript? (y/n): ");
        String jsYorN = input.nextLine();

        // input y/n for css
        System.out.print("Do you want a folder for CSS? (y/n): ");
        String cssYorN = input.nextLine();

        Website website = new Website(name, siteAuthor, jsYorN, cssYorN);

        return website;
    }
}
