package org.example.methods;


import org.example.page.ParserPage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
        pw.println(ParserPage.CreateMassive());
        pw.println("Successful!");
        pw.close();
        }
}



