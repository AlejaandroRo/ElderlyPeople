package es.uji.ei1027.elderly.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

public class Request {
    private int number;
    private String serviceType;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate creationDate;
    private String state;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate approvedDate;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate rejectedDate;
    private String comments;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate endDate;
    private String dniElderly;
    private int numberContract;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(LocalDate approvedDate) {
        this.approvedDate = approvedDate;
    }

    public LocalDate getRejectedDate() {
        return rejectedDate;
    }

    public void setRejectedDate(LocalDate rejectedDate) {
        this.rejectedDate = rejectedDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDniElderly() {
        return dniElderly;
    }

    public void setDniElderly(String dniElderly) {
        this.dniElderly = dniElderly;
    }

    public int getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }

    @Override
    public String toString() {
        return "Request{" +
                "number=" + number +
                ", serviceType='" + serviceType + '\'' +
                ", creationDate=" + creationDate +
                ", state='" + state + '\'' +
                ", approvedDate=" + approvedDate +
                ", rejectedDate=" + rejectedDate +
                ", comments='" + comments + '\'' +
                ", endDate=" + endDate +
                ", dniElderly='" + dniElderly + '\'' +
                ", numberContract=" + numberContract +
                '}';
    }
}
