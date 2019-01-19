package hibernate.entity;
import sample.Controller;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hiber {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory != null) {
            return sessionFactory;
        } else {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            return sessionFactory;
        }

    }


    public static void addStudent(String name, String sname, int age) {
        System.out.println("Стартанул метод Hibera addStudent");

        Session session = getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        Studentt student = new Studentt();
        student.setName(name);
        student.setSname(sname);
        student.setAge(age);

        session.save(student);
        transaction.commit();

        session.close();
        getSessionFactory().close();
    }

    public static Studentt getStudent(int id) {
        System.out.println("Стартанул метод Hibera getStudent");

        Session session = getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        Studentt student = session.get(Studentt.class, id);
        transaction.commit();
        System.out.println(student);
        session.close();
        return student;
    }


    public static List<Studentt> getAllStudents() {

        System.out.println("Стартанул метод Hibera getAllStudents");

        Session session = getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        List<Studentt> list;
        list = (List<Studentt>)session.createQuery("from StudentExample").list();


        return list;
    }

    public static List<sample.Student> readStudents_HQL()
    {
        System.out.println("\n\nЧтение записей : HQL");

        Session session = getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        // HQL (Hibernate Query Language)
        String sql = "From " + Studentt.class.getSimpleName();
        System.out.println("sql = " + sql);

        List<Studentt> students = session.createQuery(sql).list();
        List<sample.Student> listOfParsedStudents = new ArrayList<sample.Student>();

        for (int i = 0; i<students.size(); i++) {
            listOfParsedStudents.add(Controller.parsHiberStudent(students.get(i)));
        }

        System.out.println("Students.size = " + students.size());
        for (Iterator<Studentt> it = students.iterator(); it.hasNext();) {
            Studentt student = (Studentt) it.next();
            System.out.println(student.toString());
        }

        return listOfParsedStudents;
    }
    /*  private static final SessionFactory ourSessionFactory;*/

   /* static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }*/





        /*final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }*/
}
