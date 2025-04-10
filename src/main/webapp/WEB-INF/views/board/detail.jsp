<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 상세보기</title>
</head>
<body>
<h2>글 상세보기</h2>
<p><strong>제목:</strong> ${board.title}</p>
<p><strong>내용:</strong> ${board.content}</p>
<p><strong>작성자:</strong> ${board.writer}</p>
<p><strong>작성일:</strong> ${board.createdAt}</p>

<!-- 수정폼 -->
<form action="/board/update" method="post">
    <input type="hidden" name="id" value="${board.id}">
    <input type="hidden" name="writer" value="${board.writer}">
    제목: <input type="text" name="title" value="${board.title}"><br><br>
    내용: <textarea name="content" rows="5" cols="40">${board.content}</textarea><br><br>
    <input type="submit" value="수정">
</form>

<!-- 삭제 버튼 -->
<form action="/board/delete/${board.id}" method="post" style="margin-top:10px;">
    <input type="submit" value="삭제">
</form>

<a href="/board/list">목록으로</a>
</body>
</html>
