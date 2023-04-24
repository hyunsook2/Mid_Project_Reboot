package account;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadAcountFunc {

   //회원정보 읽어오기
    public  List<AccountDTO> readData() {
       List<AccountDTO> accountList = new ArrayList<AccountDTO>();

        try {
           File file = new File("D:\\projectReboot\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\reboot\\Storage\\readExcel.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet("account");	//시트명
            int rows = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rows; i++) {
                XSSFRow row = sheet.getRow(i);

                AccountDTO account = new AccountDTO();
                account.setId(row.getCell(0).getStringCellValue());
                account.setDeptn(row.getCell(1).getStringCellValue());
                account.setName(row.getCell(2).getStringCellValue());
                account.setPass(row.getCell(3).getStringCellValue());
                account.setGrade(row.getCell(4).getStringCellValue());
                account.setPnum(row.getCell(5).getStringCellValue());
                account.setAd(row.getCell(6).getStringCellValue());
                
          
                accountList.add(account);
            }

            workbook.close();
            fis.close();

        } catch (IOException e) {       
           e.printStackTrace();
        }

        return accountList;
    }
   
   
}