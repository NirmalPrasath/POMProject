package com.qa.hubspot.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hpsf.Constants;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.hubspot.constants.Contsants;

public class Utility {
	
	
	public static Workbook wb;
	public static Sheet sh;
	public static FileInputStream  fis;
	
	public static Object[][] getData(String sheetName)
	{
		try {
			fis=new FileInputStream(Contsants.TEST_DATA_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			wb=WorkbookFactory.create(fis);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sh=wb.getSheet(sheetName);
		
		int rows=sh.getLastRowNum();
		int columns=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rows][columns];
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
	}

	

}
