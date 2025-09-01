package com.rent_car.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)

   private Long id;
@OneToOne
@JoinColumn(name = "Inventari_ID")
private Inventari inventari;

   private String brand;
   private String model;
   private String year;
   private String targa;
   private double dailyRate;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy="vehicle",
            cascade=CascadeType.ALL)
    List<RentalItem> rentalItems =new ArrayList<>();
    public Vehicle(){}

    public Vehicle( String brand, String model, String year, double dailyRate, Status status,String targa) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
        this.status = status;
        this.targa = targa;


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String id) {
        this.targa= targa;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Vehicle{" + "ID"+
                id+
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", dailyRate=" + dailyRate +
                ", status=" + status +
                '}';
    }
}
