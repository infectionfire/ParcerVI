package org.example;
/*
this file can be added element of the massive to
 */

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.example.ParserPage.CreateMassive;

public class ApachePOIExcelWrite {

    private static final String FILE_NAME = "ParcerFile.xlsx";

    public static void main(String[] args) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("ParcerFile");

        int rowNum = 0;
        System.out.println("Creating excel");
        List<String> crms = CreateMassive();
        int colNum = 0;
        for (int i =0; i< crms.size();i++) {
            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(colNum);
            cell.setCellValue((String) crms.get(i));

            }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}