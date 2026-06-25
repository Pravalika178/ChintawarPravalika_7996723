package com.cognizant.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = null;

        try {

            tx = session.beginTransaction();

            Employee employee =
                    new Employee(
                            "David",
                            "Miller",
                            60000);

            session.save(employee);

            tx.commit();

            System.out.println("Employee Saved Successfully");

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        }

        session.close();
        factory.close();
    }
}