package sample.util;

import java.util.Currency;
import java.util.Locale;

public class CurrencyUtil {
	private Currency ccy = null;
	private String CcyCode = null;
	private String DisplayName = null;
	private String Symbol = null;
	private int fractionDigits = 0;
	private int numericCode = 0;
	private Locale lo = null;
	
	public CurrencyUtil(){
	}
	
	public CurrencyUtil(Locale lo){
		setLo(lo);
		try {
			ccy = Currency.getInstance(lo);
		} catch (Exception e) {
			System.out.println("locale: " +lo.toString());
			System.out.println("ccy: " +ccy.toString());
			
			e.printStackTrace();
		}
		convert();
	}
	
	private void convert(){
		CcyCode = ccy.getCurrencyCode();
		fractionDigits = ccy.getDefaultFractionDigits();
		numericCode = ccy.getNumericCode();
		DisplayName = ccy.getDisplayName(lo);
		Symbol = ccy.getDisplayName(lo);
		fractionDigits = ccy.getDefaultFractionDigits();
		numericCode = ccy.getNumericCode();
	}
	
	public Currency getCcy() {
		return ccy;
	}

	public void setCcy(Currency ccy) {
		this.ccy = ccy;
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

	public Locale getLo() {
		return lo;
	}

	public void setLo(Locale lo) {
		this.lo = lo;
	}


}
