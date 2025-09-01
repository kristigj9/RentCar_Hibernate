package com.rent_car.repository;

import com.rent_car.entity.Rental;
import com.rent_car.entity.RentalItem;
import com.rent_car.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RentalItemRepo {



    public void rentalItemadd(RentalItem rentalItem){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.save(rentalItem);
            t.commit();
        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }


    public void deleteRentalItemID(int id){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            RentalItem rentalItem = s.get(RentalItem.class, id);
            if (rentalItem != null) {
                s.delete(rentalItem); // ose session.delete(p);
            }

            t.commit();
        } catch(Exception e){
            if(t!=null)t.rollback(); e.printStackTrace();}
    }

    public RentalItem findRentalItemID(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(RentalItem.class, id); // merr order sipas id
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void updateRentalItem(RentalItem rentalItem) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(rentalItem);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }


}
