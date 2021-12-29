package org.example.functions;

import org.example.page.GetPageVIAndPrint;
import org.example.page.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Weight {//вес, первая строка - брутто, остальные перекидываем в габариты


    private Weight() {
        throw new IllegalStateException("Utility class");
    }

    public static void CreateWeigth() throws IOException {
        //берем страницу
        Document page = GetPageVIAndPrint.getPagePrint();
        //выбираем поля
        Element tableParameter = page.select("div.fs-13.lh-20.c-gray3").first();
        ParserPage.weight = new StringBuilder("<strong>Габаритные размеры:</strong>\n\n");
        if (tableParameter!=null) {
            //выбираем вложение
            Elements names = tableParameter.select("b");
            Elements values = names.select("b");
            //добавляем
            List<String> values1 = new ArrayList(4);
            for (Element value : values) {
                String theme = value.select("b").text();
                values1.add(theme);
            }
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    ParserPage.weight.append("- Вес брутто: ").append(values1.get(i)).append(" кг;\n- Габаритные размеры (ДхШхВ): ");
                } else if (i != 3) {
                    ParserPage.weight.append(values1.get(i)).append("x");
                } else {
                    ParserPage.weight.append(values1.get(i));
                }
            }
        }
        ParserPage.weight.append(" мм.\n\n");
    }
}