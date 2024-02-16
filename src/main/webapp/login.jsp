<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
	</head>

	<body>
		<div id="wrap">
	        <!-- http://localhost:8090/jsp_mvc2/loginCtrl -->
	        <form action="${pageContext.request.contextPath}/loginCtrl" method="post">
				<fieldset>
					<legend>정보입력</legend>
					<ul>
						<li>
							<label for="userid">아이디</label>
							<input type="text" id="userid" name="userid" value="duly" />
						</li>
						<li>
							<label for="userpw">비밀번호</label>
							<input type="text" id="userpw" name="userpw" value="1234" />
						</li>
					</ul>
				</fieldset>
				<p><button>로그인</button></p>
			</form>
		</div>
	</body>

	</html>