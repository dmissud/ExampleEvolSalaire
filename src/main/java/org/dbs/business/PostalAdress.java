package org.dbs.business;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PostalAdress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String street;
    protected int number;
    protected String zipCode;
    protected String city;

    @OneToMany(cascade = {CascadeType.ALL})
    Set<Person> persons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "PostalAdress{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", persons=" + persons +
                '}';
    }
}
