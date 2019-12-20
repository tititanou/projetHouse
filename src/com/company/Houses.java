package com.company;

public class Houses {

    private String title;
    private String ref;
    private String category;
    private int price;
    private String houseId;

    public Houses(String title, String ref, String category, int price) {
        this.title = title;
        this.ref = ref;
        this.category = category;
        this.price = price;
        this.houseId = this.title + " " + this.category + " " + this.price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle(){
        return this.title;
    }

    public String getRef() {
        return this.ref;
    }

    @Override
    public boolean equals(Object object) {
        return object.equals(this.houseId);
    }

    @Override
    public String toString() {
        return ("=====================\nTitle= " + this.title + "\nRef= " + this.ref + "\nCategory= " +
                this.category + "\nPrice= " + this.price + "\n=====================");
    }
}
