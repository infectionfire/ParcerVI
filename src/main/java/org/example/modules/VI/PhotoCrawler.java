package org.example.modules.VI;

import org.example.pageProcessing.GetPageVI;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Парсит страницу и берет первое фото товара
 * можно переделать, сделать сплит через " и вытаскивать ссылки через endWith
 */

public class PhotoCrawler extends GetPageVI{

    private static String photo = "";

    public static void setPhoto(String photo) {
        PhotoCrawler.photo = photo;
    }

    public static String getPhoto() throws IOException {
        PhotoUrlsCreate();
        return photo;
    }

    public static void PhotoUrlsCreate() throws IOException {
        Document page = getPage();
        Element imageElement = page.select("div.item").first();
        photo=imageElement.toString().replaceAll("<div class=\"stage\" data-behavior=\"stage\">","")
                .replaceAll("<div class=\"item -active\" data-behavior=\"item\">","")
                .replaceAll("<img src=\"data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7\" data-src=\"","");
        String[] ph = photo.split("\"");
        setPhoto(ph[0].replace(".jpg", "").strip());
        }
}

