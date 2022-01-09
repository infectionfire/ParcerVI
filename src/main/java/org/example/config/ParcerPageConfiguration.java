package org.example.config;

import org.example.methods.StructureCardBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParcerPageConfiguration {

    private static List<String> ttx = new ArrayList<>(100);//если товаров больше сотки поменять тоже
    public static List<String> photos = new ArrayList<>(100);//если товаров больше сотки поменять тоже
    public static List<String> instr = new ArrayList<>(100);//если товаров больше сотки поменять тоже

    public static void setPhotos(List<String> photos) {
        ParcerPageConfiguration.photos = photos;
    }

    public static void setInstr(List<String> instr) {
        ParcerPageConfiguration.instr = instr;
    }

    public static List<String> allInformationCollector() throws IndexOutOfBoundsException, IOException {
        try {//подключаем модули
            ttx=(StructureCardBuilder.BuildDescription());
        }catch (Exception e){
            System.out.println(e);
        }
        return ttx;
    }
}
