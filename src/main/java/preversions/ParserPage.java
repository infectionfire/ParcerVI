package preversions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;


import java.io.IOException;

public class ParserPage {

    public static Document getPage() throws IOException {
        String url = "https://novgorod.vseinstrumenti.ru/instrument/shurupoverty/akkumulyatornye-dreli/bezudarnye/daewoo/shurupovert-daa-1220-li/print";
        Document page = Jsoup.parse(new URL(url), 5000);
        return page;
    }

    public static void characterystics()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("table[class=fs-13]").first();
        Elements names = tableParameter.select("tr");
        Elements values = names.select("tr");
        System.out.println("Технические характеристики:\n");
        for (Element value:values){
            String theme = value.select("tr").text();
            System.out.print(theme+";\n");

        }
        System.out.println("\n");
    }

    public static void advantages()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("td[id=tab2_content]").first();
        Elements names = tableParameter.select("ul");
        Elements values = names.select("li");
        System.out.println("Особенности:\n");
        for (Element value:values){
            String theme = value.select("li").text();
            System.out.print(theme+"; \n");
        }
        System.out.println("\n");
    }


    public static void complectation()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("div.fs-13.c-gray3.complect").first();
        Elements names = tableParameter.select("ul");
        Elements values = names.select("li");
        System.out.println("Комплектация:\n");
        for (Element value:values){
            String theme = value.select("li").text();
            System.out.print(theme+"; \n");
        }
    }

    public static void main(String[] args) throws IOException {
        characterystics();
        advantages();
        complectation();
    }
}
