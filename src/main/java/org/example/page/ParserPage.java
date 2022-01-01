package org.example.page;

import org.example.functions.*;
import java.util.ArrayList;
import java.util.List;


public class ParserPage {

    final static int count = 100;//изменяем count в зависимости от количества ссылок
    public static int number = 0;//итерация по массиву
    static List<String> ttx = new ArrayList<>(30);//если товаров больше сотки поменять тоже
    public static List<String> photos = new ArrayList<>(30);//если товаров больше сотки поменять тоже
    public static List<String> instr = new ArrayList<>(30);//если товаров больше сотки поменять тоже

    private static String characteristics;
    private static StringBuilder advantages= new StringBuilder();
    private static StringBuilder equipment = new StringBuilder();
    private static StringBuilder weight = new StringBuilder();
    private static StringBuilder features  = new StringBuilder();

    public static void setCharacteristics(String characteristics) {
        ParserPage.characteristics = characteristics;
    }
    public static void setAdvantages(StringBuilder advantages) {
        ParserPage.advantages = advantages;
    }
    public static void setEquipment(StringBuilder equipment) {
        ParserPage.equipment = equipment;
    }
    public static void setWeight(StringBuilder weight) {
        ParserPage.weight = weight;
    }
    public static void setFeatures(StringBuilder features) {
        ParserPage.features = features;
    }

    public static List<String> CreateMassive() throws  IndexOutOfBoundsException{

        try {//подключаем модули
            for (int i = 0; i < count; i++) {
                StringBuilder TTX = new StringBuilder();
                Features.CreateFeatures();
                Characteristics.CreateCharacteristics();
                Advantages.CreateAdvantages();
                Equipment.CreateComplectation();
                Weight.CreateWeigth();
                PhotoCrawler.PhotoUrlsCreate();
                InstrCrawler.InstrUrlsCreate();
                TTX.append(features).append(characteristics).append(advantages).append(equipment).append(weight);
                photos.add(PhotoCrawler.photo);
                instr.add(InstrCrawler.instr);
                ttx.add(TTX.toString().replaceAll(";;",";"));
                number++;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return ttx;
    }
}
