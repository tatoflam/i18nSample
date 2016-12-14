<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.*"
 %>
<!-- 指定はuri="http://java.sun.com/jstl/"でなく"http://java.sun.com/jsp/jstl/である必要がある模様 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="requestBean" scope="request" class="sample.I18nSampleDataBean" />
<jsp:useBean id="sessionBean" scope="session" class="sample.I18nSampleDataBean" />
<jsp:useBean id="applicationBean" scope="application" class="sample.I18nSampleDataBean" />

<fmt:setLocale value="${requestBean.language}" />
<fmt:bundle basename="item" >

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result Jsp</title>
</head>
<body>
<form  method="POST" action="./index.html">
<input type="submit" value="戻る" >
</form>
Messages:<br>
&nbsp&nbsp greeting(c:out from requestBean): <c:out value="${requestBean.greeting}" /><br>
&nbsp&nbsp greeting(fmt:message): <fmt:message key="greeting.message" /><br>
&nbsp&nbsp errorMsg(c:out from requestBean): <font color="red"><c:out value="${requestBean.errorMsg}" /></font><br>
----------------------------------<br>
Input Contents:<br>
&nbsp&nbsp text1: <c:out value="${requestBean.text1}" /><br>
&nbsp&nbsp number: <c:out value="${requestBean.number}" /> Percentage: <c:out value="${requestBean.percentage}" /><br>
&nbsp&nbsp amount: <c:out value="${requestBean.amount}" /> Currency: <c:out value="${requestBean.currency}" /><br>
----------------------------------<br>
Date:<br>
&nbsp&nbsp SystemTime(java.util.Date()): <c:out value="${requestBean.systemTime}" /><br>
----------------------------------<br>
Defined Locale:<br>
&nbsp&nbsp request： <c:out value="${requestBean.language}" /><br>
&nbsp&nbsp session： <c:out value="${sessionBean.language}" /><br>
&nbsp&nbsp application： <c:out value="${applicationBean.language}" /><br>
----------------------------------<br>
Locale Utils(DateFormat, NumberFormat):<br>
&nbsp&nbsp date: <c:out value="${requestBean.date}" /><br>
&nbsp&nbsp time(Defined DateFormat): <c:out value="${requestBean.time}" /><br>
&nbsp&nbsp time(Defined SimpleDateFormat): <c:out value="${requestBean.sdftime}" /><br>
&nbsp&nbsp currency(NumberFormat): <c:out value="${requestBean.currency}" /><br>
&nbsp&nbsp percnetage(NumberFormat): <c:out value="${requestBean.percentage}" /><br>
----------------------------------<br>
Currency Utils:<br>
&nbsp&nbsp ccyString: <c:out value="${requestBean.ccyString}" /><br>
&nbsp&nbsp ccyCode: <c:out value="${requestBean.ccyCode}" /><br>
&nbsp&nbsp displayName: <c:out value="${requestBean.displayName}" /><br>
&nbsp&nbsp symbol: <c:out value="${requestBean.symbol}" /><br>
&nbsp&nbsp fractionDigits: <c:out value="${requestBean.fractionDigits}" /><br>
&nbsp&nbsp numericCode: <c:out value="${requestBean.numericCode}" /><br>
----------------------------------<br>
Available Locale:(setDefaultすると、指定の言語に変わる)<br>
<%
Locale[] locale = requestBean.getLocale();
for (int n = 0; n < locale.length; n++) {
    out.println("&nbsp&nbsp" +
        locale[n].getDisplayLanguage() + ":" + locale[n].getDisplayCountry());
%><br>
<%
}
%>
<!-- 以下のような書き方はできません（Bean側でIteratorにしてないため） 
<c:forEach var="loc" items="${reqestBean.locale}">
<c:out value="${loc}"/><br>
</c:forEach>
-->
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
<!-- 以下のような書き方はできません（Bean側でIteratorにしてないため） 
<c:forEach var="tzone" items="${reqestBean.tzIDs}">
<c:out value="${tzone}"/><br>
</c:forEach>
 -->
<br>
</body>
</fmt:bundle>
</html>