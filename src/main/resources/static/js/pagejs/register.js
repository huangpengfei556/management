window.onload=function(){
	$("#username").blur(function(){
		var username = $("#username").val();
		$.ajax({
			url:"/user/registerCheck",
		    type:"POST",
	        async:false,
	        data:"userName="+username,
	        dataType:"json",
	        success: function(data){
	        	var msg;
	        	if(data.code==200){
	        		$("#lab").html("用户名可以用");
	        		$("#lab").addClass("green");
	     	   }else{
	     		  $("#lab").html("用户名不可用");
	     		 $("#lab").addClass("red");
	     	   }
	        }
		})
	})
}


function check(){
	var username = $("#username").val();
	var password = $("#password").val();
	if(username == "" ){
		alert("用户名不能为空");
		return false;
	}
	if(password == "" ){
		alert("密码不能为空");
		return false;
	}else{
		register(username,password);
	}
}

function register(username,password){
	var user = {"userName":username,"passWord":password};
    var userInfo = JSON.stringify(user);
    $.ajax({
	   url:"/user/register",
       type:"POST",
       async:false,
       data:userInfo,
       contentType:'application/json',
       success:function(data){
    	   if(data.code==200){
    		   alert("注册成功");
    		   window.location.href = "/login.html";
    	   }else{
    		   alert(data.msg);
    	   }
       },
       error:function(){
    	  alert("请求错误");
       }
    });
}

function loginPage(){
	window.location.href = "/login.html";
}