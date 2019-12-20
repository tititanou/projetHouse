package com.company;

import java.util.List;
import java.util.Scanner;

public class Utilities {

    /*[#15] restore
- cette commande va détecter la présence des fichiers sauvegardés précédemment (si ils existent) et va les ouvrir en lecture et récupérer les informations contenues dedans pour créer de nouveaux objets en mémoire (et donc restaurer l'état mémoire comme au moment de la sauvegarde).*/

    public static void displayMenu(){
        System.out.println("====================");
        System.out.println("01 - Help");
        System.out.println("02 - Exit");
        System.out.println("03 - Add a user");
        System.out.println("04 - Edit a user");
        System.out.println("05 - Remove a user");
        System.out.println("06 - List all users");
        System.out.println("07 - Add a house");
        System.out.println("08 - Edit a house");
        System.out.println("09 - Remove a house");
        System.out.println("10 - List all houses");
        System.out.println("11 - Create a sale");
        System.out.println("12 - Close a sale");
        System.out.println("13 - List all sales");
        System.out.println("14 - Save");
        System.out.println("15 - Restore");
        System.out.println("====================");
    }

    public static int getInputChoice() {
        System.out.println("Input your choice");
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();

        if (choice.equals("1") || choice.equals("01")) {
            return 1;
        }
        else if (choice.equals("2") || choice.equals("02")) {
            return 2;
        }
        else if (choice.equals("3") || choice.equals("03")) {
            return 3;
        }
        else if(choice.equals("4") || choice.equals("04")) {
            return 4;
        }
        else if (choice.equals("5") || choice.equals("05")){
            return 5;
        }
        else if (choice.equals("6") || choice.equals("06")){
            return 6;
        }
        else if (choice.equals("7") || choice.equals("07")){
            return 7;
        }
        else if (choice.equals("8") || choice.equals("08")){
            return 8;
        }
        else if (choice.equals("9") || choice.equals("09")){
            return 9;
        }
        else if (choice.equals("10") ){
            return 10;
        }
        else if (choice.equals("11") ){
            return 11;
        }
        else if (choice.equals("12") ){
            return 12;
        }
        else if (choice.equals("13") ){
            return 13;
        }
        else if (choice.equals("14") ){
            return 14;
        }
        else if (choice.equals("15") ){
            return 15;
        }
        else {
            return -1;
        }
    }

    public static void processCommand(int cmdNum, List<Users> usersList , List<Houses> housesList , List<Sales> salesList){
        if( cmdNum == 1 ){
            displayMenu();
        }

        else if ( cmdNum == 2) {
            System.out.println("Goodbye");
        }

        else if ( cmdNum == 3) {
           UsersCmd.add(usersList);
        }

        else if (cmdNum == 4) {
            UsersCmd.edit(usersList , salesList);
        }

        else if ( cmdNum == 5) {
            UsersCmd.remove(usersList , salesList);
        }

        else if ( cmdNum == 6){
            UsersCmd.list(usersList);
        }

        else if ( cmdNum == 7){
           HousesCmd.add(housesList);
        }

        else if ( cmdNum == 8){
            HousesCmd.edit(housesList , salesList);
        }

        else if ( cmdNum == 9){
            HousesCmd.remove(housesList , salesList);
        }

        else if( cmdNum == 10){
           HousesCmd.list(housesList);
        }

        else if( cmdNum == 11){
            SalesCmd.add(usersList , housesList , salesList);
        }

        else if( cmdNum == 12){
            SalesCmd.close(housesList , salesList);
        }

        else if( cmdNum == 13){
            SalesCmd.list(salesList);
        }

        else if( cmdNum == 14){
            FilesCmd.save(usersList , housesList , salesList);
        }
        else{
           displayMenu();
        }
    }

}
