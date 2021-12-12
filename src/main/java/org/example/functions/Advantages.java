package org.example.functions;

import org.example.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Advantages {//особенности

    public static void Advantages() throws IOException {
        Document page = ParserPage.getPage();
        Element tableParameter = page.select("td[id=tab2_content]").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("ul");
        Elements values = names.select("li");
        ParserPage.advantages += "Особенности:\n" + "\n";
        for (Element value : values) {
            String theme = value.select("li").text();
            ParserPage.advantages += "- " + theme + "\n";
        }
        ParserPage.advantages += "\n";
    }
}