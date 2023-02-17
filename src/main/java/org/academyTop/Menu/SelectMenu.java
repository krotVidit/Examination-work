package org.academyTop.Menu;

import org.academyTop.DataTable;
import org.academyTop.Report.OrganizationStructureReport;
import org.academyTop.Report.RoleAssigner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SelectMenu {
    Scanner scanner = new Scanner(System.in);
    DataTable dataTable = new DataTable();


    public SelectMenu() throws IOException {
    }

    private void selectsMenuItemsAdmin() throws IOException {
        int numberMenu = scanner.nextInt();
        switch (numberMenu){
            case 2:
                RoleAssigner roleAssigner = new RoleAssigner();
                roleAssigner.assignRoles();
                ArrayList<ArrayList<String>> dataWithRoles = roleAssigner.getData();

                OrganizationStructureReport report = new OrganizationStructureReport(dataWithRoles);
                report.getGeneralReport();
                break;
            case 3 :
                dataTable.setVisible(true);

                break;

        }
        selectsMenuItemsAdmin();
    }
    public  void getSelectMenuItemsAdmin() throws IOException {
        selectsMenuItemsAdmin();
    }
}
