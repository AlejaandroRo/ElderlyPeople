package es.uji.ei1027.elderly.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

public class Contract {
    private int number;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate dateBeginning;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate dateEnding;
    private String description;
    private String serviceType;
    private int quantityServices;
    private String unitsOfMeasure;
    private double priceUnit;
    private String cifCompany;
    private String nameCompany;

    public Contract() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDateBeginning() {
        return dateBeginning;
    }

    public void setDateBeginning(LocalDate dateBeginning) {
        this.dateBeginning = dateBeginning;
    }

    public LocalDate getDateEnding() {
        return dateEnding;
    }

    public void setDateEnding(LocalDate dateEnding) {
        this.dateEnding = dateEnding;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getQuantityServices() {
        return quantityServices;
    }

    public void setQuantityServices(int quantityServices) {
        this.quantityServices = quantityServices;
    }

    public String getUnitsOfMeasure() {
        return unitsOfMeasure;
    }

    public void setUnitsOfMeasure(String unitsOfMeasure) {
        this.unitsOfMeasure = unitsOfMeasure;
    }

    public double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getCifCompany() {
        return cifCompany;
    }

    public void setCifCompany(String cifCompany) {
        this.cifCompany = cifCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "number=" + number +
                ", dateBeginning=" + dateBeginning +
                ", dateEnding=" + dateEnding +
                ", description='" + description + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", quantityServices=" + quantityServices +
                ", unitsOfMeasure=" + unitsOfMeasure +
                ", priceUnit=" + priceUnit +
                ", cifCompany='" + cifCompany + '\'' +
                '}';
    }
}
