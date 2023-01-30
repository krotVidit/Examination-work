package org.academyTop;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class LoginPassword {
    Scanner scanner = new Scanner(System.in);
    String separator = File.separator;
    FileInputStream fileExel = new FileInputStream("." + separator + "src" + separator + "main" + separator + "resources" + separator + "company.xls");
    Workbook workbook = new HSSFWorkbook(fileExel);

    HashMap<String, Integer> hashLoginPassword = new HashMap<>();

    public LoginPassword() throws IOException {
    }


    private String readsLogin() {
        System.out.println("Enter Login");
        return scanner.next();
    }

    private int readsPassword() {
        System.out.println("Enter Password");
        return scanner.nextInt();
    }

    public void putLoginPasswordHashMap() throws IOException {


        int starRow = 1;
        int endRow = 10;
        String login = null;
        int password = 0;
        for (int i = starRow; i < endRow; i++) {
            login = String.valueOf(workbook.getSheetAt(1).getRow(i).getCell(3));
            password = (int) workbook.getSheetAt(1).getRow(i).getCell(4).getNumericCellValue();

            hashLoginPassword.put(login, password);
        }


        fileExel.close();
    }


    //    public boolean checkLoginPassword() {
//        String login = readsLogin();
//        Integer password = hashLoginPassword.get(login);
//        if (password == null) {
//            return false;
//        } else {
//            System.out.println("win");
//            int printPassword = readsPassword();
//            password = hashLoginPassword.get(printPassword);
//            if (password == null) {
//                checkLoginPassword();
//                return false;
//            } else {
//                System.out.println("Win");
//                return true;
//            }
//        }
//
//    }
    private void checkLoginPassword() {

    }

    public void getCheckLoginPassword() {
        checkLoginPassword();
    }


}


