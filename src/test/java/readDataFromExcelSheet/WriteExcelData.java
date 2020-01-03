/**
 * @author Jagatheshwaran
 * 
 */
package readDataFromExcelSheet;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelData {

	public static void main(String ar[]) {

		// Workbook instance is created
		XSSFWorkbook workbook = new XSSFWorkbook();

		// createSheet() - It is used to create Sheet at runtime
		XSSFSheet sheet = workbook.createSheet("TestData");

		// A Map instance is created to store Key and value
		Map<String, Object[]> dataMap = new TreeMap<String, Object[]>();

		// The below code is used to add Data to Map
		dataMap.put("1", new Object[] { "Name", "Position" });
		dataMap.put("2", new Object[] { "Jaga", "Tester" });
		dataMap.put("3", new Object[] { "Arul", "Developer" });

		// The below code is used to get Keys from Map Data
		Set<String> keyVal = dataMap.keySet();

		int rownum = 0;

		for (String key : keyVal) {

			// createRow() - It is used to create new Row at runtime
			Row row = sheet.createRow(rownum++);

			// The values corresponding to Key stored in Map is fetched and placed in Array
			Object[] dataArray = dataMap.get(key);

			int cellnum = 0;

			for (Object data : dataArray) {

				// createCell() - It is used to new cell to write data
				Cell cell = row.createCell(cellnum++);

				if (data instanceof String) {
					cell.setCellValue((String) data);
				}
				if (data instanceof Integer) {
					cell.setCellValue((Integer) data);
				}

			}
		}

		try {

			// The below set of code is used to write the data into below provided File
			FileOutputStream file = new FileOutputStream(new File(
					System.getProperty("user.dir") + "/src/test/resources/TestFiles/excelReader/DataFile.xlsx"));
			workbook.write(file);

			// close() - It is used to close the FileInputStream instance
			file.close();

			System.out.println("Data written into the Excel");

		} catch (IOException ex) {

			ex.printStackTrace();
		}
	}
}
