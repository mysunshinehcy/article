<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>   
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>

</head>
<body>
<h1>展示用户信息</h1>
<a href="/second_webapp/login.html">退出</a>
<table>
<tr>
<td>用户名</td>
<td>密码</td>
<td>操作</td>
</tr>
<c:forEach var="user" items="${users }">
  <td>
  ${user.username }
  </td>
  <td>${user.password }</td>
  <td>
  <form method="post" action="/second_webapp/servlet/showSingleServlet">
  <input type="hidden" name="id" value="${user.id }"/>
  <input  value="修改" type="submit"/>
  </form>
 </td>
 
  <td>
    <form method="post" action="/second_webapp/servlet/deleteServlet">
  <input type="hidden" name="id" value="${user.id }"/>
  <input type="submit"  value="删除"/>
  </form>
  </td>
  <tr>
  <td></td>
  </tr>
</c:forEach>
</table>
</body>
</html>