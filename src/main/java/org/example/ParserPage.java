package org.example;

import org.example.functions.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParserPage {
    //итерация по массиву
    public static int number = 0;
    //изменяем count в зависимости от количества ссылок
    public static int count = 3;
    //если товаров больше сотки поменять тоже
    static List<String> ttx = new ArrayList<>(100);
    static String TTX = "";
    public static String characteristics ="";
    public static String advantages="";
    public static String equipment ="";
    public static String weight ="";
    public static String URL ="";

        public static Document getPage() throws IOException {
        //меняем значение для выбора ссылки, отсчет с нуля
        String url = (String) ReadingFromFile.readPrintValue().get(number)+"/print/";

        return Jsoup.parse(new URL(url), 2032);
    }
    public static Document getPageUnprint() throws IOException {
        //меняем значение для выбора ссылки, отсчет с нуля
        String url = (String) ReadingFromFile.readPrintValue().get(number);
        URL=url+"\n";
        return Jsoup.parse(new URL(url), 2037);
    }

    public static List<String> CreateMassive() throws NullPointerException {
//методы
        for (int i = 0; i < count; i++) {
            try {
                //подключаем модули
                Features.Features();
                Chatacteristics.Characteristics();
                Advantages.Advantages();
                Equipment.Complectation();
                Weight.Weigth();
                TTX= URL+Features.features+characteristics +advantages+ equipment + weight;
                ttx.add(i, TTX);
            } catch (Exception e) {
//                System.out.println(e); в принципе не нужен
            }

        }
        return ttx;
    }

}
