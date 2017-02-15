<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 	hi there! session:
	<%=session.getAttribute("name")%>
	<p>
		request:
		<%=request.getAttribute("name")%>
	<p>EL: ${name}
	<p>
		Using JSTL:
		<c:out value="${name}"></c:out>
	<p>  -->


	<!--  use JSTL get JNDI including DB connecting information 
<sql:query var="rs" dataSource="jdbc/TestDB">
select id, name, email, text from offers
</sql:query>

<c:forEach var="row" items="${rs.rows}">
    Name: ${row.name}<br/>
    Email: ${row.email}<br/>
    Text: ${row.text}<br/>
</c:forEach>

-->

	<!-- using Model class in controller to pass parameters -->
  <p><a href="${pageContext.request.contextPath}/offers">show current offer</a></p>
  <p><a href="${pageContext.request.contextPath}/createoffer">create a new offer</a></p>
	<p>
</body>
</html>