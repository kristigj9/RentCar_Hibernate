package com.rent_car;

import com.rent_car.entity.*;
import com.rent_car.repository.CustomerRepo;
import com.rent_car.repository.PaymentRepo;
import com.rent_car.repository.RentalRepo;
import com.rent_car.repository.VehicleRepo;
import java.time.format.DateTimeFormatter;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static  void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        CustomerRepo customerRepo = new CustomerRepo();
        List<Customer> customerList = new ArrayList<>();
        Customer c1 = new Customer("Kristi","Gjosasi","kristi@gmail.com","04535643","Durres");
        Customer c2 = new Customer("Reni", "Gjosasi","reni@gmail.com","0342563","Durres");
        customerRepo.addCustomer(c1);
        customerRepo.addCustomer(c2);


        //Perditesimi i klientëve të rinj.
        // for (Customer c : customerList){
            //if (c.getLastName().equals("Reni")){
                //c.setLastName("Ana");
               // customerRepo.UpdateCustomer(c);}}//

        VehicleRepo vehicleRepo = new VehicleRepo();

       // Lista e makinave per tu shtuar

        Vehicle v1 =new Vehicle("Volvo","A4","2023",25.00, Status.AVAILABLE,"AA43567");
        Vehicle v2 =new Vehicle("Benz","B1","2021",26.00, Status.AVAILABLE,"AB3425");
        Vehicle v3 =new Vehicle("Fiat", "F5","2024",21.00,Status.AVAILABLE,"AA3576");
        Vehicle v4 =new Vehicle("Audi","A3","2022", 27.00,Status.RENTED,"AA3538");

        vehicleRepo.addVehicles(v1);
        vehicleRepo.addVehicles(v2);
        vehicleRepo.addVehicles(v3);
        vehicleRepo.addVehicles(v4);
        List<Vehicle> vehicleslist = new ArrayList<>();
        for (Vehicle vehicle: vehicleslist){
            vehicleslist.add(vehicle);
        }
        vehicleslist.add(v1);
        vehicleslist.add(v2);
        vehicleslist.add(v3);
        vehicleslist.add(v4);


        RentalRepo rentalRepo=new RentalRepo();

        List<Rental>rentalListList=new ArrayList<>();

        LocalDate startRental= LocalDate.parse("05-06-2025",formatter);
        LocalDate startRental1= LocalDate.parse("05-06-2025",formatter);
        LocalDate startRental2= LocalDate.parse("09-06-2025",formatter);
        LocalDate endRental = LocalDate.parse("02-06-2025",formatter);
        LocalDate endRental1 = LocalDate.parse("06-06-2025",formatter);
        LocalDate endRental2 = LocalDate.parse("16-06-2025",formatter);

        Rental r1=new Rental(c1,startRental,endRental,v2);
        Rental r2=new Rental(c1,startRental1,endRental1,v3);
        Rental r3=new Rental(c2,startRental2,endRental2,v1);
        Rental r4=new Rental(c1,startRental1,endRental2,v4);

        rentalRepo.rentaladd(r1);
        rentalRepo.rentaladd(r2);
        rentalRepo.rentaladd(r3);
        //rentalRepo.rentaladd(r4);


        //rentalRepo.findAllRental();
//        for (Rental rental:rentalListList){
//            rentalRepo.getListRental(2);
//            System.out.println("Customer: "+ " "+ rental.getCustomer().getLastName()+ " "+ "Vehicle: "+ rental.getVehicle().getBrand());
//        }

        LocalDate paymentDate = LocalDate.parse("06-06-2025",formatter);
        LocalDate paymentDate2 = LocalDate.parse("08-06-2025",formatter);
        LocalDate paymentDate3 = LocalDate.parse("10-06-2025",formatter);


        PaymentRepo paymentRepo = new PaymentRepo();

        //List<Payment> paymentList = new ArrayList<>();
        Payment p1= new Payment(60.00,paymentDate,r1);
        Payment p2= new Payment(30.00,paymentDate2,r2);
        Payment p3= new Payment(50.00,paymentDate3,r3);
        paymentRepo.savePayments(p1);
        paymentRepo.savePayments(p2);

        //Shikimi i historikut të makinave të marra me qira për çdo klient.

    }

}