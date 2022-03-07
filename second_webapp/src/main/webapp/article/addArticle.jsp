<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">


    function publish(){
    
      console.log("aaasss");
      
     var uidG = 0;
     
     $.ajax({
       type:"post",
       url:"http://localhost:8080/second_webapp/servlet/userServlet",
       success:function(data){
         var data1 = eval("("+data+")");
         if(data1 == null){
         alert("请登录");
         //跳出当前的框架。。。
         window.parent.parent.location.href="http://localhost:8080/second_webapp/login.html";
         }else{
         
         //根据uid查询角色名
           var uid = data1.uid;//uid
           uidG = uid;
           console.log("uid="+uid);
           var dataui={
        		uid:uid   
           };
           $.ajax({
             type:'post',
             url:"http://localhost:8080/second_webapp/servlet/roleServlet",
             data:dataui,
             success:function(data){
            	 
            	 var indata = eval("("+data+")");
                 if(indata.code == 1){
                 //可以编辑
                 var user = {
                 uid:uidG
                 };
                   var article = {
                   user : user,
                   content:$("#content").val(),
                   title:$("#title").val()
                   };
                   
                   $.ajax({
                   type:'post',
                   url:"http://localhost:8080/second_webapp/servlet/addArticleServlet",
                   data:article,
                   success:function(data){
                   console.log("dataass=" + data);
                     var data1 = eval("("+data+")");
                     console.log("data1.code=" + data1.code);
                     if(data1.code == 1){
                     window.location.href="http://localhost:8080/second_webapp/article/showArticle.jsp";
                     alert("发表成功");
                     }else{
                     alert("发表失败");
                     }
                   }
                   })
                 
                 }else{
                  //不可编辑
                  alert("您没有访问权限");
                 }
            	
             }
           
           })
         }
       }
     })
    
    }
    
</script>
</head>
<body>

<input type="button" value="发表文章" id="publish" onclick="publish()"/>
<table>
<tr>
<td>标题</td>

</tr>
<tr>
<td>
<input name="title" id="title"/>
</td>
</tr>
<tr>
<td>
内容
</td>
</tr>
<tr>
<td>
<textarea name="content" id="content">
  
</textarea>
</td>
</tr>
</table>

</body>
</html>