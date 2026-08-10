package ai.zudu.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

public class ExcelUtils {

    public static String getCellData(String fileName, String sheetName, int rowNum, int cellNum) throws IOException {

        InputStream input = ExcelUtils.class.getClassLoader().getResourceAsStream("testData/" + fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        XSSFRow row = sheet.getRow(rowNum);
        XSSFCell cell = row.getCell(cellNum);

        workbook.close();
        return cell.getStringCellValue();
    }

    public static int getRowCount(String fileName, String sheetName) throws IOException {

        InputStream input = ExcelUtils.class.getClassLoader().getResourceAsStream("testData/" + fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();

        workbook.close();
        return rowCount;
    }

}
