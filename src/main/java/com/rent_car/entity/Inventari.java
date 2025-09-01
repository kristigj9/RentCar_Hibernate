package com.rent_car.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "inventari")
public class Inventari {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private int quantity;
   Status status;

   @OneToOne
   @JoinColumn(name = "Vehicle_ID")
   private Vehicle vehicle;

   public Inventari (){}
    public Inventari(int quantity, Status status, Vehicle vehicle) {
        this.quantity = quantity;
        this.status = status;
        this.vehicle = vehicle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

