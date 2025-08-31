package com.rent_car;

import com.rent_car.entity.Customer;
import com.rent_car.service.Customer_Management;


public class MainManagementCustomer {
    public static void main(String[] args) {
        Customer_Management customerManagement = new Customer_Management();
        //customerManagement.RegjistroCustomer("Ana","Duro","ana@gmail.com","04535","Tirane");
        Customer customer = customerManagement.customerRepo.findCustomerById(1);
        // customer.setTelefoni("05636367");
        customerManagement.historikuRentalKlient(1);
    }}

