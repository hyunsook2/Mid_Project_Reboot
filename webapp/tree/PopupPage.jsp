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
			<th colspan="2"><b>������</b></th>
		</tr>
		<tr>
			<td><b>��� : <input type="text" pattern="[0-9]{6}"
					maxlength="7" value="${dto.id}" disabled /></b></td>
			<td><b>�̸� : <input type="text" value="${dto.name}" disabled /></b></td>
		</tr>
		<tr>
			<td><b>�Ի��� : <input type="date" value="${dto.in_d}" disabled /></b></td>
		</tr>
		<tr>
			<td><b>�μ��� : <select name="team" disabled>
						<option value="0" ${dto.deptn == 0 ? 'selected' : ''}>������</option>
						<option value="1" ${dto.deptn == 1 ? 'selected' : ''}>�λ���</option>
						<option value="2" ${dto.deptn == 2 ? 'selected' : ''}>�ý�����</option>
				</select>
			</b></td>
			<td><b>���� : <select name="grade" disabled>
						<option value="0" ${dto.grade == 0 ? 'selected' : ''}>���</option>
						<option value="1" ${dto.grade == 1 ? 'selected' : ''}>����</option>
						<option value="2" ${dto.grade == 2 ? 'selected' : ''}>����</option>
				</select>
			</b></td>
		</tr>
		<tr>
			<td><b>������� : <input type="date" value="${dto.bday}"
					disabled /></b></td>
			<td><b>
					<form action="process.jsp" method="post">
						<label for="phone">����ó:</label> <input type="tel" id="phone"
							name="phone" onkeyup="insertHyphen(this)" maxlength="11"
							pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
							placeholder="��)010-1234-5678" value="${dto.pnum}" disabled
							required>
					</form>
			</b></td>
		</tr>
	</table>
</body>
</html>