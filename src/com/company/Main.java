package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Users> usersList = new ArrayList();
        List<Houses> housesList = new ArrayList();
        List<Sales> salesList = new ArrayList();

        Users buyer1 = new Users("azerty" , "qwerty" , "CM" , 123456 , 7);
        Users buyer2 = new Users("qwerty" , "azerty" , "CM" , 987654 , 3);
        Users buyer3 = new Users("Buyer" , "House" , "CM" , 200000 , 4);
        usersList.add(buyer1);
        usersList.add(buyer2);
        usersList.add(buyer3);
        Houses house1 = new Houses("Le Châlet" , "AB123" , "Châlet" , 100000);
        Houses house2 = new Houses("La Villa" , "CD456" , "Villa" , 300000);
        Houses house3 = new Houses("Le Loft" , "EF789" , "Loft" , 500000);
        housesList.add(house1);
        housesList.add(house2);
        housesList.add(house3);

        UsersCmd.list(usersList);
        HousesCmd.list(housesList);



        SalesCmd.add(usersList , housesList , salesList);
        FilesCmd.save(usersList , housesList , salesList);
        /*SalesCmd.list(salesList);
        HousesCmd.list(housesList);
        HousesCmd.edit(housesList , salesList);
        HousesCmd.remove(housesList , salesList);
        SalesCmd.close(housesList , salesList);
        SalesCmd.list(salesList);*/

    }
}
