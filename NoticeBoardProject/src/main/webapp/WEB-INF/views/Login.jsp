<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="msg" value="${msg}"/>
<c:choose>
	<c:when test="${not empty msg }">
		<script>alert("${msg}");</script>
	</c:when>
</c:choose>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<link href="resources/css/NoticeBoardLogin.css" rel="stylesheet" >
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
  	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
	<div class="login-container">
        <h1>로그인</h1>
        <form id="loginForm" action="LoginCheck" method="post">
            <label for="username">아이디:</label>
            <input type="text" id="username" name="id" required>
            <br>
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="pw" required>
            <br>
            <input type="submit" value="로그인">
        </form>
        <div id="naver_id_login" style="margin-top:15px;"></div>
    </div>
    <script type="text/javascript">	//네이버 API 로그인
	  	var naver_id_login = new naver_id_login("HfZiNOJCPUmElEYXkheR", "http://localhost:9090/NoticeBoardProject/Callback");
	  	var state = naver_id_login.getUniqState();
	  	naver_id_login.setButton("white", 2,40);
	  	naver_id_login.setDomain("http://localhost:9090");
	  	naver_id_login.setState(state);
	  	naver_id_login.init_naver_id_login();
  	</script>
</body>
</html>