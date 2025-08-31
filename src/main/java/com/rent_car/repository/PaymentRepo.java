package com.rent_car.repository;

import com.rent_car.entity.Payment;
import com.rent_car.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PaymentRepo {

    public void savePayments(Payment payment){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.save(payment);
            t.commit();
        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }


    public void deletePaymentID(int id){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            Payment payment = s.get(Payment.class, id);
            if (payment != null) {
                s.delete(payment); // ose session.delete(p);
            }

            t.commit();
        } catch(Exception e){
            if(t!=null)t.rollback(); e.printStackTrace();}
    }

    public Payment findPaymentID(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Payment.class, id); // merr order sipas id
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void updatePayment(Payment orderItem) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(orderItem);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }



    public List<Payment> findAllPayment() {
        List<Payment> orderItems = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderItems = session.createQuery("FROM Payment", Payment.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderItems;
    }

}
