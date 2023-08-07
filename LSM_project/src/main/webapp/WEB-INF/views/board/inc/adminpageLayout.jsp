<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화방</title>
<style type="text/css">
	html, body {margin: 0px; padding: 0px;}
</style>

<!-- jquery -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
 <!-- SWIPER 외부 라이브러리 연결-->
<link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href ='/css/header.css'>
<link rel="stylesheet" type="text/css" href ='/css/footer.css'>
<link rel="stylesheet" type="text/css" href = '<tiles:getAsString name="css"/>'>

<link rel="stylesheet" type="text/css" href = '<tiles:getAsString name="contentcss"/>'>
<link rel="stylesheet" type="text/css" href = '/mypagecss/myProfile.css'>

<!-- js -->
<script type="text/javascript" src="/js/header.js"></script>
<script src='<tiles:getAsString name="js"/>'></script>
<script src='<tiles:getAsString name="contentjs"/>'></script>
</head>


<body>
<!-- header -->
	<tiles:insertAttribute name="header"/>
	
	
	
<!-- body -->
	<tiles:insertAttribute name="body"/>
	
	
	<!-- content -->
	<tiles:insertAttribute name="content" ignore="true"/>
	
	
<!-- footer -->
	<tiles:insertAttribute name="footer"/>

</body>
</html>