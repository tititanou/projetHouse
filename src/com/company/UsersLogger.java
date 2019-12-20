package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UsersLogger implements ILogger{

    public void logToFile(String message) {
        try {
            File f = new File("usersbook.txt");
            FileWriter fileWriter = new FileWriter(f, true);
            fileWriter.write(message);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loggingFile(String message){
        try {
            File f = new File("usersbook.log");
            FileWriter fileWriter = new FileWriter(f, true);
            fileWriter.write(message);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
