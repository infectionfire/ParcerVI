package org.example.methods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingFromFile {

    //создаем массив из списка ссылок
    public static List<String> readUrlsFromTXTFile() throws IOException {
        FileReader urls = new FileReader("test.txt");
        BufferedReader input = new BufferedReader(urls);
        List<String > list = new ArrayList<>();
        String line;
        while ((line = input.readLine())!= null) {
            list.add(line);
        }
        urls.close();
        input.close();
        return list;
    }

}
