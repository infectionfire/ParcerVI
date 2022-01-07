package org.example.methods;

import java.util.List;

public class StringCharacterFormatter {

    public static StringBuilder charactFormatter(String text, String valueInf){
        StringBuilder characters = new StringBuilder();
        if(text.equals("")) {
        }else {
            List<String> stringList = List.of(text.split(", "));
            if (stringList.size() > 1) {//конструктор строки
                characters.append("- ")
                        .append(stringList.get(0))
                        .append(": ")
                        .append(valueInf)
                        .append(" ")
                        .append(stringList.get(1))
                        .append(";\n");
            }else {
                characters.append("- ")
                        .append(text).append(": ")
                        .append(valueInf)
                        .append(";\n");
            }
        }
        return characters;
    }
}