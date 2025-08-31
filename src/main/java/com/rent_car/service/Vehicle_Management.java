package com.rent_car.service;

import com.rent_car.entity.Status;
import com.rent_car.entity.Vehicle;
import com.rent_car.repository.VehicleRepo;

import java.util.ArrayList;
import java.util.List;

public class Vehicle_Management {
    //Shtimi i makinave të reja (brand, model, viti, çmimi/ditë, status).

    VehicleRepo vehicleRepo=new VehicleRepo();
    public void regjistroMakineteRe(String brand, String model, String year, double dailyRate, Status status, String targa){
        Vehicle vehicle = new Vehicle (brand,model,year,dailyRate,status,targa);
        vehicleRepo.addVehicles(vehicle);

    }

    public void perditesoMakinat(Vehicle vehicle){
        vehicleRepo.updateVehicle(vehicle);
    }

    public List<Vehicle> listaMakinaveTeLira() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicleRepo.findAllVehicle()) {
            if (vehicle.getStatus().equals(Status.AVAILABLE)) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public List<Vehicle> listaMakinavemeQera() {
        List<Vehicle> rentedVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicleRepo.findAllVehicle()) {
            if (vehicle.getStatus().equals(Status.RENTED)) {
                rentedVehicles.add(vehicle);
            }
        }
        return rentedVehicles;

    }
    public void fshiMakinatJoDisponibel() {
        for (Vehicle vehicle : vehicleRepo.findAllVehicle()) {
            if (vehicle.getStatus() == Status.MAINTENANCE) {
                vehicleRepo.deletVehicleID(vehicle.getId());
            }
        }
    }
}

