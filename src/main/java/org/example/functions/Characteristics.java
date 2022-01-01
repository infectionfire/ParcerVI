package org.example.functions;

import org.example.page.GetPageVIAndPrint;
import org.example.page.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Формирование поля "технические характеристики" для описания товарной карточки
 */

public class Characteristics extends GetPageVIAndPrint{//технические характеристики


    private Characteristics() {
        throw new IllegalStateException("Utility class");
    }

    public static void CreateCharacteristics() throws IOException {
        Document page = getPagePrint();
        Element tableParameter = page.select("table[class=fs-13]").first();
        ParserPage.characteristics = new StringBuilder("<strong>Технические характеристики:</strong>\n\n");
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
                    ParserPage.characteristics.append(characters.get(i)).append(";\n");
                } else {
                    ParserPage.characteristics.append(characters.get(i)).append(".\n");
                }

            }
            ParserPage.characteristics.append("\n");
        }
    }
}