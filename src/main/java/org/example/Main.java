package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Alien a1 = new Alien();
        Alien a2 = new Alien();
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setRam(24);
        l1.setBrand("HP");
        l1.setModel("Victus");
        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setRam(64);
        l2.setBrand("Dell");
        l2.setModel("AlienWare");
        a1.setAid(101);
        a1.setLaptops(new ArrayList<>());
        a1.setName("Ayush");
        a1.setTech("Java");
        a1.setLaptop(l1);
        a1.setLaptop(l2);

        a2.setAid(102);
        a2.setLaptops(new ArrayList<>());
        a2.setName("Vijay");
        a2.setTech("devOps");
        a2.setLaptop(l1);

        l1.setAliens(List.of(a1, a2));
        l2.setAliens(List.of(a1));
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(a1);
        session.persist(a2);
        transaction.commit();
//        Alien a2 = session.find(Alien.class, 101);
//        System.out.println(a2.getLaptop(1));
        session.close();
    }
}