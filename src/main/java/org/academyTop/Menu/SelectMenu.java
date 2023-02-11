package org.academyTop.Menu;

import org.academyTop.DataBase;

import java.io.IOException;
import java.util.Scanner;

public class SelectMenu {
    Scanner scanner = new Scanner(System.in);
    DataBase dataBase = new DataBase();
    private void selectsMenuItemsAdmin() throws IOException {
        int numberMenu = scanner.nextInt();
        switch (numberMenu){
            case 3 :
                dataBase.getPutDataBaseExelInArrayList();
                break;

        }
    }
    public  void getSelectMenuItemsAdmin() throws IOException {
        selectsMenuItemsAdmin();
    }
}
