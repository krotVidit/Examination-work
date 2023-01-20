package org.academyTop;

public class Menu {
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

        private void printMenuAdmin(){
            System.out.println("""

                Select Action
                _____________""");
            System.out.println("1.search by employees\n2.Create a report\n3.News blog\n4.Hire a new employee");
        }
        public void getPrintMenuAdmin(){
            printMenuAdmin();
        }
        private void printMenuEmployee(){
            System.out.println("""

                Select Action
                _____________""");
            System.out.println("1.search by employees\n2.Create a report\n3.News blog\n");
        }
        public void getPrintMenuEmployee(){
            printMenuEmployee();
        }
}
