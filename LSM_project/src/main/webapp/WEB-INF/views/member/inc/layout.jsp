<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>


<!-- css 
<link rel="stylesheet" type="text/css" href ='/css/header.css'>
<link rel="stylesheet" type="text/css" href ='/css/footer.css'>
-->
<link rel="stylesheet" type="text/css" href = '<tiles:getAsString name="css"/>'>



<!-- js -->
<script type="text/javascript" src="/js/header.js"></script>

<script src='<tiles:getAsString name="js"/>'></script>



</head>


<body>

	<!-- header 
		<tiles:insertAttribute name="header" />-->
	<!-- body -->
		<tiles:insertAttribute name="body"/>
	<!-- footer 
		<tiles:insertAttribute name="footer"/>-->
</body>
</html>