package org.example.page_processing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.example.methods.ReadingFromFile.readUrlsFromTXTFile;

public class GetPageVI {
    
    public static List<Document> getPage() throws IOException {
            List<Document> documentList = new ArrayList<>();
                        //меняем значение для выбора ссылки, отсчет с нуля
            List<String> urls = readUrlsFromTXTFile();
            for (String url: urls) {
                documentList.add(Jsoup.parse(new URL(url), 45000));
            }
            return documentList;
    }
}
