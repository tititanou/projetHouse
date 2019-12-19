package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Users> usersList = new ArrayList();
        List<Houses> housesList = new ArrayList();

	    HousesCmd.add(housesList);
        HousesCmd.add(housesList);
        HousesCmd.list(housesList);
        HousesCmd.edit(housesList);
        HousesCmd.list(housesList);
        HousesCmd.remove(housesList);
        HousesCmd.list(housesList);
    }
}
