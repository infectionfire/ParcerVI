package org.example;

import org.example.functions.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParserPage {

    public static int count = 100;//изменяем count в зависимости от количества ссылок
    public static int number = 0;//итерация по массиву
    static List<String> ttx = new ArrayList<>(30);//если товаров больше сотки поменять тоже
    static List<String> photos = new ArrayList<>(30);//если товаров больше сотки поменять тоже
    public static List<String> photo = new ArrayList<>();
    static String TTX = "";
    public static String characteristics ="";
    public static String advantages="";
    public static String equipment ="";
    public static String weight ="";
    public static String features  ="";
    public static String URLS  ="";

        public static Document getPagePrint() throws IOException {
        //меняем значение для выбора ссылки, отсчет с нуля
        String url = ReadingFromFile.readPrintValue().get(number)+"/print/";
        return Jsoup.parse(new URL(url), 2000);
    }

        public static Document getPage() throws IOException {
            //меняем значение для выбора ссылки, отсчет с нуля
            String url = ReadingFromFile.readPrintValue().get(number);
            URLS = url+"\n\n";
            return Jsoup.parse(new URL(url), 2000);
        }

    public static List<String> CreateMassive() throws NullPointerException {

        for (int i = 0; i < count; i++) {
            try {
                //подключаем модули
                Features.CreateFeatures();
                Chatacteristics.CreateCharacteristics();
                Advantages.CreateAdvantages();
                Equipment.CreateComplectation();
                Weight.CreateWeigth();
                PhotoCrawler.PhotoCrawler();
                TTX= features+characteristics +advantages+ equipment + weight;
                photos.add(PhotoCrawler.photo);
                ttx.add(TTX);
                number++;
            } catch (Exception e) {
//                System.out.println(e);игнорируем, не запишет больше, чем нужно
            }
        }
        return ttx;
    }
}
