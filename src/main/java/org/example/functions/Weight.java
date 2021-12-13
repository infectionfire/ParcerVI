package org.example.functions;

import org.example.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Weight {//вес, первая строка - брутто, остальные перекидываем в габариты

    public static void Weigth() throws IOException {
        Document page = ParserPage.getPage();
        Element tableParameter = page.select("div.fs-13.lh-20.c-gray3").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("b");
        Elements values = names.select("b");
        ParserPage.weight += "<strong>Габаритные размеры:</strong>\n" + "\n";
        List<String> values1 = new ArrayList<String>(4);
        for (Element value : values) {
            String theme = value.select("b").text();
            values1.add(theme);
        }
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                ParserPage.weight += "- Вес брутто: " + values1.get(i) + " кг;\n- Габаритные размеры (ДхШхВ): ";
            } else if (i != 3) {
                ParserPage.weight += values1.get(i) + "x";
            } else {
                ParserPage.weight += values1.get(i);
            }
        }
        ParserPage.weight += " мм.";
        ParserPage.weight += "\n\n";

    }
}