package ai.zudu;

import ai.zudu.utils.ExcelUtils;
import org.testng.annotations.Test;



public class ExcelTestData {

    @Test
    public void readExcelData() throws Exception {
        String email1 = ExcelUtils.getCellData("loginData.xlsx", "sheet1", 1,0);
        String email2 = ExcelUtils.getCellData("loginData.xlsx", "sheet1", 2,0);
        String email3 = ExcelUtils.getCellData("loginData.xlsx", "sheet1", 3,0);

        System.out.println("First emailId: "+email1);
        System.out.println("Second emailId: "+email2);
        System.out.println("Third emailId: "+email3);
    }

    @Test
    public void readAllExcelData() throws Exception {
        int rowCount = ExcelUtils.getRowCount("loginData.xlsx", "sheet1");

        for(int i=1; i<=rowCount;i++){
            String email = ExcelUtils.getCellData("loginData.xlsx", "sheet1", i, 0);
            System.out.println("Row "+i+" Email: "+email);
        }
    }

}
