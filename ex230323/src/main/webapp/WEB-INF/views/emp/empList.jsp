<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<style>
	table, tr, th, td{
		border:1px solid black;
	}
</style>
</head>
<body>
	<button type="button" onclick="location.href='empInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="emp">
				<tr onclick="location.href='empInfo?employeeId=${emp.employeeId}'">
					<td>${emp.employeeId }</td>
					<td>${emp.firstName }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td><fmt:formatDate value="${emp.hireDate}" pattern="yyyy-MM-dd"/></td>
					<td>${emp.jobId }</td>
					<td>${emp.salary }</td>
					<td><button type="button" onclick="deleteInfo(${emp.employeeId }, event)">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
	
		function printAlert(message) {
			if(message == null ||  message == '') return; 
			alert(message);
		}
		
		printAlert(`${result}`);
		
		function deleteInfo(id, evnet){
			$.ajax({
				url:'empDelete',
				method:'post',
				data: {employeeId : id},
				//dataType: 'json', //html, text, json, xml은 알아서 파싱해줘서 dataType생략가능
				success: function(data) {
					console.log(data);
				},
				error : function(reject){
					console.log(reject);
				}
			});
			event.stopPropagation(); //이벤트 버블링 막는 메소드
			location.reload();
		}
	</script>
</body>
</html>