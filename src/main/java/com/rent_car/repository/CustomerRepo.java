package com.rent_car.repository;

import com.rent_car.entity.Customer;
import com.rent_car.entity.Vehicle;
import com.rent_car.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerRepo {

    public void addCustomer(Customer customer){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            boolean ekziston = findByMail(customer.getMail());
            if (ekziston ==true) {
                System.out.println("Klieti  me mail " + customer.getMail() + " është regjistruar më parë");
            } else {
                s.save(customer);
                t.commit();
                System.out.println(" Klienti me mail " + customer.getMail() + " u shtua me sukses");
            }
        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }


    public void deleteCustomerById(int id) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Customer c = session.get(Customer.class, id);
            if (c != null) {
                session.delete(c);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();  // rollback ndodh ndërkohë që session është akoma hapur
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close(); // mbyllet vetëm në fund
            }
        }
    }


    public Customer findCustomerById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Customer.class, id); // merr customer sipas id
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void UpdateCustomer(Customer customer) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(customer);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Customer> findAll() {
        List<Customer> customers = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customers = session.createQuery("FROM Customer", Customer.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }

    public boolean findByMail(String mail) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT 1 FROM Customer c WHERE c.mail = :mail";
            List<String> list = session.createQuery(hql, String.class)
                    .setParameter("mail", mail)
                    .getResultList();
            return !list.isEmpty();  // true nëse ekziston, false nëse nuk ekziston
        }
    }

}
