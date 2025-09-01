package com.rent_car.service;

import com.rent_car.entity.*;
import com.rent_car.repository.InventariRepo;
import com.rent_car.repository.RentalItemRepo;
import com.rent_car.repository.RentalRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rental_Process {

    RentalRepo rentalRepo = new RentalRepo();
    public  void saveRental(Customer customer, LocalDate startDate, LocalDate endDate, Vehicle vehicle){
        Rental rental = new Rental(customer,startDate,endDate,vehicle);
        rentalRepo.rentaladd(rental);
    }

    public List<Rental> qeratePerKlient(Customer customer){
        List<Rental> rentals = new ArrayList<>();
        for (Rental rental: rentalRepo.findAllRental()){
            if (rental.getCustomer().getName().equals(customer.getName())){
                System.out.println();
            }
        }
        return rentals;
    }

    public void isVehicleAvailable(long id, LocalDate dataStart, LocalDate dataEnd) {
        boolean available = true;
        for (Rental rental : rentalRepo.findAllRental()) {
           //Zgjedhim makinen
            if (rental.getVehicle().getId() == id) {
                //Kontrollojme per datat
                if (dataStart.isBefore(rental.getEndDate()) && dataEnd.isAfter(rental.getStartDate())) {
                    available = false;
                    break;
                }}}
        if (available) {
            System.out.println("Makina eshte e disponueshme");}
        else {
            System.out.println("Makina nuk eshte e disponueshme");}



        }

    InventoryManagement inventoryManagement = new InventoryManagement();
    InventariRepo inventariRepo = new InventariRepo();

    public void ktheMakineNeInventar(int Id) {

        Rental rental = rentalRepo.findRentalID(Id);
            if(rental.getVehicle().getStatus()!=Status.AVAILABLE){
                System.out.println("Numri i makinaven ne inventari ishte: "+
                        inventoryManagement.numeroMakinaInventar());

                rental.getVehicle().setStatus(Status.AVAILABLE);
                inventariRepo.addInventariById(Id);

                System.out.println("Numi i Makinaven ne inventar eshte: "+
                        inventoryManagement.numeroMakinatDisponibelInventar());

            }
        }

    }

