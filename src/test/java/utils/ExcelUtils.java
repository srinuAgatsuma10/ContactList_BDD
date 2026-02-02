package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {
    public static List<Map<String, String>> getExcelData(String filePath, String sheetName) {
        List<Map<String, String>> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet NOT found with name: " + sheetName);
            }

            DataFormatter formatter = new DataFormatter();
            Row headerRow = sheet.getRow(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) {
                    continue;
                }

                Map<String, String> currentData = new HashMap<>();
                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    String key = headerRow.getCell(j).getStringCellValue().trim();
                    Cell cell = currentRow.getCell(j);
                    String value = "";
                    if (cell != null) {
                        value = formatter.formatCellValue(cell).trim();
                    }
                    currentData.put(key, value);
                }
                data.add(currentData);
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
