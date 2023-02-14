package org.academyTop.Menu;

import org.academyTop.DataBase;
import org.academyTop.DataTable;

import java.io.IOException;
import java.util.Scanner;

public class SelectMenu {
    Scanner scanner = new Scanner(System.in);
    DataTable dataTable = new DataTable();

    public SelectMenu() throws IOException {
    }

    private void selectsMenuItemsAdmin() throws IOException {
        int numberMenu = scanner.nextInt();
        switch (numberMenu){
            case 3 :
                dataTable.setVisible(true);


                break;

        }
    }
    public  void getSelectMenuItemsAdmin() throws IOException {
        selectsMenuItemsAdmin();
    }
}
