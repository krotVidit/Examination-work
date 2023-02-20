package org.academyTop.Menu;

import org.academyTop.DataBase.DataBase;
import org.academyTop.DataBase.DataTable;
import org.academyTop.Report.Employee;
import org.academyTop.Report.EmployeeParser;
import org.academyTop.Report.Generator.AverageSalary;
import org.academyTop.Report.Generator.OrganizationStructureReport;
import org.academyTop.Report.Generator.TopHighlyPaidEmployees;
import org.academyTop.Report.Generator.TopLoyalEmployees;
import org.academyTop.Report.Roles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectMenu {
    Scanner scanner = new Scanner(System.in);
    Roles roleAssigner = new Roles();
    EmployeeParser employeeParser = new EmployeeParser();
    DataBase dataBase = new DataBase();
    List<Employee> employees = employeeParser.getParseData(roleAssigner.getData());
    AverageSalary reportGeneratorAverageSalary = new AverageSalary(employees);
    List<ArrayList<String>> data = dataBase.getPutDataBaseExelInArrayList();


    public SelectMenu() throws IOException {
    }

    private void selectsMenuItemsAdmin() throws IOException {
        try {
            int numberMenu = Integer.parseInt(scanner.nextLine());
            switch (numberMenu) {
                case 1:
                    new DataTable().setVisible(true);
                    new Menu().getPrintMenuAdmin();
                    selectsMenuItemsAdmin();
                    break;
                case 2:
                    new Menu().getPrintMenuReport();
                    selectsMenuReport();
                    new Menu().getPrintMenuAdmin();
                    selectsMenuItemsAdmin();
                    break;

                case 3:
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
            int numberSelect = Integer.parseInt(scanner.nextLine());
            switch (numberSelect) {
                case 1:
                    roleAssigner.getAssignsRole();
                    ArrayList<ArrayList<String>> dataWithRoles = roleAssigner.getData();
                    OrganizationStructureReport reportStructureOrganization = new OrganizationStructureReport(dataWithRoles);
                    reportStructureOrganization.getGeneratesHierarchyReport();
                    break;
                case 2:
                    reportGeneratorAverageSalary.getGenerateReportAverageSalary();
                    reportGeneratorAverageSalary.getSavesReportToFile();
                    break;
                case 3:
                    TopHighlyPaidEmployees topHighlyPaidEmployees = new TopHighlyPaidEmployees(employees);
                    topHighlyPaidEmployees.getSavesReportToFile();
                    break;
                case 4:

                    TopLoyalEmployees reportGeneratorLoyalEmployees = new TopLoyalEmployees(employees);
                    reportGeneratorLoyalEmployees.getCreateReportLoyalEmployees();
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
