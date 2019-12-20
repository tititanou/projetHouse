package com.company;

public class Users {

    private String firstName;
    private String lastName;
    private String patronym;
    private String bank;
    private int loan;
    private int rate;

    public Users(String firstName, String lastName, String bank, int loan, int rate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bank = bank;
        this.loan = loan;
        this.rate = rate;
        this.patronym = this.firstName + " " + this.lastName;
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

    public String getBank() {
        return bank;
    }

    public int getLoan() {
        return loan;
    }

    public int getRate() {
        return rate;
    }

    public String getPatronym(){
        return this.patronym;
    }

    @Override
    public boolean equals(Object object) {
        return object.equals(this.patronym);
    }

    @Override
    public String toString() {
        return ("======================\nFirst name= " + this.firstName + "\nLast name= " + this.lastName +
                "\nBank= " + this.bank + "\nLoan= " + this.loan + "\nRate= " + this.rate + "\n=========================");
    }
}
