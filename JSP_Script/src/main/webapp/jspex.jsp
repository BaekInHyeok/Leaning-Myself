<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<%--선언태그--%>
		<%!
		int num=10;
		String str="jsp";
		ArrayList<String> list=new ArrayList<String>();
		
		public void jspMethod(){
			System.out.println("--jspMethod");
		}
		
		%>
		<!-- HTML 주석코드 -->
		<%-- JSP 주석코드 --%>
		
		<%--스크립트립 태그 : JSP 페이지에 자바코드를 넣기 위한 태그--%>
		<%if(num>0){%>
		<p>num>0</p>
		<%}
		else{%>
		<p>num<0</p>
		<%} %>
		
		<%--표현식 태그--%>
		num is <%=num %>
		
		<!-- 지시어 -->
		<%@ include file="footer.jsp" %>
	</body>
</html>