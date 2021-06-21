package ex45;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtilities {

    // takes input file path and reads text into the string 'data'
    public static String readFromFile(String path) {
        try {
            String data = new String(Files.readAllBytes(Paths.get(path)));
            return data;
        } catch (IOException e) {
            System.out.println("Failure reading file");
        }
        return null;
    }

    // replaces all instances of a word in the string with another word
    // writes edited string to output file
    public static String writeToFile(String find, String outputFile) {
        String replace = find.replaceAll("utilize", "use");
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            fileWriter.write(replace);
            fileWriter.close();

        } catch (IOException e) {
            return "Error writing to file.";
        }

        return "File output successful, 'utilize' replaced with 'use'.";
    }

    // creates file in /ex45/ according to string provided
    public static String createFile(String outputFile){
        try {
            File file = new File(outputFile);
            if (file.createNewFile()) {
                return "File successfully created.";
            }
        } catch (IOException e) {
            return "Error creating file.";
        }
        return "File already created.";
    }
}
