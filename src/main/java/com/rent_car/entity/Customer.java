package com.rent_car.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.ValueGenerationType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customers")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastName;
    private String mail;
    private String telefoni;
    private String adrese;


    @OneToMany(mappedBy="customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Rental> rentals = new ArrayList<>();


    public Customer( String name,String lastName, String mail,String telefoni, String adrese) {
        this.name=name;
        this.adrese = adrese;
        this.lastName = lastName;
        this.mail = mail;
        this.telefoni = telefoni;

    }
    public Customer(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdrese() {
        return adrese;
    }

    public void setAdrese(String adrese) {
        this.adrese = adrese;
    }

    public String getTelefoni() {
        return telefoni;
    }

    public void setTelefoni(String telefoni) {
        this.telefoni = telefoni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", telefoni='" + telefoni + '\'' +
                ", adrese='" + adrese + '\'' +
                '}';
    }
}
