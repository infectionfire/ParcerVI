package org.example.functions;

import org.example.page.GetPageVI;
import org.example.page.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

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
                    .replace("<div itemprop=\"description\" class=\"content-block\">", "")
                    .replaceAll("<p style=\"text-align:justify\">","")
                    .replaceAll("<p style=\"text-align: justify;\">","")
                        .replaceAll("<li style=\"text-align:justify\">","")
                        .replaceAll("<li style=\"text-align: justify;\">","")
                        .replaceAll("<p style=\"text-align:justify;\">","")
                        .replaceAll("<strong>", "")
                        .replaceAll("</strong>","")
                        .replaceAll("</p>","")
                        .replaceAll("</div>","")
                        .replaceAll("&nbsp;","")
                        .replaceAll("<p>","")
                        .replaceAll("<li>","")
                        .replaceAll("</li>","")
                        .replaceAll("<ul>","")
                        .replaceAll("</ul>","")
                        .replaceAll("\n","")+"\n\n");
        }else {
         ParserPage.features= new StringBuilder("\n\n");}
        }

}
