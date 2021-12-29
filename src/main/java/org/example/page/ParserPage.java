package org.example.page;

//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


import org.example.functions.*;

import java.util.ArrayList;
import java.util.List;

public class ParserPage {
//    static Logger logger = LogManager.getLogger();

    public static int count = 100;//изменяем count в зависимости от количества ссылок
    public static int number = 0;//итерация по массиву
    static List<String> ttx = new ArrayList<>(30);//если товаров больше сотки поменять тоже
    public static List<String> photos = new ArrayList<>(30);//если товаров больше сотки поменять тоже
    public static List<String> photo = new ArrayList<>();
    static String TTX = "";
    public static String characteristics ="";
    public static String advantages="";
    public static String equipment ="";
    public static String weight ="";
    public static String features  ="";
    public static String URLS  ="";

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
            }
        }
        return ttx;
    }
}
