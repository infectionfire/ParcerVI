package org.example.config;

import org.example.modules.VI.ManualCrawler;
import org.example.modules.VI.PhotoCrawler;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.modules.VI.Advantages.createAdvantages;
import static org.example.modules.VI.Characteristics.createCharacteristics;
import static org.example.modules.VI.Equipment.createComplectation;
import static org.example.modules.VI.Features.createFeatures;
import static org.example.modules.VI.Weight.createWeight;
import static org.example.pageProcessing.GetPageVI.getPage;

/**
 * Файл для составления конфигурации описания
 */
public class StructureCardBuilder {
    private static List<String> ttx = new ArrayList<>(100);//если товаров больше сотки поменять тоже
    private static List<String> photos = new ArrayList<>(100);//если товаров больше сотки поменять тоже
    private static List<String> instr = new ArrayList<>(100);//если товаров больше сотки поменять тоже

    public static List<String> getTtx() {
        return ttx;
    }

    public static void setTtx(List<String> ttx) {
        StructureCardBuilder.ttx = ttx;
    }

    public static List<String> getPhotos() {
        return photos;
    }

    public static void setPhotos(List<String> photos) {
        StructureCardBuilder.photos = photos;
    }

    public static List<String> getInstr() {
        return instr;
    }

    public static void setInstr(List<String> instr) {
        StructureCardBuilder.instr = instr;
    }

    private StructureCardBuilder() {
        throw new IllegalStateException("Utility class");
    }

    //функции для заполнения ттх
    public static void BuildDescription() throws IOException {
        List<String> productCards = new ArrayList<>(100);
        List<Document> documentList = getPage();
        List<String> photoListBuilder = new ArrayList<>(100);
        List<String> instrListBuilder = new ArrayList<>(100);
        for(Document document:documentList) {

            StringBuilder oneProductCard = new StringBuilder();

            oneProductCard.append(createFeatures(document))
                    .append(createCharacteristics(document))
                    .append(createAdvantages(document))
                    .append(createComplectation(document))
                    .append(createWeight(document));
            productCards.add(oneProductCard.toString().replaceAll(";;",";"));
            photoListBuilder.add(PhotoCrawler.getPhoto(document));
            instrListBuilder.add(ManualCrawler.getManual(document));
            }
        setPhotos(photoListBuilder);
        setInstr(instrListBuilder);
        setTtx(productCards) ;
    }
}
