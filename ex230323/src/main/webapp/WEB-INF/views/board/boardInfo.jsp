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
	<form>
		<div>
			<h3>게시글 상세조회</h3>
		</div>
		<table>
			<tr>
				<th>번호</th>
				<td><input type="number" name="bno" value="${boardInfo.bno}"
					readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${boardInfo.title}"
					readonly /></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"
					value="${boardInfo.writer}" readonly /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents" readonly>${boardInfo.contents}</textarea></td>
			</tr>
			<tr>
				<th>첨부이미지
				<th><c:choose>
						<c:when test="${not empty boardInfo.image }">
							<td><img
								src="<c:url value="/resources/images/${boardInfo.image}"/>"
								style="width: 50%;" alt="이미지" /></td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
			</tr>
			<tr>
				<th>작성일자</th>
				<td><input type="text" name="regdate"
					value="<fmt:formatDate value="${boardInfo.regdate }" pattern="yyyy/MM/dd"/>"
					readonly /></td>
			</tr>

		</table>
		<button type="button"
			onclick="location.href='boardUpdate?bno=${boardInfo.bno}'">수정하러가기</button>
		<button type="button" onclick="location.href='boardDelete?bno=${boardInfo.bno}'">삭제</button>
	</form>
</body>
</html>