package com.rent_car.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rentalItem")
public class RentalItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "rental_ID")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "vehicle_ID")
    private Vehicle vehicle;

    public RentalItem(Rental rental, Vehicle vehicle) {
            this.rental = rental;
            this.vehicle = vehicle;}

    public RentalItem(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "RentalItem{" +
                "id=" + id +
                ", rental=" + rental +
                ", vehicle=" + vehicle +
                '}';
    }
}



