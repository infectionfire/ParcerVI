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
    public static int count = 200;
    //если товаров больше сотки поменять тоже
    static List<String> ttx = new ArrayList<>(200);
    public static List<String> photo = new ArrayList<>();
    static String TTX = "";
    public static String characteristics ="";
    public static String advantages="";
    public static String equipment ="";
    public static String weight ="";
    public static String features  ="";
    public static String URLS  ="";

        public static Document getPage() throws IOException {
        //меняем значение для выбора ссылки, отсчет с нуля
        String url = ReadingFromFile.readPrintValue().get(number)+"/print/";

        return Jsoup.parse(new URL(url), 2000);
    }
        public static Document getPageUnprint() throws IOException {
            //меняем значение для выбора ссылки, отсчет с нуля
            String url = (String) ReadingFromFile.readPrintValue().get(number);
            URLS = url+"\n\n";
            return Jsoup.parse(new URL(url), 2000);
        }

    public static List<String> CreateMassive() throws NullPointerException {
//методы
        for (int i = 0; i < count; i++) {
            try {
                //подключаем модули
                GetFeatures.Features();
                GetChatacteristics.Characteristics();
                GetAdvantages.Advantages();
                GetEquipment.Complectation();
                GetWeight.Weigth();
                TTX= features+characteristics +advantages+ equipment + weight;
                ttx.add(i, TTX);
                number++;
            } catch (Exception e) {
//                System.out.println(e);игнорируем, не запишет больше, чем нужно
            }
        }
        return ttx;
    }

}
