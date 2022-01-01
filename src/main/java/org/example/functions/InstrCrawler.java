package org.example.functions;

import org.example.page.GetPageVI;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;


public class InstrCrawler extends GetPageVI{
    public static String instr = "";

    public static void InstrCrawler() throws IOException {
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

