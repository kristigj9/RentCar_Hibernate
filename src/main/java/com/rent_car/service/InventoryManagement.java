package com.rent_car.service;

import com.rent_car.entity.Inventari;
import com.rent_car.entity.Status;
import com.rent_car.entity.Vehicle;
import com.rent_car.repository.InventariRepo;
import jakarta.persistence.criteria.CriteriaBuilder;

public class InventoryManagement {

    //Ruajtja makinave ne inventar

    InventariRepo inventariRepo = new InventariRepo();
    public void saveInventary(Vehicle vehicle,Status status, int quantity){
        Inventari inventari = new Inventari(quantity,status,vehicle);
        inventariRepo.addInventari(inventari);
    }
   // Mbajtja e sasisë së makinave për çdo model.

        public int numeroMakinatDisponibelInventar() {
        int quanityInventory =0;
            for (Inventari inventari : inventariRepo.findAllInventari()) {
                    quanityInventory+=1;
                }


            return quanityInventory;
            }

    //Kur një makinë jepet me qira → reduce quantity -1.


    public int zbritMakinaRented() {
        int quanityInventory = numeroMakinatDisponibelInventar();
        for (Inventari inventari : inventariRepo.findAllInventari()) {
            if (inventari.getStatus() == Status.RENTED) {
                quanityInventory-=1;
            }
        }
        return quanityInventory;


    }

    public int numeroMakinaInventar(){
        int quanityInventory = numeroMakinatDisponibelInventar();
        for (Inventari inventari : inventariRepo.findAllInventari()){
            if (inventari.getStatus() == Status.AVAILABLE){
                quanityInventory+=1;
            }
        }
        return quanityInventory;

    }

    //Sasia Makinave per cdo model

    public int SasiaperModelInventory(String model){
       int modelQuantityInventory=0;

        for (Inventari inventari: inventariRepo.findAllInventari()){
            if(inventari.getVehicle().getModel().equals(model)){
                modelQuantityInventory =inventariRepo.findByModelInventar(model);
            }}
        return modelQuantityInventory;
    }
}



