<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attendence</title>
<script type="text/javascript">
function atTime() { //출근
	var currentDate = new Date();
	var hours = currentDate.getHours();
	var minutes = currentDate.getMinutes();
	var seconds = currentDate.getSeconds();
	var timeString = hours + ":" + minutes + ":" + seconds;
	document.getElementById("atTime").innerHTML = timeString;
}
function atTime2() { //퇴근
	var currentDate = new Date();
	var hours = currentDate.getHours();
	var minutes = currentDate.getMinutes();
	var seconds = currentDate.getSeconds();
	var timeString = hours + ":" + minutes + ":" + seconds;
	document.getElementById("atTime2").innerHTML = timeString;
}
</script>
</head>
<body>
	<!--table border="1" width="90%">
		<tr>
			<td>사번</td><td>${dto.id}</td>
			<td>부서명</td><td>${dto.deptn}</td>
			<td>팀원이름</td><td>${dto.name}</td>
			<td>근무일수</td><td>${dto.work_d}</td>
			<td>출근시간</td><td>${dto.start_t}</td>
			<td>퇴근시간</td><td>${dto.id.end_t}</td>
		</tr>
	</table-->
	<button onclick="atTime()">출근</button> <button onclick="atTime2()">퇴근</button>
	<table>
	<tr>
		<td id="atTime">출근시간</td><td>${dto.start_t}</td>
		<td id="atTime2">퇴근시간</td><td>${dto.id.end_t}</td>
	</tr>
	</table>
</body>
</html>