package org.example.functions;

import org.example.page.GetPageVI;
import org.example.page.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;


public class PhotoCrawler extends GetPageVI{
    public static String photo = "";

    public static void PhotoCrawler() throws IOException {
        Document page = getPage();
        Element imageElement = page.select("div.item").first();
        photo=imageElement.toString().replaceAll("<div class=\"stage\" data-behavior=\"stage\">","")
                .replaceAll("<div class=\"item -active\" data-behavior=\"item\">","")
                .replaceAll("<img src=\"data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7\" data-src=\"","");
        String[] ph = photo.split("\"");
        photo= ph[0];
        }
}

