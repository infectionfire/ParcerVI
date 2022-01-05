package org.example;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static org.example.config.ParcerPageConfiguration.InformationCollector;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        pw.println(InformationCollector());
        pw.println("Successful!");
        pw.close();

        }
}



