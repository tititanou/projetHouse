package com.company;

import java.util.HashMap;
import java.util.Map;

public class HousesBook {

    private Map<String, Houses> housesMap;
    private HousesLogger logger;

    HousesBook() {
        housesMap = new HashMap<>();
        logger = new HousesLogger();
    }

    void addHouses(String title, String ref, String category, int price) {
        Houses house = new Houses(title, ref, category, price);
        housesMap.put(ref, house);
        logger.logToFile("Adding house/" + title + "/" + ref + "/" + category + "/" + price + "\n");
        logger.loggingFile("Adding house\n" + house + "\n");
    }
}

