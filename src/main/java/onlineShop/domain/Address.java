package onlineShop.domain;

import javax.persistence.*;

/**
 * Created by Damian Bartos
 * 21.08.2016.
 */
@Entity
@Table(name = "ADDRESSES")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ZIP_CODE")
    private String zipCode;

    protected Address(){}

    public Address(String street, String houseNumber, String city, String zipCode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
