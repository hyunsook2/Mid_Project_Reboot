<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reboot</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<style>.sidebar {
 background-color:#4169E1;
   height: 100%;
   width: 65px;
   position: fixed;
   top: auto;
   left: auto;
   overflow-x: hidden;
   padding-top: 25px;
   border-right: 4px solid white;
   border-radius: 7px;
   z-index: 0;
}
.sidebar ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

.sidebar ul li a {
  display: flex;
  align-items: center;
  color: black;
  padding: 5px 5px;
  text-decoration: none;
  flex-direction : column;
  margin: 5px 5px;
  background-color: pink;
  border-radius: 5px;
}

.sidebar ul li a img {
  width: 16px;
  height: 16px;
  margin-right: 3px;
}

.sidebar ul li a:hover {
  background-color: white;
  color: black;
}
.sidebar ul li a:active {
  background-color: gray;
  color: white;
}

.sidebar-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 8px 16px;
  background-color: #f2f2f2;
  text-align: center;
  border-bottom: 5px solid white;
}

.sidebar-header h1 {
  font-size: 20px;
  margin: 0;
}

/* 사이드바 2 스타일링 */
.sidebar2 {
  background-color: #21a5b7;
  height: 100%;
  width: 200px;
  position: fixed;
  top: 95px;
  left:64px;
  overflow-x: hidden;
  border-radius: 7px;
}

.sidebar2 ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

.sidebar2 ul li a {
  display: block;
  color: white;
  padding: 8px 16px;
  text-decoration: none;
}


.sidebar2 ul li a:hover {
  background-color: #555;
  color: white;
}
.sidebar2 ul li a:active {
  background-color: gray;
  color: white;
}
.sidebar2 a:active {
  background-color: black;
  color: white;
}
.sidebar2-header {
  height: 100%;
  width: 200px;
  position: fixed;
  top: 0;
  left:64px;
  overflow-x: hidden;
  padding-top: 20px;
  border-bottom: 4px solid white;
 }
 
.sidebar2-header img {
  width: 200px;
  height: 70px;
  margin: 0 auto;
  padding:0;
  margin-right: 8px;
}
.center-header{
  display:block;
  width: 300px;
  height: 60px;
  font-size: 30px;
  margin: 20px 890px;
  text-align: center;
  background-color: #4169E1;
  padding-top: 10px;
  border-radius: 7px;
  font-family: 'temp'; 
  color:white;
}
.center-header a:hover {
  color: white;
}
.center-header a{
  color:white;
}
.board {
  background-color: #8DD9CC;
  height: 100%;
  width:100%;
  position: fixed;
  float:right;
  top: 10%;
  left: 14%;
  overflow-x: hidden;
  padding-top: 20px;
  border-radius: 7px;
}
#테두리{
border:2px double white;
}

.board button {
  position: fixed;
  width:100px;
  height:40px;
  right:400px;
  bottom:60px;   
  color:white;
  border-radius: 5px;
}

@font-face {
            font-family: 'temp';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/KCC-Ganpan.woff2') format('woff2');
            font-weight: normal;
            font-style: normal;
        }
 .menu-item{font-family: 'temp';  text-shadow: 1px 1px 2px white;}

