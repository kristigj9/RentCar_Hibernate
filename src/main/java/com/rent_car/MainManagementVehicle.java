package com.rent_car;

import com.rent_car.entity.Vehicle;
import com.rent_car.service.Vehicle_Management;

import java.util.List;

public class MainManagementVehicle {
    public static void main(String[] args) {

        Vehicle_Management vehicleManagement = new Vehicle_Management();
        List<Vehicle> makinateLira = vehicleManagement.listaMakinaveTeLira();
        if (makinateLira.isEmpty()) {
            System.out.println("Nuk ka makina te lira");
        }

        else {
            System.out.println("Makinat e lira jane: ");
            makinateLira.forEach( vehicle -> System.out.println("Brandi makines "+vehicle.getBrand()+ " Targa "+
                    vehicle.getTarga()+" Cmimi " + vehicle.getDailyRate() ));
        }
    }
}



