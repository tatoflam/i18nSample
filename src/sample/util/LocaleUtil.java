package sample.util;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class LocaleUtil {
//	static LocaleUtil loUtil = null;
	private Locale lo = null;
	private ResourceBundle bundle = null; 	
	private String localeDate = null;
	private String localeTimeZone = null;
	private String localeCurrency = null;
	private String localePercentage = null;
	
/* クライアント/セッションごとにnewするべき
	public synchronized static LocaleUtil getInstance(){
		if (loUtil == null) {
			loUtil = new LocaleUtil();
		}
		return loUtil;
	}
*/
	public LocaleUtil(){	
	}
	
	public LocaleUtil(Locale lo) {
		setLo(lo);
		bundle = ResourceBundle.getBundle("item" , lo);
	}
	
	public String getItem(String key){
		return bundle.getString(key);
	}
	
	public String convertLocaleDate(){
		localeDate = DateFormat.getDateTimeInstance(
				DateFormat.FULL,
				DateFormat.FULL,
				lo).format(new Date());
		return localeDate;
	}
	
	public String convertLocaleTimeZone(){
		Calendar calender = Calendar.getInstance(lo);
		DateFormat df = DateFormat.getDateTimeInstance(
				DateFormat.FULL,
				DateFormat.FULL,
				lo);
		df.setTimeZone(TimeZone.getTimeZone(bundle.getString("timezone.id")));
		localeTimeZone = df.format(calender.getTime());
		return localeTimeZone;
	}

	public String convertSdfLocaleTimeZone(){
		Calendar calender = Calendar.getInstance(lo);
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS z", lo);
		df.setTimeZone(TimeZone.getTimeZone(bundle.getString("timezone.id")));
		localeTimeZone = df.format(calender.getTime());
		return localeTimeZone;
	}
	
	public String convertLocaleCurrency(Double number){
		NumberFormat nft = NumberFormat.getCurrencyInstance(lo);
		localeCurrency = nft.format(number);
		return localeCurrency;
	}
	
	public String convertLocalePercentage(Double number){
		NumberFormat nft = NumberFormat.getPercentInstance(lo);
		localePercentage = nft.format(number);
		return localePercentage;
	}
	
	public Locale getLo() {
		return lo;
	}

	public void setLo(Locale lo) {
		this.lo = lo;
	}
}
