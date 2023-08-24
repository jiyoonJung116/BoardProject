<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 상세보기</title>
	<link href="resources/css/NoticeBaordDetail.css?after" rel="stylesheet" >
</head>
<body>
	<div style="width: 1904px;">
		<div class="board_background">
			<div class="fl po_rela">
				<span class="board_font">Board</span>
			</div>
		</div>
		<form action="/noticeUpdate" method="post" accept-charset="UTF-8">
			<input type="hidden" name="loginId" value="${loginId}"/>
			<table>
				<tbody>
					<tr>
						<th class="detail_st1 detail_st2">제목</th>
                    	<td class="detail_st">
	                    	<input type="text" name = "title" class="title_update" value="${detailBoard.title}"/>
	                    	<input type="hidden" name ="bno" value="${detailBoard.bno}">
	                    </td>
		            </tr>
	                <tr>
						<th class="detail_st1 detail_st2">작성자</th>
                   		<td class="writer txtLittle detail_st3">${detailBoard.nickname}</td>
	                </tr>
	                <tr>
						<th class="detail_st1 detail_st2">작성일</th>
                   		<td class="writer txtLittle detail_st3">${detailBoard.writedate}</td>
	                </tr>
	                <tr>
						<th class="detail_st1 detail_st2">조회</th>
                   		<td class="writer txtLittle detail_st3">${detailBoard.hitcount}</td>
	                </tr>
	                <tr class="view">
	                	<th class="detail_st5"></th>
						<td>
	               			<div class="detail">
	               				<textarea name="content" class="update_comment_area">${detailBoard.content}</textarea>
	               			</div>
	                    </td>
	                </tr>
				</tbody>
			</table>
			<input type="submit" class="detail_bt" value="작성완료"/>
			<button id="btn_write" class="detail_bt detail_st4" onclick="window.location.href='${pageContext.request.contextPath}/NoticeBoard'">목록</button>
		</form>	
	</div>
</body>
</html>