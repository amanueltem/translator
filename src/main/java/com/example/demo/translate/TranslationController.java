package com.example.demo.translate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;

@RestController
@RequestMapping("/api/translate")
public class TranslationController {

    private final ExcelService excelService;

    public TranslationController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @PostMapping(value = "/excel", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Resource> translateExcel(
            @RequestParam("file") MultipartFile file,
            @RequestParam("startRow") int startRow,
            @RequestParam("column") int column
    ) throws Exception {

        // 1. Save uploaded file temporarily
        File inputFile = File.createTempFile("input_", ".xlsx");
        file.transferTo(inputFile);

        // 2. Create output file
        File outputFile = File.createTempFile("translated_", ".xlsx");

        // 3. Translate the file
        excelService.translateExcel(
                inputFile.getAbsolutePath(),
                outputFile.getAbsolutePath(),
                startRow,
                column
        );

        // 4. Return translated file as a download
        InputStreamResource resource = new InputStreamResource(new FileInputStream(outputFile));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=translated.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);
    }

}

