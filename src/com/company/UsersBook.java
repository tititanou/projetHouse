package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsersBook {

    private Map<String, Users> usersMap;
    private UsersLogger logger;

    UsersBook() {
        usersMap = new HashMap<>();
        logger = new UsersLogger();
    }

    void addUsers(String firstName , String lastName , String bank , int loan , int rate) {
        Users buyer = new Users(firstName , lastName , bank , loan , rate);
        String patro = firstName + " " + lastName;
        usersMap.put(patro, buyer);
        logger.logToFile("Adding buyer/" + firstName + "/" + lastName + "/" + bank + "/" + loan + "/" + rate + "\n");
        logger.loggingFile("Adding buyer\n" + buyer + "\n");
    }
}
