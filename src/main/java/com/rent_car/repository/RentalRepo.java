package com.rent_car.repository;

import com.rent_car.entity.*;
import com.rent_car.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RentalRepo {

    public void rentaladd(Rental rental){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.save(rental);
            t.commit();
        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }


    public void deleteRentalID(int id){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            Rental rental = s.get(Rental.class, id);
            if (rental != null) {
                s.delete(rental); // ose session.delete(p);
            }

            t.commit();
        } catch(Exception e){
            if(t!=null)t.rollback(); e.printStackTrace();}
    }

    public Rental findRentalID(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Rental.class, id); // merr order sipas id
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void updateRental(Rental rental) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(rental);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }



    public List<Rental> findAllRental() {
        List<Rental> orderItems = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderItems = session.createQuery("FROM Rental", Rental.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderItems;
    }


    public List<Rental> getListRental(long id ) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Rental r WHERE r.id = :id";
            return session.createQuery(hql, Rental.class)
                    .setParameter("id", id)
                    .list();
        }
    }
}
