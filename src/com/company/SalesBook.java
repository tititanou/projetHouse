package com.company;

import java.util.HashMap;
import java.util.Map;

public class SalesBook {

    private Map<String, Sales> salesMap;
    private SalesLogger logger;

    SalesBook() {
        salesMap = new HashMap<>();
        logger = new SalesLogger();
    }

    void addSales(Users buyer, Houses house, String saleAgreement, String definitiveSale) {
        Sales sale = new Sales(buyer , house , saleAgreement , definitiveSale);
        String ref = house.getRef();
        salesMap.put(ref, sale);
        logger.logToFile("Adding sale/" + buyer.getFirstName() + "/" + buyer.getLastName() + "/" + house.getRef() + "/"
                + saleAgreement + "/" + definitiveSale + "\n");
        logger.loggingFile("Adding sale\n" + sale + "\n");
    }

}
