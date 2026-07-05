package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {
		File file = new File(System.getProperty("user.dir") + "//testData//" + fileName);
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<User> userList=null;
		User userData;
		try {
			fileReader = new FileReader(file);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();// Reading the ColNames ---- Row 1
			// csvReader.readNext();// Row 2
			// data = csvReader.readNext();// Row 3

			// data = csvReader.readNext();// ROW4 [No row!! or we have reached the end of
			// the CSV file, readNext() returns
			// you null.
			userList = new ArrayList<User>();

			while ((line = csvReader.readNext()) != null) {
				userData = new User(line[0], line[1]);
				userList.add(userData);
			}
			for (User user : userList) {
				System.out.println(user);
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();
	}
}
