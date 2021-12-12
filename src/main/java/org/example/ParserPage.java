package org.example;

import org.example.functions.Advantages;
import org.example.functions.Chatacterystics;
import org.example.functions.Complectation;
import org.example.functions.Weight;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParserPage {

public static int number = 0;
//изменяем count в зависимости от количества ссылок
    public static int count = 3;
    static List<String> ttx = new ArrayList<>(3);
    static String TTX = "";
    public static String characterystics ="";
    public static String advantages="";
    public static String complectation="";
    public static String weigth="";

        public static Document getPage() throws IOException {
        //меняем значение для выбора ссылки, отсчет с нуля
        String url = (String) ReadingFromFile.readPrintValue().get(number);
            return Jsoup.parse(new URL(url), 2032);
    }

    public static List<String> CreateMassive() throws NullPointerException {
//методы
        for (int i = 0; i < count; i++) {
            try {
                Chatacterystics.Characterystics();
                Advantages.Advantages();
                Complectation.Complectation();
                Weight.Weigth();
                TTX=characterystics +advantages+complectation+weigth;
                ttx.add(i, TTX);
                TTX = ""; characterystics ="";advantages="";complectation="";weigth="";
                number++;
            } catch (Exception e) {
//                System.out.println(e); в принципе не нужен
            }

        }
        return ttx;
    }

}
