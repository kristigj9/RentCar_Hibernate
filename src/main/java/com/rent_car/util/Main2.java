package com.rent_car.util;

import com.rent_car.entity.*;
import com.rent_car.repository.CustomerRepo;
import com.rent_car.repository.RentalRepo;
import com.rent_car.repository.VehicleRepo;

import java.time.LocalDate;

public record Main2() {
    public static void main(String[] args) {
        RentalRepo rentalRepo=new RentalRepo();

        CustomerRepo customerRepo=new CustomerRepo();
        Customer customer=new Customer("Cako","Gezim","gezim@gmail.com","0453563","Tirane");

        Vehicle vehicle=new Vehicle("benz","220","2000",35.2, Status.AVAILABLE,"AB0453");
        VehicleRepo vehicleRepo = new VehicleRepo();
        vehicleRepo.addVehicles(vehicle);
        Payment payment=new Payment();

        payment.setAmount(34.5);
        payment.setPaymentDate(LocalDate.now());


        Rental r1=new Rental();
        r1.setCustomer(customer);
        r1.setStartDate(LocalDate.now());
        r1.setEndDate(LocalDate.now().plusDays(3));
        r1.setVehicle(vehicle);

        rentalRepo.rentaladd(r1);
        customerRepo.addCustomer(customer);


    }
}
