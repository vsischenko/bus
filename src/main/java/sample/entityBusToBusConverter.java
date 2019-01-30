package sample;


import hibernate.entity.entity.HBus;

import java.util.ArrayList;
import java.util.List;

public class entityBusToBusConverter {

    //Конвертирует полученный объект Hibernate в объект Bus, с которым работает Fx приложение
    public static Bus parsEntityBus (HBus temp) {
        sample.Bus bus = new sample.Bus(temp.getID(),
                String.valueOf(temp.getRoute()),
                temp.getNumber(),
                temp.getModel(),
                temp.getAddDate(),
                temp.getSeenDate(),
                temp.isNumTabOnFrontWindow(),
                temp.getPark(), temp.getColor());
        bus.getHistory().addAll(temp.getHistory());
        if (temp.getPlanshets().size()==0) {}
        else {
            String tempString="";
            for (int i=0; i<temp.getPlanshets().size(); i++) {
                bus.getPlanshetList().add(entityPlanshetToFXPlanshetConverter.parsEntityPlanshet(temp.getPlanshets().get(i)));
                tempString += temp.getPlanshets().get(i).getInvNumber() + "  ";
            }
            bus.setPlNum(tempString);
        }
        return bus;
    }

    //Конвертирует полученный List Hibernatовских Автобусов в List Автобусов для FX
    public static List<Bus> parsListOfEntityBus (List<HBus> hiberList) {
        List<sample.Bus> list = new ArrayList<Bus>();

        for (int i = 0; i<hiberList.size(); i++) {
            list.add(parsEntityBus(hiberList.get(i)));
        }
        return list;
    }
}
