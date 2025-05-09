package edu.uoc.pac4;

import edu.uoc.pac4.data.DataRepository;
import edu.uoc.pac4.exception.ResearchCenterException;

public class ResearchCenter {
    private String name;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;
    private DataRepository dataRepository;

    public ResearchCenter(String name, String city, String address, String phoneNumber, String email, DataRepository dataRepository)
            throws ResearchCenterException {
        setName(name);
        setCity(city);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setDataRepository(dataRepository);
    }

    public void setName(String name) throws ResearchCenterException {
        if (name == null || name.trim().isEmpty()) {
            throw new ResearchCenterException(ResearchCenterException.ERROR_NAME);
        }
        this.name = name.trim();
    }

    public void setCity(String city) throws ResearchCenterException {
        if (city == null) {
            throw new ResearchCenterException(ResearchCenterException.ERROR_CITY);
        }
        this.city = city.trim();
    }

    public void setAddress(String address) throws ResearchCenterException {
        if (address == null) {
            throw new ResearchCenterException(ResearchCenterException.ERROR_ADDRESS);
        }
        this.address = address.trim();
    }

    public void setPhoneNumber(String phoneNumber) throws ResearchCenterException {
        if (phoneNumber == null || !phoneNumber.matches("(\\+)?\\d{7,}")) {
            throw new ResearchCenterException(ResearchCenterException.ERROR_PHONE_NUMBER);
        }
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) throws ResearchCenterException {
        if (email == null || !email.matches("^[a-z0-9._-]+" + "@" + "[a-z0-9.-]+\\.[a-z]{2,}$")) {
            throw new ResearchCenterException(ResearchCenterException.ERROR_EMAIL);
        }
        this.email = email;
    }

    public void setDataRepository(DataRepository dataRepository) throws ResearchCenterException {
        if (dataRepository == null) {
            throw new ResearchCenterException(ResearchCenterException.ERROR_DATA_REPOSITORY);
        }
        this.dataRepository = dataRepository;
    }

    public String getName() { return name; }
    public String getCity() { return city; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public DataRepository getDataRepository() { return dataRepository; }

    @Override
    public String toString() {
        return String.format("{\"name\": \"%s\", \"city\": \"%s\", \"address\": \"%s\", \"phoneNumber\": \"%s\", \"email\": \"%s\", \"dataRepository\": %s}",
                name, city, address, phoneNumber, email, dataRepository.toString());
    }
}