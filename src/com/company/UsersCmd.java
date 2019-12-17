package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UsersCmd {

    private Map<String, Users> usersBook = new HashMap<>();

    public static Users createUser() {
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
                    } else {
                        System.out.println("Rate is not ok!");
                    }
                } else {
                    System.out.println("Loan is not ok!");
                }
            } catch (Exception e) {
                System.out.println(" Not valid because " + e.getMessage() + " \n Create a buyer again.");
                // consume the rest of characters from the standard input
                sc.next();
            }
        } while (!isOK);
        // return the new object
        return buyer;
    }

    public static void adduser(List<Users> usersList) {
        Users buyer = createUser();
        for (int i = 0; i < usersList.size(); i++) {
            if (buyer.equals(usersList.get(i))) {
                System.out.println("Error: this user already exists.");
                return;
            }
        }
        usersList.add(buyer);
    }


    public static void edituser(List<Users> usersList) {
        /*
                - la commande recherche un utilisateur avec exactement le patronyme rentré. Si l'utilisateur existe, alors la commande demande le nouveau nom (si on entre une chaine vide, alors pas de changement de nom), demande ensuite le nouveau prénom (si chaine vide, pas de changement) et va demander ensuite chaque champ (toujours avec la possibilité de ne pas changer la valeur en appuyant sur entrée pour laisser une chaine vide).
                - la commande va ensuite vérifier les nouvelles informations entrées (comme le fait adduser) et enregistrer les modifications de l'utilisateur DANS LE MEME OBJET (on modifie l'utilisateur, on n'en créé pas de nouveau). SI une erreur est survenue dans la saisie des nouvelles valeurs (ex : le nouveau nom et le nouveau prénom existent deja, ou bien un taux qui n'est pas un entier) alors on ne modifie pas l'utilisateur et on affiche un message d'erreur.
                - si l'utilisateur recherché n'existe pas dans la liste, alors on affiche un message d'erreur.
                - si l'utilisateur est utilisé dans une transaction , alors la modification de cet utilisateur ne pourra pas se faire et un message d'erreur sera affiché */
        String function;
        String fn;
        String ln;
        String firstname;
        String lastname;
        String b;
        String l;
        int loan;
        String r;
        int rate;

        Scanner sc = new Scanner(System.in);

        boolean isOK = false;
       // do {
            try {
                System.out.println("edituser,firstname,lastname,");
                Scanner scan = sc.useDelimiter(",");
                function = scan.next();
                fn = scan.next();
                ln = scan.next();
                String patro = fn + " " + ln;
                for (int i = 0; i < usersList.size(); i++) {
                    Users buyer = usersList.get(i);
                    if (buyer.equals(patro)) {
                        Scanner scann = new Scanner(System.in);
                        System.out.println("Enter a new firstname:");
                        firstname = scann.nextLine();
                        if (!firstname.equals("")) {
                            System.out.println("Enter a new lastname: ");
                            lastname = scann.nextLine();
                            if (!lastname.equals("")) {
                                String patronym = firstname + " " + lastname;
                                for (int j = 0; j < usersList.size(); j++) {
                                    if (!usersList.get(j).equals(patronym)) {
                                        buyer.setFirstName(firstname);
                                        buyer.setLastName(lastname);
                                    } else {
                                        System.out.println("This buyer already exists!");
                                    }
                                }
                            } else {
                                String patronym = firstname + " " + ln;
                                for (int j = 0; j < usersList.size(); j++) {
                                    if (!usersList.get(j).equals(patronym)) {
                                        buyer.setFirstName(firstname);
                                    } else {
                                        System.out.println("This buyer already exists!");
                                    }
                                }
                            }
                        } else {
                            System.out.println("Enter a new lastname: ");
                            lastname = sc.nextLine();
                            if (!lastname.equals("")) {
                                String patronym = fn + " " + lastname;
                                for (int j = 0; j < usersList.size(); j++) {
                                    if (!usersList.get(j).equals(patronym)) {
                                        buyer.setLastName(lastname);
                                    } else {
                                        System.out.println("This buyer already exists");
                                    }
                                }
                            }
                        }
                        System.out.println("Enter a new bank: ");
                        b = scann.nextLine();
                        if (!b.equals("")) {
                            buyer.setBank(b);
                        }
                        System.out.println("Enter a new loan: ");
                        l = scann.nextLine();
                        if (!l.equals("")) {
                            loan = Integer.parseInt(l);
                            if (loan > 100000) {
                                buyer.setLoan(loan);
                            } else {
                                System.out.println("Loan is not ok!");
                            }
                        }
                        System.out.println("Enter a new rate: ");
                        r = scann.nextLine();
                        if (!r.equals("")) {
                            rate = Integer.parseInt(r);
                            if (rate >= 0 && rate <= 100) {
                                buyer.setRate(rate);
                            } else {
                                System.out.println("Rate is not ok!");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(" Not valid because " + e.getMessage() + " \n Create a buyer again.");
                // consume the rest of characters from the standard input
                sc.next();
            }
        //} while (!isOK) ;
                // return the new object

    }
}