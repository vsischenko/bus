package sample;

import hibernate.entity.entity.Hphotoset;

public class entytyPhotosetConverter {

    public static Photoset photosetConverter(Hphotoset hphotoset) {

        Photoset temp = new Photoset(hphotoset.getDateOfPhotoset());
        temp.setId(hphotoset.getId());


        return temp;
    }


}
