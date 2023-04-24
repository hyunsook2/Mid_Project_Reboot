<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="800" height="600" align="center">
		<tr>
			<th colspan="2"><b>상세정보</b></th>
		</tr>
		<tr>
			<td><b>사번 : <input type="text" pattern="[0-9]{6}"
					maxlength="7" value="${dto.id}" disabled /></b></td>
			<td><b>이름 : <input type="text" value="${dto.name}" disabled /></b></td>
		</tr>
		<tr>
			<td><b>입사일 : <input type="date" value="${dto.in_d}" disabled /></b></td>
		</tr>
		<tr>
			<td><b>부서명 : <select name="team" disabled>
						<option value="0" ${dto.deptn == 0 ? 'selected' : ''}>업무팀</option>
						<option value="1" ${dto.deptn == 1 ? 'selected' : ''}>인사팀</option>
						<option value="2" ${dto.deptn == 2 ? 'selected' : ''}>시스템팀</option>
				</select>
			</b></td>
			<td><b>직급 : <select name="grade" disabled>
						<option value="0" ${dto.grade == 0 ? 'selected' : ''}>사원</option>
						<option value="1" ${dto.grade == 1 ? 'selected' : ''}>팀장</option>
						<option value="2" ${dto.grade == 2 ? 'selected' : ''}>사장</option>
				</select>
			</b></td>
		</tr>
		<tr>
			<td><b>생년월일 : <input type="date" value="${dto.bday}"
					disabled /></b></td>
			<td><b>
					<form action="process.jsp" method="post">
						<label for="phone">연락처:</label> <input type="tel" id="phone"
							name="phone" onkeyup="insertHyphen(this)" maxlength="11"
							pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
							placeholder="예)010-1234-5678" value="${dto.pnum}" disabled
							required>
					</form>
			</b></td>
		</tr>
	</table>
</body>
</html>