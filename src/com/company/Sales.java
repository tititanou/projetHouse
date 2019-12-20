package com.company;

import java.util.Date;

public class Sales {
    /**
     * attributes of the sales class
     * a buyer of type Users
     * a house of type Houses
     * a date of sale agreement firm of type String
     * a date definitive sale of type String
     */
    private Users buyer;
    private Houses house;
    private String saleAgreement;
    private String definitiveSale;

    /**
     * constructor method of sales objects
     * @param buyer
     * @param house
     * @param saleAgreement
     * @param definitiveSale
     */
    public Sales(Users buyer, Houses house, String saleAgreement, String definitiveSale) {
        this.buyer = buyer;
        this.house = house;
        this.saleAgreement = saleAgreement;
        this.definitiveSale = definitiveSale;
    }

    /**
     * getter method of all attributes of the sales object
     * @return the object buyer
     * return the object house
     * return the date of sale agreement
     * return the date of definitive sale
     */

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

    /**
     * method to change the definitive sale
     * @param definitiveSale
     */
    public void setDefinitiveSale(String definitiveSale){
        this.definitiveSale = definitiveSale;
    }

    /**
     * override the toString method, allows to display the firstname and lastname of the buyer, the title and ref of
     * the house, the sale agreement date and the date of  definitive sale
     * @return a string with all these info
     */
    public String toString() {
        return ("=====================\nBuyer= " + this.buyer.getPatronym() + "\nHouse= " + this.house.getTitle() + " ref= " + this.house.getRef() +
                "\nSale agreement firm= " + this.saleAgreement + "\nSale definitive firm= " + this.definitiveSale + "\n=====================");
    }
}
