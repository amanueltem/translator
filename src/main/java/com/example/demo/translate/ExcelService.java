package com.example.demo.translate;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;

@Service
@Slf4j
public class ExcelService {

    private final TranslationService translationService;

    public ExcelService(TranslationService translationService) {
        this.translationService = translationService;
    }

    public void translateExcel(String inputFile, String outputFile, int startRow, int column) throws Exception {
        try (FileInputStream file = new FileInputStream(inputFile);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            for (Sheet sheet : workbook) {

                int lastRow = sheet.getLastRowNum();

                for (int rowIndex = startRow; rowIndex <= lastRow; rowIndex++) {

                    Row row = sheet.getRow(rowIndex);
                    if (row == null) continue;

                    Cell cell = row.getCell(column);
                    if (cell == null) continue;

                    if (cell.getCellType() == CellType.STRING) {

                        String original = cell.getStringCellValue().trim();
                        if (original.isEmpty()) continue;
                        String translated=translationService.translate(original);
                        cell.setCellValue(translated);

                    }
                }
            }

            // Write out to a new file => perfect clone + modifications
            try (FileOutputStream outFile = new FileOutputStream(outputFile)) {
                workbook.write(outFile);
            }
        }
    }

}
