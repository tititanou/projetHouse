package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UsersCmd {

    private Map<String , Users> usersBook= new HashMap<>();

    public static Users createUser(){
        String function;
        String fn;
        String ln;
        String b;
        int l;
        int r;

        Scanner sc = new Scanner(System.in);

        boolean isOK = false;
        Users buyer = null;
        do {
            try {
                System.out.println("adduser,firstname,lastname,bank,loan,rate,");
                Scanner scan = sc.useDelimiter(",");
                function = scan.next();
                fn = scan.next();
                ln = scan.next();
                b = scan.next();
                l = scan.nextInt();
                if (l > 100000) {
                    r = scan.nextInt();
                    if (r >= 0 && r <= 100) {
                        // don't forget to close the scanner!!
                        // scan.close();
//                        sc.close();
                        buyer = new Users(fn, ln, b, l, r);
                        //System.out.println(character.toString());
                        isOK = true;
                    }
                    else{
                        System.out.println("Rate is not ok!");
                    }
                }else {
                    System.out.println("Loan is not ok!");
                }
            } catch (Exception e) {
                System.out.println(" Not valid because " + e.getMessage() + " \n Create a buyer again.");
                // consume the rest of characters from the standard input
                sc.next();
            }
        }while( !isOK );
        // return the new object
        return buyer;
    }

    public static void adduser(List<Users> usersList){
        Users buyer =  createUser();
        for(int i = 0 ; i < usersList.size() ; i++) {
            if (buyer.equals(usersList.get(i))) {
                System.out.println("Error: this user already exists.");
                return;
            }
        }
        usersList.add(buyer);
    }

}
