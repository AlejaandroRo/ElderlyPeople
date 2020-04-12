package es.uji.ei1027.elderly.model;

import java.sql.Date;

public class Contract {
    private int number;
    private Date dateBeginning;
    private Date dateEnding;
    private String description;
    private String serviceType;
    private int quantityServices;
    private int unitsOfMeasure;
    private double priceUnit;
    private String cifCompany;

    public Contract() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDateBeginning() {
        return dateBeginning;
    }

    public void setDateBeginning(Date dateBeginning) {
        this.dateBeginning = dateBeginning;
    }

    public Date getDateEnding() {
        return dateEnding;
    }

    public void setDateEnding(Date dateEnding) {
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

    public int getUnitsOfMeasure() {
        return unitsOfMeasure;
    }

    public void setUnitsOfMeasure(int unitsOfMeasure) {
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
