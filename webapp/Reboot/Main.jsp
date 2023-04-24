<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="JCalender.MyCalendar" %>
<%@page import="java.util.Date"%>
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

#달력{
margin-right:280px;
}


--캘린더--
/* 기본스타일  */	
	#cal {background-color: #F2F2F2;}
	#cal tr{height: 60px;}
	#cal td{width: 100px; text-align: right; font-size: 15pt; font-family: D2coding;}
/* 타이틀 스타일 */

/* 요일 스타일 */
	#cal td.sunday{ text-align: center; font-weight: bold; color: red; font-family: D2coding; }
	#cal td.saturday{ text-align: center; font-weight: bold; color: blue; font-family: D2coding; }
	#cal td.etcday{ text-align: center; font-weight: bold; color: black; font-family: D2coding; }

/* 날짜 스타일 */
	#cal td.sun{ text-align: right; font-size: 15pt; color: red; font-family: D2coding; vertical-align: top;}
	#cal td.sat{ text-align: right; font-size: 15pt; color: blue; font-family: D2coding; vertical-align: top;}
	#cal td.etc{ text-align: right; font-size: 15pt; color: black; font-family: D2coding; vertical-align: top;}
	
	#cal td.redbefore{ text-align: right; font-size: 12pt; color: red; font-family: D2coding; vertical-align: top;}
	#cal td.before{ text-align: right; font-size: 12pt; color: gray; font-family: D2coding; vertical-align: top;}
	

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
          <li><a class="menu-item">캘린더</a></li>
        </ul>
   </div>
   
   
   <!-- 로그인정보 -->
     <div class="center-header">
        <h2><a id="캘린더">메인 페이지</a></h2>
     </div>
     
     <!-- 가운데 -->
     <div class="board">
      	<%
// 컴퓨터 시스템의 년, 월 받아오기
	Date date = new Date();
	int year = date.getYear() +1900;
	int month = date.getMonth() +1;

	//	오류사항 걸러주기	
	try{
		year = Integer.parseInt(request.getParameter("year"));
		month = Integer.parseInt(request.getParameter("month"));
		
		if(month>=13){
			year++;
			month =1;
		}else if(month <=0){
			year--;
			month =12;
		}
	}catch(Exception e){
		
	}

%>
<!-- 달력 만들기 -->
<div id="달력">
	<table width ="1200px" height="auto" align ="center" border ="4px solid white" cellpadding="5" cellspacing="0" id="cal" >
	<tr border ="4px solid white">
<!-- 이전달 버튼 만들기 -->
		<th>
		<input type="button" value="이전 달" onclick="location.href='?year=<%=year%>&month=<%=month-1%>'">
		</th>
<!-- 제목 만들기 -->
		<th id = "title" colspan = "5" margin-bottom="20px">
		　　　　　　　　　　　　　　　　　　　　　　　　　　　　　<h3 style="font-weight:bold" >　　　　　　　　　　　<%=year%>  <%=month%>월 </h3>
		</th>
			
<!-- 다음달 버튼 만들기 -->
		<th>
		<input type="button" value="다음 달" onclick="location.href='?year=<%=year%>&month=<%=month+1%>'">
		</th>
	</tr>
<!-- 요일 표시칸 만들어주기(단, 토,일요일은 색을 다르게 하기위해 구분해주기) -->
	<tr id="테두리">
		<td class = "sunday" id='테두리'>일</td>
		<td class = "etcday" id='테두리'>월</td>
		<td class = "etcday"  id='테두리'>화</td>
		<td class = "etcday"  id='테두리'>수</td>
		<td class = "etcday" id='테두리'>목</td>
		<td class = "etcday" id='테두리'>금</td>
		<td class = "saturday" id='테두리'>토</td>
	</tr>
	
<!-- 날짜 집어 넣기 -->
	<tr id="테두리">
	<%
//	1일의 요일을 계산한다(자주 쓰이기 때문에 변수로 선언해두기)
		int first = MyCalendar.weekDay(year, month, 1);
	
//	1일이 출력될 위치 전에 전달의 마지막 날짜들을 넣어주기위해 전 달날짜의 시작일을 계산한다.
		int start = 0 ;
		start = month ==1? MyCalendar.lastDay(year-1, 12)- first : MyCalendar.lastDay(year, month-1)- first;

//	1일이 출력될 위치를 맞추기 위해 1일의 요일만큼 반복하여 전달의날짜를 출력한다.
		for(int i= 1; i<= first; i++){
			if(i==1){
/* 일요일(빨간색)과 다른날들의 색을 구별주기  */
				out.println("<td class = 'redbefore' id='테두리'>"+(month ==1? 12 : month-1)+"/"+ ++start +"</td>");
			}else{
				out.println("<td class = 'before' id='테두리'>"+(month ==1? 12 : month-1)+"/"+ ++start +"</td>");
				
			}
		}

/* 1일부터 달력을 출력한 달의 마지막 날짜까지 반복하며 날짜를 출력 */
		for(int i = 1; i <= MyCalendar.lastDay(year, month); i++){
			/* 요일별로 색깔 다르게 해주기위해 td에 class 태그걸어주기 */
			switch(MyCalendar.weekDay(year, month, i)){
				case 0 :
					out.println("<td class ='sun' id='테두리'>" +i +"</td>");
					break;
				case 6 :
					out.println("<td class ='sat' id='테두리'>" +i +"</td>");
					break;
				default :
					out.println("<td class ='etc' id='테두리'>" +i +"</td>");
					break;
			}
			
/* 출력한 날짜(i)가 토요일이고 그달의 마지막 날짜이면 줄을 바꿔주기 */
			if(MyCalendar.weekDay(year, month, i) == 6 && i != MyCalendar.lastDay(year, month)){
				out.println("</tr><tr>");			
			}
		}
		if(MyCalendar.weekDay(year, month, MyCalendar.lastDay(year, month)) !=6){
			for(int i = MyCalendar.weekDay(year, month, MyCalendar.lastDay(year, month))+1; i < 7; i++){
				out.println("<td></td>");	
			}
		}
	%>
	</tr>
</table>
</div>
    </div>
</body>
</html>