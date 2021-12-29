package org.example;
/*
this file can be added element of the massive to
 */

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.page.ParserPage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.example.page.ParserPage.*;

public class ApachePOIExcelWrite {

    private static final String FILE_NAME = "ParserFile.xlsx";

    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("ParserFile");

        int rowNum = 0;//счетчик строк
        int colNum = 0;//фиксируем столбец для вывода
        int index = 0;
        List<String> createMassiveForXLSX = CreateMassive();
        for (String crm : createMassiveForXLSX) {//цикл создания параметризированного списка
            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(colNum);
            Cell cellPhoto = row.createCell(colNum+1);
            cell.setCellValue(crm);
            cellPhoto.setCellValue(ParserPage.photos.get(index++).replace("68x60", "800x800"));
        }

        FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
        workbook.write(outputStream);
//        logger.info("Это информационное сообщение!");

        outputStream.close();
        workbook.close();
    }
}