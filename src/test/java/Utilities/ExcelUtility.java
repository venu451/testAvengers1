package Utilities;


import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import BasePackage.BaseClass;

/*utility file to perform data  driven operations*/
public class ExcelUtility extends BaseClass{
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;   
	
	/* set the cell data into the excel sheet */
	public void setCellData(int rownum,int colnum,String data,int head) throws IOException
	{
//		fi=new FileInputStream(xlfile);
		try {
			row=super.ws.getRow(rownum);
			cell=row.getCell(colnum);
		}catch(Exception rowException) {
			row=super.ws.createRow(rownum);
			cell=row.createCell(colnum);
		}
		
		if(cell==null) {
			cell = row.createCell(colnum);
		}
		
		cell.setCellValue(data);
		CellStyle cellStyle;
		/*Setting the background colour for the cell to differenciate the headers and the data*/
		if(head==0) {
			cellStyle = super.wb.createCellStyle();
	        cellStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
	        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}else if(head==1) {
			cellStyle = super.wb.createCellStyle();
	        cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
	        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}else {
			cellStyle = super.wb.createCellStyle();
	        cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
	        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
		/*Adjusting the cell width*/
		super.ws.setColumnWidth(0, 256*50);
		super.ws.setColumnWidth(1, 256*50);
		cellStyle.setWrapText(true);
		
		cell.setCellStyle(cellStyle);
	}
}
