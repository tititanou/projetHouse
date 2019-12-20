package com.company;

import java.util.List;

public class FilesCmd {

public static void save(List<Users> usersList , List<Houses> housesList , List<Sales> salesList){

    UsersBook usersBook = new UsersBook();
    HousesBook housesBook = new HousesBook();
    SalesBook salesBook = new SalesBook();

    for (int i = 0 ; i < usersList.size() ; i++){
        Users buyer = usersList.get(i);
        usersBook.addUsers(buyer.getFirstName() , buyer.getLastName() , buyer.getBank() , buyer.getLoan() , buyer.getRate());
    }

    for (int j = 0 ; j < housesList.size() ; j++){
        Houses house = housesList.get(j);
        housesBook.addHouses(house.getTitle() , house.getRef() , house.getCategory() , house.getPrice());
    }

    for (int k = 0 ; k < salesList.size() ; k++){
        Sales sale = salesList.get(k);
        salesBook.addSales(sale.getBuyer() , sale.getHouse() , sale.getSaleAgreement() , sale.getDefinitiveSale());
    }

}

}
