<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="loginId" value="${loginId}"/>
<c:choose>
	<c:when test="${empty loginId }">
		<script>
			alert("로그인부터 하세요");
			location.href="${pageContext.request.contextPath}/";
		</script>
	</c:when>
</c:choose>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 상세보기</title>
	<link href="resources/css/NoticeBaordDetail.css?after" rel="stylesheet" >
	<script src="resources/js/jquery-3.7.0.min.js"></script>
	<script>
		function showReplyForm(commentId) {
		        let replyForm = document.getElementById("replyForm_" + commentId);
		        if (replyForm.style.display === "block") {
		            replyForm.style.display = "none";
		        } else {
		            replyForm.style.display = "block";
		        }
	    }
		$(function() {
			$(".delete_bt, .reply_delete_bt").click(function() {
			    let rno = $(this).parents(".comment_area").attr("rno");
			    let _this = $(this).parents(".comment_area");

			    $.ajax({
			        type: 'delete',  
			        url: '/'+rno,    
			        dataType: 'text', 
			        success: function(data){
			            _this.remove();
			            alert(data); 
			        },
			        error: function (request, status, error) {
			            console.log("code: " + request.status);
			            console.log("message: " + request.responseText);
			            console.log("error: " + error);
			        }
			    });
			});
			
			$(".update_bt").click(function() { // 댓글 수정
			    let content = $(this).parents(".comment_area").find(".comment_content").text();
			    let str = '<div>'
			            + ' <textarea>' + content + '</textarea>'
			            + ' <button class="update_complete_bt">수정완료</button>'
			            + '</div>';
			    $(this).parents(".comment_area").append(str);
			});

			$(document).on("click", ".update_complete_bt", function() { // 댓글 수정
			    let new_content = $(this).prev().val();
			    let rno = $(this).parents(".comment_area").attr("rno");
			    _this = $(this);
			    
			    let commentDto = {
			        rno: rno,
			        content: new_content
			    };
			    
			    $.ajax({
			        type: 'post',
			        url: 'comment/modify/' + rno, 
			        data: JSON.stringify(commentDto),
			        contentType: 'application/json; charset=utf-8',
			        success: function(data) {
			            _this.parents(".comment_area").find(".comment_date").text(data.writedate);
			            _this.parents(".comment_area").find(".comment_content").text(new_content);
			            _this.parent().remove();
			            alert("수정되었습니다.");
			        },
			        error: function(request, status, error) {
			            console.log("code: " + request.status);
			            console.log("message: " + request.responseText);
			            console.log("error: " + error);
			        }
			    });
			});

			$(".reply_update_bt").click(function() {	//대댓글 수정
				let content = $(this).parents(".reply_area").find(".comment_content").text();
				let str = '<div>'
						+ '	<textarea>'+content+'</textarea>'
						+ '	<button class="update_complete_bt">수정완료</button>'
						+ '</div>';
				$(this).parents(".reply_area").append(str);
			});
			
			$(document).on("click", ".update_complete_bt", function() {	//대댓글 수정
				let new_content = $(this).prev().val();
			    let rno = $(this).parents(".comment_area").attr("rno");
			    _this = $(this);
			    
			    let commentDto = {
			        rno: rno,
			        content: new_content
			    };
			    
			    $.ajax({
			        type: 'post',
			        url: 'comment/modify/' + rno, 
			        data: JSON.stringify(commentDto),
			        contentType: 'application/json; charset=utf-8',
			        success: function(data) {
			            _this.parents(".comment_area").find(".comment_date").text(data.writedate);
			            _this.parents(".comment_area").find(".comment_content").text(new_content);
			            _this.parent().remove();
			            alert("수정되었습니다.");
			        },
			        error: function(request, status, error) {
			            console.log("code: " + request.status);
			            console.log("message: " + request.responseText);
			            console.log("error: " + error);
			        }
			    });
			}); 
		});
	</script>
