package org.academyTop;

import java.io.IOException;
import java.util.Scanner;

public class SelectMenu {
    Scanner scanner = new Scanner(System.in);
    DateBase dateBase = new DateBase();
    private void selectsMenuItemsAdmin() throws IOException {
        int numberMenu = scanner.nextInt();
        switch (numberMenu){
            case 1 :
                dateBase.getPutDataBaseExelInArrayList();
                break;

        }
    }
    public  void getSelectMenuItemsAdmin() throws IOException {
        selectsMenuItemsAdmin();
    }
}
