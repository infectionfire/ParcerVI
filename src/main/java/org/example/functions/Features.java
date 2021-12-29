package org.example.functions;

import org.example.page.GetPageVI;
import org.example.page.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Features {

    private Features() {
        throw new IllegalStateException("Utility class");
    }
    //доделать метод

    public static void CreateFeatures()  throws IOException {

        Document page = GetPageVI.getPage();
        Element element = page.select("div.content-block").first();
        if (element!=null){
            //добавить зависимости от других параметров, добавить обработчик
            //обработка выдачи, завернуть в массив для работы с О1 через, хз сколько памяти сожрет
            String strg = element.toString().replace("<div itemprop=\"description\" class=\"content-block\">", "");
            strg = strg.replaceAll("<p style=\"text-align:justify\">","");
            strg = strg.replaceAll("<p style=\"text-align: justify;\">","");
            strg = strg.replaceAll("<li style=\"text-align:justify\">","");
            strg = strg.replaceAll("<li style=\"text-align: justify;\">","");
            strg = strg.replaceAll("<p style=\"text-align:justify;\">","");
            strg = strg.replaceAll("<strong>", "");
            strg = strg.replaceAll("</strong>","");
            strg = strg.replaceAll("</p>","");
            strg = strg.replaceAll("</div>","");
            strg = strg.replaceAll("&nbsp;","");
            strg = strg.replaceAll("<p>","");
            strg = strg.replaceAll("<li>","");
            strg = strg.replaceAll("</li>","");
            strg = strg.replaceAll("<ul>","");
            strg = strg.replaceAll("</ul>","");
            strg = strg.replaceAll("\n","");

            ParserPage.features=strg.strip()+"\n\n";
        }else {
         ParserPage.features="\n\n";}
        }

}
