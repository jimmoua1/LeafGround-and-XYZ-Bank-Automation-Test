// two ways to do this
    // 1st Way => single method (harder way)
    // 2nd Way => multiple method (simple way)

// Example Excel Table at "Excel" folder

package _TestNotes.hybrid_driven_framework.POM.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {
    // 2nd Way of Excel (not a single method)
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;


    // 1st Way of Excel (single method)
                    // Map<String, Map<String, String>> variableName
    public static Map<String, Map<String, String>> readExcel() throws IOException {
        //<testName>, <ColHeader>, <ColValue>
        // to loop other sheet
            // <sheet, <testName, <ColHeader, ColValue>>>
            // IF NOT DOING Excel, and doing CSV files
                // <testName,List<String>>
        Map<String, Map<String, String>> fileData = new HashMap<>();
        File file = new File("D:\\IntelliJ\\_Projects\\GenSparkMavenUI\\src\\test\\java\\_TestNotes\\hybrid_driven_framework\\POM\\_notes\\_Excel\\test1.xlsx");
            // whenever read something use "FileInputStream" input into Java
            // whenever set/change something use  "FileOutputStream" in line 114
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        XSSFRow headers = sheet.getRow(0);          // headers

        // to loop other sheet will put here
//            XSSFSheet sheet = wb.getSheetAt(0);   // will delete line 27
//            for (int i = 0; i < ; i++) {
//                // sheets code here
//            }

        // getting all the rows and columns
        for(int i = 1; i <= sheet.getLastRowNum(); i++){       // iterate to "int i = 1" since 0 column is "testName"
            XSSFRow row = sheet.getRow(i);
            // can create cell here
                //  row.createCell();
            Map<String, String> colMap = new HashMap<>();      // map variable "colMap"
            for (int j = 1; j < row.getLastCellNum() ; j++) {  // iterate to "int i = 1" since 0 column is testName is "toolTip"
                // map.put(header<key>, header<value>)
                colMap.put(headers.getCell(j).toString(), row.getCell(j).toString());    // replace all the key, value
                // IF created a Cell
                    // Cell cell = row.getCell(0); // 0 is column
                    // cell.setCellValue("type value here");
            }
            fileData.put(row.getCell(0).toString(), colMap);  // replace row to text, in the hashMap
        }

        // can debug with "Evaluate" by
            // Row of TestName which is "ToolTip"
                // Map<String, String> data = fileData.get("ToolTip");
            // Column of "Username" or "Password"
                // data.get("Username");
                // data.get("Password");


        return fileData; // return the Map variable name "fileData"
    }

    // 2nd Way of Excel (not a single method)
    public void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        // create an object of File class to open xls file
        File file = new File(excelFilePath);
        // create an object of FileInputStream class to read Excel file
        FileInputStream inputStream = new FileInputStream(file);
        // creating workbook instance that refers to .xls file
        workbook = new XSSFWorkbook(inputStream);
        // creating a Sheet object
        sheet = workbook.getSheetAt(Integer.parseInt(sheetName));
            // OR same code as ---> "sheet = workbook.getSheetAt(sheetName)"
    }


    // 2nd Way of Excel (not a single method)
        // get the cell based on row and cell number
    public String getCellData(int rowNumber, int cellNumber){
        // getting the cell value from rowNumber and cellNumber
        cell = sheet.getRow(rowNumber).getCell(cellNumber);

        return cell.getStringCellValue();
    }


    // 2nd Way of Excel (not a single method)
        // get how many rows in sheet
    public int getRowCountInSheet() {
        int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        return rowcount;
    }


    // 2nd Way of Excel (not a single method)
        // setting the cell value
    public void setCellValue(int rowNum, int cellNum, String cellValue, String excelFilePath) throws IOException {
        // getting the cell value from rowNumber and cellNumber
        sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);
        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

}
