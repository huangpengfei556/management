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
    		   window.location.href = "/index.html";
    	   }else{
    		   alert("验证错误");
    	   }
       },
       error:function(){
    	  alert("请求错误");
       }
    });
}

function loginPage(){
	window.location.href = "/index.html";
}