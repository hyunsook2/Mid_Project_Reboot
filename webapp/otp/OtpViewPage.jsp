<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reboot</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<style>
.sidebar {
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

.board button {
  position: fixed;
  width:100px;
  height:40px;
  right:400px;
  bottom:60px;   
  color:white;
  border-radius: 5px;
}

#테두리{
border:2px double white;
}

@font-face {
            font-family: 'temp';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/KCC-Ganpan.woff2') format('woff2');
            font-weight: normal;
            font-style: normal;
        }
 .menu-item{font-family: 'temp';  text-shadow: 1px 1px 2px white;}

/* otp 관련 css*/
.container{ /*합칠때 문제생기면 삭제*/
		width : 100%;
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100vh; /*화면크기에 상관없이 가운데 배치 문제있을시 삭제*/
	}
	form{
		display : block;
		position: center;
	}

/*otpviewpage table css*/

	table {
		margin-left : 8%;
	    width: 70%;
	    border-collapse: collapse;
	}

	th, td {
	    border-bottom: 2px solid #444444;
	    padding: 10px;
	}
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
          <li><a href="../JOTP/otp.do" class="menu-item">출근</a></li>
          <li><a href="../JOTP/otpleave.do" class="menu-item">퇴근</a></li>
         <li><a href="../JOTP/CommutionController.do" class="menu-item">근태현황</a></li>
        </ul>
   </div>
   <!-- 로그인정보 -->
     <div class="center-header">
        <h2><a>근태현황</a></h2>
     </div>
     	
     <!-- 가운데 -->
     <div class="board">
     	<c:choose>
   <c:when test="${result==1}">
      <form id="search" method="get">
         <table>
            <tr>
               <td align="center"><select name="searchType">
                     <option value="name" selected="selected">이름</option>
               </select> <input type="search" name="searchStr" value="${map.searchStr}" />
               </td>
            </tr>
         </table>
      </form>
   </c:when>
   </c:choose>
      <table border="1">
         <tr>
            <td>번호</td>
            <td>사번</td>
            <td>부서명</td>
            <td>팀원이름</td>
            <td>날짜</td>
            <td>출근시간</td>
            <td>퇴근시간</td>
            <td>출근상태</td>
         </tr>
         <c:choose>
            <c:when test="${empty dto}">
               <tr>
                  <td colspan="8" align="center">등록된 출근 및 퇴근기록이 없습니다.</td>
               </tr>
            </c:when>
            <c:otherwise>
               <c:forEach var="otp" items="${dto}" varStatus="stat">
                  <tr>
                     <td>${otp.idx}</td>
                     <td>${otp.id}</td>
                     <td><c:choose>
                           <c:when test="${otp.deptn==1 }">
                              <option value="1" selected>업무팀</option>
                           </c:when>
                           <c:when test="${otp.deptn==2}">
                              <option value="2" selected>인사팀</option>
                           </c:when>
                           <c:otherwise>
                              <option value="3" selected>서비스팀</option>
                           </c:otherwise>
                        </c:choose></td>
                     <td>${otp.name}</td>
                     <td>${otp.day_t}</td>
                     <td>${otp.time_s}</td>
                     <td>${otp.time_e}</td>
                     <td><c:choose>
                           <c:when test="${otp.type==0 }">
                              <option value="1" selected>출근</option>
                           </c:when>
                           <c:when test="${otp.type==1}">
                              <option value="2" selected>퇴근</option>
                           </c:when>
                        </c:choose></td>
                     <!--                <td>
                        <button type="button" onclick="location.href='${pageContext.request.contextPath}/otp/remove?idx=${otp.idx}'">삭제</button>
                     </td>  삭제기능 주석-->
                  </tr>
               </c:forEach>
            </c:otherwise>
         </c:choose>
      </table>
      <table border="1" width="90%">
         <tr align="center">
            <td>${map.pagingStr}</td>
      </table>
	</div>
</body>
</html>