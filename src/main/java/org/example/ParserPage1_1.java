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
//изменяем count в зависимости от количества ссылок
    public static int count = 3;
    static List<String> ttx = new ArrayList<String>(3);
    static String TTX = "",characterystics ="",advantages="",complectation="",weigth="";

        public static Document getPage() throws IOException {
        //меняем значение для выбора ссылки, отсчет с нуля
        String url = (String) ReadingFromFile.readPrintValue().get(number);
        Document page = Jsoup.parse(new URL(url), 2032);
                return page;
    }
//технические характеристики
    public static void Characterystics()  throws IOException {
        characterystics+= getPage().baseUri()+"\n\n";
        Document page = getPage();
        Element tableParameter = page.select("table[class=fs-13]").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("tr");
        Elements values = names.select("tr");
        characterystics+="Технические характеристики:\n"+"\n";
        for (Element value:values){
            String theme = value.select("tr").text();
            characterystics+="- "+theme+";\n";

        }
        characterystics+="\n";
    }
    //особенности
    public static void Advantages()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("td[id=tab2_content]").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("ul");
        Elements values = names.select("li");
        advantages+="Особенности:\n"+"\n";
        for (Element value:values){
            String theme = value.select("li").text();
            advantages+="- "+theme+"\n";
        }
        advantages+="\n";
    }

    //комплектация
    public static void Complectation()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("div.fs-13.c-gray3.complect").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("ul");
        Elements values = names.select("li");
        complectation+="Комплектация:\n"+"\n";
        for (Element value:values){
            String theme = value.select("li").text();
            complectation+="- "+theme+"\n";
        }
        complectation+="\n";
    }
    //вес, первая строка - брутто, остальные перекидываем в габариты
    public static void Weigth()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("div.fs-13.lh-20.c-gray3").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("b");
        Elements values = names.select("b");
        weigth+="Габаритные размеры:\n"+"\n";
        List<String> values1 = new ArrayList<>(4);
        for (Element value:values){
            String theme = value.select("b").text();
            values1.add(theme);
        }
        for(int i =0; i<4;i++){
            if (i==0){
                weigth+="- Вес брутто: "+ values1.get(i).toString()+" кг;\n- Габаритные размеры (ДхШхВ): ";
            }else if (i!=3){
                weigth+= values1.get(i) +"x";
            }else{
                weigth+= values1.get(i);
            }
        }
        weigth+=" мм.";
        weigth+="\n\n";

    }

    public static List<String> CreateMassive() throws IOException, NullPointerException {
//методы

        for (int i = 0; i < count; i++) {
            try {
                Characterystics();
                Advantages();
                Complectation();
                Weigth();
                TTX=characterystics +advantages+complectation+weigth;
                ttx.add(i, TTX);
                TTX = ""; characterystics ="";advantages="";complectation="";weigth="";
                number++;
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        return ttx;
    }

}
