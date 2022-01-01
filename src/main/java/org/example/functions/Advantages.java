package org.example.functions;

import org.example.page.GetPageVIAndPrint;
import org.example.page.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static org.example.page.ParserPage.setAdvantages;

/**
 * Формирование поля особенности для описания товарной карточки
 */

public class Advantages extends GetPageVIAndPrint {//особенности

    private Advantages() {
        throw new IllegalStateException("Utility class");
    }

    public static void CreateAdvantages() throws IOException {
        StringBuilder advantagesCreate = new StringBuilder("<strong>Особенности:</strong>\n\n");

        Document page = getPagePrint();//берем ссылку на товар
        Element tableParameter = page.select("td[id=tab2_content]").first();//выбираем поле для парсинга

        if (tableParameter!=null) {//проверка на пустое поле
            Elements names = tableParameter.select("ul");//вытаскиваем инфу из маркированного списка
            Elements values = names.select("li");
            for (Element value : values) {//цикл добавляет значения к строке, попутно форматируя ее
                String theme = value.select("li").text();
                advantagesCreate.append("- ").append(theme).append(";\n");
            }
        }
        if(advantagesCreate.toString().endsWith(".;\n")){
            advantagesCreate = new StringBuilder(advantagesCreate.toString().replace(".;\n", ".\n"));
        }

        setAdvantages(advantagesCreate.append("\n"));
    }
}