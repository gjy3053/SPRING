<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="updateForm" action="boardUpdate" method="post"
		onsubmit="return false">
		<div>
			<h3>게시글 수정</h3>
		</div>
		<table>
			<tr>
				<th>번호</th>
				<td><input type="number" name="bno" value="${boardInfo.bno}"
					readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${boardInfo.title}" /></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"
					value="${boardInfo.writer}" readonly /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${boardInfo.contents}</textarea></td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td><input type="text" name="image"
					value="${boardInfo.image}"/></td>
			</tr>
			<tr>
				<th>수정날짜
				<td><input type="date" name="updatedate" /></td>
			</tr>
		</table>
		<button type="submit">수정완료</button>
		<button type="button" onclick="location.href='getBoardInfo?bno=${boardInfo.bno}'">수정취소</button>
	</form>

	<script>
		function formOptionChk() {
			let title = document.getElementsByName('title')[0];
			let contents = document.getElementsByName('contents')[0];

			if (title.value == "") {
				alert("제목이 입력되지 않았습니다.");
				title.focus();
				return;
			}
			if (contents.value == "") {
				alert("내용이 입력되지 않았습니다.");
				contents.focus();
				return;
			}

			updateForm.submit();
		}

		document.querySelector('button[type="submit"]').addEventListener(
				'click', formOptionChk);
	</script>
</body>
</html>