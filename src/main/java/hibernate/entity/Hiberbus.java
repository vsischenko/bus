package hibernate.entity;

import hibernate.entity.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sample.Planshet;
import sample.entityBusToBusConverter;
import sample.entityPlanshetToFXPlanshetConverter;

import java.util.ArrayList;
import java.util.Date;
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

    //проверка на дубликат автобуса в базе
    public static Boolean exists(String number) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("select number from HBus where number = :number");
        query.setParameter("number", number);

        if (((org.hibernate.query.Query) query).list().isEmpty()) {
            return false;

        } else {
            return true;
        }

    }


//TODO Создать объект Hbus и добавить его в базу.

    public static void addBusToDatabase(ArrayList<String> arrOfFields) {
        Session session = getSessionFactory().openSession();
        //   Transaction transaction = session.beginTransaction();


        HBus newBus = new HBus();

        newBus.setAddDate(new Date());
        newBus.setNumber(arrOfFields.get(0));
        newBus.setModel(arrOfFields.get(1));
        newBus.setRoute(Integer.parseInt(arrOfFields.get(2)));
        newBus.setColor(arrOfFields.get(3));

        if (arrOfFields.get(4) == null) {
            newBus.setNumTabOnFrontWindow(false);
        } else {
            if (arrOfFields.get(4).equals("На лобовом")) {
                newBus.setNumTabOnFrontWindow(true);
            } else {
                newBus.setNumTabOnFrontWindow(false);
            }
        }

        newBus.setPark(arrOfFields.get(5));

        newBus.setSeenDate(new Date());

        SpecialMarks sp = new SpecialMarks();
        sp.setDate(new Date());
        sp.setLog(arrOfFields.get(6));

        History history = new History();

        history.setAddDate(new Date());
        history.setLog("Добавлен в базу");
        history.setBus(newBus);


        newBus.setSpecialMarks(sp);

        session.save(newBus);
        session.save(history);

        session.close();


    }

    //TODO Поиск по номеру автобуса
    //Достать объект Hbus по уникальному госномеру
    public static HBus getBus(String gosnum) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        HBus bus = session.byNaturalId(HBus.class)
                .using("number", gosnum)
                .load();
        transaction.commit();

        return bus;
    }


    //Достать автобус из таблицы по ID
    public static sample.Bus getBus(int id) {
        System.out.println("Стартанул метод HiberBus getBus (id)");
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        HBus temp = session.get(HBus.class, id);
        transaction.commit();

        //getSessionFactory().close();
        sample.Bus bus;
        bus = entityBusToBusConverter.parsEntityBus(temp);
        session.close();
        return bus;
    }

    //Достать все автобусы
//TODO Считываем содержание таблица BUS в TableView
    public static List<HBus> getAllInBusTable() {
        System.out.println("\n\nЧтение записей в таблице Bus: HQL");
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // HQL (Hibernate Query Language запрос)
        String sql = "From " + HBus.class.getSimpleName();
        System.out.println("sql = " + sql);

        List<HBus> hiberBusList = session.createQuery(sql).list();

        System.out.println("Размер листа = " + hiberBusList.size());

        for (int i = 0; i < hiberBusList.size(); i++) {

            if (hiberBusList.get(i).isInArch()) {
                hiberBusList.remove(i);
            }

        }

        return hiberBusList;

    }

//TODO Достать Планшет из таблицы по ID

    public static sample.Planshet getPlanshet(int id) {
        System.out.println("Стартанул метод HiberBus getPlanshet (id)");
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Hplanshet temp = session.get(Hplanshet.class, id);
        transaction.commit();
        session.close();
        //getSessionFactory().close();

        return entityPlanshetToFXPlanshetConverter.parsEntityPlanshet(temp);
    }

    //TODO Достать планшет из базы по уникальному инвентарному номеру не конвертированный в объект FX

    public static Hplanshet getPlanshet(String invNum) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Hplanshet planshet = session.byNaturalId(Hplanshet.class)
                .using("invNumber", invNum)
                .load();

        return planshet;
    }


//TODO Достать Считать всё из таблицы Planshet в TableView


    //Берем планшет и устанавливаем на автобус

    public static void replacePlanshet(String invNum, String busNum) {
        System.out.println("Стартанул тестовый метод переноса планшета");
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Hplanshet planshet = session.byNaturalId(Hplanshet.class)
                .using("invNumber", invNum)
                .load();
        HBus bus = session.byNaturalId(HBus.class)
                .using("number", busNum)
                .load();

        if (planshet.getBus().getNumber().equals(bus.getNumber())) {
            System.out.println("Попытка поставить планшет туда, где он уже есть");
            return;
        }

        //логируем демонтаж планшета при переносе
        if (planshet.getBus() != null) {
            PlanshetHistory planshetHistory = new PlanshetHistory(
                    new Date(),
                    planshet,
                    planshet.getState(), "Планшет Инв.№: " + planshet.getInvNumber() + " перемещен с автобуса : " + planshet.getBus().getNumber()
            );
            History history = new History(
                    new Date(),
                    "с автобуса " + planshet.getBus().getNumber() + " демонтирован планшет Инв№ : " + planshet.getInvNumber(),
                    planshet.getBus());
            session.save(planshetHistory);
            session.save(history);
        }

        planshet.setBus(bus);
        planshet.setMountDate(new Date());
        PlanshetHistory planshetHistory = new PlanshetHistory(
                new Date(),
                planshet,
                planshet.getState(), "Планшет Инв.№: " + planshet.getInvNumber() + " установлен на автобус госномер : " + bus.getNumber()
        );

        session.save(planshetHistory);
        session.save(planshet);
        History history = new History();
        history.setAddDate(new Date());
        history.setLog(history.getAddDate() + " ++ " + bus.getNumber() + " установлен планшет инв.№ : " + planshet.getInvNumber());
        history.setBus(bus);
        session.save(history);
        transaction.commit();
        session.close();

    }

}
