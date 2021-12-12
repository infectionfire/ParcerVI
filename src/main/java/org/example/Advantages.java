package org.example;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Advantages {//особенности

    public static void Advantages() throws IOException {
        Document page = ParserPage1_1.getPage();
        Element tableParameter = page.select("td[id=tab2_content]").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("ul");
        Elements values = names.select("li");
        ParserPage1_1.advantages += "Особенности:\n" + "\n";
        for (Element value : values) {
            String theme = value.select("li").text();
            ParserPage1_1.advantages += "- " + theme + "\n";
        }
        ParserPage1_1.advantages += "\n";
    }
}