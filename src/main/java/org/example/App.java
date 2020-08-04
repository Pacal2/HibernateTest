package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Collection;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        //Set up object Alien

        /*
        AlienName pacalName = new AlienName("Javik", "Kuhul", "Chatan");
        AlienName xenoName = new AlienName("Xe", "No", "Morth");
        AlienName fredName = new AlienName("Freddy", "Bob", "Jones");

        Alien pacal = new Alien(1, pacalName, "Green");
        Alien xeno = new Alien(2, xenoName, "Blue");
        Alien fred = new Alien(3, fredName, "Red");
        */




        // Set up object laptop

        /*
        Laptop samsung = new Laptop(101, "Samsung");
        samsung.setAlien(pacal);

        Laptop dell = new Laptop(102, "Dell");
        dell.setAlien(fred);

        Laptop apple = new Laptop(103, "Apple");
        apple.setAlien(fred);

        Laptop asus = new Laptop(104, "Asus");
        asus.setAlien(pacal);

        Laptop acer = new Laptop(105, "Acer");
        acer.setAlien(fred);

        pacal.getLaps().add(samsung);
        pacal.getLaps().add(asus);

        fred.getLaps().add(dell);
        fred.getLaps().add(apple);
        fred.getLaps().add(acer);

         */

        //listOfLaptops.add(dellLaptop);

        // Set up object Student
        //Student student = new Student(1, "Pacal", 50);
        //student.getListOfLaptops().add(samsungLaptop);

        //samsungLaptop.getListOfStudents().add(student);





        // Set up session
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        // Saving object to data base

        /*
        session.save(xeno);
        session.save(fred);
        session.save(pacal);

        session.save(dell);
        session.save(asus);
        session.save(acer);
        session.save(apple);
        session.save(samsung);
         */

        // Getting data from data base
        //Alien a1 = (Alien) session.get(Alien.class, 1);
        //System.out.println(a1.getName());

        //System.out.println(pacal.toString());

        // Caching data
        Alien a2 = null;
        a2 = (Alien) session.get(Alien.class, 1);
        System.out.println(a2);

        // Commits
        session.getTransaction().commit();
        session.close();

        // Additional sessions
        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();

        a2 = (Alien) session2.get(Alien.class, 1);
        System.out.println(a2);

        session2.getTransaction().commit();
        session2.close();

    }
}
