package utilities;

import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CurrentDate {

	public String getCurrentDate(){
		/*
		LocalDateTime now = LocalDateTime.now();  
		//System.out.println("Before Formatting: " + now);  
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		String formatDateTime = now.format(format);
		return formatDateTime;
		*/
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		String timestamp = df.format(new Date());
		return (timestamp);
	}
}
