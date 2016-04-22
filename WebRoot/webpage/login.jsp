<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/context/mytags.jsp"%>
<%@ taglib uri="mytags" prefix="lypxc"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${webRoot}">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" src="<%=path %>/webpage/js/jquery.1.8.3.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
	/*$.ajax({
		type: "GET",
		url: "test/ajaxtest",
		//data: {num:"4"},	
		dataType: "json",
		cache: false,
		success: function(data) {
			console.log(data)
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log(XMLHttpRequest)
			console.log(textStatus)
			console.log(errorThrown)
			alert("出了点小状况！");
		}
	});	*/
	</script>

  </head>
  
  <body>
    <lypxc:showTable name="ss"></lypxc:showTable>
    <br>
    path:${path}<br>
    ctx:${ctx}<br>
    ctx_page:${ctx_page}<br/>
    basePath:${basePath}
    <br/><br/>
    <c:forEach items="${list}" var="st">
     ${st.logmessage}<br/><br/>
    </c:forEach>
  </body>
</html>
