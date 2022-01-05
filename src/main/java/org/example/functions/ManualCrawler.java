package org.example.functions;

import org.example.page.GetPageVI;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Парсит страницу и берет ссылку на инструкцию если она есть
 * в случае отсутствия инструкции в формате PDF возвращает пустую строку для заполнения ячейки в эксель
 */

public class ManualCrawler extends GetPageVI{
    private static String instr = "";

    public static String getManual() {
        return instr;
    }

    public static void CreateInstrUrl() throws IOException {
        Document page = getPage();
        Element imageElement = page.select("ul.unordered-list.-links.spoiler.-download").first();
        instr=imageElement.toString();
        String[] ins = instr.split("href=\"//");
        ins=ins[1].split("\"");
        instr=ins[0];
        if (!instr.endsWith(".pdf")){
            instr="";
        }
        }
}

