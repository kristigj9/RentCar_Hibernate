package com.rent_car.service;

import com.rent_car.entity.Customer;
import com.rent_car.entity.Rental;
import com.rent_car.entity.Status;
import com.rent_car.entity.Vehicle;
import com.rent_car.repository.CustomerRepo;

import java.util.ArrayList;
import java.util.List;

public class Customer_Management {
  public CustomerRepo customerRepo = new CustomerRepo();
    public void RegjistroCustomer(String emri,String lastName,String mail,String telefoni,String adresa){
        Customer c = new Customer (emri,lastName,mail,telefoni,adresa);
        customerRepo.addCustomer(c);
    }
    public void UpdateCustomer(Customer customer){
        customerRepo.UpdateCustomer(customer);
    }


    public void historikuRentalKlient(long id) {
        Customer c = customerRepo.findCustomerById(id);
        if (c != null) {
            System.out.println("Historiku i makinave per klientin: " + c.getName() + " " + c.getLastName());
            c.getRentals().forEach(rental -> {
                System.out.println("Makina: " + rental.getVehicle().getBrand() +
                        " Data e rental " + rental.getStartDate() +
                        " Data e dorezimit " + rental.getEndDate());
            });
        } else{
            System.out.println("Klienti nuk u gjet");
        }
        }
    }





