package org.example;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import static org.example.config.StructureCardBuilder.BuildDescription;
import static org.example.config.StructureCardBuilder.getTtx;

/**
 * Записывает информацию о товаре в текстовый файл testFile.txt
 * актуально для единичной выборки
 */

public class WriteToFile {


    static File file = new File("testFile.txt");

    public static void main(String[] args) throws IOException {
        try(PrintWriter pw = new PrintWriter(file)) {
            BuildDescription();
            pw.println(getTtx());
            pw.println("Successfully!");
        }
    }
}



