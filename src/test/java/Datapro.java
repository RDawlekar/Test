import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class Datapro {
    @DataProvider(name="getdata")
    public static Object[][] getexcelData(String excelSheet,String result)
    {
        Object[][] data=getdata(System.getProperty("user.dir")+"\\TestData\\"+excelSheet+".xlsx",excelSheet);
        return data;
    }

    public static Object[][] getdata(String filepath,String name) {
        Object[][] exceldetails = null;


        try {
            FileInputStream fs = new FileInputStream(new File(filepath));
            XSSFWorkbook wb = new XSSFWorkbook(fs);
            XSSFSheet sheet;
            boolean isfound=false;

            for (int i=0;i<wb.getNumberOfSheets();i++)
            {
                if(wb.getSheetAt(i).equals(name))
                {
                    isfound=true;
                    sheet=wb.getSheet(name);
                    Iterator<Row> rowIterator= sheet.iterator();
                    while (rowIterator.hasNext())
                    {
                        Row row=rowIterator.next();
                        Iterator<Cell>cellIterator = row.cellIterator();
                        while(cellIterator.hasNext())
                        {
                            Cell cell=cellIterator.next();
                            exceldetails[cell.getRowIndex()][cell.getColumnIndex()]=cell.getStringCellValue();
                        }
                    }
                }
            }
            if(!isfound)
            {

            }
        } catch (Exception e) {

        }
        return exceldetails;
    }
}
