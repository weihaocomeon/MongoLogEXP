

//时间控件
/*$('#beginTime').datebox({    
    required:true,  
    editable:false,
    onSelect:valDate
}); 

$('#endTime').datebox({    
    required:true,
    editable:false,
    onSelect:valDate
});  
*/

//验证输入时间
function valDate(){
	var beginTime= ($('#beginTime').combo('getValue')).replace('-',"").replace('-',"");	
	var endTime= ($('#endTime').combo('getValue')).replace('-',"").replace('-',"");	
	if((endTime<beginTime)&&(endTime!="")&&(beginTime!="")){
		showMsg('友情提示','开始时间必须小于结束时间','warning');
		//限制不可提交
		//$('#submitButton').linkbutton('disable');
		$('#submitButton').attr({"disabled":"disabled"});	
	}else{
		//恢复状态
		$('#submitButton').removeAttr("disabled");
	}
}

//当前时间获取
function getNowDate(){
	return (new Date()).toLocaleString();
}




//信息显示
function showMsg(msgTitle,msg,icon){
	$.messager.alert(msgTitle,msg,icon);
}