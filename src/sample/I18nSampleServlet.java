package sample;

import java.io.IOException;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sample.util.LocaleUtil;
import sample.util.CurrencyUtil;

/**
 * Servlet implementation class I18nSampleServlet
 */
public class I18nSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public I18nSampleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "./jsp_result.jsp";
		request.setCharacterEncoding("UTF-8");
		String lang = request.getParameter("language");
		String text1 = request.getParameter("text1");
		String text2 = request.getParameter("text2");
		String text3 = request.getParameter("text3");
		String setDefault = request.getParameter("setDefault");
		
		Double number = 0D;
		Double amount = 0D;
					
		Locale lo = new Locale(lang);
		LocaleUtil loUtil = new LocaleUtil(lo);
		String countryid = loUtil.getItem("locale.country.id");

		//　強引に言語・国でLocaleを上書き
		Locale newLo = new Locale(lang, countryid);
		loUtil = new LocaleUtil(newLo);

		// ServerInstanceを書き換えるようなので、setDefaultは使わないほうがよさそう?
		if (setDefault.equals("on")) {
			Locale.setDefault(lo);
		}
		String systemTime = (new java.util.Date()).toString();
		String errorMsg = null;
		
		try {
			number = Double.parseDouble(text2);
		} catch (NumberFormatException e) {
			errorMsg = loUtil.getItem("error.message");
			// e.printStackTrace();
		}
		try {
			amount = Double.parseDouble(text3);
		} catch (NumberFormatException e) {
			errorMsg = loUtil.getItem("error.message");
			// e.printStackTrace();
		}
		
		
		String greeting = loUtil.getItem("greeting.message");
		String lcurrency = loUtil.convertLocaleCurrency(amount); // 通貨記号は国idが必要
		String ldate = loUtil.convertLocaleDate();
		String ltime = loUtil.convertLocaleTimeZone();
		String lSdftime = loUtil.convertSdfLocaleTimeZone();
		String lpercentatge = loUtil.convertLocalePercentage(number);
		
		//Currencyに渡すロケールは、国が必要
		CurrencyUtil cuUtil = new CurrencyUtil(newLo);
		Currency ccy = cuUtil.getCcy();
		String CcyCode = cuUtil.getCcyCode();
		String DisplayName = cuUtil.getDisplayName();
		String Symbol = cuUtil.getSymbol();
		int fractionDigits = cuUtil.getFractionDigits();
		int numericCode = cuUtil.getNumericCode();
		
		Locale[] allLocale = Locale.getAvailableLocales();
		String[] allTzIDs = TimeZone.getAvailableIDs();
		
		I18nSampleDataBean bean = new I18nSampleDataBean();
		bean.setLanguage(lang);	
		bean.setText1(text1);
		bean.setNumber(number);
		bean.setAmount(amount);
		
		bean.setSystemTime(systemTime);
		
		// LocaleUtil
		bean.setGreeting(greeting);
		bean.setErrorMsg(errorMsg);
		bean.setCurrency(lcurrency);
		bean.setDate(ldate);
		bean.setTime(ltime);
		bean.setSdftime(lSdftime);
		bean.setPercentage(lpercentatge);
		
		// CurrencyUtil
		bean.setCcyString(ccy.toString());
		bean.setCcyCode(CcyCode);
		bean.setDisplayName(DisplayName);
		bean.setSymbol(Symbol);
		bean.setFractionDigits(fractionDigits);
		bean.setNumericCode(numericCode);
		
		bean.setLocale(allLocale);
		bean.setTzIDs(allTzIDs);
		
		//request
		request.setAttribute("requestBean", bean);
		//context
		getServletContext().setAttribute("applicationBean", bean);
		//session
		HttpSession session = request.getSession();
		session.setAttribute("sessionBean", bean);
		
		if (request.getParameter("page").equals("jsp")){
			nextPage = "./jsp_result.jsp";
		} else {
			nextPage = "./jstl_result.jsp";
		}
		RequestDispatcher rDispatcher = request.getRequestDispatcher(nextPage);
		rDispatcher.forward(request, response);
	}

}
