// This is one way of working on Excel Files (Not recommended)
    // align with "ExcelUtils" in "utils" folder

package _TestNotes.hybrid_driven_framework.POM.java;

import _TestNotes.hybrid_driven_framework.POM.pages.ToolTipPageFactory;
import _TestNotes.hybrid_driven_framework.POM.utils.LoadProperties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelJava extends BaseTest {

    // test example
    @Test
    public void testToolTip() throws IOException {
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/tooltip.html");
        ToolTipPageFactory toolTipPageFactory = new ToolTipPageFactory(driver);
        toolTipPageFactory.login("testing");
    }

// in Main importing the Excel table
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\IntelliJ\\_Projects\\GenSparkMavenUI\\src\\test\\java\\_TestNotes\\hybrid_driven_framework\\POM\\_notes\\_Excel\\test1.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(0);

    // getting all the rows and columns
        for(int i = 0; i <= sheet.getLastRowNum(); i++){
            row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum() ; j++) {
                Cell cell = row.getCell(j);
                System.out.println(cell);
            }
        }

    // getting "Column 1"
//        Cell cell = row.getCell(0);
//        System.out.println(cell);
    }
}
