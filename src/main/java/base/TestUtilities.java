package base;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest {

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@DataProvider(name = "NegativeLoginTest")
	public String[][] data() {
		return new String[][] { { "tomsmith", "", "Negative", "Your password is invalid!" },
				{ "", "SuperSecretPassword!", "Negative", "Your username is invalid!" },
				{ "", "", "Negative", "Your username is invalid!" } };

	}
	
	@DataProvider(name = "NegativeLoginTestExcel")
	public String[][] readDataFromExcel() throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestData/NegativeLogin.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int numOfRows = sheet.getLastRowNum();		
		int numOfColumns = sheet.getRow(0).getLastCellNum();
		String[][] arr = new String[numOfRows][numOfColumns];
		
		for(int i=1;i<=numOfRows;i++){
		
		XSSFRow currentRow = sheet.getRow(i);
		
		for(int j=0;j<numOfColumns;j++) {
			
			try {
			arr[i-1][j] = currentRow.getCell(j).toString();
			}
			catch(Exception e) {
				arr[i-1][j] = "";
			}
			
		}
		}
		
		workbook.close();
		file.close();
		return arr;}
	}
