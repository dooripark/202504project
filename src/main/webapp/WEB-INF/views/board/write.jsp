<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글쓰기</title>
</head>
<body>
<h2>글쓰기</h2>
<form action="/board/write" method="post">
    제목: <input type="text" name="title"><br><br>
    내용: <textarea name="content" rows="5" cols="40"></textarea><br><br>
    작성자: <input type="text" name="writer"><br><br>
    <input type="submit" value="등록">
</form>
<a href="/board/list">목록으로</a>
</body>
</html>
