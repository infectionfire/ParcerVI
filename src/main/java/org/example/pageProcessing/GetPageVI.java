package org.example.pageProcessing;

import org.example.config.ParcerPageConfiguration;
import org.example.methods.ReadingFromFile;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class GetPageVI {
    public static Document getPage() throws IOException {
            //меняем значение для выбора ссылки, отсчет с нуля
            String url = ReadingFromFile
                    .readPrintValue()
                    .get(ParcerPageConfiguration.getNumber());
            return Jsoup.parse(new URL(url), 45000);
        }
}
