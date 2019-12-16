package com.company;

public class Users {

    /*
    [>] Les acquéreurs
- le prénom (chaine de caractères)
- le nom (chaine de caractères)
- la banque (chaine de caractères)
- l'emprunt en euros (entier)
- le taux d'emprunt en pourcentage (nombre entier entre 0 et 100)
     */

    private String firstName;
    private String lastName;
    private String bank;
    private int loan;
    private int rate;

    public Users(String firstName, String lastName, String bank, int loan, int rate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bank = bank;
        this.loan = loan;
        this.rate = rate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}