package org.example.functions;

import org.example.page.GetPageVIAndPrint;
import org.example.page.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static org.example.page.ParserPage.setEquipment;

/**
 * Формирование поля "Комплектация" для описания товарной карточки
 */

public class Equipment extends GetPageVIAndPrint{

    private Equipment() {
        throw new IllegalStateException("Utility class");
    }

    public static void CreateComplectation() throws IOException {
        StringBuilder equipment = new StringBuilder("<strong>Комплектация:</strong>\n\n");
        Document page = getPagePrint();

        Element tableParameter = page.select("div.fs-13.c-gray3.complect").first();
        if (tableParameter!=null){

            Elements names = tableParameter.select("ul");
            Elements values = names.select("li");

            for (Element value : values) {
                String theme = value.select("li").text();
                equipment.append("- ").append(theme).append(";\n");
                }
            equipment = new StringBuilder(equipment.toString().replace(";;", ";"));

            StringBuilder stringBuilder = new StringBuilder(equipment);
            stringBuilder.replace(stringBuilder.length()-2,stringBuilder.length()-1,".");
            equipment = new StringBuilder(stringBuilder + "\n");
            equipment = new StringBuilder(equipment.toString().replace("..", "."));
            }
        setEquipment(equipment);
    }
}