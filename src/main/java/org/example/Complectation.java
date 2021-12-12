package org.example;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Complectation {//комплектация

    public static void Complectation() throws IOException {
        Document page = ParserPage1_1.getPage();
        Element tableParameter = page.select("div.fs-13.c-gray3.complect").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("ul");
        Elements values = names.select("li");
        ParserPage1_1.complectation += "Комплектация:\n" + "\n";
        for (Element value : values) {
            String theme = value.select("li").text();
            ParserPage1_1.complectation += "- " + theme + "\n";
        }
        ParserPage1_1.complectation += "\n";
    }
}