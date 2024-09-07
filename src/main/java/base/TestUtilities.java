package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class TestUtilities extends BaseTest {

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  String takeScreenshot() {
		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String pathname = System.getProperty("user.dir") + File.separator + "test-output" + File.separator
				+ "Screenshots" + File.separator + getTodaysDate() + File.separator + testName + File.separator
				+ testMethodName + "_"+getSystemTime() + ".png";
		// String pathname = System.getProperty("user.dir")+"test.png";
		File DestFile = new File(pathname);
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return pathname;

	}

	@DataProvider(name = "NegativeLoginTest")
	public String[][] data() {
		return new String[][] { { "tomsmith", "", "Negative", "Your password is invalid!" },
				{ "", "SuperSecretPassword!", "Negative", "Your username is invalid!" },
				{ "", "", "Negative", "Your username is invalid!" } };

	}

	@DataProvider(name = "NegativeLoginTestExcel")
	public String[][] readDataFromExcel(Method method) throws IOException {

		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "TestData"
				+ File.separator + method.getDeclaringClass().getSimpleName() + File.separator + method.getName()
				+ ".xlsx";

		FileInputStream file = new FileInputStream(pathname);

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int numOfRows = sheet.getLastRowNum();
		int numOfColumns = sheet.getRow(0).getLastCellNum();
		String[][] arr = new String[numOfRows][numOfColumns];

		for (int i = 1; i <= numOfRows; i++) {

			XSSFRow currentRow = sheet.getRow(i);

			for (int j = 0; j < numOfColumns; j++) {

				try {
					arr[i - 1][j] = currentRow.getCell(j).toString();
				} catch (Exception e) {
					arr[i - 1][j] = "";
				}

			}
		}

		workbook.close();
		file.close();
		return arr;
	}

	@DataProvider(name = "csvReader")
	public static Iterator<Object[]> csvReader(Method method) throws CsvValidationException {
		List<Object[]> list = new ArrayList<Object[]>();

		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "TestData"
				+ File.separator + method.getDeclaringClass().getSimpleName() + File.separator + method.getName()
				+ ".csv";

		File file = new File(pathname);
		try {
			CSVReader reader = new CSVReader(new FileReader(file));

			String[] keys = reader.readNext(); // reading the first row(headers) and saving them as keys array
			if (keys != null) {
				String[] dataParts;
				while ((dataParts = reader.readNext()) != null) { // reading each data row and saving it to DataParts
																	// array
					Map<String, String> testData = new HashMap<String, String>();
					for (int i = 0; i < keys.length; i++) {
						testData.put(keys[i], dataParts[i]);
					}
					list.add(new Object[] { testData });
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File " + pathname + " was not found.\n" + e.getStackTrace().toString());
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + pathname + " file.\n" + e.getStackTrace().toString());
		}

		return list.iterator();
	}

	protected static String getTodaysDate() {
		return (new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
	}

	protected static String getSystemTime() {
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	}

}
