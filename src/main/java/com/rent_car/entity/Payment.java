package com.rent_car.entity;
import jakarta.persistence.*;
import jdk.jfr.MemoryAddress;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Entity
@Table (name = "payments")
public class Payment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn  (name = "rental_id")
    private Rental rental;

    public Payment(){

    }
    public Payment( double amount, LocalDate paymentDate, Rental rental) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.rental = rental;

    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
