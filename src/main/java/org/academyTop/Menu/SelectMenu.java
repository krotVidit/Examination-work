package org.academyTop.Menu;

import org.academyTop.DataBase.DataBase;
import org.academyTop.DataBase.DataTable;
import org.academyTop.Report.Employee;
import org.academyTop.Report.EmployeeParser;
import org.academyTop.Report.Generator.AverageSalary;
import org.academyTop.Report.Generator.OrganizationStructureReport;
import org.academyTop.Report.Generator.TopHighlyPaidEmployees;
import org.academyTop.Report.Generator.TopLoyalEmployees;
import org.academyTop.Report.RoleAssigner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectMenu {
    Scanner scanner = new Scanner(System.in);
    RoleAssigner roleAssigner = new RoleAssigner();
    EmployeeParser employeeParser = new EmployeeParser();
    DataBase dataBase = new DataBase();
    List<Employee> employees = employeeParser.parseData(roleAssigner.getData());
    AverageSalary reportGenerator = new AverageSalary(employees);
    List<ArrayList<String>> data = dataBase.getPutDataBaseExelInArrayList();
    List<Employee> employees1 = employeeParser.parseData((ArrayList<ArrayList<String>>) data);


    public SelectMenu() throws IOException {
    }

    private void selectsMenuItemsAdmin() throws IOException {
        try {
            int numberMenu = scanner.nextInt();
            switch (numberMenu) {
                case 2:
                    new Menu().getPrintMenuReport();
                    selectsMenuReport();
                    new Menu().getPrintMenuAdmin();
                    selectsMenuItemsAdmin();
                    break;
                case 3:
                    new DataTable().setVisible(true);
                    new Menu().getPrintMenuAdmin();
                    selectsMenuItemsAdmin();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid value entered\n");
                    Menu menu = new Menu();
                    menu.getPrintMenuAdmin();
                    selectsMenuItemsAdmin();
            }
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid value entered\n");
            Menu menu = new Menu();
            menu.getPrintMenuAdmin();
            selectsMenuItemsAdmin();
        }
    }
    public void getSelectsMenuItemsAdmin() throws IOException {
        selectsMenuItemsAdmin();
    }

    private void selectsMenuReport() throws IOException {
        try {
            int numberSelect = scanner.nextInt();
            switch (numberSelect) {
                case 1:
                    roleAssigner.getAssignRoles();
                    ArrayList<ArrayList<String>> dataWithRoles = roleAssigner.getData();
                    OrganizationStructureReport report = new OrganizationStructureReport(dataWithRoles);
                    report.getGeneralReport();
                    break;
                case 2:
                    reportGenerator.getGenerateReport();
                    reportGenerator.getSaveReportToFile();
                    break;
                case 3:
                    TopHighlyPaidEmployees reportGenerator1 = new TopHighlyPaidEmployees(employees);
                    reportGenerator1.getCreatesReportHighlyPaidEmployees();
                    break;
                case 4:
                    EmployeeParser employeeParser = new EmployeeParser();

                    List<Employee> employees = employeeParser.parseData(roleAssigner.getData());

                    TopLoyalEmployees reportGenerator = new TopLoyalEmployees(employees);
                    reportGenerator.createReportLoyalEmployees();
                    break;
                case 5:
                    Menu menu = new Menu();
                    menu.getPrintMenuAdmin();
                    selectsMenuItemsAdmin();
                    break;
                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nInvalid value entered\n");
                    Menu menu1 = new Menu();
                    menu1.getPrintMenuReport();
                    selectsMenuReport();
            }
            Menu menu = new Menu();
            menu.getPrintMenuReport();
            selectsMenuReport();

        } catch (NumberFormatException e) {
            System.out.println("\nInvalid value entered\n");
            Menu menu = new Menu();
            menu.getPrintMenuReport();
            selectsMenuReport();
        }
    }
    public void getSelectsMenuReport() throws IOException {
        selectsMenuReport();
    }
}
