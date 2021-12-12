package org.example.functions;

import org.example.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Chatacterystics {//технические характеристики

    public static void Characterystics() throws IOException {
        ParserPage.characterystics += ParserPage.getPage().baseUri() + "\n\n";
        Document page = ParserPage.getPage();
        Element tableParameter = page.select("table[class=fs-13]").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("tr");
        Elements values = names.select("tr");
        ParserPage.characterystics += "Технические характеристики:\n" + "\n";
        for (Element value : values) {
            String theme = value.select("tr").text();
            ParserPage.characterystics += "- " + theme + ";\n";

        }
        ParserPage.characterystics += "\n";
    }
}