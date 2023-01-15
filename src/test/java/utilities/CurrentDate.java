package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDate {

	public String getCurrentDate(){
		LocalDateTime now = LocalDateTime.now();  
		//System.out.println("Before Formatting: " + now);  
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		String formatDateTime = now.format(format);
		return formatDateTime;
	}
}
