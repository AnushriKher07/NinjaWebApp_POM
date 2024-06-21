package com.ninja.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
    private static final String Login = null;

	public static String generateTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return now.format(formatter);
    }

    public static String generateEmailWithTimestamp(String prefix, String suffix) {
        String timestamp = generateTimestamp();
        return "usertest00" +timestamp+"@gmail.com";

}
    
    private static XSSFWorkbook workbook;

    public static void openExcelFile(String filePath) {
        try {
            FileInputStream input = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object[][] getTestData(String sheetName) {
        XSSFSheet sheet = workbook.getSheet(sheetName);

        // Verify that the sheet exists before attempting to read data
        if (sheet == null) {
            throw new RuntimeException("Sheet not found: " + sheetName);
        }

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j).toString();
            }
        }

        return data;
    }

    public static void closeExcelFile() {
        // Close the workbook or perform any cleanup if needed
        try {
            if (workbook != null) {
                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}