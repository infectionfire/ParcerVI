package org.example.functions;

import org.example.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;


public class PhotoCrawler {
    public static String photo = "";

    public static void PhotoCrawler() throws IOException {
        Document page = ParserPage.getPage();
        Element imageElement = page.select("div.item").first();
        photo+=imageElement;

        photo=photo.replaceAll("<div class=\"stage\" data-behavior=\"stage\">","");
        photo=photo.replaceAll("<div class=\"item -active\" data-behavior=\"item\">","");
        photo=photo.replaceAll("<img src=\"data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7\" data-src=","");
        String[] ph = photo.split("\"");
        photo=ph[1];
        }
}

