package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Alien a1 = new Alien();
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setRam(24);
        l1.setBrand("HP");
        l1.setModel("Victus");
        a1.setAid(101);
        a1.setName("Ayush");
        a1.setTech("Java");
        a1.setLaptop(l1);
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(l1);
        session.persist(a1);
        transaction.commit();
        Alien a2 = session.find(Alien.class, 101);
        System.out.println(a2.getLaptop());
        session.close();
    }
}