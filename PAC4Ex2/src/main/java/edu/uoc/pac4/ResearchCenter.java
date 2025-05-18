package edu.uoc.pac4;

import edu.uoc.pac4.data.DataRepository;

public class ResearchCenter {
    private String name;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;
    private DataRepository dataRepository;

    public ResearchCenter(String name, String city, String address, String phoneNumber, String email, DataRepository dataRepository) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dataRepository = dataRepository;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public DataRepository getDataRepository() { return dataRepository; }
    public void setDataRepository(DataRepository dataRepository) { this.dataRepository = dataRepository; }

    @Override
    public String toString() {
        return "ResearchCenter{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", dataRepository=" + dataRepository +
                '}';
    }
}