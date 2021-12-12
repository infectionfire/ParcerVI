package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import static org.example.ParserPage1_1.ttx;


public class WriteToFile {

    static File file = new File("testFile.txt");
    static PrintWriter pw;

    static {
        try {
            pw = new PrintWriter(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        pw.println(ParserPage1_1.CreateMassive());
//        pw.println(ttx);
        pw.println("Done!");
        pw.close();
        System.out.println(ttx);
    }



}



