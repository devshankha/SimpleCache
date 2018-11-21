package Cache;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(cal.MINUTE, 5000);
		d = cal.getTime();
		System.out.println(d);
		
	}

}
