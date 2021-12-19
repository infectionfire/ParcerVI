package org.example.functions;

import org.example.ParserPage;
import org.example.ReadingFromFile;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import static org.example.ParserPage.number;
import static org.example.preversions.ParseListing.getPage;

public class Features {
//доделать метод

    public static void Features()  throws IOException {

        Document page = ParserPage.getPageUnprint();
        String str = "";
        Element element = page.select("div.content-block").first();
        if (element!=null){
//        str+=element; previous version, not work with 2+ strings
//        String[] string = str.split(">");
//        str=string[2];
//        String[] string1 = str.split("<");
//        ParserPage.features=string1[0]+"\n\n";
            String strg = element.toString().replace("<div itemprop=\"description\" class=\"content-block\">", "");
            strg = strg.replace("<p style=\"text-align:justify\">","");
            strg = strg.replace("<strong>", "");
            strg = strg.replace("</strong>","");
            strg = strg.replace("</p>","");
            ParserPage.features=strg+"\n";
        }else {
         ParserPage.features="\n\n";;}
        }

}
