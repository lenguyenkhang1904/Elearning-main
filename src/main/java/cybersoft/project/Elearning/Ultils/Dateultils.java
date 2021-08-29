package cybersoft.project.Elearning.Ultils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dateultils {
	public static final String DATE_FORMAT= "yyyy-MM-dd HH:mm:ss";
	public static  DateTimeFormatter format =DateTimeFormatter.ofPattern(DATE_FORMAT);
//@formatter:on
	public static String toString(LocalDateTime date)
	{
		return date.format(format);
	}
	public static LocalDateTime toDate(String date)
	{
		return LocalDateTime.parse(date,format);
	}

}
