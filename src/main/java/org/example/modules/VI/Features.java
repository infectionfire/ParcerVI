package org.example.modules.VI;

import org.example.methods.HtmlToText;
import org.example.pageProcessing.GetPageVI;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import static org.example.methods.StructureCardBuilder.setFeatures;
import static org.example.pageProcessing.GetPageVI.getPage;

/**
 *Формирование начального текста описания товарной карточки
 */

public class Features{

    private Features() {
        throw new IllegalStateException("Utility class");
    }
    //доделать метод

    public static void CreateFeatures()  throws IOException {

        Document page = getPage();
        Element element = page.select("div.content-block").first();
        if (element!=null){
            setFeatures( new StringBuilder(HtmlToText.html2text(element.toString())+"\n\n"));
        }else {
            setFeatures( new StringBuilder("\n\n"));}
        }

}
