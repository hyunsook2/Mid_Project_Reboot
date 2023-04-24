<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="utils.ManageCookie" %> 
<%
	String loginId=ManageCookie.readCookie(request, "loginId");
	String cookieCheck="";
	if(!loginId.equals("")){
	cookieCheck="checked";		
	}
%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="js/my-login.js"></script>
<style>
html,body {
	height: 100%;
}
body.my-login-page {
	background-color: #f7f9fb;
	font-size: 14px;
}
.my-login-page .brand {
	width: 200px;
	height: 200px;
	margin: auto;
	margin-top: 100px;
}
.my-login-page .brand img {
	width: 100%;
}
.my-login-page .card-wrapper {
	width: 400px;
}
.my-login-page .card {
	border-color: transparent;
	box-shadow: 0 4px 8px rgba(0,0,0,.05);
}
.my-login-page .card.fat {
	padding: 10px;
}
.my-login-page .card .card-title {
	margin-bottom: 30px;
}
.my-login-page .form-control {
	border-width: 2.3px;
}
.my-login-page .form-group {
	margin:10px;
}
.my-login-page .form-group label {
	width: 100%;
}
.my-login-page .btn.btn-block {
	padding: 12px 10px;
	width:300px;
	margin-left:10px;
}
.my-login-page .footer {
	margin: 40px 0;
	color: #888;
	text-align: center;
}
@media screen and (max-width: 425px) {
	.my-login-page .card-wrapper {
		width: 90%;
		margin: 0 auto;
	}
}
@media screen and (max-width: 320px) {
	.my-login-page .card.fat {
		padding: 0;
	}
	.my-login-page .card.fat .card-body {
		padding: 15px;
	}
}
</style>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous" />
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
</head>
<body class="my-login-page">

	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-md-center h-100">
				<div class="card-wrapper">
					<div class="brand">
						<img src="img/RebootLogo.png" alt="logo">
					</div>
					<div class="card fat">
						<div class="card-body">
							<form method="POST" class="my-login-validation" action="../rebootServlet/login.do">
								<div class="form-group">
									<input type="text" class="form-control" name="id" required autofocus placeholder="사번" value="<%=loginId %>" />
								</div>
								<div class="form-group">
									<input type="password" class="form-control" name="pass" required data-eye placeholder="비밀번호"/>
								</div>

								<div class="form-group">
									<div class="custom-checkbox custom-control">
										<input type="checkbox" name="remember" id="remember" class="custom-control-input" value="Y" <%=cookieCheck %>/> 사번저장
									</div>
								</div>

								<div class="form-group m-0">
									<button type="submit" class="btn btn-primary btn-block">
										로그인
									</button>
								</div>
							</form>
						</div>
					</div>
					<div class="footer">
						Copyright &copy; 2023 &mdash; Reboot<br>(문의사항은 관리팀 : 070-7438-3742)
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="js/my-login.js"></script>

</body>
</html>