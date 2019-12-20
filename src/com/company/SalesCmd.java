package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SalesCmd {

    public static Sales create(List<Users> usersList , List<Houses> housesList , List<Sales> salesList){
        String f;
        String fn;
        String ln;
        String ref;
        Scanner sc = new Scanner(System.in);
        boolean isOK = false;
        boolean houseIsOk = false;
        boolean saleIsOk = false;
        String patro = null;
        Users buyer = null;
        Houses house = null;
        Sales sale = null;
        do {
            try {
                System.out.println("createsale/firstname/lastname/ref");
                String scan = sc.nextLine();
                String[] info = scan.split("/");
                f = info[0];
                fn = info[1];
                ln = info[2];
                ref = info[3];
                if (!f.equals("") && !fn.equals("") && !ln.equals("") && !ref.equals("")) {
                    String function = f.toLowerCase();
                    if (function.equals("createsale")) {
                        patro = fn + " " + ln;
                        for (int i = 0; i < usersList.size(); i++) {
                            Users b = usersList.get(i);
                            if (b.equals(patro)) {
                                buyer = b;
                            }
                        }
                        if (buyer != null) {
                            for (int j = 0; j < housesList.size(); j++) {
                                Houses h = housesList.get(j);
                                if (h.getRef().equals(ref)) {
                                    house = h;
                                }
                            }
                            if (house != null) {
                                if (salesList.size() > 0) {
                                    for (int k = 0; k < salesList.size(); k++) {
                                        if (salesList.get(k).getHouse().getRef().equals(house.getRef())) {
                                            houseIsOk = false;
                                            System.out.println("This house is already for sale.");
                                            break;
                                        } else {
                                            houseIsOk = true;
                                        }
                                    }
                                } else {
                                    houseIsOk = true;
                                }
                                if (houseIsOk) {
                                    if (salesList.size() > 0) {
                                        for (int i = 0; i < salesList.size(); i++) {
                                            if (salesList.get(i).getBuyer().equals(patro)) {
                                                saleIsOk = false;
                                                System.out.println("This buyer already has a current transaction.");
                                                break;
                                            }
                                            else {
                                                saleIsOk = true;
                                            }
                                        }
                                    } else {
                                        saleIsOk = true;
                                    }
                                }
                            } else {
                                System.out.println("House ref is not valid.");
                                isOK = false;
                                continue;
                            }
                        } else {
                            System.out.println("Buyer is not valid.");
                            isOK = false;
                            continue;
                        }
                    } else {
                        System.out.println("Invalid command");
                        isOK = false;
                    }
                } else {
                    System.out.println("You cannot enter null value. Please try again.");
                }
                if (saleIsOk) {
                    RandomDate date = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 12, 1));
                    SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
                    String saleAgreement = formater.format(date);
                    sale = new Sales(buyer, house, saleAgreement, "");
                    System.out.println("The sale\n" + sale.toString() + "\nhas been created.");
                    isOK = true;
                }
            } catch (Exception e) {
                System.out.println(" Not valid because " + e.getMessage() + " \n Please try again.");
            }
        } while (!isOK);
        return sale;
    }

    public static void add(List<Users> usersList , List<Houses> housesList , List<Sales> salesList) {
        Sales sale = create(usersList , housesList , salesList);
        if(sale != null) {
            for (int i = 0; i < salesList.size(); i++) {
                if (sale.equals(salesList.get(i))) {
                    System.out.println("Error: this sale already exists.\nCreatesale failed.\nPlease try again ");
                    return;
                }
            }
            salesList.add(sale);
        }
        else {
            System.out.println("Createsale failed.\nPlease try again.");
        }
    }

    public static void close(List<Houses> housesList , List<Sales> salesList){
        String f;
        String ref;
        Scanner sc = new Scanner(System.in);
        boolean houseIsOK = false;
        boolean functionIsOk = false;
        boolean closeIsOK =false;
        Sales sale = null;
        do {
            try {
                do {
                    System.out.println("closesale/ref");
                    String scan = sc.nextLine();
                    String[] info = scan.split("/");
                    f = info[0];
                    ref = info[1];
                    if (!f.equals("") && !ref.equals("")) {
                        String function = f.toLowerCase();
                        if (function.equals("closesale")) {
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
                    for (int i = 0; i < salesList.size(); i++) {
                        if (salesList.get(i).getHouse().getRef().equals(ref)) {
                            sale = salesList.get(i);
                        }
                    }
                } else {
                    System.out.println("This house doesn't exist");
                    closeIsOK = false;
                }
                if (sale != null) {
                    if(sale.getDefinitiveSale().equals("")) {
                        String date1 = sale.getSaleAgreement();
                        String[] infos = date1.split("-");
                        RandomDate date2 = new RandomDate(LocalDate.of(Integer.parseInt(infos[0]), Integer.parseInt(infos[1]), Integer.parseInt(infos[2])), LocalDate.of(2019, 12, 1));
                        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
                        String definitiveDate = formater.format(date2);
                        sale.setDefinitiveSale(definitiveDate);
                        System.out.println("The sale\n" + sale.toString() + "\nhas been closed.");
                        closeIsOK = true;
                    }
                    else {
                        System.out.println("This house has already been sold. Closesale failed.");
                        closeIsOK = true;
                        break;
                    }
                } else {
                    System.out.println("This house is not being acquired.");
                    closeIsOK = false;
                }
            } catch (Exception e) {
                System.out.println(" Not valid because " + e.getMessage() + " \n Please try again.");
            }
        }while (!closeIsOK);

    }

    public static void list(List<Sales> salesList){
        for(int i = 0; i < salesList.size() ; i++) {
            System.out.println(salesList.get(i).toString());
        }
    }
}
