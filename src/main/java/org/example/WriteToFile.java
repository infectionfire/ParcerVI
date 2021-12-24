package org.example;

import java.io.*;

import static ToXls.ToXls.DelimitedToXls;


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
        System.out.println("Done!");
        pw.close();
        DelimitedToXls("testFile.txt");
        }
}



