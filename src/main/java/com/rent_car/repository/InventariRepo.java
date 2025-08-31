package com.rent_car.repository;

import com.rent_car.entity.Inventari;
import com.rent_car.entity.Status;
import com.rent_car.entity.Vehicle;
import com.rent_car.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class InventariRepo {
        public void addInventari(Inventari inventari){
            Transaction t=null;
            try(Session s= HibernateUtil.getSessionFactory().openSession()){
                t=s.beginTransaction();
                boolean ekziston = findByTargaInventari(inventari.getVehicle().getTarga());
                if (ekziston ==true) {
                    System.out.println("Makina me targën " + inventari.getVehicle().getTarga() + " është regjistruar më parë ne inventar");
                } else {
                    s.save(inventari);
                    t.commit();
                    System.out.println(" Makina me targën " + inventari.getVehicle().getTarga()
                            + " u shtua me sukses ne inventar");
                }
            } catch(Exception e){
                if(t!=null)t.rollback();
                e.printStackTrace();}
        }


        public void deleteVehicleIDInventari(long id){
            Transaction t=null;
            try(Session s= HibernateUtil.getSessionFactory().openSession()) {
                t = s.beginTransaction();
                Inventari inventari = s.get(Inventari.class, id);
                if (inventari != null) {
                    s.delete(inventari); // ose session.delete(p);
                }

                t.commit();
            } catch(Exception e){
                if(t!=null)t.rollback(); e.printStackTrace();}
        }

        public Inventari findVehicleIDneInventar(int id) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.get(Inventari.class, id); // merr order sipas id
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        public void updateInventari(Inventari inventari) {
            Transaction tx = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                tx = session.beginTransaction();
                session.update(inventari);
                tx.commit();
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            }
        }



        public List<Inventari> findAllInventari() {
            List<Inventari> inventaris = null;

            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                inventaris = session.createQuery("FROM Inventari", Inventari.class).list();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return inventaris;
        }

        public List<Vehicle> getVehiclesByStatusInventari(Status status) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                String hql = "FROM Inventari i WHERE i.status = :status";
                return session.createQuery(hql, Vehicle.class)
                        .setParameter("status", status)
                        .list();
            }
        }

        public boolean findByTargaInventari(String targa) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                String hql = "SELECT 1 FROM Inventari i WHERE i.vehicle.targa = :targa";
                List<Inventari> list = session.createQuery(hql, Inventari.class)
                        .setParameter("targa", targa)
                        .getResultList();
                return !list.isEmpty();  // true nëse ekziston, false nëse nuk ekziston
            }


        }

    public int findByModelInventar(String model) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Inventari i WHERE i.vehicle.model = :model";
            List<Inventari> list = session.createQuery(hql, Inventari.class)
                    .setParameter("model", model)
                    .list();
            return list.size();
        }
    }


}

