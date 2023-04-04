<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록</title>
</head>
<body>
	<form name="insertForm" action="boardInsert" method="post" onsubmit="return false">
	<div>
		<h3>게시글 등록</h3>
	</div>
	<table>
		<tr>
			<th>도서번호</th>
			<td><input type="number" name="bookNo" value=${boardInfo.bno} readonly></td>
		</tr>
		<tr>
			<th>도서명</th> 
			<td><input type="text" name="bookName"/></td>
		</tr>
		<tr>
			<th>도서표지</th>
			<td><input type="text" name="bookCovering"/></td>
		</tr>
		<tr>
			<th>출판일자</th>
			<td><input type="text" name="bookDate"/></td>
		</tr>
		<tr>
			<th>금액<th>
			<td><input type="number" name="bookPrice"/></td>
		</tr>
		<tr>
			<th>출판사<th>
			<td><input type="text" name="bookPublisher"/></td>
		</tr>
		<tr>
			<th>도서소개<th>
			<td><textarea name="bookInfo"></textarea></td>
		</tr>
		</table>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='http://localhost:8081/java/'">조회</button>
	</form>
	
	<script>
		function formOptionChk(){
			let bookName = document.getElementsByName('bookName')[0];
			let writer = document.getElementsByName('writer')[0];
			let contents = document.getElementsByName('contents')[0];
			
			if(title.value==""){
				alert("제목이 입력되지 않았습니다.");
				title.focus();
				return;
			}
			if(writer.value==""){
				alert("작성자가 입력되지 않았습니다.");
				writer.focus();
				return;
			}
			if(contents.value==""){
				alert("내용이 입력되지 않았습니다.");
				contents.focus();
				return;
			}
			
			insertForm.submit();
		}
	
		document.querySelector('button[type="submit"]').addEventListener('click', formOptionChk);
	</script>
</body>
</html>