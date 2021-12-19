package preversions;

import org.example.ReadingFromFile;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class ParserPage1_0 {

public static int number = 0;
    public static String TTX = "";

        public static Document getPage() throws IOException {
        //меняем значение для выбора ссылки, отсчет с нуля
        String url = (String) ReadingFromFile.readPrintValue().get(number);
        Document page = Jsoup.parse(new URL(url), 5000);
        return page;
    }
//технические характеристики
    public static void characterystics()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("table[class=fs-13]").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("tr");
        Elements values = names.select("tr");
        System.out.println("Технические характеристики:\n");
        for (Element value:values){
            String theme = value.select("tr").text();
            System.out.print("- "+theme+";\n");

        }
        System.out.println("\n");
    }
    //особенности
    public static void advantages()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("td[id=tab2_content]").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("ul");
        Elements values = names.select("li");
        System.out.println("Особенности:\n");
        for (Element value:values){
            String theme = value.select("li").text();
            System.out.print("- "+theme+"\n");
        }
        System.out.println("\n");
    }

    //комплектация
    public static void complectation()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("div.fs-13.c-gray3.complect").first();
        assert tableParameter != null;
        Elements names = tableParameter.select("ul");
        Elements values = names.select("li");
        System.out.println("Комплектация:\n");
        for (Element value:values){
            String theme = value.select("li").text();
            System.out.print("- "+theme+"\n");
        }
        System.out.println("\n");
    }
    //вес, первая строка - брутто, остальные перекидываем в габариты
    public static void weigth()  throws IOException {
        Document page = getPage();
        Element tableParameter = page.select("div.fs-13.lh-20.c-gray3").first();
        assert tableParameter != null;
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
