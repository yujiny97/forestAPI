<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="net.sf.json.*" %>
 
<%
	request.getAttribute("");
    response.setContentType("application/json");
 
    JSONObject obj = new JSONObject();
 
    obj.put("status", "true");
    obj.put("message", "json출력 성공!");
     
    response.getWriter().write(obj.toString());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>