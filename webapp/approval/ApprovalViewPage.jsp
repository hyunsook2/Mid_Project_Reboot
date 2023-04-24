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
          <li><a href="../rebootServlet/approvalPage.do" class="menu-item">기안서 작성</a></li>
          <li><a href="../approval/approvalWaitPage.do" class="menu-item">결재대기 문서함</a></li>
          <li><a href="../approval/approvalOkPage.do" class="menu-item">결재완료 문서함</a></li>
          <li><a href="../approval/approvalNoPage.do" class="menu-item">반려 문서함</a></li>
        </ul>
   </div>
   <!-- 로그인정보 -->
     <div class="center-header">
        <h2><a>문서 상세보기</a></h2>
     </div>
     
     <!-- 가운데 -->
     <div class="board">
     	
     	<form id="viewForm" enctype="multipart/form-data" method="post" ><br><br>
     	기안서 번호
		<input type="text" name="idx" value="${dto.idx}" readonly />
		기안서 올릴놈
		<input type="text" name="fromId" value="${dto.id}" readonly />
		
		<input type="text" name="fromName" value="${dto.name}" readonly />
		기안서 받을놈
		<input type="text" name="toId" value="${dto2.id}" readonly />
		
		<input type="text" name="toName" value="${dto2.name}" readonly />
		<br><br>
		상태
		<input type="text" name="state" value="${dto.state}" readonly/><br><br><br>
		부서
		<input type="text" name="deptView" value='<c:choose><c:when test="${dto3.deptn == 0}">인사팀</c:when><c:when test="${dto3.deptn == 1}">시스템팀</c:when><c:when test="${dto3.deptn == 2}">업무팀</c:when><c:otherwise>부서명: 알 수 없는 부서</c:otherwise></c:choose>' readonly />
		<input type="hidden" name="dept" value='${dto3.deptn}' />
		<br><br>
		제목
		<input type="text" name="title" value="${dto.title}" readonly/><br><br><br>
		내용<br>
		<textarea rows="5" cols="100" name="content" readonly>${dto.content}</textarea><br>
		첨부파일
		<input type="file" name="ofile"/><br><br>
				<c:if test="${not empty dto.ofile }">
					${dto.ofile}
					<a href="../approval/download.do?ofile=${dto.ofile }&nfile=${dto.nfile}&idx=${dto.idx}">[다운로드]</a>
				</c:if>
				
		<c:set var="isHidden" value="${dto.state.equals('반려') || dto.state.equals('대기') ? '' : 'display: none;'}" />
		<div style="${isHidden}">
		반려내용<br>
		<c:set var="isHiddenArea" value="${dto3.grade == 0 ? '' : 'readonly'}" />
		<textarea name="companion" cols="70" rows="5" ${isHiddenArea}>${dto.companion}</textarea>
		</div>
		<br><br>
		
		<c:set var="isHiddenBTN" value="${dto.state.equals('대기') ? '' : 'display: none;'}" />
		
		<div style="${isHiddenBTN}">
		<c:set var="hidden" value="${dto3.grade == 0 ? 'submit' : 'hidden'}" />
		<input type="${hidden}" value="반려" onclick="submitNo()"/>
		
		<c:set var="hidden" value="${dto3.grade == 0 ? 'submit' : 'hidden'}"/>
		<input type="${hidden}" value="승인"  onclick="submitOk()"/><br><br>
		</div>
		
	</form>

		<button type="button" onclick="location.href='../approval/approvalWaitPage.do';">대기목록 바로가기</button>
		<button type="button" onclick="location.href='../approval/approvalNoPage.do';">반려목록 바로가기</button>
		<button type="button" onclick="location.href='../approval/approvalOkPage.do';">완료목록 바로가기</button>

     </div>
   <script>
   
   function submitNo() {
		//폼 데이터를 수집하여 반려로 전송하는 로직
	   var confirmResult = confirm("반려하시겠습니까?");
	   if (confirmResult) {
	     document.getElementById("viewForm").action = "../approval/approvalNoPage.do";
	     document.getElementById("viewForm").submit();
	   }
	 }

	 function submitOk() {
	   // 폼 데이터를 수집하여 승인으로 전송하는 로직
	   var confirmResult = confirm("승인하시겠습니까?");
	   if (confirmResult) {
	   document.getElementById("viewForm").action = "../approval/approvalOkPage.do";
	   document.getElementById("viewForm").submit();
	   }
	 }
	 
</script>
</body>
</html>