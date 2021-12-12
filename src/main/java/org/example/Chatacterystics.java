package org.example;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Chatacterystics {//технические характеристики

    public static void Characterystics() throws IOException {
        ParserPage1_1.characterystics += ParserPage1_1.getPage().baseUri() + "\n\n";
        Document page = ParserPage1_1.getPage();
        Element tableParameter = page.select("table[class=fs-13]").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("tr");
        Elements values = names.select("tr");
        ParserPage1_1.characterystics += "Технические характеристики:\n" + "\n";
        for (Element value : values) {
            String theme = value.select("tr").text();
            ParserPage1_1.characterystics += "- " + theme + ";\n";

        }
        ParserPage1_1.characterystics += "\n";
    }
}