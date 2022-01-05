package org.example.modules.VI;

import org.example.pageProcessing.GetPageVI;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import static org.example.pageProcessing.StructureCardBuilder.setAdvantages;

/**
 * Формирование поля особенности для описания товарной карточки
 */

public class Advantages extends GetPageVI {//особенности

    private Advantages() {
        throw new IllegalStateException("Utility class");
    }

    public static void CreateAdvantages() throws IOException {
        StringBuilder advantagesCreate = new StringBuilder("<strong>Особенности:</strong>\n\n");
        Element element = getPage()
                .select("div.advantages.spoiler")
                .first();
        if (element!=null) {
            Elements names = element.select("ul");//вытаскиваем инфу из маркированного списка
            Elements values = names.select("li");

            for (Element value : values) {//цикл добавляет значения к строке, попутно форматируя ее
                String theme = value.select("li").text();
                advantagesCreate.append("- ").append(theme).append(";\n");
            }
        }
        if (advantagesCreate.toString().endsWith(";\n")){
            advantagesCreate.replace(advantagesCreate.length()-2,advantagesCreate.length()-1,".\n");
        }

        setAdvantages(advantagesCreate);
    }
}