<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<script src="../js/jquery.js" type="text/javascript"></script>
<script src="../js/jquery.min.js" type="text/javascript"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

var curPage = 1;
var indata = {
		uid:1,
		curpage:curPage
};

$(function(){
	
	var i = 0;
	var test1 = parseInt(i) + 1;
	console.log("test1=" + test1);
	
	getData(curPage,1);
})
 
    
    function getData(curPage,type){
	console.log("curPage = " + curPage);
	
    	   $.ajax({
    	    	type:"post",
    	    	url:"http://localhost:8080/second_webapp/servlet/showArticle",
    	    	data: indata,
    	    	success:function(data){
    	    		console.log("data="+data);
    	    		var tbody = $("#tbody");
    	    		var data = eval("("+data+")");
    	    		if(data.length == 0){
    	    			alert("已经到最后一页了");
    	    		}
    	    		for(var i = 0 ; i < data.length; i ++){
    	    			//console.log("i="+i);
    	    			var article = data[i];
    	    			var title = article.title;
    	    			var content = article.content;
    	    			var author = article.user.username;
    	    			var index =  parseInt(i)+1;
    	    			//console.log("index="+index);
    	    			//console.log("indata.curPage =" +indata.curPage);
    	    			if(curPage == 1){
    	    				
    	    			}else{
    	    				index = (curPage -1 ) * 10 + 
    	    				parseInt(i)+1;
    	    				//console.log("index="+index);
    	    			}
    	    			
    	    			
    	    			
    	    			var tr = $("<tr></tr>");
    	    			var td1 = $("<td>"+title+"</td>");
    	    			var td2 = $("<td>"+content+"</td>");
    	    			var td3 = $("<td>"+author+"</td>");
    	    			var td4 = $("<td>"+index+"</td>");
    	    			tr.append(td4).append(td1).append(td2).append(td3);
    	    			tbody.append(tr);
    	    			
    	    		}
    	    		if(type == 1){
    	    			
    	    		}else if(type == 2){
    	    			curPage++;
    	    		}
    	    		
    	    		
    	    		
    	    	}
    	    	
    	    })
    }
    
  
    
    function nextPage(){
    	indata.curpage = ++curPage;
    	console.log("indata.curpage = " + indata.curpage);
    	getData(indata.curpage ,2);
    	
    }
</script>

</head>
<body>
<button onclick="nextPage()">下一页</button>
<a  href="/second_webapp/article/addArticle.jsp">发表</a>
<table>
<thead>
<tr>
<td>序号</td>
<td>文章标题</td>
<td>文章内容</td>
<td>作者</td>
</tr>
</thead>
<tbody id="tbody">
  
</tbody>

</table>
</body>
</html>