package com.company;

public class RandomDate {

    private final int day;
    private final int month;
    private final int year;

    public RandomDate(int day , int month , int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String toString(){
        return (this.day + "-" + this.month + "-" + this.year);
    }
}

