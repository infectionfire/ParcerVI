package org.example.modules.VI;

import org.example.pageProcessing.GetPageVI;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static org.example.pageProcessing.StructureCardBuilder.setCharacteristics;

/**
 * Формирование поля "технические характеристики" для описания товарной карточки
 */

public class Characteristics extends GetPageVI {//технические характеристики
    private Characteristics() {
        throw new IllegalStateException("Utility class");
    }


    public static void CreateCharacteristics() throws IOException {
        StringBuilder charact = new StringBuilder("<strong>Технические характеристики:</strong>\n\n");
        Element element = getPage()
                .select("div.features.spoiler")
                .first();
        if (element!=null) {
            Elements names = element.select("ul");//вытаскиваем инфу из маркированного списка
            Elements values = names.select("li");

            for (Element value : values) {//цикл добавляет значения к строке, попутно форматируя ее
                String theme = value.select("li").text();
                charact.append("- ").append(theme).append(";\n");
            }
        }
        if (charact.toString().endsWith(";\n")){
            charact.replace(charact.length()-2,charact.length()-1,".");
        }

        setCharacteristics(charact+"\n");
    }
}