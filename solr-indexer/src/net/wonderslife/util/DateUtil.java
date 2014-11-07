package net.wonderslife.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 返回符合Solr需要的日期格式
	 * 
	 * @param sDate
	 *            "yyyy-MM-dd HH:mm:ss"
	 * @return YYYY-MM-DDTHH:SS:MMZ
	 * @throws ParseException
	 */
	public static String extractDateForSolr(String sDate) throws ParseException {
		if (!sDate.equals("") & !sDate.equals("0")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(sDate);
			long ldate = date.getTime();
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(ldate);
			// String time = cal.get(Calendar.YEAR) + "-"
			// + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DATE)
			// + "T" + cal.get(Calendar.HOUR) + ":"
			// + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND)
			// + "Z";
			String time = cal.get(Calendar.YEAR) + "-"
					+ cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DATE)
					+ "T00:00:00Z";
			return time;
		} else {
			return "1950-01-01T00:00:00Z";
		}
	}
}
