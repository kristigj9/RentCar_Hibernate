package com.rent_car.repository;

import com.rent_car.entity.Payment;
import com.rent_car.entity.Status;
import com.rent_car.entity.Vehicle;
import com.rent_car.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VehicleRepo {
    public void addVehicles(Vehicle vehicle){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            boolean ekziston = findByTarga(vehicle.getTarga());
            if (ekziston ==true) {
                System.out.println("Makina me targën " + vehicle.getTarga() + " është regjistruar më parë");
            } else {
                s.save(vehicle);
                t.commit();
                System.out.println(" Makina me targën " + vehicle.getTarga() + " u shtua me sukses");
            }
        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }


    public void deletVehicleID(long id){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            Vehicle vehicle = s.get(Vehicle.class, id);
            if (vehicle != null) {
                s.delete(vehicle); // ose session.delete(p);
            }

            t.commit();
        } catch(Exception e){
            if(t!=null)t.rollback(); e.printStackTrace();}
    }

    public Vehicle findVehicleID(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Vehicle.class, id); // merr order sipas id
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void updateVehicle(Vehicle vehicle) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(vehicle);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }



    public List<Vehicle> findAllVehicle() {
        List<Vehicle> vehicles = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            vehicles = session.createQuery("FROM Vehicle", Vehicle.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesByStatus(Status status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Vehicle v WHERE v.status = :status";
            return session.createQuery(hql, Vehicle.class)
                    .setParameter("status", status)
                    .list();
        }
    }

    public boolean findByTarga(String targa) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT 1 FROM Vehicle v WHERE v.targa = :targa";
            List<Integer> list = session.createQuery(hql, Integer.class)
                    .setParameter("targa", targa)
                    .getResultList();
            return !list.isEmpty();  // true nëse ekziston, false nëse nuk ekziston
        }
    }}


