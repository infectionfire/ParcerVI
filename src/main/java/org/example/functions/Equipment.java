package org.example.functions;

import org.example.page.GetPageVIAndPrint;
import org.example.page.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Формирование поля "Комплектация" для описания товарной карточки
 */

public class Equipment extends GetPageVIAndPrint{

    private Equipment() {
        throw new IllegalStateException("Utility class");
    }

    public static void CreateComplectation() throws IOException {

        Document page = getPagePrint();

        Element tableParameter = page.select("div.fs-13.c-gray3.complect").first();
        if (tableParameter!=null){
            ParserPage.equipment = new StringBuilder("<strong>Комплектация:</strong>\n\n");
            Elements names = tableParameter.select("ul");
            Elements values = names.select("li");

            for (Element value : values) {
                String theme = value.select("li").text();
                ParserPage.equipment.append("- ").append(theme).append(";\n");
                }
            ParserPage.equipment = new StringBuilder(ParserPage.equipment.toString().replace(";;", ";"));

            StringBuilder stringBuilder = new StringBuilder(ParserPage.equipment);
            stringBuilder.replace(stringBuilder.length()-2,stringBuilder.length()-1,".");
            ParserPage.equipment = new StringBuilder(stringBuilder + "\n");
            ParserPage.equipment = new StringBuilder(ParserPage.equipment.toString().replace("..", "."));
            }else{
            ParserPage.equipment = new StringBuilder("<strong>Комплектация:</strong>\n\n\n");
        }
    }
}