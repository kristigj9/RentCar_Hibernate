package com.rent_car.service;

import com.rent_car.entity.Rental;
import com.rent_car.entity.RentalItem;
import com.rent_car.entity.Vehicle;
import com.rent_car.repository.RentalItemRepo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental_ItemReport_Statistics {
    RentalItemRepo rentalItemRepo= new RentalItemRepo();
    public void addRentalItemService(Rental rental, Vehicle vehicle, LocalDate startDate, LocalDate endDate){

        RentalItem rentalItem=new RentalItem();
        rentalItem.setRental(rental);
        rentalItem.setVehicle(vehicle);
        rentalItem.getRental().setEndDate(endDate);
        rentalItem.getRental().setStartDate(startDate);
        rentalItemRepo.rentalItemadd(rentalItem);




    }

}
