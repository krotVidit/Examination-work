package org.academyTop;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LoginPassword loginPassword = new LoginPassword();

        loginPassword.getPutLoginPasswordInHashMap();
        loginPassword.getCheckLoginPassword();

    }
}
