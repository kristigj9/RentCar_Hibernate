package com.rent_car.entity;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rentals")
public class Rental {
    @Id //Primary Key Generation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;


    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "vehicle_Id")
    private Vehicle vehicle;

    @OneToMany(mappedBy="rental", cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<Payment> payments = new ArrayList<>();

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RentalItem> rentalItems = new ArrayList<>();



    public Rental(){}

    public Rental( Customer customer, LocalDate startDate, LocalDate endDate, Vehicle vehicle) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer=customer;
        this.vehicle=vehicle;


    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Rental{" + "ID"+ id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                "id="+customer+
                "id="+vehicle+
                '}';
    }
}
