package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    public static Map<String, String> getTestData(String sheetName) {
        Map<String, String> data = new HashMap<>();

        try {
            FileInputStream fis = new FileInputStream(
                    "src/test/resources/TestData/LoginData.xlsx"
            );

            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            Row valueRow = sheet.getRow(1);

            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                data.put(
                        headerRow.getCell(i).getStringCellValue(),
                        valueRow.getCell(i).getStringCellValue()
                );
            }

            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
