package org.example;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.example.config.ParcerPageConfiguration.ttxInformationCollector;

/**
 * Записывает информацию о товаре в текстовый файл testFile.txt
 * актуально для единичной выборки
 */

public class WriteToFile {

    static File file = new File("testFile.txt");
    static PrintWriter pw;

    static {
        try {
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        pw.println(ttxInformationCollector());
        pw.println("Successfully!");
        pw.close();

        }
}



