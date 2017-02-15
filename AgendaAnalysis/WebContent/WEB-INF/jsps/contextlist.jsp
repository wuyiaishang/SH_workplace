<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body >
	<div class="container-fluid" align="center">
		<h3>
			The Keyword is
			<c:out value="${keyword}"></c:out>	
		</h3>
		<br>
				<c:forEach var="context" items="${ctList}">
			<p>
				<textarea readonly="readonly" name="message" rows="2" cols="50" >${context}</textarea>
				<a class="twitter-share-button"
					href="https://twitter.com/intent/tweet?text=${context} ${enUrl}">Tweet</a>
			</p>
		</c:forEach>
		<br>
		<a href="${pageContext.request.contextPath}">Continue Searching</a>
	</div>
</body>
</html>