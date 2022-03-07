<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
   $(function(){

	   
   })
   
   function getCon(src){
	   
	   var content = $("#content");
	   content.attr("src",src);
   }
</script>
<style type="text/css">
  
  #menu{
    
    
  }
 #concss{
   position:relative;
   /*float:right;*/
   /*align:center;*/
   top:-50px;
   left:300px;
 }
 
 #content{
 
  width:600px;
  height:100%;
 }
</style>
</head>
<body>

<div id="menu">
  <ul>
  <li>
    模块1
    <ul>
    <li> <a href="javascript:getCon('article/showArticle.jsp');">目录1</a></li>
    <li><a href="javascript:getCon('other/other.jsp');"> 目录2</a></li>
    <li>目录3</li>
    </ul>
  </li>
  <li>
  模块2
  
  </li>
  <li>
  模块3
  
  </li>
  </ul>
  </div>
  <div id="concss">
  <iframe src="article/showArticle.jsp" id="content">
  </iframe>
  </div>
</body>
</html>