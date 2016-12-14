<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
%>
<%
// LocaleUtilに切り出してJSP上のロジックは削除済
// Locale objLcl=request.getLocale();
// if(objLcl==null){objLcl=Locale.ENGLISH;}
// ResourceBundle objRb=ResourceBundle.getBundle("item",objLcl);
// または
// ResourceBundle objRb=requestBean.getBundle();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="requestBean" scope="request" class="sample.I18nSampleDataBean" />
<jsp:useBean id="sessionBean" scope="session" class="sample.I18nSampleDataBean" />
<jsp:useBean id="applicationBean" scope="application" class="sample.I18nSampleDataBean" />
<%
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result Jsp</title>
</head>
<body>
<form  method="POST" action="./index.html">
<input type="submit" value="戻る" >
</form>
Messages:<br>
&nbsp&nbsp greeting: <jsp:getProperty name="requestBean" property="greeting" /><br>
&nbsp&nbsp error message: <font color="red"><jsp:getProperty name="requestBean" property="errorMsg" /></font><br>
----------------------------------<br>
Input Contents:<br>
&nbsp&nbsp text: <jsp:getProperty name="requestBean" property="text1" /><br>
&nbsp&nbsp number: <jsp:getProperty name="requestBean" property="number" />
, percentage: <jsp:getProperty name="requestBean" property="percentage" /><br>
&nbsp&nbsp amount: <jsp:getProperty name="requestBean" property="amount" />
, currency: <jsp:getProperty name="requestBean" property="currency" /><br>
----------------------------------<br>
Date:<br>
&nbsp&nbsp SystemDate(java.util.Date()): <jsp:getProperty name="requestBean" property="systemTime" /><br>
----------------------------------<br>
Defined Locale:<br>
&nbsp&nbsp request： <jsp:getProperty name="requestBean" property="language" /><br>
&nbsp&nbsp session： <jsp:getProperty name="sessionBean" property="language" /><br>
&nbsp&nbsp application： <jsp:getProperty name="applicationBean" property="language" /><br>
----------------------------------<br>
Locale Utils(DateFormat, NumberFormat):<br>
&nbsp&nbsp date: <jsp:getProperty name="requestBean" property="date" /><br>
&nbsp&nbsp time(Defined DateFormat): <jsp:getProperty name="requestBean" property="time" /><br>
&nbsp&nbsp time(Defined SimpleDateFormat): <jsp:getProperty name="requestBean" property="sdftime" /><br>
&nbsp&nbsp currency(NumberFormat): <jsp:getProperty name="requestBean" property="currency" /><br>
&nbsp&nbsp percnetage(NumberFormat): <jsp:getProperty name="requestBean" property="percentage" /><br>
----------------------------------<br>
Currency Utils:<br>
&nbsp&nbsp ccyString: <jsp:getProperty name="requestBean" property="ccyString" /><br>
&nbsp&nbsp ccyCode: <jsp:getProperty name="requestBean" property="ccyCode" /><br>
&nbsp&nbsp displayName: <jsp:getProperty name="requestBean" property="displayName" /><br>
&nbsp&nbsp symbol: <jsp:getProperty name="requestBean" property="symbol" /><br>
&nbsp&nbsp fractionDigits: <jsp:getProperty name="requestBean" property="fractionDigits" /><br>
&nbsp&nbsp numericCode: <jsp:getProperty name="requestBean" property="numericCode" /><br>
----------------------------------<br>
Available Locale:(setDefaultで他言語に変わる)<br>
<%
Locale[] locale = requestBean.getLocale();
for (int n = 0; n < locale.length; n++) {
    out.println("&nbsp&nbsp" +
        locale[n].getDisplayLanguage() + ":" + locale[n].getDisplayCountry());
%><br>
<%
}
%>
----------------------------------<br>
Available TimeZone:(setDefaultで他言語に変わる)<br>
<%
String[] tzIDs = requestBean.getTzIDs();
for (int n = 0; n < tzIDs.length; n++) {
    TimeZone tz = TimeZone.getTimeZone(tzIDs[n]);
	out.println("&nbsp&nbsp" +
		tz.getID() + ":" + tz.getDisplayName()); 
%><br>
<%
}
%>
<br>
</body>
</html>