package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {
		File xlsxFile = new File(System.getProperty("user.dir") + "//testData//" + fileName);// XLSX FILE
		XSSFWorkbook xssfWorkbook = null;
		List<User> userList = null;
		Cell emailAddressCell;
		Cell passwordCell;
		Row row;
		User user;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;

		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			userList = new ArrayList<User>();

			xssfSheet = xssfWorkbook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();// Skipping the Col Name
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);

				// System.out.println(emailAddressCell.toString());

				/// System.out.println(secondCell.toString());
			}
			xssfWorkbook.close();

		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();
	}
}
