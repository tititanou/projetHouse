package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Users> usersList = new ArrayList();

	    UsersCmd.adduser(usersList);
        UsersCmd.adduser(usersList);
        UsersCmd.adduser(usersList);

        for(int i = 0; i < usersList.size() ; i++) {
            System.out.println(usersList.get(i).toString());
        }
    }
}
