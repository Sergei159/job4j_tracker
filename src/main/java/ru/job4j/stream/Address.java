package ru.job4j.stream;

import java.util.Objects;

public class Address {
    private String city;

    private String street;

    private int house;

    private int apartment;

    public Address(String city, String street, int house, int apartment) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;

    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != this.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(city, address.city)
                && Objects.equals(street, address.street)
                && house == address.house
                && apartment == address.apartment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, house, apartment);
    }

    @Override
    public String toString() {
        return "{"
                + "city='" + city + '\''
                + ", street=" + street
                + ", house=" + house
                + ", apartment=" + apartment
                + '}';
    }

}
