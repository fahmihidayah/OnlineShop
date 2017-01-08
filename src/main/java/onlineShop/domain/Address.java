package onlineShop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Damian Bartos
 * 21.08.2016.
 */
@Entity
@Table(name = "ADDRESSES")
public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ADDRESS_ID")
//    private long addressId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "STREET")
    private String street;

    @NotNull
    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;

    @NotNull
    @Column(name = "CITY")
    private String city;

    @NotNull
    @Column(name = "ZIP_CODE")
    private String zipCode;

    protected Address() {
    }

    public Address(String street, String houseNumber, String city, String zipCode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.zipCode = zipCode;
    }

//    public long getAddressId() {
//        return addressId;
//    }

//    public void setAddressId(long addressId) {
//        this.addressId = addressId;
//    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Address{" +
//                "addressId=" + addressId +
                ", userId=" + userId +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
