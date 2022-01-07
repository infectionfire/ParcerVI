package org.example.modules.VI;

import org.example.pageProcessing.GetPageVI;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import static org.example.methods.StructureCardBuilder.setAdvantages;
import static org.example.pageProcessing.GetPageVI.getPage;

/**
 * Формирование поля особенности для описания товарной карточки
 */

public class Advantages{//особенности

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
        if (advantagesCreate.toString().endsWith(".;\n") || advantagesCreate.toString().endsWith(";\n")){
            advantagesCreate.replace(advantagesCreate.length()-3,advantagesCreate.length()-1,".\n");
        }
        setAdvantages(advantagesCreate);
    }
}