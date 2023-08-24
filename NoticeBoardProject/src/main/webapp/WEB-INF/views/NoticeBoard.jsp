<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="resources/js/jquery-3.7.0.min.js"></script>
	<link href="resources/css/NoticeBoard.css?after" rel="stylesheet" >
	<script>
		let page_requested = 1;
		function request_one_page(){	//무한스크롤
			page_requested +=1;
			$.ajax({
				type : 'get',
				url : 'InfiniteScroller',
				data : { 'pageNum': page_requested },
				dataType : 'json',
				success: function(data){
					for(var i = 0; i<=data.length-1; i++){
						let str = "<tr>"
						         +"<td class=\"bno\">"+data[i].bno+"</td>"
						         +"<td>"+data[i].title+"</td>"
						         +"<td class=\"nickname\">"+data[i].nickname+"</td>"
						         +"<td>"+data[i].writedate+"</td>"
						         +"<td>"+data[i].hitcount+"</td>"
						         +"</tr>";
						$("#board_table").append(str);
						$("tr").click(function() {
							let bno = $(this).find(".bno").text();
							location.href = "${pageContext.request.contextPath}/boardDetail?bno=" + bno + "&nickname=" + nickname;
						});
					}
				},
				error: function (request, status, error) {
			        console.log("code: " + request.status)
			        console.log("message: " + request.responseText)
			        console.log("error: " + error);
			    }
			});
		}
		
		$(function(){
			$("#searchButton").click(function() {	//검색 ajax
				  var searchKeyword = $("#searchWord").val();
		
				  $.ajax({
						type : 'get',
						url : 'SearchKeyword',
						data : { 'searchKeyword': searchKeyword },
						dataType : 'json',
						success: function(data){
							console.log(data);
							$("#board_table").html('<tr>'
										+ '	<th class="notice_width2">번호</th>'
										+ '	<th class="notice_width">제목</th>'
										+ '	<th class="notice_width1">작성자</th>'
										+ '	<th class="notice_width3">작성일시</th>'
										+ '	<th>조회수</th>'
										+ '</tr>');
							
							for(var i = 0; i<=data.length-1; i++) {
								let str = "<tr>"
							         +"<td class=\"bno\">"+data[i].bno+"</td>"
							         +"<td>"+data[i].title+"</td>"
							         +"<td class=\"nickname\">"+data[i].nickname+"</td>"
							         +"<td>"+data[i].writedate+"</td>"
							         +"<td>"+data[i].hitcount+"</td>"
							         +"</tr>";
								$("#board_table").append(str);
								$("tr").click(function() {
									let bno = $(this).find(".bno").text();
									let nickname = $(this).find(".nickname").text();
									location.href = "${pageContext.request.contextPath}/boardDetail?bno=" + bno + "&nickname=" + nickname;
								});
							}
						},
						error: function (request, status, error) {
					        console.log("code: " + request.status)
					        console.log("message: " + request.responseText)
					        console.log("error: " + error);
					    }
					});				
			});  
			$(window).scroll(function(){
				  var scrT = $(window).scrollTop();
				  console.log(scrT); 
				  if(scrT == $(document).height() - $(window).height()){
				  	request_one_page();
				  } 
			}); 
			$("tr").click(function() {	//게시글 상세보기
				  let bno = $(this).find(".bno").text();
				  let nickname = $(this).find(".nickname").text();
				  location.href = "${pageContext.request.contextPath}/boardDetail?bno=" + bno + "&nickname=" + nickname;
			});
			$(".write_bt").click(function(){	//글쓰기
				location.href = "${pageContext.request.contextPath}/board_write";
			});
			$(".join_bt").click(function(){		//회원가입
				location.href = "${pageContext.request.contextPath}/join";
			});
			$(".login_bt").click(function(){	//로그인
				location.href = "${pageContext.request.contextPath}/login";
			});
			$(".logout_bt").click(function(){ // 로그아웃
                location.href = "${pageContext.request.contextPath}/logout";
            });
		});
	</script>
</head>
<body>
	<div id="searchResults">
		<div class="board_background">
			<div class="fl po_rela">
				<span class="board_font">Board</span>
			</div>
			  <div class="notice_st">
			    <input type="text" class="input_border form-control" placeholder="Search" name="searchWord" id="searchWord" />
			  	<button class="notice_st1 notice_bt1" type="button" id="searchButton">
			    	<span>검색</span>
			  	</button>
			  </div>
		</div>
		<div class="board_background1">
			<div class="fr po_rela">
				<% if (session.getAttribute("loginId") != null) { %> 
			        <button type="button" class="notice_bt logout_bt">로그아웃</button>
			        <button type="button" class="notice_bt write_bt">글쓰기</button>
    			 <% } else { %> 
			        <button type="button" class="notice_bt login_bt">로그인</button>
			        <button type="button" class="notice_bt join_bt">회원가입</button>
    			 <% } %> 
			</div>
		</div> 
		<div style="height : 100%">
			<table id="board_table" class="po_rela notice_location">
				<tr>
					<th class="notice_width2">번호</th>
					<th class="notice_width">제목</th>
					<th class="notice_width1">작성자</th>
					<th class="notice_width3">작성일시</th>
					<th class="notice_width5">조회수</th>
				</tr>
				<c:forEach var="dto" items="${listBoard }">
					<tr>
						<td class="bno">${dto.bno}</td>
						<td>${dto.title}</td>
						<td class="nickname">${dto.nickname}</td>
						<td>${dto.writedate}</td>
						<td>${dto.hitcount}</td>
					</tr>
				</c:forEach>
			</table>
		</div> 
	</div>
</body>
</html>
