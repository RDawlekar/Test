package FunctionalLibrary;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class dataDriven
{
    @DataProvider(name="getdata")
    public Object[][] getdata() throws IOException {
    Object[][] data= readExcelData("C:\\Users\\rkuma\\IdeaProjects\\Test\\TestData\\HomePage.xlsx","Sheet1");
        return data;
    }

    public Object[][] readExcelData(String path,String sheetname) throws IOException {
        Object[][] data = null;
        try {

            //Fileobject to read file
            FileInputStream fis = new FileInputStream(path);
            //Workbook object to create workbook
            Workbook wb = new XSSFWorkbook(fis);
            int sheetcount = wb.getNumberOfSheets();
            int sheetindex = 0;
            for (int k = 0; k < sheetcount; k++) {
                if (wb.getSheetName(k).equals(sheetname)) {
                    sheetindex = k;
                    break;
                }
            }
            XSSFSheet sheet = (XSSFSheet) wb.getSheetAt(sheetindex);
            XSSFRow row = sheet.getRow(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new Object[noOfRows - 1][noOfCols];
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    data[i - 1][j] = cell.getStringCellValue();
                }
            }
        }
        catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }
}