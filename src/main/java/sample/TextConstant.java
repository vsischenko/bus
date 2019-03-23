package sample;

public class TextConstant {

   final static String [] busModelList = {"Богдан 92", "Богдан 91", "Иван", "Эталон", "Рута"};
   final static String [] busRouteNumbers = {"121", "146", "175", "185", "232","203"};
   final static String [] busColor = {"Желтый", "Белый", "Синий", "Фиолетовый", "Кобинированный"};
   final static String [] busTableOnFrontWindow = {"На лобовом", "Лобовое свободно"};

    public static String[] getBusModelList() {
        return busModelList;
    }

    public static String[] getBusRouteNumbers() {
        return busRouteNumbers;
    }

    public static String[] getBusColor() {
        return busColor;
    }

    public static String[] getBusTableOnFrontWindow() {
        return busTableOnFrontWindow;
    }
}
