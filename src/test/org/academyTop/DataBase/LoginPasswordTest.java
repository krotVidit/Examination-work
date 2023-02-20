package org.academyTop.DataBase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginPasswordTest {
    private LoginPassword loginPassword;
    private Scanner scanner;

    @BeforeEach
    public void setup() {
        loginPassword = new LoginPassword();
        scanner = new Scanner(System.in);
    }

    @Test
    public void testPutLoginPasswordInHashMap() throws IOException {

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Mimirov", 1234);
        expected.put("Procha", 4321);
        expected.put("Petrov", 1324);
        expected.put("Mironov", 1243);
        expected.put("Kirilov", 1342);
        expected.put("Kotov", 4132);
        expected.put("Yaric", 3421);
        expected.put("Popov", 3142);
        expected.put("Novoselov", 2341);

        loginPassword.getPutLoginPasswordInHashMap();

        HashMap<String, Integer> actual = loginPassword.hashLoginPassword;
        assertEquals(expected, actual);
    }}


