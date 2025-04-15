<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>REST 메모 등록</title>
</head>
<body>
<h2>REST 메모 등록</h2>

<form id="memoForm">
    <label>ID: <input type="number" name="id" /></label><br/>
    <label>내용: <input type="text" name="content" /></label><br/>
    <button type="submit">등록</button>
</form>

<script>
    document.getElementById('memoForm').addEventListener('submit', function(e) {
        e.preventDefault();
        const formData = new FormData(this);
        const data = {
            id: parseInt(formData.get('id')),
            content: formData.get('content')
        };

        fetch('<c:url value="/api/memos"/>', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(res => res.text())
        .then(msg => {
            alert(msg);
            window.location.href = '<c:url value="/api/memos" />';
        });
    });
</script>

</body>
</html>
