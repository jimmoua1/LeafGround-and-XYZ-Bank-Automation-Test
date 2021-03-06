package Assignments._LeafGroundWebsite.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {
    public static Map<String, Map<String, String>> readExcel() throws IOException {
        // <testName,<colHeaders,colValues>>
        Map<String, Map<String,String>> fileData = new HashMap<>();
        File file = new File("D:\\IntelliJ\\_Projects\\GenSparkMavenUI\\src\\test\\java\\Assignments\\_LeafGroundWebsite\\LeafGround.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        XSSFRow headers = sheet.getRow(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            Map<String,String> colMap = new HashMap<>();
            for (int j = 0; j < row.getLastCellNum(); j++) {
                colMap.put(headers.getCell(j).toString(), row.getCell(j).toString());
            }
            fileData.put(row.getCell(0).toString(), colMap);
        }
        return fileData;
    }
}
