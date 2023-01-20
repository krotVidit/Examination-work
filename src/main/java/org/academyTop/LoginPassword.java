package org.academyTop;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class LoginPassword  {
    Scanner scanner = new Scanner(System.in);
    Workbook workbook = new HSSFWorkbook(new FileInputStream("D:\\Java\\IDEA\\Examination paper\\company.xls"));

    public LoginPassword() throws IOException {
    }

    private String readsLogin(){
        System.out.println("Enter Login");
       return scanner.next();
    }

    private int readsPassword(){
        System.out.println("Enter Password");
        return scanner.nextInt();
    }

    private void printNotCorrect(){
        System.out.println("Incorrect data entered\nTry again \n");
        checkLoginPassword();
    }





    private void checkLoginPassword(){
       String login = workbook.getSheetAt(1).getRow(1).getCell(3).getStringCellValue();
       if (login.equals(readsLogin())){
           System.out.println("Correct Login");
       }
       else {
           printNotCorrect();
       }

       int password = (int) workbook.getSheetAt(1).getRow(1).getCell(4).getNumericCellValue();

       if(password==readsPassword()){
           System.out.println("Correct Password");
       }
       else {
           printNotCorrect();
       }
       new Menu().getPrintMenuAdmin();

    }

    public void getCheckLoginPassword(){
        checkLoginPassword();
    }


}
