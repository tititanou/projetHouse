package com.company;

public class Houses {
    /**
     * attributes of Houses class
     */
    private String title;
    private String ref;
    private String category;
    private int price;
    private String houseId;

    /**
     * Constructor method of Houses objects
     * @param title of type String
     * @param ref of type String
     * @param category of type String
     * @param price of type Int
     *  the houseId is the concatenation of the attributes title, category and price
     */
    public Houses(String title, String ref, String category, int price) {
        this.title = title;
        this.ref = ref;
        this.category = category;
        this.price = price;
        this.houseId = this.title + " " + this.category + " " + this.price;
    }

    /**
     * To change the title of the house
     * @param title is a String new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * To change the ref of the house
     * @param ref is a String new ref
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * To change the category of the house
     * @param category is a String new category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * To change the price of the house
     * @param  price is a int new price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * to get the title of the house
     * @return the String title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * to get the category of the house
     * @return the String category
     */
    public String getCategory() {
        return category;
    }

    /**
     * to get the price of the house
     * @return the int price
     */
    public int getPrice() {
        return price;
    }

    /**
     * to get the ref of the house
     * @return the String ref
     */
    public String getRef() {
        return this.ref;
    }

    /**
     * override of the equals method
     * @param object take an object as parameter
     * @return true if the object is equals to the houseId , else return false
     */
    @Override
    public boolean equals(Object object) {
        return object.equals(this.houseId);
    }

    /**
     * override the toString method
     * @return the house infos in a string
     */
    @Override
    public String toString() {
        return ("=====================\nTitle= " + this.title + "\nRef= " + this.ref + "\nCategory= " +
                this.category + "\nPrice= " + this.price + "\n=====================");
    }
}
