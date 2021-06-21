/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Website {

    String siteName;
    String author;
    String js;
    String css;

    public Website(String name, String siteAuthor, String jsYorN, String cssYorN) {
        siteName = name;
        author = siteAuthor;
        js = jsYorN;
        css = cssYorN;
    }

    public static boolean createWebsiteDirectory(File file) {
        return file.mkdirs();
    }

    public static void createWebsiteHTML(String directory, Website website) {
        File file = new File(directory + "/index.html");

        // create FileWriter and write boilerplate html filled with website properties
        try {
            if (file.createNewFile()) {
                FileWriter writeHTML = new FileWriter(directory + "/index.html");
                writeHTML.write("<!doctype html>\n" +
                        "\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "  <meta charset=\"utf-8\">\n" +
                        "\n" +
                        "  <title>" + website.siteName + "</title>\n" +
                        "  <meta name=\"description\" content=\"" + website.siteName + "\">\n" +
                        "  <meta name=\"" + website.author + "\">\n" +
                        "\n" +
                        "  <link rel=\"stylesheet\" href=\"css/styles.css?v=1.0\">\n" +
                        "\n" +
                        "</head>\n" +
                        "\n" +
                        "<body>\n" +
                        "  <script src=\"js/scripts.js\"></script>\n" +
                        "</body>\n" +
                        "</html>");
                writeHTML.close();
            }

        } catch (IOException e) {
            System.out.println("Could not create file.");
        }
    }

    public static boolean createWebsiteCSS(String directory) {
        File file = new File(directory + "/css");
        return file.mkdir();
    }

    public static boolean createWebsiteJS(String directory) {
        File file = new File(directory + "/js");
        return file.mkdir();
    }
}
