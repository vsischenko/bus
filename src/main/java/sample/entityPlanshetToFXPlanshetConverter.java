package sample;

import hibernate.entity.entity.Hplanshet;

public class entityPlanshetToFXPlanshetConverter {

    public static sample.Planshet parsEntityPlanshet(Hplanshet temp) {
        Planshet planshet = new Planshet(

                temp.getInvNumber(),
                temp.getTypeOfPlanshet(),
                temp.getMountDate(),
                temp.getSeenDate(),
                temp.getDismountDate(),
                temp.getBus().getNumber(),
                temp.getState());


return planshet;
    }
}
