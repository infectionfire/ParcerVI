package org.example.functions;

import org.example.page.GetPageVIAndPrint;
import org.example.page.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Advantages {//особенности

    private Advantages() {
        throw new IllegalStateException("Utility class");
    }

    public static void CreateAdvantages() throws IOException {
        //берем ссылку на товар
        Document page = GetPageVIAndPrint.getPagePrint();
        //выбираем поле для парсинга
        Element tableParameter = page.select("td[id=tab2_content]").first();
        //проверка на пустое поле
        ParserPage.advantages = "<strong>Особенности:</strong>\n\n";
        if (tableParameter!=null) {
            //вытаскиваем инфу из маркированного списка
            Elements names = tableParameter.select("ul");
            Elements values = names.select("li");
            //цикл добавляет значения к строке, попутно форматируя ее
            for (Element value : values) {
                String theme = value.select("li").text();
                ParserPage.advantages += "- " + theme + ";\n";
            }
        }
        ParserPage.advantages = ParserPage.advantages.replace(";;",";");
        if(ParserPage.advantages.endsWith(".;\n"))
        {
            ParserPage.advantages = ParserPage.advantages.replace(".;\n",".\n");
        }
        ParserPage.advantages += "\n";
    }
}