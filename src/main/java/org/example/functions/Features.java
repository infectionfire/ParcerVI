package org.example.functions;

import org.example.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Features {
//доделать метод

    public static void Features()  throws IOException {

        Document page = ParserPage.getPageUnprint();
        Element element = page.select("div.content-block").first();
        if (element!=null){
            //добавить зависимости от других параметров, добавить обработчик
            //обработка выдачи, завернуть в массив для работы с О1 через, хз сколько памяти сожрет
            String strg = element.toString().replace("<div itemprop=\"description\" class=\"content-block\">", "");
            strg = strg.replace("<p style=\"text-align:justify\">","");
            strg = strg.replace("<strong>", "");
            strg = strg.replace("</strong>","");
            strg = strg.replace("</p>","");
            strg = strg.replace("</div>","");
            strg = strg.replace("&nbsp;","");
            strg = strg.replace("<p style=\"text-align: justify;\">","");
            strg = strg.replace("<li style=\"text-align:justify\">","");
            strg = strg.replace("<li style=\"text-align: justify;\">","");
            strg = strg.replace("<p>","");
            strg = strg.replace("<li>","");
            strg = strg.replace("</li>","");
            strg = strg.replace("<ul>","");
            strg = strg.replace("</ul>","");
            strg = strg.replace("\n","");
            ParserPage.features=strg+"\n\n";
        }else {
         ParserPage.features="\n\n";;}
        }

}
