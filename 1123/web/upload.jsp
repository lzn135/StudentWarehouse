<%--
  Created by IntelliJ IDEA.
  User: 罗振宁
  Date: 2020/11/23
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">

    <input type="file" name="upload"><br>

    <input type="submit" value="上传">、

</form>


</form>
</body>
</html>
