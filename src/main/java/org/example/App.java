package org.example;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;


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
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
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

        //Query caching
        /*
        Query q1 = session.createQuery("FROM Alien WHERE ID=101");
        q1.setCacheable(true);
        Alien a3 = (Alien) q1.uniqueResult();

        // Caching data
        Alien a2 = null;
        a2 = (Alien) session.get(Alien.class, 1);
        System.out.println(a2);

        // HQL (Hibernate Query Language)
        Random random = new Random();

         */

        /*
        // Creating multiple entries
        for (int i=1; i<=50; i++) {
            Student s = new Student();
            s.setNumber(i);
            s.setName("Name " + i);
            s.setMarks(random.nextInt(100));
            session.save(s);
        }
         */

        // Printing data(HQL)
        /*
        Query qForList = session.createQuery("FROM Student WHERE marks > 50");
        List<Student> students = qForList.list();

        for(Student s : students) {
            System.out.println(s);
        }

        Query qForOne = session.createQuery("FROM Student WHERE number=7");
        Student student = (Student) qForOne.uniqueResult();
        System.out.println(student);

         */

        // Printing data(HQL) part. 2
        /*
        int number = 7;
        Query q = session.createQuery("SELECT number, marks, name FROM Student WHERE number= :number");
        q.setParameter("number",number);
        Query qList = session.createQuery("SELECT number, marks, name FROM Student");

        Object[] studentTwo = (Object[]) q.uniqueResult();;
        List<Object[]> studentTwoList = (List<Object[]>) qList.list();

        for(Object o : studentTwo) {
            System.out.println(o);
        }

        for(Object[] studentFromList : studentTwoList) {
            System.out.println(studentFromList[0] + " : " + studentFromList[1] + " : " + studentFromList[2]);
        }

        System.out.println(studentTwo[0] + " : " + studentTwo[1] + " : " + studentTwo[2]);

         */

        // Printing data(HQL) part. 3 - native queries
        /*
        SQLQuery query = session.createSQLQuery("SELECT * FROM student WHERE marks>60");
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List students = query.list();

        for(Object o : students) {
            Map m = (Map)o;
            System.out.println(m.get("name") + " : " + m.get("marks"));
        }

         */

        // Hibernate Object States Persistence Life Cycle
        /*
        Laptop l = new Laptop();
        l.setId(106);
        l.setName("Sony");

        session.save(l);


        l.setName("Dell");

        //session.remove(l);

         */

        // Get vs. Load
        Laptop lap = (Laptop) session.get(Laptop.class, 6);
        // Laptop lap = (Laptop) session.load(Laptop.class, 6);
        System.out.println(lap);

        // Commits
        session.getTransaction().commit();

        // Detaching
        /*
        session.evict(l);
        l.setName("Asus");

         */

        //session.close();

        // Additional sessions
        /*
        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();

        Query q2 = session2.createQuery("FROM Alien WHERE ID=101");
        q2.setCacheable(true);
        a3 = (Alien) q2.uniqueResult();

        a2 = (Alien) session2.get(Alien.class, 1);
        System.out.println(a2);

        session2.getTransaction().commit();
        session2.close();

         */

    }
}
