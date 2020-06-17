<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="java.util.*" %>
<%@ page import="kr.co.beautifour.domain.PlantsVO" %>
<%@ page import="java.io.*" %>
<%@ page import="net.sf.json.*" %>
 
<%
	List<PlantsVO> plants_li = (List<PlantsVO>)request.getAttribute("result");
    response.setContentType("application/json");
 
    JSONObject obj = new JSONObject();
 
    obj.put("result", plants_li.get(0).getfskName());
    obj.put("result", plants_li.get(0).getfseName());
     
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