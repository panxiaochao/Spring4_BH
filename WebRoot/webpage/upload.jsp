<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>上传</title>
<link href="${ctx}/plugins/jquery-uploadfiy/uploadify.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx_page}/js/jquery.1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/plugins/jquery-uploadfiy/jquery.uploadify.js"></script>
<script type="text/javascript" src="${ctx}/plugins/jquery-uploadfiy/swfobject.js"></script>
<script type="text/javascript">
     $(document).ready(function(){
          $("#uploadify").uploadify({
         	 'width': 100,
         	 'height': 20,
         	 'auto': false,
             'multi': true,
             'swf': '${ctx}/plugins/jquery-uploadfiy/uploadify.swf',
             'uploader': '${ctx}/uploadFile',
             'cancelImg': '${ctx}/plugins/jquery-uploadfiy/uploadify-cancel.png',
             'folder': '/',
             'queueID': 'fileQueue',
             //附带值
		      'formData':{
		           /*'userid':'用户id',
		           'username':'用户名',
		           'rnd':'加密密文'*/
		       },
               'buttonText': '选择文件',
               'buttonClass': 'btn btn-primary',
               'buttonImage': null,
             	//expressInstall.swf文件的路径。
		       'expressInstall':'${ctx}/plugins/jquery-uploadfiy/expressInstall.swf',
		       //在浏览窗口底部的文件类型下拉菜单中显示的文本
		       'fileTypeDesc':'支持的格式:',
		       //允许上传的文件后缀
		       'fileTypeExts':'*.jpg;*.jpge;*.gif;*.png;*.doc;*.pdf',
		       //上传文件的大小限制
		       'fileSizeLimit':'10MB',
		       //上传数量
		       'queueSizeLimit' : 10,
		       'onProgress' : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
		            //有时候上传进度什么想自己个性化控制，可以利用这个方法
		            //使用方法见官方说明
		       },
		       'onUploadSuccess':function(file, data, response){
		    	   console.log(file);
		    	   console.log(data);
		    	   console.log(response);
		    	   data = data.substring(0, data.indexOf("."));
		    	   var img = "<img src=${ctx}/test/outImg/"+data+" />";
		    	   $('.imgshow').append(img);
                   /*
                   $("#upload_org_code_img").attr("src","${pageContext.request.contextPath}/getImg?file="+data);  
                   $("#upload_org_code_img").show();*/
               },
		       //返回一个错误，选择文件的时候触发
		       'onError':function(file, errorCode, errorMsg){
		           switch(errorCode) {
		               case -100:
		                   alert("上传的文件数量已经超出系统限制的"+$('#file_upload').uploadify('settings','queueSizeLimit')+"个文件！");
		                   break;
		               case -110:
		                   alert("文件 ["+file.name+"] 大小超出系统限制的"+$('#file_upload').uploadify('settings','fileSizeLimit')+"大小！");
		                   break;
		               case -120:
		                   alert("文件 ["+file.name+"] 大小异常！");
		                   break;
		               case -130:
		                   alert("文件 ["+file.name+"] 类型不正确！");
		                   break;
		           }
		       },
		       //加上此句会重写onSelectError方法【需要重写的事件】
               'overrideEvents': ['onSelectError'],
               //返回一个错误，选择文件的时候触发
               'onSelectError':function(file, errorCode, errorMsg){
                   switch(errorCode) {
                       case -110:
                           alert("文件 ["+file.name+"] 大小超出系统限制的" + $('#file_upload').uploadify('settings', 'fileSizeLimit') + "大小！");
                           break;
                       case -120:
                           alert("文件 ["+file.name+"] 大小异常！");
                           break;
                       case -130:
                           alert("文件 ["+file.name+"] 类型不正确！");
                           break;
                   }
               },
		       //检测FLASH失败调用
		       'onFallback':function(){
		           alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
		       }			        
		             /*
		       'onUploadStart': function (file) {
		                 $('#fileQueue').attr('style', 'top:200px;left:400px;width:400px;height :400px;visibility :visible');
		             }*/
		             
		         });
		     });  
</script>
</head>

<body>
<div>
<a class="btn btn-primary" href="javascript:$('#uploadify').uploadify('upload','*')">上传</a> 
<a class="btn" href="javascript:$('#uploadify').uploadify('cancel', $('.uploadifive-queue-item').first().data('file'))">取消上传</a> 
</div>
<input type="file" name="uploadify" id="uploadify" />
<div id="fileQueue"></div>
<div class="imgshow" ></div>
<a href="index.jsp">返回</a>
</body>
</html>
