package afterBurner.FileHandling;

import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtilities {
	
	static File file = new File("E:\\StarGateTeam\\AfterBurnerHybridFramework\\TestDataFiles\\TestData.xlsx");
	static XSSFWorkbook wb ;
	static XSSFSheet sheet;
	
	public static int getRowCount(){
		//Excel sheet extension xls then use class HSSFWorkbook
		//Excel sheet extension xlsx
		 try {
			wb = new XSSFWorkbook(file);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		int count = sheet.getLastRowNum();
		return count;
	}

	
	public static int getCellCount(){

		 try {
			wb = new XSSFWorkbook(file);
		} catch (InvalidFormatException | IOException e) {
				e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		int count = sheet.getRow(0).getLastCellNum();
		return count;
	}
	
	public static String getStringData() {

		 try {
			wb = new XSSFWorkbook(file);
		} catch (InvalidFormatException | IOException e) {
				e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		String value =  sheet.getRow(1).getCell(1).getStringCellValue();
		
		return value;
	}
	
	public static double getNumericData() {

		 try {
			wb = new XSSFWorkbook(file);
		} catch (InvalidFormatException | IOException e) {
				e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		double value =  sheet.getRow(1).getCell(0).getNumericCellValue();
		
		return value;
	}
	
	public static void getData() {

		 try {
			wb = new XSSFWorkbook(file);
		} catch (InvalidFormatException | IOException e) {
				e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		
		DataFormatter formatter = new DataFormatter();
		
		int rowCount = getRowCount();
		int cellCount = getCellCount();
		
		for(int row = 1;row<rowCount;row++) {
			for(int cell = 0;cell<cellCount;cell++) {
				String value =  formatter.formatCellValue(sheet.getRow(row).getCell(cell));
				System.out.print(value+" ");
			}
			System.out.println();
		}
	
	}
	
	public static void main(String[] args) {
		
		System.out.println("Count of Rows = "+getRowCount());
		System.out.println("Count of Cell = "+getCellCount());
		System.out.println("Get String Data = "+getStringData());
		System.out.println("Get Numeric Data = "+getNumericData());
	    getData();
	}
}
