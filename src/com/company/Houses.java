package com.company;

public class House {

    /*
    [>] Les maisons
- l'intitulé (chaine de caractères)
- la référence (chaine de caractères arbitraire et unique, ex: B312)
- la catégorie (chaine de caractères)
- le prix (entier)
     */

    private String title;
    private String ref;
    private String category;
    private int price;

    public House(String title, String ref, String category, int price) {
        this.title = title;
        this.ref = ref;
        this.category = category;
        this.price = price;
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

    public String getRef() {
        return ref;
    }
}
