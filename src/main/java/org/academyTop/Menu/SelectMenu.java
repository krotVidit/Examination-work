package org.academyTop.Menu;

import org.academyTop.DataBase;
import org.academyTop.DataTable;
import org.academyTop.Report.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectMenu {
    Scanner scanner = new Scanner(System.in);
    DataTable dataTable = new DataTable();
    RoleAssigner roleAssigner = new RoleAssigner();
    EmployeeParser employeeParser = new EmployeeParser();


    public SelectMenu() throws IOException {
    }

    private void selectsMenuItemsAdmin() throws IOException {
        int numberMenu = scanner.nextInt();
        switch (numberMenu){
            case 1: DataBase database = new DataBase();
                List<Employee> employees = employeeParser.parseData(roleAssigner.getData());

                ReportGenerator reportGenerator = new ReportGenerator(employees);
                reportGenerator.generateReport();
                reportGenerator.saveReportToFile("report.txt");
                break;
            case 2:
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
