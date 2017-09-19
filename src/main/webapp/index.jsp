<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>补录日志导出程序</title>
	<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="static/easyui/themes/material/easyui.css">
	<link rel="stylesheet" type="text/css" href="static/easyui/themes/icon.css">
	<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="static/easyui/locale/easyui-lang-zh_CN.js"></script>
	
		
		<link href="static/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
		<link href="static/css/index.css" type="text/css" rel="stylesheet">
		<link href="static/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
	
	
	
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript" src="static/bootstrap/js/bootstrap.js"></script>
	<!--控件中文包  -->
</head>
<body> 
<script type="text/javascript">

</script>


		<div class="jumbotron">
  <h2 style="margin-left: 50px">补录日志导出</h2>

</div>

	<div class='bigSize'>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">档 案 号 :</span>
		  <input type="text" id="dah" class="form-control" placeholder="输入档案号" aria-describedby="basic-addon1">
		</div>
		
		<div class="input-group">
		<span class="input-group-addon" id="basic-addon2">表 &nbsp;&nbsp;名 :</span>
		 <input type="text"  id="tablename" class="form-control" placeholder="输入表名" aria-describedby="basic-addon2">
		</div>
		
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon3">用 户 名 :</span>
		  <input type="text" id="username" class="form-control"  placeholder="输入用户名" aria-describedby="basic-addon3">
		</div>
		
		 <!-- <div class="input-group">
		   <span  class="input-group-addon" id="basic-addon4">导出文件地址:</span>
    	<input type="file" id="exampleInputFile" class="form-control"  placeholder="选择导出文件地址" aria-describedby="basic-addon4">
		</div> -->
		
		<div class="input-group">
		 <label class="input-group-addon" id="basic-addon5">日志起始时间 :</label>
			<input class=" easyui-datebox" aria-describedby="basic-addon5" id="beginTime"   >   
		</div>
		<div class="input-group">
		 <label class="input-group-addon" id="basic-addon6">日志结束时间 :</label>
			<input class=" easyui-datebox" aria-describedby="basic-addon6" id="endTime"   >   
		</div>
 		
 		<div class="input-group">
	 		<button type="button" id="submitButton" class="btn btn-info btn-lg" onclick="expExecl()">导出EXECL</button>
		
			<button type="button" id="resetButton" class="btn btn-warning reset btn-lg" >条件重置</button>
 		</div>
 		
 		<!-- <a href="aaa">点击测试</a> -->
 	</div>		
<script type="text/javascript">

//点击导出按钮后的按钮效果
$('#resetButton').click(function () {
	//1.档案号重置
	$("#dah").val("");
	//2.姓名空
	$("#username").val("");	
	//3.表名空
	$("#tablename").val("");
	//3.发起时间
	date= getNowDate();
	 $('#beginTime').datebox('setValue',date);
	 $('#endTime').datebox('setValue',date);
	 //4.恢复按钮状态
	 $('#submitButton').removeAttr("disabled");
	
})
	
	//时间控件
	$('#beginTime').datebox({    
	  required:true,  
	  editable:false,
	  onSelect:valDate,
	  value:getNowDate()
	}); 
	
	$('#endTime').datebox({    
	  required:true,
	  editable:false,
	  onSelect:valDate,
	  value:getNowDate()
	});  

	//点击导出按钮后触发
	function expExecl(){
		window.location.href="aaa?dah="+$("#dah").val().trim()+"&username="+$("#username").val().trim()+"&tablename="+$("#tablename").val().trim()
				+"&beginTime="+$('#beginTime').datebox('getValue')+"&endTime="+$('#endTime').datebox('getValue');
	}

</script>

 
 
	
		
</body>
</html>