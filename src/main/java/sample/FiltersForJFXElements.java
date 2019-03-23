package sample;

import java.util.ArrayList;

//в выпадающих списках при редактировании выводит для замены "все кроме выбранного".

public class FiltersForJFXElements {


    public static ArrayList filterCboxMenu(Bus selectedBus, String choise) {
        String[] a = TextConstant.getBusModelList();
        ArrayList list = new ArrayList();
        switch (choise) {
            case "model":
                for (int i = 0; i < a.length; i++) {
                    if (a[i].equals(selectedBus.getModel())) {
                    } else {
                        list.add(a[i]);
                    }
                }
                break;
            case "route":
                a = TextConstant.getBusRouteNumbers();
                for (int i = 0; i < a.length; i++) {
                    if (a[i].equals(selectedBus.getRoute())) {
                    } else {
                        list.add(a[i]);
                    }
                }
                break;

            case "color":
                a = TextConstant.getBusColor();
                for (int i = 0; i < a.length; i++) {
                    if (a[i].equals(selectedBus.getBusColor())) {
                    } else {
                        list.add(a[i]);
                    }
                }
                break;
            case "table":

                a = TextConstant.busTableOnFrontWindow;
                if (selectedBus.getNumTabOnFrontWindow()) {
                    list.add("Лобовое свободно");
                } else {
                    list.add("Лобовое занято");
                }
                break;
        }
        return list;
    }

}
