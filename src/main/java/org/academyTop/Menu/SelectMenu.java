package org.academyTop.Menu;

import org.academyTop.DateBase;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SelectMenu {
    Scanner scanner = new Scanner(System.in);
    DateBase dateBase = new DateBase();
    private void selectsMenuItemsAdmin() throws IOException {
        int numberMenu = scanner.nextInt();
        switch (numberMenu){
            case 3 :
                dateBase.getPutDataBaseExelInArrayList();
                break;

        }
    }
    public  void getSelectMenuItemsAdmin() throws IOException {
        selectsMenuItemsAdmin();
    }
}
