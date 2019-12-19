package com.company;

import java.util.List;
import java.util.Scanner;

public class HousesCmd {

    public static Houses create(){
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
                    System.out.println("Error: this house: "+ housesList.get(i).toString() +
                            "already exists.\nAddhouse failed.\nPlease try again ");
                    return;
                }
            }
            housesList.add(house);
        }
        else {
            System.out.println("Addhouse failed.\nPlease try again.");
        }
    }

    /* - pour chaque champ de valeur, on peut laisser une chaine vide pour indiquer qu'on ne change pas la valeur (comme expliqué dans la commande edituser).*/
    public static void edit(List<Houses> housesList) {
        String f;
        String title;
        String ref;
        String category;
        String p;
        int price;
        Scanner sc = new Scanner(System.in);
        Scanner scann = new Scanner(System.in);
        boolean houseIsOK = false;
        boolean functionIsOk = false;
        boolean editIsOK =false;
        Houses existingHouse = null;
        Houses house = null;
        do {
            try {
                do {
                    System.out.println("edithouse/ref");
                    String scan = sc.nextLine();
                    String[] info = scan.split("/");
                    f = info[0];
                    ref = info[1];
                    if (!f.equals("") && !ref.equals("")) {
                        String function = f.toLowerCase();
                        if (function.equals("edithouse")) {
                            for (int i = 0; i < housesList.size(); i++) {
                                Houses house1 = housesList.get(i);
                                if (house1.getRef().equals(ref)) {
                                    houseIsOK = true;
                                    break;
                                } else {
                                    houseIsOK = false;
                                }
                            }
                            functionIsOk = true;
                        } else {
                            System.out.println("Invalid command. Please try again");
                            functionIsOk = false;
                        }
                    } else {
                        System.out.println("You cannot enter null value. Please try again.");
                    }
                } while (!functionIsOk);

                if (houseIsOK) {
                    System.out.println("Enter a new title");
                    title = scann.nextLine();
                    System.out.println("Enter a new ref: ");
                    ref = scann.nextLine();
                    System.out.println("Enter a new category: ");
                    category = scann.nextLine();
                    System.out.println("Enter a new price: ");
                    p = scann.nextLine();
                    for (int i = 0; i < housesList.size(); i++) {
                        house = housesList.get(i);
                        if (house.getRef().equals(ref)) {
                            existingHouse = house;
                        }
                    }
                    if (existingHouse != null) {
                        System.out.println("This house already exists.");
                        editIsOK = false;
                        break;
                    } else {
                        if (!p.equals("")) {
                            price = Integer.parseInt(p);
                            if (!title.equals("")) {
                                house.setTitle(title);
                            }
                            if (!ref.equals("")) {
                                house.setRef(ref);
                            }
                            if (!category.equals("")) {
                                house.setCategory(category);
                            }
                            house.setPrice(price);
                            editIsOK = true;
                            break;
                        }
                        else {
                            if (!title.equals("")) {
                                house.setTitle(title);
                            }
                            if (!ref.equals("")) {
                                house.setRef(ref);
                            }
                            if (!category.equals("")) {
                                house.setCategory(category);
                            }
                            editIsOK = true;
                            break;
                        }
                    }
                }else {
                    System.out.println("This house doesn't exist!");
                    editIsOK = false;
                }
            } catch (Exception e) {
                System.out.println(" Not valid because " + e.getMessage() + " \n Please try again.");
            }
        }while (!editIsOK);
    }

    public static void remove(List<Houses> housesList) {
    /*[#9] removehouse <ref>
    - cette commande recherche une référence de maison et la supprime de la liste en mémoire.
    - si la référence n'est pas trouvée, un message d'erreur s'affiche.
    - si la référence existe, il faut vérifier que cette maison n'est pas utilisée dans une transaction. Si ce n'est pas le cas, un message d'erreur affichera que cette maison ne peut pas être supprimée car actuellement utilisée.*/
        String f;
        String ref;
        Houses house = null;
        Scanner sc = new Scanner(System.in);
        boolean houseIsOK = false;
        boolean functionIsOk = false;
        boolean removeIsOk = false;
        do {
            try {
                do {
                    System.out.println("removehouse/ref");
                    String scan = sc.nextLine();
                    String[] info = scan.split("/");
                    f = info[0];
                    ref = info[1];
                    if (!f.equals("") && !ref.equals("")) {
                        String function = f.toLowerCase();
                        if (function.equals("removehouse")) {
                            for (int i = 0; i < housesList.size(); i++) {
                               house = housesList.get(i);
                                if (house.getRef().equals(ref)) {
                                    houseIsOK = true;
                                    break;
                                } else {
                                    houseIsOK = false;
                                }
                            }
                            if(!houseIsOK){
                                System.out.println("This house doesn't exist.");
                            }
                            functionIsOk = true;
                        } else {
                            System.out.println("Invalid command. Please try again");
                            functionIsOk = false;
                        }
                    } else {
                        System.out.println("You cannot enter null value. Please try again.");
                    }
                } while (!functionIsOk);
                if (houseIsOK) {
                    System.out.println("Do you want to remove \n" + house.toString() + "?\n Yes/No");
                    Scanner scann = new Scanner(System.in);
                    String input = scann.next();
                    String answer = input.toLowerCase();
                    if (answer.equals("yes")) {
                        housesList.remove(house);
                        System.out.println(house.toString() + "\nhas been deleted.");
                        removeIsOk = true;
                    } else if (answer.equals("no")) {
                        System.out.println(house.toString() + "\nhasn't been deleted.");
                        removeIsOk = true;
                    } else {
                        System.out.println("Answer incorrect.\nRemove failed.\nPlease try again.");
                        removeIsOk = false;
                    }
                }
            } catch (Exception e) {
                System.out.println(" Not valid because " + e.getMessage() + " \n Please try again.");
            }
        }while (!removeIsOk);
    }

    public static void list(List<Houses> housesList){
        for(int i = 0; i < housesList.size() ; i++) {
            System.out.println(housesList.get(i).toString());
        }
    }
}
