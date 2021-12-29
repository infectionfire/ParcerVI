package org.example.page;

import org.example.methods.ReadingFromFile;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class GetPageVI {
    public static Document getPage() throws IOException {
            //меняем значение для выбора ссылки, отсчет с нуля
            String url = ReadingFromFile.readPrintValue().get(ParserPage.number);
            ParserPage.URLS = url+"\n\n";
            return Jsoup.parse(new URL(url), 2000);
        }
}
