package org.example.functions;

import org.example.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class GetAdvantages {//особенности

    public static void Advantages() throws IOException {
        //берем ссылку на товар
        Document page = ParserPage.getPage();
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