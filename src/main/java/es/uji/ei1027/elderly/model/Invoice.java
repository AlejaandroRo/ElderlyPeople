package es.uji.ei1027.elderly.model;

import java.sql.Date;

public class Invoice {
    private Date date;
    private int number;
    private int amount;
    private String concept;
    private String dniElderly;

    public Invoice() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getDniElderly() {
        return dniElderly;
    }

    public void setDniElderly(String dniElderly) {
        this.dniElderly = dniElderly;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "date=" + date +
                ", number=" + number +
                ", amount=" + amount +
                ", concept='" + concept + '\'' +
                ", dniElderly='" + dniElderly + '\'' +
                '}';
    }
}
