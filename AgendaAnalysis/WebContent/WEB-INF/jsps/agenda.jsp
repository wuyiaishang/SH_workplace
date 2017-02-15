<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>PDF Analysis</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container-fluid" align="center">
		<h3>The current related agenda is :</h3>
		<h5><c:out value="${urlInfo['text']}"/></h5>
		<a href="${urlInfo['url']}">Look though the agenda</a>	
		<form method="get"
			action="${pageContext.request.contextPath}/contextlist">
<br>
			<p>
				Input keyword: <input name="keyword" type="text" />
				<input type="submit" value="Apply">
			</p>
		</form>
		
	  
		
	</div>

</body>
</html>