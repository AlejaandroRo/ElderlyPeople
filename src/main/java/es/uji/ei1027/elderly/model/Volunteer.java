package es.uji.ei1027.elderly.model;

import java.sql.Date;

public class Volunteer {
    private String name;
    private int phoneNumber;
    private String userV;
    private String email;
    private String pwd;
    private String hobbies;
    private Date applicationDate;
    private Date acceptationDate;
    private Date finalDate;
    private boolean accepted;
    private Date birthDate;

    public Volunteer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserV() {
        return userV;
    }

    public void setUserV(String userV) {
        this.userV = userV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getAcceptationDate() {
        return acceptationDate;
    }

    public void setAcceptationDate(Date acceptationDate) {
        this.acceptationDate = acceptationDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", userV='" + userV + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", applicationDate=" + applicationDate +
                ", acceptationDate=" + acceptationDate +
                ", finalDate=" + finalDate +
                ", accepted=" + accepted +
                ", birthDate=" + birthDate +
                '}';
    }
}