</style>
</head>
<body>
		<div class="sidebar">
		<ul>
			<li>
				<a href="../rebootServlet/myPage.do">
					<img src="http://localhost:8081/reboot/Reboot/img/user.png" alt="메뉴 1">
					<span style="font-size: 9pt;">프로필</span>
				</a>
            </li> 
            <li>
              <a href="../JOTP/otp.do">
                   <img src="http://localhost:8081/reboot/Reboot/img/Attendance.png" alt="메뉴 2">
                   <span style="font-size: 3pt;">근태기록</span>
              </a>
            </li>
            <li>
              <a href="../rebootServlet/approvalPage.do">
                <img src="http://localhost:8081/reboot/Reboot/img/Approval.png" alt="메뉴 3">
                <span style="font-size:3pt;">전자결재</span>
           </a>
            </li>
            <li>
              <a href="../tree/tree.do">
                <img src="http://localhost:8081/reboot/Reboot/img/organization.png" alt="메뉴 4">
                <span style="font-size: 9pt;">조직도</span>
              </a>
            </li>
               <li><a href="../rebootServlet/accountList.do"> <img
                     src="http://localhost:8081/reboot/Reboot/img/Edit.png" alt="메뉴 4">
                     <span style="font-size: 3pt;">계정관리</span>
               </a></li>
           <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <li>
              <a href="../rebootServlet/logout.do">
                <img src="http://localhost:8081/reboot/Reboot/img/logout.png" alt="메뉴 5">
                <span style="font-size: 3pt;">로그아웃</span>
              </a>
            </li>
       </ul>
     </div>
     <!-- 사이드바헤드 이미지 -->
     <div class="sidebar2-header">
        <a href="../rebootServlet/main.do">
          <img style="button" src="http://localhost:8081/reboot/Reboot/img/RebootLogo.png" alt="로고 이미지" >
        </a>
    </div>
	<!-- 사이드바 2 -->
	<div class="sidebar2">
		<ul>
          <li><a href="../rebootServlet/myPage.do?id=${dto.id}" class="menu-item">개인정보 조회</a></li>
          <li><a href="../rebootServlet/editPage.do?id=${dto.id}" class="menu-item">개인정보 수정</a></li>
        </ul>
	</div>
	<!-- 로그인정보 -->
	<div class="center-header">
		<h2>
			<a>개인정보 수정</a>
		</h2>
	</div>

	<!-- 가운데 -->
	<div class="board">
		<br> <br> <br>
		<form action="../rebootServlet/editPage.do" method="post" >
			<table border="1" width="800" height="600" align="center">
				<tr>
					<td><b>사번 : <input type="text" pattern="[0-9]{6}"
							maxlength="7" value="${dto.id}" disabled /></b></td>
					<td><b>이름 : <input type="text" value="${dto.name}"
							disabled /></b></td>
				</tr>
				<tr>
					<td colspan="2"><b>비밀번호 : <input type="password" size="50"
							maxlength="20" name="password" value="${dto.password}" /></b></td>
				</tr>
				<tr>
					<td><b>입사일 : <input type="date" value="${dto.in_d}"
							disabled /></b></td>
				</tr>
				<tr>
					<td><b>부서명 : <select name="team" value="${dto.deptn}"
							disabled>
								<option value="0">업무팀</option>
								<option value="1">인사팀</option>
								<option value="2">시스템팀</option>
						</select></b></td>
					<td><b>직급 : <select name="grade" value="${dto.grade}"
							disabled>
								<option value="a">사원</option>
								<option value="b">팀장</option>
								<option value="c">사장</option>
						</select></b></td>
				</tr>
				<tr>
					<td><b>생년월일 : <input type="date" name="bday"
							value="${dto.bday}" /></b></td>
					<td><b> <label for="phone">연락처:</label> <input type="tel"
							id="phone" onkeyup="insertHyphen(this)"
							maxlength="11"
							placeholder="예)010-1234-5678" name="pnum" value="${dto.pnum}" required>
					</b></td>
				</tr>
				<tr>
					<td colspan="2"><b>주소 : <input type="text" size="80"
							maxlength="50" name="ad" value="${dto.ad}" /></b></td>
				</tr>
			</table>
			<button type="submit" style="background-color: #4169E1">수정하기</button>
		</form>
	</div>

	<script>
  function handleSidebar1Click(index) {
    // query string에 index 값을 추가하여 사이드바2로 전달
    window.location.href = "sidebar2.html?index=" + index;
  }
	document.querySelector("a").addEventListener('click',function(event){
		event.preventDefault();
		console.log("!!");
	    window.location.href = "sidebar2.html?index=" + index;
	})
  // query string에서 index 값을 추출하여 해당하는 메뉴를 활성화
  const queryParams = new URLSearchParams(window.location.search);
  const index = queryParams.get("index");
  if (index !== null) {
    const menuItem = document.querySelectorAll(".sidebar2 .menu-item")[index];
    menuItem.classList.add("active");
  }
  
  /* function insertHyphen(element) {
	  let value = element.value.replace(/-/g, ''); // 기존 하이픈 제거
	  let regex = /^(\d{3})(\d{4})(\d{4})$/; // 정규표현식
	  if (regex.test(value)) {
	    value = value.replace(regex, '$1-$2-$3'); // 하이픈 삽입
	    element.value = value; // 변환된 값으로 업데이트
	  }
	} */
</script>
	<div class="center-header">
		<h2>
			<a href="#" onclick="handleSidebar1click(4)">메인페이지</a>
		</h2>
	</div>

</body>
</html>