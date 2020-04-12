package es.uji.ei1027.elderly.model;

public class Company {
    private String name;
    private String cif;
    private String address;
    private String contactPersonName;
    private String contactPersonPhoneNumber;
    private String contactPersonEmail;
    private String serviceType;

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContractPersonName() {
        return contactPersonName;
    }

    public void setContractPersonName(String contractPersonName) {
        this.contactPersonName = contractPersonName;
    }

    public String getContactPersonPhoneNumber() {
        return contactPersonPhoneNumber;
    }

    public void setContactPersonPhoneNumber(String contactPersonPhoneNumber) {
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", cif='" + cif + '\'' +
                ", address='" + address + '\'' +
                ", contractPersonName='" + contactPersonName + '\'' +
                ", contractPersonPhoneNumber='" + contactPersonPhoneNumber + '\'' +
                ", contractPersonEmail='" + contactPersonEmail + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
