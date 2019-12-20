package com.company;

import java.util.HashMap;
import java.util.Map;

public class HousesBook {

    /**
     * attributes of the housesbook class
     */
    private Map<String, Houses> housesMap;
    private HousesLogger logger;

    /**
     * constructor method of housesbook objects
     */
    HousesBook() {
        housesMap = new HashMap<>();
        logger = new HousesLogger();
    }

    /**
     * method to add a house object to a hashmap , to a .txt file , to a .log file
     * take as parameters all the attributes of a houses object
     * @param title
     * @param ref
     * @param category
     * @param price
     */
    void addHouses(String title, String ref, String category, int price) {
        Houses house = new Houses(title, ref, category, price);
        housesMap.put(ref, house);
        logger.logToFile("Adding house/" + title + "/" + ref + "/" + category + "/" + price + "\n");
        logger.loggingFile("Adding house\n" + house + "\n");
    }
}

