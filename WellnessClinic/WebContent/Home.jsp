<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Medi Care</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css">
	<link href="<c:url value="http://fonts.googleapis.com/css?family=Montserrat:400,700%&CPT+Serif:400,700,400italic" />" rel="Stylesheet">
	<link href="<c:url value="http://fonts.googleapis.com/css?family=Montserrat|Open+Sans" />" rel="Stylesheet">
	<style>
	*{
	margin:0px;
	padding:0px;
		
}

.bgimage{
 	background-image: url("pic6.jpg");
    background-size: 100% 100%;
	width:100%;
	height:100vh;
	background-size: 100% 100%;
	width:100%;
	height:100vh;
	
}



body {
    background-image: url("pic6.jpg");
}

.menu{
	
	width: 100%;
	height: 100px;
	background-color: lightblue;
		
}

.leftmenu{
	width:25%;
	line-height: 100px;
	float:left;
}

.leftmenu h4{
	
	padding-left: 70px;
	line-height: 100px;
	font-weight:bold;
	color:white;
	font-size: 22px;
	font-family: 'Open Sans' , sans-serif;
}

.rightmenu{
	width:75%;
	height :100px;
	float:right;
	/* background-color:red;  */
}

.rightmenu ul{
	margin-left: 250px;
}


.rightmenu ul li {
	font-family:'Montserrat',sans-serif;
	display: inline-block;
	list-style: none;
	font-size:15px;
	color:white;
	font-weight:bold;
	line-height: 100px;
	margin-left:40px;
    text-transform: uppercase;	
}

#firstlist
{
	color:white
} 

.rightmenu ul li:hover
{
  background-color: orange;
}

.text{
	width:100%;
	margin-top: 185px;
	text-transform:uppercase;
	text-align: center:
	color:white;
	
}

.text h4 {
	font-size: 14px;
	font-family:'Open Sans',sans-serif;
	margin-left:500px;
	color:white;
}

.text h1{
	font-size:62px;
	font-family: 'Montserrat', sans-serif;
	font-weight:700px;
	margin: 14px 0px 30px 30px;
	margin-left:120px;
	color:white;
}

#care{
	font-size:50px;
	font-family: 'Montserrat', sans-serif;
	font-weight:700px;
	margin: 14px 0px 30px 30px;
	margin-left:250px;
	color:orange;
	
}

#likebutton{
	background-color:white;
	border:none;
	font-size: 12px;
	font-weight:bold;
	text-transform: uppercase;
	line-height: 40px;
	width: 150px;
	font-family: 'Montserrat', sans-serif;
	margin-top: 15px;
	border: 3px solid white;
	margin-left:400px;
}

#subscribebutton{
	border-color:transparent;
	border:none;
	font-family: 'Montserrat', sans-serif;
	font-weight:bold;
	line-height: 40px;
	border: 3px solid white;
	width:150px;
	}
	

</style>
	
	</head>
	
	<body>
	
	<div class="bgimage">
	
	<div class="menu">
	
		<div class="leftmenu">
		<h4> Medi Care </h4>
		</div>
		
		<div class="rightmenu">
			<ul>
				<li id="firstlist" ><a href="Home.jsp" style="text-decoration:none"> Home</a> </li>
				<li> Services </li>
				<li> Works </li>
				<li> About us </li>
				<li> Blog </li>
				<li> Contact </li>
				<li><a href="login.jsp" style="text-decoration:none"> Login</a> </li>
			</ul>
		</div>
		
		</div>
		
		<div class ="text">
		
			<h4 id="care"> WE CARE FOR YOUR HEALTH </h4>
			<h1> Entrust your health our doctors <h1>
			
			<button id="likebutton" ><a style="text-decoration:none" href="https://www.facebook.com/medicare/?hc_ref=ARSGaUYjPBJvOG7tGBZmx-LX8ZUuS87HbbGwq_rcGO6Lj8oftWJ6O4L2JdXLC0tf6f8&fref=nf&__xts__%5B0%5D=68.ARBKa3d6MIolpI1qhARe0GSk29dwf6K0yMfEms2_48zpAhbDNnMc47aQG6Eb0-_YiNzyzKBBkH3uxSxaTZXdyWRLyBc-UQnCkGlDE2Sssd_SKyr2nIbw_kcEeBgU1RWaz9mtmJOamQQkv9PqEs903tv5CYUcCeOSn5WZg77F0gvwnbLd2YPusCW9HRuc3VyVXU3w4_HufDG1fyhMcsdtOm9gKrPEjnj_VEsVLZPupfe_t6yzzaNIKdjeJHrauvaDYGolThKlGhrayqzOfeuVV5ZOrBvpfGwNfT7OioTSWZnx7dewF3FGB3YIyJwuNSVD9zU4dFkqtdzdf7dnxv2FT09EPA&__tn__=kC-R" target="_blank"> like share</a> </button>
			<button id="subscribebutton" ><a style="text-decoration:none" href="https://www.youtube.com/channel/UCttfJcDqkWJAORC6ZJWiIIg" target="_blank" > SUBSCRIBE </a> </button>
		
		</div>
		
	
	</div>
	
	 <footer class="page-footer font-small blue">

        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">© 2019 Copyright:
          <a> The Three Musketeers</a>
        </div>
        <!-- Copyright -->
      
      </footer>
	
	</body>
	
</html>