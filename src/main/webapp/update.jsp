<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>     
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<h1>修改</h1>
<form  method="post" action="/second_webapp/servlet/updateServlet">
  <table>
  <tr>
  <td>用户名：</td>
  <td><input value="${user.username }"  name="username"/></td>
  </tr>
  <tr>
  <td>密码:</td>
  <td><input value="${user.password }" name="password"/></td>
  <input value="${user.id }" type="hidden" name="id"/>
  </tr>
  <tr>
  <td><input value="修改" type="submit"/></td>
  </tr>
  </table>
  </form>
</body>
</html>