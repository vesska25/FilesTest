package com.vesska;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import static org.assertj.core.api.Assertions.assertThat;


public class ZipFileTest {

    ClassLoader cl = ZipFileTest.class.getClassLoader();

    @Test
    void parseZipFile() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("testZip.zip");
                ZipInputStream zis = new ZipInputStream(resource)
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".pdf")) {
                    PDF content = new PDF(zis);
                    assertThat(content.text).contains("ЗАЯВЛЕНИЕ-АНКЕТА");
                } else if (entry.getName().endsWith(".xlsx")) {
                    XLS content = new XLS(zis);
                    assertThat(content.excel.getSheetAt(0).getRow(1).getCell(0).getStringCellValue()).contains("sechs");
                } else if (entry.getName().endsWith(".csv")) {
                    CSVReader reader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> content = reader.readAll();
                    assertThat(content.get(1)[0]).contains("german");
                }
            }
        }
    }
}