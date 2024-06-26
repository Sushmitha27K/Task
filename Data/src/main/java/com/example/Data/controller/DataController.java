
package com.example.Data.controller;



import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Data.entity.DataEntity;
import com.example.Data.service.DataService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class DataController {
    @Autowired
    private DataService dataService;

    @GetMapping("/data")
    public String getAllData(Model model) {
        List<DataEntity> dataList = dataService.getAllData();
        model.addAttribute("dataList", dataList);
        return "data";
    }

    @GetMapping("/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        List<DataEntity> dataList = dataService.getAllData();

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"data.pdf\"");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);

        for (DataEntity data : dataList) {
            table.addCell(data.getId().toString());
            table.addCell(data.getName());
            table.addCell(data.getValue());
        }

        document.add(table);
        document.close();
    }

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        List<DataEntity> dataList = dataService.getAllData();

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"data.xls\"");

        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("DataEntity");

        int rowNum = 0;
        for (DataEntity data : dataList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(data.getId());
            row.createCell(1).setCellValue(data.getName());
            row.createCell(2).setCellValue(data.getValue());
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }

    @GetMapping("/export/csv")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        List<DataEntity> dataList = dataService.getAllData();

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"data.csv\"");

        PrintWriter writer = response.getWriter();
        writer.println("ID,Name,Value");
        for (DataEntity data : dataList) {
            writer.println(data.getId() + "," + data.getName() + "," + data.getValue());
        }
    }
}
