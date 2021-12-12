package org.example.functions;

import org.example.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Complectation {//комплектация

    public static void Complectation() throws IOException {
        Document page = ParserPage.getPage();
        Element tableParameter = page.select("div.fs-13.c-gray3.complect").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("ul");
        Elements values = names.select("li");
        ParserPage.complectation += "Комплектация:\n" + "\n";
        for (Element value : values) {
            String theme = value.select("li").text();
            ParserPage.complectation += "- " + theme + "\n";
        }
        ParserPage.complectation += "\n";
    }
}