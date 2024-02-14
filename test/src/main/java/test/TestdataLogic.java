package test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestdataLogic {

	@DataProvider(name = "usercredentials")

	public Object Exceldata() throws Throwable {
		
		File file = new File("./data provider/Book1.xlsx");

		FileInputStream stream = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(stream);

		XSSFSheet sheet = workbook.getSheetAt(0);

		int rows = sheet.getPhysicalNumberOfRows();

		int cells = sheet.getRow(0).getLastCellNum();

		Object[][] info = new Object[rows-1][cells];

		for (int i = 0; i < rows-1; i++) {

			for (int j = 0; j < cells; j++) {

				DataFormatter df=new DataFormatter();
				
				info[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));

			}

		}

		return info;
	}
}