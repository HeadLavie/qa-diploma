package ru.netology.testUtils;

import lombok.Data;

@Data
public class Cards {
    private String number;
    private String month;
    private String year;
    private String cardholder;
    private String cvc;

    public String getNumber() {
        return number;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getCardholder() {
        return cardholder;
    }

    public String getCvc() {
        return cvc;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}