package org.academyTop;

import org.academyTop.Menu.MainMenu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class LoginPassword {
    DataBase dataBase =new DataBase();
    Scanner scanner = new Scanner(System.in);
    HashMap<String, Integer> hashLoginPassword = new HashMap<>();
    String login = null;
    int password = 0;


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
            login = String.valueOf(dataBase.getPatchFileExel().getSheetAt(1).getRow(i).getCell(3));
            password = (int) dataBase.getPatchFileExel().getSheetAt(1).getRow(i).getCell(4).getNumericCellValue();

            hashLoginPassword.put(login, password);
        }
        System.out.println(hashLoginPassword);
        dataBase.getPatchFileExel().close();
    }

    public void getPutLoginPasswordInHashMap() throws IOException {
        putLoginPasswordInHashMap();
    }


    private void checkLoginPassword() throws IOException {
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
                if (login.equals("Mimirov") || login.equals("Mironov") || login.equals("Yaric")) {
                    new MainMenu().getPrintMenuAdmin();
                } else {
                    new MainMenu().getPrintMenuEmployee();
                }
            } else {
                System.out.println("Password is incorrect, please try again\n");
                checkLoginPassword();
            }

        }
    }
    public void getCheckLoginPassword() throws IOException {
        checkLoginPassword();
    }
}


