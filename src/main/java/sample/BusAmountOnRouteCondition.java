package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class BusAmountOnRouteCondition {
    static int bus121 = 0;
    static int bus146 = 0;
    static int bus175 = 0;
    static int bus185 = 0;
    static int bus232 = 0;
    static int bus203 = 0;

    public static void counter(ObservableList<Bus> list) {

        bus121 = 0;
        bus146 = 0;
        bus175 = 0;
        bus185 = 0;
        bus232 = 0;
        bus203 = 0;

        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i).getRoute()) {
                case "121":
                    bus121++;
                    break;
                case "146":
                    bus146++;
                    break;
                case "175":
                    bus175++;
                    break;
                case "185":
                    bus185++;
                    break;
                case "232":
                    bus232++;
                    break;
                case "203":
                    bus203++;
                    break;
            }
        }

    }

}
