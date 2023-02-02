package org.academyTop;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class DateBase {

    private HSSFWorkbook patchFileExel() throws IOException {
        String separator = File.separator;
        FileInputStream fileExel = new FileInputStream("." + separator + "src" + separator + "main" + separator + "resources" + separator + "company.xls");
        return new HSSFWorkbook(fileExel);
    }

    public HSSFWorkbook getPatchFileExel() throws IOException {
        return patchFileExel();
    }


    private void All() throws IOException {
        for (Row row : patchFileExel().getSheetAt(0)) {
            for (Cell cell : row) {

                System.out.println(ChecksCellForFormat(cell) + " ");
            }
        }
        patchFileExel().close();
    }
    public void getAll() throws IOException {
        All();
    }


    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    private static String ChecksCellForFormat(Cell cell) {
        String result = null;
        switch (cell.getCellType()) {
            case STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    result = simpleDateFormat.format(cell.getDateCellValue()); // передали формат даты
                } else {
                    result = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                result = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                result = cell.getCellFormula();
                break;
            default:
                System.out.println();
        }
        return result;

    }

}



