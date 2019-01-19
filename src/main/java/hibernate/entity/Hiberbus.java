package hibernate.entity;

import hibernate.entity.entity.Bus;
import hibernate.entity.entity.Contact;
import hibernate.entity.entity.History;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class Hiberbus {


    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory != null) {
            return sessionFactory;
        } else {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            return sessionFactory;
        }

    }

    public static void addBus() {
        System.out.println("Стартанул метод HiberBus addBus");

        Session session = getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        Contact contact = session.get(Contact.class, 1);
        Bus bus = session.get(Bus.class, 1);
        contact.setBus(bus);
        session.saveOrUpdate(contact);



        Bus bus2 = session.get(Bus.class,2);
        System.out.println("++++ "+bus);
        System.out.println("++++ "+bus2);
       // System.out.println("++++ "+bus.getContacts().get(1));




        //   System.out.println("Размер массива контактов " + bus.getContacts().size());
        transaction.commit();
        session.close();
        getSessionFactory().close();
    }

    public static void main(String[] args) {


        addBus();

    }

}
