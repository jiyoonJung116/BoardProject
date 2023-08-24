<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 작성</title>
	<link href="resources/css/NoticeBoardWrite.css?after" rel="stylesheet" >
</head>
<body>
	<div class="write_st_width">
		<div class="board_background">
			<div class="fl po_rela">
				<span class="board_font">Board</span>
			</div>
		</div>
		<form action="/boardWrite" method="post" accept-charset="UTF-8">
		    <input type="hidden" name="loginId" value="${loginId}"/>
		    <table>
		        <tbody>
		            <tr>
		                <th class="detail_st1 detail_st2">제목</th>
		                <td class="detail_st">
		                    <input type="text" name="title" style="width: 1163px; height: 40px;border: 1px solid #c2c2c2;">
		                </td>
		            </tr>
		            <tr class="view">
		                <th class="detail_st1 detail_st2">내용</th>
		                <td class="detail_st">
		                    <textarea name="content" class="board_area"></textarea>
		                </td>
		            </tr>
		        </tbody>
		    </table>
		    <div>
		        <button class="wirte_bt" type="submit">등록</button>
		    </div>
		</form>
	</div>
</body>
</html>