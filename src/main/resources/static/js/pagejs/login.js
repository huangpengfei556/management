function checkUser(){
	var username=$("#username").val();
	var password=$("#password").val();
	if(username == "" ){
		alert("用户名不能为空");
		return false;

	}
	if(password == "" ){
		alert("密码不能为空");
		return false;
	}else{
		checkAuth(username,password);
	}
}

function checkAuth(username,password) {

	var user = {"userName":username,"passWord":password};
    var userInfo = JSON.stringify(user);
    $.ajax({
	   "url":"/user/login",
       "type":"POST",
       "async":false,
       "data":userInfo,
       "contentType":'application/json',
       success:function(data){
    	   console.log(data);
    	   if(data.code==200){
    		   console.log(data.code);
    		   window.location.href = "/main.html";
    	   }else{
    		   alert("验证错误");
    	   }
       },
       error:function(){
    	  alert("请求错误");
       }
    });
}

function register(){
	window.location.href = "/register.html";
}