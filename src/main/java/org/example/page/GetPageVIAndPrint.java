package org.example.page;

import org.example.methods.ReadingFromFile;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 * Берет ссылку на товар из файла test.txt и прикрепляет к ней
 * /print/ для упрощения выборки по полям
 */

public class GetPageVIAndPrint {
    public static Document getPagePrint() throws IOException {
    //меняем значение для выбора ссылки, отсчет с нуля
    String url = ReadingFromFile
            .readPrintValue()
            .get(ParserPage.number)+"/print/";
    return Jsoup.parse(new URL(url), 2000);
}
}
