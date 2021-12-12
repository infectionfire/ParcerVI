package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class ParserPage1 {

public static int number = 0;

        public static Document getPage() throws IOException {
        //меняем значение для выбора ссылки, отсчет с нуля
        String url = (String) ReadingFromFile.readPrintValue().get(number);
        Document page = Jsoup.parse(new URL(url), 5000);
        return page;
    }

    public static Document getPageUnprint() throws IOException {
        //меняем значение для выбора ссылки, отсчет с нуля
        String url = (String) ReadingFromFile.readPrintValue().get(number);
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
            System.out.print("- "+theme+";\n");

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
            System.out.print("- "+theme+"\n");
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
            System.out.print("- "+theme+"\n");
        }
        System.out.println("\n");
    }

    public static void weigth()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("div.fs-13.lh-20.c-gray3").first();
        Elements names = tableParameter.select("b");
        Elements values = names.select("b");
        System.out.println("Габаритные размеры:\n");
        for (Element value:values){
            String theme = value.select("b").text();
            System.out.print("- Вес брутто: "+theme+" кг;\n");
        }
        //кривые габариты, последние 3 строчки перенести
        System.out.println("- Габаритные размеры (ДхШхВ): мм.");
    }

    public static void main(String[] args) throws IOException, NullPointerException {
//методы
        characterystics();
        advantages();
        complectation();
        weigth() ;
    }
}
