package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HousesLogger implements ILogger{

    /**
     *method to create a new file and write on it
     * @param message
     */
    public void logToFile(String message) {
        try {
            File f = new File("housesbook.txt");
            FileWriter fileWriter = new FileWriter(f, true);
            fileWriter.write(message);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *method to create a new file and write on it
     * @param message
     */
    public void loggingFile(String message){
        try {
            File f = new File("housesbook.log");
            FileWriter fileWriter = new FileWriter(f, true);
            fileWriter.write(message);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
