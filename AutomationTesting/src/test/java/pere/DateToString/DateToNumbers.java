package pere.DateToString;

import java.util.Calendar;

public class DateToNumbers {
	public String returnDateAsNumber() {

		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH)); // 0 to 11
		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		String hour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
		String minute = String.valueOf(cal.get(Calendar.MINUTE));
		String second = String.valueOf(cal.get(Calendar.SECOND));
		String currentTimeInString = year + month + day + hour + minute + second;
		return currentTimeInString;
	}
	
	
}//
