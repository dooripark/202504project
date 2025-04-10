<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>게시판 목록</title>
</head>
<body>
<h2>게시판 목록</h2>
<a href="/board/write">글쓰기</a>
<table border="1" cellspacing="0" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
    </tr>
    <c:forEach var="board" items="${boards}">
        <tr>
            <td>${board.id}</td>
            <td><a href="/board/detail/${board.id}">${board.title}</a></td>
            <td>${board.writer}</td>
            <td>${board.createdAt}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
