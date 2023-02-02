package org.academyTop;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DateBase {

    private HSSFWorkbook patchFileExel() throws IOException {
        String separator = File.separator;
        FileInputStream fileExel = new FileInputStream("." + separator + "src" + separator + "main" + separator + "resources" + separator + "company.xls");
        return new HSSFWorkbook(fileExel);
    }

    public HSSFWorkbook getPatchFileExel() throws IOException {
        return patchFileExel();
    }

}


