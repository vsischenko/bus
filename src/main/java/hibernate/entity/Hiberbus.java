package hibernate.entity;

import hibernate.entity.entity.HBus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import sample.entityBusToBusConverter;

import java.util.List;

public class Hiberbus {


    private static SessionFactory sessionFactory;

    // Синглтон, Session Factory
    public static SessionFactory getSessionFactory() {
        if (sessionFactory != null) {
            return sessionFactory;
        } else {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            return sessionFactory;
        }
    }






    // TODO По клику на строку в TreeView получаем иноформацию и прописываем ее в полях Label в области для редактирования
    //TODO Поиск по номеру автобуса

    //Достать автобус из таблицы по ID
    public static sample.Bus getBus(int id) {
        System.out.println("Стартанул метод HiberBus getBus (id)");
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        HBus temp = session.get(HBus.class, id);

        transaction.commit();
        session.close();
        //getSessionFactory().close();
        sample.Bus bus = new sample.Bus();
        bus = entityBusToBusConverter.parsEntityBus(temp);

        return bus;
    }

    //Достать все автобусы
//TODO Считываем содержание таблица BUS в TableView
    public static List<HBus> getAllInBusTable () {
        System.out.println("\n\nЧтение записей в таблице Bus: HQL");
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // HQL (Hibernate Query Language запрос)
        String sql = "From " + HBus.class.getSimpleName();
        System.out.println("sql = " + sql);

        List<HBus> hiberBusList = session.createQuery(sql).list();

        System.out.println("Размер листа = " + hiberBusList.size());

        return hiberBusList;

    }

}
