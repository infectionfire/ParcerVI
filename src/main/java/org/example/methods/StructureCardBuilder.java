package org.example.methods;

import org.example.modules.VI.*;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.config.ParcerPageConfiguration.*;
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

    private StructureCardBuilder() {
        throw new IllegalStateException("Utility class");
    }

    //функции для заполнения ттх
    public static List<String> BuildDescription() throws IOException {
        List<String> productCards = new ArrayList<>();
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
        return productCards;
    }
}
