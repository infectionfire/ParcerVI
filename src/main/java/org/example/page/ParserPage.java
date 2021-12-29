package org.example.page;

import org.example.functions.*;
import java.util.ArrayList;
import java.util.List;

public class ParserPage {

    public static int count = 100;//изменяем count в зависимости от количества ссылок
    public static int number = 0;//итерация по массиву
    static List<String> ttx = new ArrayList<>(30);//если товаров больше сотки поменять тоже
    public static List<String> photos = new ArrayList<>(30);//если товаров больше сотки поменять тоже
    static StringBuilder TTX = new StringBuilder();
    public static StringBuilder characteristics = new StringBuilder();
    public static StringBuilder photo = new StringBuilder();
    public static StringBuilder advantages= new StringBuilder();
    public static StringBuilder equipment = new StringBuilder();
    public static StringBuilder weight = new StringBuilder();
    public static StringBuilder features  = new StringBuilder();

    public static List<String> CreateMassive() throws  IndexOutOfBoundsException{

        try {//подключаем модули
            for (int i = 0; i < count; i++) {
                Features.CreateFeatures();
                Characteristics.CreateCharacteristics();
                Advantages.CreateAdvantages();
                Equipment.CreateComplectation();
                Weight.CreateWeigth();
                PhotoCrawler.PhotoCrawler();
                TTX.append(features).append(characteristics).append(advantages).append(equipment).append(weight);
                photos.add(PhotoCrawler.photo);
                ttx.add(TTX.toString());
                TTX=new StringBuilder();
                number++;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return ttx;
    }
}
