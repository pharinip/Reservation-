package com.reservationapp.service.impl;

import com.reservationapp.entity.Passenger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    public void generateExcel(List<Passenger> passengers, HttpServletResponse response) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Passengers");

        // Create header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"ID", "First Name", "Last Name", "Email", "Mobile", "From Location", "To Location", "Bus ID", "Route ID", "Sub Route ID"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Populate data rows
        int rowNum = 1;
        for (Passenger passenger : passengers) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(passenger.getId());
            row.createCell(1).setCellValue(passenger.getFirstName());
            row.createCell(2).setCellValue(passenger.getLastName());
            row.createCell(3).setCellValue(passenger.getEmail());
            row.createCell(4).setCellValue(passenger.getMobile());
            row.createCell(5).setCellValue(passenger.getFromLocation());
            row.createCell(6).setCellValue(passenger.getToLocation());
            row.createCell(7).setCellValue(passenger.getBusId());
            row.createCell(8).setCellValue(passenger.getRouteId());
            row.createCell(9).setCellValue(passenger.getSubRouteId());
        }

        // Set content type and attachment header
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=passengers.xlsx");

        // Write workbook to response output stream
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}

