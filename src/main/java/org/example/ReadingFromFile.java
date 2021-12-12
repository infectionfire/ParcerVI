package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingFromFile {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("test.txt");

        Scanner sc = new Scanner(file);
        List<String> words = new ArrayList<>();
        while (sc.hasNextLine()){
            words.add(sc.nextLine());
        }
        System.out.println(words.toString());
    }
}
