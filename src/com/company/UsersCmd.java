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
                System.out.println("adduser/firstname/lastname/bank/loan(more than 100.000)/rate(between 0 and 100)");
                String scan = sc.nextLine();
                if(!scan.toLowerCase().equals("back")) {
                    String[] info = scan.split("/");
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
                    } else {
                        System.out.println("You cannot enter null value. Please try again.");
                    }
                }else {
                    break;
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
                    System.out.println("Error: this user already exists.\nAdduser failed.\nPlease try again ");
                    return;
                }
            }
            usersList.add(buyer);
        }
        else {
            System.out.println("Adduser failed.\nPlease try again.");
        }
    }

    public static void edit(List<Users> usersList , List<Sales> salesList) {
        String f;
        String fn = "";
        String ln = "";
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
        boolean editIsOK =false;
        boolean isBuying = true;
        Users existingBuyer = null;
        Users buyer = null;
        Users buyer1 = null;

        do {
            try {
                do {
                    System.out.println("edituser/firstname/lastname");
                    String scan = sc.nextLine();
                    if(!scan.toLowerCase().equals("back")) {
                        String[] info = scan.split("/");
                        f = info[0];
                        fn = info[1];
                        ln = info[2];
                        if (!f.equals("") && !fn.equals("") && !ln.equals("")) {
                            String function = f.toLowerCase();
                            if (function.equals("edituser")) {
                                patro = fn + " " + ln;
                                for (int i = 0; i < usersList.size(); i++) {
                                    buyer1 = usersList.get(i);
                                    if (buyer1.equals(patro)) {
                                        buyerIsOK = true;
                                        break;
                                    } else {
                                        buyerIsOK = false;
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
                    }else {
                        return;
                    }
                } while (!functionIsOk);
                if (buyerIsOK) {
                    if(salesList.size() > 0) {
                        for (int j = 0; j < salesList.size(); j++) {
                            if (buyer1.equals(salesList.get(j).getBuyer())) {
                                isBuying = true;
                                break;
                            } else {
                                isBuying = false;
                            }
                        }
                    }else {
                        isBuying = false;
                    }
                    if (!isBuying) {
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
                        if (!firstname.equals("") && !lastname.equals("")) {
                            patronym = firstname + " " + lastname;
                        } else if (!firstname.equals("") && lastname.equals("")) {
                            patronym = firstname + " " + ln;
                        } else if (firstname.equals("") && !lastname.equals("")) {
                            patronym = fn + " " + lastname;
                        } else {
                            patronym = "";
                        }
                        for (int i = 0; i < usersList.size(); i++) {
                            buyer = usersList.get(i);
                            if (buyer.equals(patronym)) {
                                existingBuyer = buyer;
                            }
                        }
                        if (existingBuyer != null) {
                            System.out.println("This user already exists.");
                            editIsOK = false;
                            continue;
                        } else {
                            if (!l.equals("")) {
                                loan = Integer.parseInt(l);
                                if (loan < 100000) {
                                    System.out.println("Loan is not ok!");
                                    editIsOK = false;
                                    continue;
                                } else {
                                    if (!r.equals("")) {
                                        rate = Integer.parseInt(r);
                                        if (rate <= 0 || rate >= 100) {
                                            System.out.println("Rate is not ok!");
                                            editIsOK = false;
                                            continue;
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
                                        editIsOK = true;
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
                                    editIsOK = true;
                                }
                            } else {
                                if (!r.equals("")) {
                                    rate = Integer.parseInt(r);
                                    if (rate <= 0 || rate >= 100) {
                                        System.out.println("Rate is not ok!");
                                        editIsOK = false;
                                        continue;
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
                                    editIsOK = true;
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
                                    editIsOK = true;
                                }
                            }
                        }
                    } else {
                        System.out.println("This buyer already has a current transaction.");
                    }
                } else {
                    System.out.println("This user doesn't exist!");
                    editIsOK = false;
                }
            } catch (Exception e) {
                System.out.println(" Not valid because " + e.getMessage() + " \n Please try again.");
            }
        }while (!editIsOK);
    }

    public static void remove(List<Users> usersList , List<Sales> salesList) {
        String f;
        String fn;
        String ln;
        String patro;
        Users buyer = null;
        Scanner sc = new Scanner(System.in);
        boolean buyerIsOK = false;
        boolean functionIsOk = false;
        boolean canRemove =false;
        boolean removeIsOk = false;
        do {
            try {
                do {
                    System.out.println("removeuser/firstname/lastname");
                    String scan = sc.nextLine();
                    if(!scan.toLowerCase().equals("back")) {
                        String[] info = scan.split("/");
                        f = info[0];
                        fn = info[1];
                        ln = info[2];
                        if (!f.equals("") && !fn.equals("") && !ln.equals("")) {
                            String function = f.toLowerCase();
                            if (function.equals("removeuser")) {
                                patro = fn + " " + ln;
                                for (int i = 0; i < usersList.size(); i++) {
                                    buyer = usersList.get(i);
                                    if (buyer.equals(patro)) {
                                        buyerIsOK = true;
                                        break;
                                    } else {
                                        buyerIsOK = false;
                                    }
                                }
                                if (!buyerIsOK) {
                                    System.out.println("This buyer doesn't exist.");
                                }
                                functionIsOk = true;
                            } else {
                                System.out.println("Invalid command. Please try again");
                                functionIsOk = false;
                            }
                        } else {
                            System.out.println("You cannot enter null value. Please try again.");
                        }
                    }else {
                        return;
                    }
                } while (!functionIsOk);
                if (buyerIsOK) {
                    if(salesList.size() > 0) {
                        for (int j = 0; j < salesList.size(); j++){
                            if (buyer.equals(salesList.get(j).getBuyer())) {
                                canRemove = false;
                                break;
                            } else {
                                canRemove = true;
                            }
                        }
                    }else {
                    canRemove = true;
                    }
                }
                if(canRemove){
                    System.out.println("Do you want to remove \n" + buyer.toString() + "?\n Yes/No");
                    Scanner scann = new Scanner(System.in);
                    String input = scann.next();
                    String answer = input.toLowerCase();
                    if (answer.equals("yes")) {
                        usersList.remove(buyer);
                        System.out.println(buyer.toString() + "\nhas been deleted.");
                        removeIsOk = true;
                    } else if (answer.equals("no")) {
                        System.out.println(buyer.toString() + "\nhasn't been deleted.");
                        removeIsOk = true;
                    } else {
                        System.out.println("Answer incorrect.\nRemove failed.\nPlease try again.");
                        removeIsOk = false;
                    }
                }else {
                    System.out.println("This buyer already has a current transaction.");
                }
            } catch (Exception e) {
                System.out.println(" Not valid because " + e.getMessage() + " \n Please try again.");
            }
        }while (!removeIsOk);
    }

    public static void list(List<Users> usersList){
        for(int i = 0; i < usersList.size() ; i++) {
            System.out.println(usersList.get(i).toString());
        }
    }

}