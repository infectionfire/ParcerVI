package org.example;

import TestPackage.ToXls.ToXls;

import java.io.*;


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
        ToXls.DelimitedToXls("testFile.txt");
        }
}



