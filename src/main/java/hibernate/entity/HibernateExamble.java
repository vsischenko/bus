package hibernate.entity;

import hibernate.entity.entity.students.Exam;
import hibernate.entity.entity.students.StudentExample;
import hibernate.entity.entity.students.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExamble {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

      //  StudentExample s= session.get(StudentExample.class, 1);

        Subject s = new Subject();
        s.setName("Фантастические чтения");

        Exam exam = new Exam();
        exam.setSubject(s);

        session.save(exam);

        StudentExample a = new StudentExample();
        a.setAge(24);
        a.setFirstName("Marta");
        a.setLastName("Galizka");




        StudentExample temp = session.get(StudentExample.class,3);

        System.out.println(temp.getExams());



        session.close();
        sessionFactory.close();
    }


}