</head>
<body>
	<div style="width: 1904px;">
		<div class="board_background">
			<div class="fl po_rela">
				<span class="board_font">Board</span>
			</div>
		</div>
		<table style="margin-left: 388px;">
			<tbody>
					<tr>
						<th class="detail_st1 detail_st2">제목</th>
                    	<td class="detail_st">${detailBoard.title}</td>
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
	                  			<div>${detailBoard.content}</div>
	               			</div>
	                    </td>
	                </tr>
			</tbody>
		</table>
		<div>
			<button id="btn_write" class="detail_bt detail_st4" onclick="window.location.href='${pageContext.request.contextPath}/NoticeBoard'">목록</button>
			<c:if test="${loginId eq writerId}">
			    <button class="detail_bt" onclick="window.location.href='${pageContext.request.contextPath}/notice_update_form?bno=${bno}'">수정하기</button>
			    <button class="detail_bt" onclick="window.location.href='${pageContext.request.contextPath}/noticeDelete?bno=${bno}'">삭제하기</button>
			</c:if>
		</div>
		<h3 class="detail_st4 comment_area1">댓글</h3>
		<form action="/commentWrite" method="post" class="detail_st7">
				<input type="hidden" name="bno" value="${bno}">
				<input type="hidden" name="writerId" value="${loginId}">
				<input type="hidden" name="nickname" value="${nickname}">
				<span class="comment_write_nick">${nickname}</span>
				<p>
					<textarea class="comment_write_area" rows="5" cols="50" name="content" placeholder="댓글을 입력해주세요"></textarea>
				</p>
				<p>
					<button type="submit" class="detail_bt comment_write_complete">등록</button>
				</p>
		</form> 
		<div>
    		<c:forEach var="dto" items="${listComment}">
	        	<div class="comment_area comment_line" style="width: 500px;" rno="${dto.rno}">
		            <div class="comment_box">
		           	 <c:choose>
		            	<c:when test="${dto.step eq 0}">
			                <input type="hidden" name="rno" value="${dto.rno}">
			                <div class="comment_nick_box">
			                    <div class="comment_nickname detail_st5">${dto.nickname}</div>
			                    <p>
			                        <span class="comment_content detail_st5">${dto.content}</span>
			                    </p>
			                </div>
			                <div>
			                    <span class="comment_date detail_st5 detail_st6" style="color: #dbd3d3;">${dto.writedate}</span>
			                    <button type="button" class="reply_bt" onclick="showReplyForm(${dto.rno})">답글쓰기</button>
			                </div>
				                <c:if test="${loginId eq writerId}">
					                <button class="detail_bt update_bt">수정하기</button>
					                <button class="detail_bt delete_bt">삭제하기</button>
				            	</c:if>
				            	</c:when>
		                <c:when test="${dto.step eq 1}">
		                <!-- 대댓글 -->
				                <div id="replies_${dto.rno}">
				                    <div class="comment_area reply_area reply" style="width: 470px; margin-left: 30px;" rno="${dto.rno}">
				                        <div class="comment_box">
				                            <input type="hidden" name="rno" value="${dto.rno}">
				                            <div class="comment_nick_box">
				                                <div class="comment_nickname detail_st5">${dto.nickname}</div>
				                                <p>
				                                    <span class="comment_content detail_st5">${dto.content}</span>
				                                </p>
				                            </div>
				                            <div>
				                                <span class="comment_date detail_st5 detail_st6" style="color: #dbd3d3;">${dto.writedate}</span>
				                                <!-- 대댓글 수정, 삭제 버튼 -->
				                                <c:if test="${loginId eq writerId}">
									                <button class="detail_bt reply_update_bt">수정하기</button>
									                <button class="detail_bt reply_delete_bt">삭제하기</button>
					            				</c:if>
				                            </div>
				                        </div>
				                    </div>
				            	</div>
			            	</c:when>
			            </c:choose>
		            </div>
		            <form action="/replyWrite" method="post" class="detail_st7" id="replyForm_${dto.rno}" style="display: none; margin-left: 30px;" accept-charset="UTF-8">
		                <input type="hidden" name="rno" value="${dto.rno}">
		                <input type="hidden" name="bno" value="${dto.bno}">
		                <input type="hidden" name="writerId" value="${loginId}">
		                <input type="text" name="content" class="reply_st" id="replyInput_${dto.rno}"  placeholder="대댓글 입력">
		                <button class="detail_bt reply_submit_bt" type="submit">등록</button>
		            </form>
	        	</div>
    		</c:forEach>
		</div>
	</div>
</body>
</html>