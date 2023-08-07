<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화방</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
 <!-- SWIPER 외부 라이브러리 연결-->
<link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href ='/css/header.css'>
<link rel="stylesheet" type="text/css" href ='/css/footer.css'>
<link rel="stylesheet" type="text/css" href = '<tiles:getAsString name="css"/>'>


<!-- js -->
<script type="text/javascript" src="/js/header.js"></script>


<script src='<tiles:getAsString name="js"/>'></script>


<style type="text/css">
html, body {margin: 0px; padding: 0px;}
body {
  font-family: Arial, sans-serif;
  height: 100%; /* body를 화면 전체 높이로 설정 */
  margin: 0; /* body의 margin을 0으로 설정 */
}

nav {
  width: 250px;
  background-color: #fff;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
  margin-bottom: 0; /* nav의 margin-bottom을 0으로 설정 */
  height: calc(100% - 100px); /* body 높이에서 header와 footer 높이를 뺀 값으로 설정 */
}

</style>


</head>


<body>
<!-- header -->
	<tiles:insertAttribute name="header"/>
	
	
	
<!-- body -->
	<tiles:insertAttribute name="body"/>
	
	

	
<!-- footer -->
	<tiles:insertAttribute name="footer"/>

	



</body>
</html>