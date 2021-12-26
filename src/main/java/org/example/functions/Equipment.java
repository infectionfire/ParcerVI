package org.example.functions;

import org.example.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Equipment {//комплектация


    private Equipment() {
        throw new IllegalStateException("Utility class");
    }

    public static void CreateComplectation() throws IOException {

        Document page = ParserPage.getPagePrint();

        Element tableParameter = page.select("div.fs-13.c-gray3.complect").first();
        if (tableParameter!=null){
            ParserPage.equipment = "<strong>Комплектация:</strong>\n\n";
            Elements names = tableParameter.select("ul");
            Elements values = names.select("li");

            for (Element value : values) {
                String theme = value.select("li").text();
                ParserPage.equipment += "- " + theme + ";\n";
                }
            ParserPage.equipment = ParserPage.equipment.replace(";;",";");

            StringBuilder stringBuilder = new StringBuilder(ParserPage.equipment);
            stringBuilder.replace(stringBuilder.length()-2,stringBuilder.length()-1,".");
            ParserPage.equipment = stringBuilder+"\n";
            ParserPage.equipment = ParserPage.equipment.replace("..",".");
            }else{
            ParserPage.equipment = "<strong>Комплектация:</strong>\n\n\n";
        }
    }
}