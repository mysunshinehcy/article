<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form  action="/second_webapp/servlet/addArtitleServlet" method="post">
<input type="submit" value="发表文章"/>
<table>
<tr>
<td>标题</td>

</tr>
<tr>
<td>
<input name="title"/>
</td>
</tr>
<tr>
<td>
内容
</td>
</tr>
<tr>
<td>
<textarea name="content">
  
</textarea>
</td>
</tr>
</table>

</form>
</body>
</html>