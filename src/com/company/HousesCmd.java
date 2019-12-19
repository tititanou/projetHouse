package com.company;

import java.util.List;
import java.util.Scanner;

public class HousesCmd {

    public static Houses create(){
        /*[#7] addhouse <title> <ref> <category> <price>
        - ajoute une maison dans la liste
        - cherche d'abord un objet qui porte la même référence (ou le même intitulé ET la même catégorie ET le même prix).
        - Si un objet existe déjà dans la mémoire, alors on affiche un message d'erreur (avec les infos de la maison existant par exemple)*/
        String f;
        String title;
        String ref;
        String category;
        String p;
        int price;
        Scanner sc = new Scanner(System.in);
        boolean isOK = false;
        Houses house = null;

        do {
            try {
                System.out.println("addhouse/title/ref/category/price");
                String scan = sc.nextLine();
                String [] info = scan.split("/");
                f = info[0];
                title = info[1];
                ref = info[2];
                category = info[3];
                p = info[4];
                if (!f.equals("") && !title.equals("") && !ref.equals("") && !category.equals("") && !p.equals("")) {
                    String function = f.toLowerCase();
                    if (function.equals("addhouse")) {
                        price = Integer.parseInt(p);
                        house = new Houses(title, ref, category, price);
                        isOK = true;
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
        return house;
    }

    public static void add(List<Houses> housesList) {
        Houses house = create();
        if(house != null) {
            for (int i = 0; i < housesList.size(); i++) {
                if (house.getRef().equals(housesList.get(i).getRef()) || house.equals(housesList.get(i))) {
                    System.out.println("Error: this user already exists.\nAdduser failed.\nPlease try again ");
                    return;
                }
            }
            housesList.add(house);
        }
        else {
            System.out.println("Addhouse failed.\nPlease try again.");
        }
    }

    public static void list(List<Houses> housesList){
        for(int i = 0; i < housesList.size() ; i++) {
            System.out.println(housesList.get(i).toString());
        }
    }
}
