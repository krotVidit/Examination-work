package org.academyTop.DataBase;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DataBaseTest {
    private static DataBase database;
    private static HSSFWorkbook workbook;
    private static ArrayList<ArrayList<String>> data;

    @BeforeAll
    static void init() throws IOException {
        database = new DataBase();
        workbook = database.getPatchFileExel();
        data = database.getPutDataBaseExelInArrayList();
    }

    @Test
    void testGetPatchFileExel() throws IOException {
        assertNotNull(workbook);
    }

    @Test
    void testGetPutDataBaseExelInArrayList() throws IOException {
        assertNotNull(data);
    }

}
