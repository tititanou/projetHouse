package com.company;

import java.util.HashMap;
import java.util.Map;

public class SalesBook {

    /**
     * private attributes of the salesbook class
     * a Map with keys of type String and values of type Sales
     * a logger of type saleslogger
     */
    private Map<String, Sales> salesMap;
    private SalesLogger logger;

    /**
     * Constructor method of salesbook
     */
    SalesBook() {
        salesMap = new HashMap<>();
        logger = new SalesLogger();
    }

    /**
     * method calling the methods to log the informations of a sale in a file
     * @param buyer
     * @param house
     * @param saleAgreement
     * @param definitiveSale
     */
    void addSales(Users buyer, Houses house, RandomDate saleAgreement, RandomDate definitiveSale) {
        Sales sale = new Sales(buyer , house , saleAgreement , definitiveSale);
        String ref = house.getRef();
        salesMap.put(ref, sale);
        logger.logToFile("Adding sale/" + buyer.getFirstName() + "/" + buyer.getLastName() + "/" + house.getRef() + "/"
                + saleAgreement + "/" + definitiveSale + "\n");
        logger.loggingFile("Adding sale\n" + sale + "\n");
    }

}
