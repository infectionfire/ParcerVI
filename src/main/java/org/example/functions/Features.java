package org.example.functions;

import org.example.ParserPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import static org.example.preversions.ParseListing.getPage;

public class Features {
//доделать метод
    public static String  features="";


    public static void Features()  throws IOException {

        Document page = ParserPage.getPageUnprint();
        String str = "";
        Element element = page.select("div.content-block").first();
        str+=element;
        String[] string = str.split(">");
        str=string[2];
        String[] string1 = str.split("<");
        features=string1[0]+"\n\n";
        }

}
