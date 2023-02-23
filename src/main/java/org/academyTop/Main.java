package org.academyTop;

import org.academyTop.DataBase.LoginPassword;
import org.academyTop.Menu.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        LoginPassword loginPassword = new LoginPassword();

        menu.getPrintsNameProgram();
        loginPassword.getPutLoginPasswordInHashMap();
        loginPassword.getCheckLoginPassword();

    }
}
