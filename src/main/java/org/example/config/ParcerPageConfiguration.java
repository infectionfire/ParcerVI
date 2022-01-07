package org.example.config;

import org.example.modules.VI.ManualCrawler;
import org.example.modules.VI.PhotoCrawler;
import org.example.methods.StructureCardBuilder;

import java.util.ArrayList;
import java.util.List;

public class ParcerPageConfiguration {

    final static int count = 100;//изменяем count в зависимости от количества ссылок
    private static int number = 0;//итерация по массиву
    private static List<String> ttx = new ArrayList<>(100);//если товаров больше сотки поменять тоже
    public static List<String> photos = new ArrayList<>(100);//если товаров больше сотки поменять тоже
    public static List<String> instr = new ArrayList<>(100);//если товаров больше сотки поменять тоже
    public static int getNumber() {
        return number;
    }

    public static List<String> allInformationCollector() throws  IndexOutOfBoundsException{

        try {//подключаем модули
            for (int i = 0; i < count; i++) {
                photos.add(PhotoCrawler.getPhoto());
                instr.add(ManualCrawler.getManual());
                ttx.add(StructureCardBuilder.BuildDescription().toString().replaceAll(";;",";"));
                number++;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return ttx;
    }

    public static List<String> InformationCollector() throws  IndexOutOfBoundsException{

        try {//подключаем модули
            for (int i = 0; i < count; i++) {
                ttx.add(StructureCardBuilder.BuildDescription().toString().replaceAll(";;",";"));
                number++;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return ttx;
    }
}
