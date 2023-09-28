package DataReaders;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadData {

    private  FileInputStream fis;
    private  XSSFWorkbook excelFile;

    public ReadData(String filepath){
        try{
        fis = new FileInputStream(new File(filepath));
        excelFile = new XSSFWorkbook(fis);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFacebookLoginSheet(String login_status) {
        ArrayList<String> loginCredentialsList = new ArrayList<>();
        XSSFSheet facebook_Login_Sheet = excelFile.getSheet("Facebook_Login_TestData");
        if (login_status.toLowerCase().contains("successfullogin")) {
            Row row = facebook_Login_Sheet.getRow(1);
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
               Cell c = cellIterator.next();
              loginCredentialsList.add(c.getStringCellValue());
            }
            for(String str: loginCredentialsList){
                System.out.println(str);
            }
        }
        else if (login_status.toLowerCase().contains("failedlogin")){
            Row row = facebook_Login_Sheet.getRow(2);
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()){
                Cell c = cellIterator.next();
                loginCredentialsList.add(c.getStringCellValue());
            }
            for(String str: loginCredentialsList){
                System.out.println(str);
            }
        }
        try {
            excelFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loginCredentialsList;
    }

    public List<String> readFacebookSignUpSheet() {
        List<String> Registration_Credentials_List = new ArrayList<>();
        XSSFSheet facebook_registration_sheet = excelFile.getSheet("Facebook_Registration_TestData");
        Row row = facebook_registration_sheet.getRow(1);
        Iterator<Cell> cellIterator = row.cellIterator();
           while(cellIterator.hasNext()){
              Cell cell = cellIterator.next();
             CellType cellType = cell.getCellType();
              switch(cellType){
                  case STRING:
                     Registration_Credentials_List.add(cell.getStringCellValue());
                     break;
                  case NUMERIC:
                      Registration_Credentials_List.add(String.valueOf((int)(cell.getNumericCellValue())));
              }
           }
           for (String str : Registration_Credentials_List){
               System.out.println(str);
           }
        return Registration_Credentials_List;
    }


}
