<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>i18n Top</title>
</head>
<body>
Default Locale: 
<fmt:formatDate value="<%= new java.util.Date() %>"/> <br> 
Locale ja_JP: 
<fmt:setLocale value="jp_JP"/>
<fmt:formatDate value="<%= new java.util.Date() %>"/> <br>

<fmt:setLocale value="de_DE"/>
Locale de_DE: 
<fmt:formatDate value="<%= new java.util.Date() %>"/> <br> 

<fmt:setLocale value="en_US" scope="session"/>    
Locale en_US: 
<fmt:formatDate value="<%= new java.util.Date() %>"/> <br>     

</body>
</html>