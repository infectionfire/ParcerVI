package org.example.preversions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;


import java.io.IOException;

public class ParseListing {

    public static Document getPage() throws IOException {
        String url = "";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args)  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("main[class=col-9 main]").first();
        Elements names = tableParameter.select("title");
        Elements values = names.select("href");

        for (Element name:names){
            String theme = name.select("href").text();
            System.out.print(theme+"; \n");
        }



    }
}
