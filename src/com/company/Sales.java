package com.company;

import java.util.Date;

public class Sales {

    private Users buyer;
    private Houses house;
    private String saleAgreement;
    private String definitiveSale;

    public Sales(Users buyer, Houses house, String saleAgreement, String definitiveSale) {
        this.buyer = buyer;
        this.house = house;
        this.saleAgreement = saleAgreement;
        this.definitiveSale = definitiveSale;
    }

    public Users getBuyer() {
        return this.buyer;
    }

    public Houses getHouse() {
        return this.house;
    }

    public String getSaleAgreement(){
        return this.saleAgreement;
    }

    public String getDefinitiveSale(){
        return this.definitiveSale;
    }

    public void setDefinitiveSale(String definitiveSale){
        this.definitiveSale = definitiveSale;
    }

    public String toString() {
        return ("=====================\nBuyer= " + this.buyer.getPatronym() + "\nHouse= " + this.house.getTitle() + " ref= " + this.house.getRef() +
                "\nSale agreement firm= " + this.saleAgreement + "\nSale definitive firm= " + this.definitiveSale + "\n=====================");
    }
}
