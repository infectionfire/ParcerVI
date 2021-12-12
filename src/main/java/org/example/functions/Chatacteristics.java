package org.example.functions;

import org.example.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Chatacteristics {//технические характеристики

    public static void Characterystics() throws IOException {
        ParserPage.characterystics += ParserPage.getPage().baseUri() + "\n\n";
        Document page = ParserPage.getPage();
        Element tableParameter = page.select("table[class=fs-13]").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("tr");
        Elements values = names.select("tr");
        ParserPage.characterystics += "Технические характеристики:\n" + "\n";
        List<String> characters = new ArrayList<>();
        for (Element value : values) {
            String theme = value.select("tr").text();
            characters.add("- " + theme);
        }
        for (int i = 0; i < characters.size(); i++) {
            if (i != characters.size()-1) {
                ParserPage.characterystics += characters.get(i) + ";";
            } else {
                ParserPage.characterystics += characters.get(i) + ".\n";
            }
            ParserPage.characterystics += "\n";
        }
    }
}