/**
 * @author Jagatheshwaran
 * 
 */
package readDataFromExcelSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String ar[]) throws IOException {

		// The below code is used to create FileInputStream object with provided File
		// path
		FileInputStream file = new FileInputStream(
				new File(System.getProperty("user.dir") + "/src/test/resources/TestFiles/excelReader/DataFile.xlsx"));

		// Workbook instance is created by passing FileInputStream Instance
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Sheet is created with Workbook instance
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Iterator<Row> is used to iterate Rows in Sheet
		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {

			// The below code is used to iterate next by next Rows in Sheet
			Row row = rowIterator.next();

			// Iterator<Cell> is used iterate Cells based on iterated Row in Sheet
			Iterator<Cell> cellIterator = row.iterator();

			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();

				// The below set of code is used to get the Cell content type and print on the
				// Console output
				switch (cell.getCellType()) {

				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue() + " ");
					break;

				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue() + " ");
					break;

				}
			}

			System.out.println(" ");
		}

		// close() - It is used to close the FileInputStream instance
		file.close();
	}

}
