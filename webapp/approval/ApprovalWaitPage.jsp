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
        <h2><a>결재대기 문서함</a></h2>
     </div>
     
     <!-- 가운데 -->
     <div class="board">
     <h2>목록 보기</h2>
	<!-- 검색 -->
	<form method="get">
		<table border="1" width="90%">
			<tr>
				<td align="center">
					<select name="searchType">
						<option value="title" <c:if test="${map.searchType=='title'}">selected</c:if>>제목</option>
						<option value="content" <c:if test="${map.searchType=='content'}">selected</c:if>>내용</option>
					</select>
					<input type="search" name="searchStr" value="${map.searchStr }"/>
					<input type="submit" value="검색"/>
				</td>			
			</tr>
		</table>
	</form>
	<!-- 목록 -->
	<table border="1" width="90%">
		<tr>
			<th>상태</th>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>첨부파일</th>
		</tr>
	<c:choose>
		<c:when test="${empty boardList }">
				<tr>
					<td colspan="6" align="center">등록된 게시물이 없습니다.</td>
				</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${boardList }" var="list" varStatus="stat">
			<tr align="center">
				<td>${list.state}</td>
				<td>${map.totalCount-((map.pageNum-1)*map.pageSize)-stat.index}</td>
				<td align="center">
					<a href="../approval/view.do?idx=${list.idx}">${list.title}</a>
				</td>
				<td>${list.name }</td>
				<td>${list.regdate }</td>
				<td>
					<c:if test="${not empty list.ofile }">
						<a href="../approval/download.do?ofile=${list.ofile }&nfile=${list.nfile}&idx=${list.idx}">[${list.ofile}]</a>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</table>
	<table border="1" width="90%">
		<tr align="center">
			<td>
				${map.pagingStr}
			</td>
		</tr>
	</table>
    	
   
 
     </div>
   <script>
 
  
  
</script>
</body>
</html>