package com.saurabhAPIAuto.utils;

// Open the FieInputStream
// Understand the workbook
// Sheet
// Row
// Column
// Cell
// Close the Stream

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilsExcel {

    // It will be used by the DataProvider of the TestNG
    // Object[][]
    public static  String File_Name = "src/test/resources/Book1.xlsx";
    static Workbook book;
    static Sheet sheet;

    public static Object [][] getTestData(String sheetName){
        FileInputStream file = null;
        try {
            file = new FileInputStream(File_Name);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }

        }

        return  data;

    }

    @DataProvider
    public Object[][] getData(){

        // In future can we have written the logic of which sheet i want to open
        // Ask user, which sheet they want to use
        // Data.properties -> sheet1 or sheet 2
        // sheet1 can be the cred of QA
        // sheet2  can be cred of Prod
        return getTestData("Sheet1");
    }


}
