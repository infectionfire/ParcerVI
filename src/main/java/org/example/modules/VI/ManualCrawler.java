package org.example.modules.VI;

import org.example.pageProcessing.GetPageVI;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import static org.example.pageProcessing.GetPageVI.getPage;

/**
 * Парсит страницу и берет ссылку на инструкцию если она есть
 * в случае отсутствия инструкции в формате PDF возвращает пустую строку для заполнения ячейки в эксель
 */

public class ManualCrawler{
    private static String instr = "";

    public static void setInstr(String instr) {
        ManualCrawler.instr = instr;
    }

    public static String getManual() throws IOException {
        CreateInstrUrl();
        return instr;
    }

    public static void CreateInstrUrl() throws IOException {
        setInstr("");
        Document page = getPage();
        Element imageElement = page.select("ul.unordered-list.-links.spoiler.-download").first();
        if (imageElement != null) {
            instr = imageElement.toString();
            String[] ins = instr.split("href=\"//");
            ins = ins[1].split("\"");
            setInstr(ins[0]);
            if (!instr.endsWith(".pdf")) {
                setInstr("");
            }
        }
    }
}





