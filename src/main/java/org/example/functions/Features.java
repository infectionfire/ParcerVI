package org.example.functions;

import org.example.methods.HtmlToText;
import org.example.page.GetPageVI;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

import static org.example.page.ParserPage.setFeatures;

/**
 *
 */

public class Features extends GetPageVI{

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
