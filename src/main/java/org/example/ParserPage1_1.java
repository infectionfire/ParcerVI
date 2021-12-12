package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParserPage1_1 {

public static int number = 0;
    public static int count = 100;
    static List<String> ttx = new ArrayList<String>(100);
    static String TTX = "";

        public static Document getPage() throws IOException {
        //меняем значение для выбора ссылки, отсчет с нуля
        String url = (String) ReadingFromFile.readPrintValue().get(number);
        Document page = Jsoup.parse(new URL(url), 5000);
                return page;
    }
//технические характеристики
    public static void characterystics()  throws IOException {
        TTX+= getPage().baseUri()+"\n\n";
        Document page = getPage();
        Element tableParameter = page.select("table[class=fs-13]").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("tr");
        Elements values = names.select("tr");
        TTX+="Технические характеристики:\n"+"\n";
        for (Element value:values){
            String theme = value.select("tr").text();
            TTX+="- "+theme+";\n";

        }
        TTX+="\n";
    }
    //особенности
    public static void advantages()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("td[id=tab2_content]").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("ul");
        Elements values = names.select("li");
        TTX+="Особенности:\n"+"\n";
        for (Element value:values){
            String theme = value.select("li").text();
            TTX+="- "+theme+"\n";
        }
        TTX+="\n";
    }

    //комплектация
    public static void complectation()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("div.fs-13.c-gray3.complect").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("ul");
        Elements values = names.select("li");
        TTX+="Комплектация:\n"+"\n";
        for (Element value:values){
            String theme = value.select("li").text();
            TTX+="- "+theme+"\n";
        }
        TTX+="\n";
    }
    //вес, первая строка - брутто, остальные перекидываем в габариты
    public static void weigth()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("div.fs-13.lh-20.c-gray3").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("b");
        Elements values = names.select("b");
        TTX+="Габаритные размеры:\n"+"\n";
        for (Element value:values){

            String theme = value.select("b").text();
            TTX+="- Вес брутто: "+theme+" кг;\n";
        }
        //кривые габариты, последние 3 строчки перенести
        TTX+="- Габаритные размеры (ДхШхВ): мм.";
        TTX+="\n\n";

    }

    public static void main(String[] args) throws IOException, NullPointerException {
//методы

        for (int i = 0; i<count; i++){
            try{
            characterystics();
            advantages();
            complectation();
            weigth();
            ttx.add(i, TTX);
            TTX="";
            number++;}
            catch (Exception e){
                System.out.println(e);
            }
        }
        System.out.println(ttx.toString());
    }
}
