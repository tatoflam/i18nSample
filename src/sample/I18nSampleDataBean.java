package sample;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nSampleDataBean {
	private String language = null;
	private ResourceBundle bundle;
	private Locale[] locale;
	private String[] tzIDs;
	
	private String systemTime;
	private String time;
	private String sdftime;
	private String text1;
	private Double number;
	private Double amount;
	private String greeting;
	private String errorMsg;
	private String currency;
	private String date;
	private String percentage;
	
	private String ccyString = null;
	private String CcyCode = null;
	private String DisplayName = null;
	private String Symbol = null;
	private int fractionDigits = 0;
	private int numericCode = 0;
	
	
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String lang) {
		this.language = lang;
	}

	public ResourceBundle getBundle() {
		return this.bundle;
	}

	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	public Locale[] getLocale() {
		return locale;
	}

	public void setLocale(Locale[] locale) {
		this.locale = locale;
	}

	public String[] getTzIDs() {
		return tzIDs;
	}

	public void setTzIDs(String[] tzIDs) {
		this.tzIDs = tzIDs;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	public String getSdftime() {
		return sdftime;
	}

	public void setSdftime(String sdftime) {
		this.sdftime = sdftime;
	}

	public String getCcyString() {
		return ccyString;
	}

	public void setCcyString(String ccy) {
		this.ccyString = ccy;
	}

	public String getCcyCode() {
		return CcyCode;
	}

	public void setCcyCode(String ccyCode) {
		CcyCode = ccyCode;
	}

	public String getDisplayName() {
		return DisplayName;
	}

	public void setDisplayName(String displayName) {
		DisplayName = displayName;
	}

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public int getFractionDigits() {
		return fractionDigits;
	}

	public void setFractionDigits(int fractionDigits) {
		this.fractionDigits = fractionDigits;
	}

	public int getNumericCode() {
		return numericCode;
	}

	public void setNumericCode(int numericCode) {
		this.numericCode = numericCode;
	}

	public String getSystemTime() {
		return systemTime;
	}

	public void setSystemTime(String systemTime) {
		this.systemTime = systemTime;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
