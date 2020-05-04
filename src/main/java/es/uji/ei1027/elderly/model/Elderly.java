package es.uji.ei1027.elderly.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

public class Elderly {
    private String name;
    private String dni;
    private String surname;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
    private int phoneNumber;
    private String bankAccountNumber;
    private String email;
    private String userPwd;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate dateCreation;
    private String alergies;
    private String diseases;
    private String address;
    private String userCAS;

    public Elderly() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAlergies() {
        return alergies;
    }

    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserCAS() {
        return userCAS;
    }

    public void setUserCAS(String userCAS) {
        this.userCAS = userCAS;
    }

    @Override
    public String toString() {
        return "Elderly{" +
                "name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber=" + phoneNumber +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", email='" + email + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", dateCreation=" + dateCreation +
                ", alergies='" + alergies + '\'' +
                ", diseases='" + diseases + '\'' +
                ", address='" + address + '\'' +
                ", userCAS='" + userCAS + '\'' +
                '}';
    }
}
