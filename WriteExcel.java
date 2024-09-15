package com.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;



public class WriteExcel {

	private static final String FILE_PATH = "C:\\Users\\hp\\OneDrive\\Desktop\\Eclipse_workspace\\Java_Selenium_Code\\others\\example.xlsx";

	public static void main(String[] args) {

		// Create a new workbook
		Workbook workbook = new XSSFWorkbook();

		// Create a sheet in the workbook
		Sheet sheet = workbook.createSheet("Data");

		// Create a row and put some cells in it
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Name");
		headerRow.createCell(2).setCellValue("Age");

		// Add some data to the rows
		Row row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue(1);
		row1.createCell(1).setCellValue("John Doe");
		row1.createCell(2).setCellValue(30);

		Row row2 = sheet.createRow(2);
		row2.createCell(0).setCellValue(2);
		row2.createCell(1).setCellValue("Jane Smith");
		row2.createCell(2).setCellValue(25);

		// Resize columns to fit the content
		for (int i = 0; i < 3; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH)) {
			workbook.write(fileOut);
			System.out.println("Excel file written successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Closing the workbook
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
