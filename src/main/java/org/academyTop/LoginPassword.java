package org.academyTop;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class LoginPassword {
    Scanner scanner = new Scanner(System.in);
    HashMap<String, Integer> hashLoginPassword = new HashMap<>();
    String login = null;
    int password = 0;


    private HSSFWorkbook patchFileExel() throws IOException {
        String separator = File.separator;
        FileInputStream fileExel = new FileInputStream("." + separator + "src" + separator + "main" + separator + "resources" + separator + "company.xls");
        return new HSSFWorkbook(fileExel);
    }

    public void getParchFileExel() throws IOException {
        patchFileExel();
    }


    private String readsLogin() {
        System.out.println("Enter Login");
        return scanner.next();
    }

    private int readsPassword() {
        System.out.println("Enter Password");
        return scanner.nextInt();
    }

    private void putLoginPasswordInHashMap() throws IOException {


        int starRow = 1;
        int endRow = 10;
        for (int i = starRow; i < endRow; i++) {
            login = String.valueOf(patchFileExel().getSheetAt(1).getRow(i).getCell(3));
            password = (int) patchFileExel().getSheetAt(1).getRow(i).getCell(4).getNumericCellValue();

            hashLoginPassword.put(login, password);
        }
        System.out.println(hashLoginPassword);
        patchFileExel().close();
    }

    public void getPutLoginPasswordInHashMap() throws IOException {
        putLoginPasswordInHashMap();
    }


    private void checkLoginPassword()  {
        String login = readsLogin();
        Integer keyHash = hashLoginPassword.get(login);
        if (keyHash == null) {
            System.out.println("Login not found, please try again\n");
            checkLoginPassword();
        } else {
            System.out.println("Login correct\n");
            int password = readsPassword();
            if (password == keyHash) {
                System.out.println("Password correct\n");
            } else {
                System.out.println("Password not found, please try again\n");
                checkLoginPassword();
            }
        }
    }
    public void getCheckLoginPassword(){
        checkLoginPassword();
    }
}


