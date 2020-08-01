package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


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
        AlienName pacalName = new AlienName("Javik", "Kuhul", "Chatan");
        Alien pacal = new Alien(1, pacalName, "Green");

        // Set up object laptop
        Laptop laptop = new Laptop(101, "Dell");

        // Set up object Student
        Student student = new Student(1, "Pacal", 50);

        // Set up session
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        // Saving object to data base
        session.save(laptop);
        session.save(student);
        //session.save(pacal);


        // Getting data grom data base
        //pacal = (Alien) session.get(Alien.class, 105);

        session.getTransaction().commit();

        System.out.println(pacal.toString());
    }
}
