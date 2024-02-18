<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
</head>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<body>
    <div id="wrap">
        <h1>상세게시글</h1>
        <p>${name}님 환영합니다.</p>
        
        <form action="${contextPath}/editCtrl" method="post">
            <input type="hidden" name="seq" value="${dto.seq}" />
            <fieldset>
                <legend>글내용</legend>
                <table>
                   <tbody>
                        <tr>
                            <th scope="row"><label for="title">제목</label></td>
                            <td>
                                <input type="text" id="title" name="title" value="${dto.title}"/>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">닉네임</th>
                            <td>${dto.nickname}</td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="content">내용</label></th>
                            <td>
                                <textarea name="content" cols="40" rows="10">${dto.content}</textarea>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">등록일</th>
                            <td>${dto.regdate}</td>
                        </tr>
                        <tr>
                            <th scope="row">조회수</th>
                            <td>${dto.cnt}</td>
                        </tr>
                   </tbody>
                </table>                
            </fieldset>
            <p><button>글수정</button></p>
        </form>
        <p>
            <a href="./write.jsp">글등록</a> <br>
            <a href="${contextPath}/deleteCtrl?seq=${dto.seq}">글삭제</a> <br>
            <a href="${contextPath}/listCtrl">글목록</a> <br>       
        </p>
    </div>

</body>
</html>










