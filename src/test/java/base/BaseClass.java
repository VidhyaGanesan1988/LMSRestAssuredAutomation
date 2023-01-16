package base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import utilities.Config;
import utilities.ExcelReader;

public class BaseClass {

	public static final Logger logger = LogManager.getLogger(BaseClass.class.getName());

	public static String randomestring()

	{
		String generateinvalidID=RandomStringUtils.randomNumeric(3);
		return(generateinvalidID);
	}
	
	public static String DynamicprogName () {
		String name = "Jan23-NinjaCreators-SDET-" + randomestring();
		return(name);
	}
	
	
	
	public static String Timestamp() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		String timestamp = df.format(new Date());
		return (timestamp);
	}
	
	public static Map<String,String> getDataFromExcel(String SheetName, int Rownumber) throws InvalidFormatException, IOException  {
		ExcelReader excelReader = new ExcelReader();
		Map<String,String> Data = 
				excelReader.getData(Config.EXCEL, SheetName).get(Rownumber);
		return Data;
	}


}
