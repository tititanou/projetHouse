package com.company;

import java.util.*;

public class UsersCmd {


    public static Users create() {
        String f;
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
                System.out.println("adduser/firstname/lastname/bank/loan(more than 100.000)/rate(between 0 and 100)/");
                String scan = sc.nextLine();
                String [] info = scan.split("/");
                f = info[0];
                fn = info[1];
                ln = info[2];
                b = info[3];
                l = Integer.parseInt(info[4]);
                r = Integer.parseInt(info[5]);
                if (!f.equals("") && !fn.equals("") && !ln.equals("") && !b.equals("")) {
                    String function = f.toLowerCase();
                    if (function.equals("adduser")) {
                        if (l > 100000) {
                            if (r >= 0 && r <= 100) {
                                buyer = new Users(fn, ln, b, l, r);
                                isOK = true;
                            } else {
                                System.out.println("Rate is not ok!");
                                isOK = false;
                            }
                        } else {
                            System.out.println("Loan is not ok!");
                            isOK = false;
                        }
                    } else {
                        System.out.println("Invalid command. Please try again");
                        isOK = false;
                    }
                }
                else {
                    System.out.println("You cannot enter null value. Please try again.");
                }
            } catch (Exception e) {
                System.out.println(" Not valid because " + e.getMessage() + " \n Please try again.");
            }
        } while (!isOK);
        return buyer;
    }

    public static void add(List<Users> usersList) {
        Users buyer = create();
        if(buyer != null) {
            for (int i = 0; i < usersList.size(); i++) {
                if (buyer.equals(usersList.get(i))) {
                    System.out.println("Error: this user already exists.");
                    return;
                }
            }
            usersList.add(buyer);
        }
        else {
            System.out.println("Adduser failed. Please try again.");
        }
    }

    public static void edit(List<Users> usersList) {
        /* - si l'utilisateur est utilisé dans une transaction , alors la modification de cet utilisateur ne pourra pas se faire et un message d'erreur sera affiché */
        String f;
        String fn;
        String ln;
        String firstname;
        String lastname;
        String b;
        String l;
        int loan;
        String r;
        int rate;
        String patro = "";
        Scanner sc = new Scanner(System.in);
        Scanner scann = new Scanner(System.in);
        boolean buyerIsOK = false;
        boolean functionIsOk = false;
        do {
            System.out.println("edituser/firstname/lastname/");
            String scan = sc.nextLine();
            String [] info = scan.split("/");
            f = info[0];
            fn = info[1];
            ln = info[2];
            if (!f.equals("") && !fn.equals("") && !ln.equals("")) {
                String function = f.toLowerCase();
                if (function.equals("edituser")) {
                    patro = fn + " " + ln;
                    for (int i = 0; i < usersList.size(); i++) {
                        Users buyer = usersList.get(i);
                        if (buyer.equals(patro)) {
                            buyerIsOK = true;
                        } else {
                            buyerIsOK = false;
                        }
                    }
                    functionIsOk = true;
                } else {
                    System.out.println("Invalid command. Please try again");
                    functionIsOk = false;
                }
            }
            else {
                System.out.println("You cannot enter null value. Please try again.");
            }
        }while (!functionIsOk);

        if(buyerIsOK) {
            System.out.println("Enter a new firstname:");
            firstname = scann.nextLine();
            System.out.println("Enter a new lastname: ");
            lastname = scann.nextLine();
            System.out.println("Enter a new bank: ");
            b = scann.nextLine();
            System.out.println("Enter a new loan(>100.000): ");
            l = scann.nextLine();
            System.out.println("Enter a new rate(0 <= rate <= 100): ");
            r = scann.nextLine();

            String patronym;
            if(!firstname.equals("") && !lastname.equals("")){
                patronym = firstname + " " + lastname;
            }
            else if (!firstname.equals("") && lastname.equals("")){
                patronym = firstname + " " + ln;
            }
            else if (firstname.equals("") && !lastname.equals("")){
                patronym = fn + " " + lastname;
            }
            else {
                patronym = patro;
            }
            for (int i = 0 ; i < usersList.size() ; i++){
                Users buyer = usersList.get(i);
                if (buyer.equals(patronym)){
                    System.out.println("This user already exists.");
                    break;
                }
                else {
                    if (!l.equals("")) {
                        loan = Integer.parseInt(l);
                        if (loan < 100000) {
                            System.out.println("Loan is not ok!");
                            break;
                        } else {
                            if (!r.equals("")) {
                                rate = Integer.parseInt(r);
                                if (rate <= 0 || rate >= 100) {
                                    System.out.println("Rate is not ok!");
                                    break;
                                } else {
                                    if (!firstname.equals("")) {
                                        buyer.setFirstName(firstname);
                                    }
                                    if (!lastname.equals("")) {
                                        buyer.setLastName(lastname);
                                    }
                                    if (!b.equals("")) {
                                        buyer.setBank(b);
                                    }
                                    buyer.setLoan(loan);
                                    buyer.setRate(rate);
                                }
                            } else {
                                if (!firstname.equals("")) {
                                    buyer.setFirstName(firstname);
                                }
                                if (!lastname.equals("")) {
                                    buyer.setLastName(lastname);
                                }
                                if (!b.equals("")) {
                                    buyer.setBank(b);
                                }
                                buyer.setLoan(loan);
                            }
                        }
                    }
                    else{
                        if (!r.equals("")) {
                            rate = Integer.parseInt(r);
                            if (rate <= 0 || rate >= 100) {
                                System.out.println("Rate is not ok!");
                                break;
                            } else {
                                if (!firstname.equals("")) {
                                    buyer.setFirstName(firstname);
                                }
                                if (!lastname.equals("")) {
                                    buyer.setLastName(lastname);
                                }
                                if (!b.equals("")) {
                                    buyer.setBank(b);
                                }
                                buyer.setRate(rate);
                            }
                        } else {
                            if (!firstname.equals("")) {
                                buyer.setFirstName(firstname);
                            }
                            if (!lastname.equals("")) {
                                buyer.setLastName(lastname);
                            }
                            if (!b.equals("")) {
                                buyer.setBank(b);
                            }
                        }
                    }
                }
            }
        }
        else {
            System.out.println("This user doesn't exist!");
        }
    }

    public static void remove(List<Users> usersList) {
/*  [#5] removeuser <firstname> <lastname>
- cette commande recherche un utilisateur avec le même nom ET prénom rentrés et va le supprimer de la liste.
- si l'utilisateur recherché n'existe pas, alors on affiche un message d'erreur comme quoi il est introuvable.
- si l'utilisateur existe, il est supprimé de la liste en mémoire, et on affiche un message de réussite de l'effacement.
- si l'utilisateur est utilisé dans une transaction , alors l'effacement de cet utilisateur ne pourra pas se faire et un message d'erreur sera affiché */

        String f;
        String fn;
        String ln;
        String patro;
        Scanner sc = new Scanner(System.in);
        boolean buyerIsOK = false;
        boolean functionIsOk = false;
        do{
            System.out.println("edituser/firstname/lastname/");
            String scan = sc.nextLine();
            String [] info = scan.split("/");
            f = info[0];
            fn = info[1];
            ln = info[2];
            if (!f.equals("") && !fn.equals("") && !ln.equals("")) {
                String function = f.toLowerCase();
                if (function.equals("edituser")) {
                    patro = fn + " " + ln;
                    for (int i = 0; i < usersList.size(); i++) {
                        Users buyer = usersList.get(i);
                        if (buyer.equals(patro)) {
                            buyerIsOK = true;
                        } else {
                            buyerIsOK = false;
                        }
                    }
                    functionIsOk = true;
                } else {
                    System.out.println("Invalid command. Please try again");
                    functionIsOk = false;
                }
            }
            else {
                System.out.println("You cannot enter null value. Please try again.");
            }
        }while (!functionIsOk);
        /*if (buyerIsOK){
            System.out.println("Do you want to reemove " + );
        }*/

    }

    public static void list(List<Users> usersList){
        for(int i = 0; i < usersList.size() ; i++) {
            System.out.println(usersList.get(i).toString());
        }
    }
}