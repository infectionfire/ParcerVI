package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingFromFile {


    //создаем массив из списка ссылок
    public static List<String> readPrintValue() throws FileNotFoundException {
        File file = new File("test.txt");

        Scanner sc = new Scanner(file);
        List<String > list = new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        sc.close();
        return list;

    }

}
