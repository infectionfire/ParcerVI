package org.example.functions;

import org.example.page.GetPageVIAndPrint;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.page.ParserPage.setCharacteristics;

/**
 * Формирование поля "технические характеристики" для описания товарной карточки
 */

public class Characteristics extends GetPageVIAndPrint{//технические характеристики


    private Characteristics() {
        throw new IllegalStateException("Utility class");
    }
    static StringBuilder charact = new StringBuilder("<strong>Технические характеристики:</strong>\n\n");

    public static void CreateCharacteristics() throws IOException {
        Document page = getPagePrint();
        Element tableParameter = page.select("table[class=fs-13]").first();
        if (tableParameter!=null) {
            Elements names = tableParameter.select("tr");
            Elements values = names.select("tr");
            List<String> characters = new ArrayList<>();
            for (Element value : values) {
                String theme = value.select("tr").text();
                characters.add("- " + theme);
            }
            for (int i = 0; i < characters.size(); i++) {
                if (i != characters.size() - 1) {
                    charact.append(characters.get(i)).append(";\n");
                } else {
                    charact.append(characters.get(i)).append(".\n");
                }
            }
            setCharacteristics(charact.toString()+"\n");
        }
    }
}