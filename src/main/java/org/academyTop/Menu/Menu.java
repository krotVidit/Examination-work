package org.academyTop.Menu;

import java.io.IOException;

public class Menu {
    SelectMenu selectMenu = new SelectMenu();

    public Menu() throws IOException {
    }

    private void printsNameProgram(){
            System.out.print("""

                ********************************
                ** Employee accounting system **
                ********************************

                """);
        }
        public void getPrintsNameProgram(){
            printsNameProgram();
        }

        private void printMenuAdmin() throws IOException {
            System.out.println("""

                Select Action
                _____________""");
            System.out.println("1.search by employees\n2.Create a report\n3.DataBase\n4.Exit");
            selectMenu.getSelectMenuItemsAdmin();

        }
        public void getPrintMenuAdmin() throws IOException {
            printMenuAdmin();
        }

    private void printMenuEmployee() {
        System.out.println("""

                Select Action
                _____________""");
        System.out.println("1.search by employees\n2.Create a report\n3.News blog\n");
    }

    public void getPrintMenuEmployee() {
        printMenuEmployee();
    }

    private void printMenuReport() {
        System.out.println("""

                Select Action
                _____________""");
        System.out.println("1.Organization structure\n2.Average salary by organization and department\n3.The highest paid\n4.Most dedicated employees");
    }
    public void getPrintMenuReport(){
        printMenuReport();
    }

}
