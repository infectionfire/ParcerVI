package org.example.functions;

import org.example.page.GetPageVI;
import org.example.page.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

public class Features extends GetPageVI{

    private Features() {
        throw new IllegalStateException("Utility class");
    }
    //доделать метод

    public static void CreateFeatures()  throws IOException {

        Document page = getPage();
        Element element = page.select("div.content-block").first();
        if (element!=null){
            //добавить зависимости от других параметров, добавить обработчик
            //обработка выдачи, завернуть в массив для работы с О1 через, хз сколько памяти сожрет
            ParserPage.features = new StringBuilder(element.toString()
                    .replace("<div itemprop=\"description\" class=\"content-block\">", " ")
                    .replaceAll("<p style=\"text-align:justify\">"," ")
                    .replaceAll("<p style=\"text-align: justify;\">"," ")
                        .replaceAll("<li style=\"text-align:justify\">"," ")
                        .replaceAll("<li style=\"text-align: justify;\">"," ")
                        .replaceAll("<p style=\"text-align:justify;\">"," ")
                        .replaceAll("<strong>", " ")
                        .replaceAll("</strong>"," ")
                        .replaceAll("</p>"," ")
                        .replaceAll("</br>"," ")
                        .replaceAll("<br>"," ")
                        .replaceAll("</div>"," ")
                        .replaceAll("&nbsp;"," ")
                        .replaceAll("<p>"," ")
                        .replaceAll("<li>"," ")
                        .replaceAll("</li>"," ")
                        .replaceAll("<ul>"," ")
                        .replaceAll("</ul>"," ")
                        .replaceAll("\n"," "));
            List<String > str = List.of(ParserPage.features.toString().split("<"));
            ParserPage.features = new StringBuilder(str.get(0).replace("  "," ").replace("  "," ")).append("\n\n");
        }else {
         ParserPage.features= new StringBuilder("\n\n");}
        }

}
