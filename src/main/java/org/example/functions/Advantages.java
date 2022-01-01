package org.example.functions;

import org.example.page.GetPageVIAndPrint;
import org.example.page.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Формирование поля особенности для описания товарной карточки
 */

public class Advantages extends GetPageVIAndPrint {//особенности

    private Advantages() {
        throw new IllegalStateException("Utility class");
    }

    public static void CreateAdvantages() throws IOException {

        Document page = getPagePrint();//берем ссылку на товар
        Element tableParameter = page.select("td[id=tab2_content]").first();//выбираем поле для парсинга
        ParserPage.advantages = new StringBuilder("<strong>Особенности:</strong>\n\n");
        if (tableParameter!=null) {//проверка на пустое поле
            Elements names = tableParameter.select("ul");//вытаскиваем инфу из маркированного списка
            Elements values = names.select("li");
            for (Element value : values) {//цикл добавляет значения к строке, попутно форматируя ее
                String theme = value.select("li").text();
                ParserPage.advantages.append("- ").append(theme).append(";\n");
            }
        }
        ParserPage.advantages = new StringBuilder(ParserPage.advantages.toString().replace(";;", ";"));
        if(ParserPage.advantages.toString().endsWith(".;\n"))
        {
            ParserPage.advantages = new StringBuilder(ParserPage.advantages.toString().replace(".;\n", ".\n"));
        }
        ParserPage.advantages.append("\n");
    }
}