package com.company;

/*import java.time.LocalDate;
import java.util.Date;*/

public class RandomDate /*extends Date*/ {

    private final int day;
    private final int month;
    private final int year;
    /*private final LocalDate minDate;
    private final LocalDate maxDate;
    private final Random random; */

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

    /*public RandomDate(LocalDate minDate, LocalDate maxDate) {
        this.minDate = minDate;
        this.maxDate = maxDate;
        this.random = new Random();


    public LocalDate nextDate() {
        int minDay = (int) minDate.toEpochDay();
        int maxDay = (int) maxDate.toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    @Override
    public String toString() {
        return "RandomDate{" +
                "maxDate=" + maxDate +
                ", minDate=" + minDate +
                '}';
    }

     */
}

