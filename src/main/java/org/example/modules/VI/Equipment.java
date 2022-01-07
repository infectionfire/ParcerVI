package org.example.modules.VI;

import org.example.pageProcessing.GetPageVI;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static org.example.methods.StructureCardBuilder.setEquipment;
import static org.example.pageProcessing.GetPageVI.getPage;

/**
 * Формирование поля "Комплектация" для описания товарной карточки
 */

public class Equipment{

    private Equipment() {
        throw new IllegalStateException("Utility class");
    }

    public static void CreateComplectation() throws IOException {
        StringBuilder equipment = new StringBuilder("<strong>Комплектация:</strong>\n\n");
        Document page = getPage();

        Element tableParameter = page.select("div.equipment.spoiler").first();
        if (tableParameter!=null){

            Elements names = tableParameter.select("ul");
            Elements values = names.select("li");

            for (Element value : values) {
                String theme = value.select("li").text();
                equipment.append("- ").append(theme).append(";\n");
                }
            equipment = new StringBuilder(equipment.toString().replace(";;", ";"));

            StringBuilder temp = equipment.replace(equipment.length()-2,equipment.length()-1,".")
                    .append("\n");
            equipment = new StringBuilder(temp.toString()
                    .replace("..", "."));
        }
        setEquipment(equipment);
    }
}