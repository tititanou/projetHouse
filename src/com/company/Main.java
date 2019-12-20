package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /**
         * attributes of the main class
         * an int corresponding to the input choice of the application user
         * the 3 lists to stock the objects
         */
        int myChoice;
        List<Users> usersList = new ArrayList();
        List<Houses> housesList = new ArrayList();
        List<Sales> salesList = new ArrayList();

        do {
            Utilities.displayMenu();
            myChoice = Utilities.getInputChoice();
            if (myChoice != 2) {
                Utilities.processCommand(myChoice , usersList , housesList , salesList);
            }
        } while(myChoice != 2);

    }
}
