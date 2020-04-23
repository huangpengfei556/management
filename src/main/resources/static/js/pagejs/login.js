window.onload=function(){
	$.ajax({
		url:"/user/verifyCode",
		type:"POST",
		async:true,
		timeout:6000,
		success:function(data){
			if(data.code==200){
	           console.log(data.data.fileName);
	           var file = "verifyCode/"+data.data.fileName;
	           console.log(file);		//	verifyCode//f8cfb134-573a-4bfd-b41f-ec97113ab87a.jpg
	           $("#verifyCode").attr("src",file);
			}else{
				alert("验证码创建失败");
			}
		},
		error:function(){
			alert("初始化失败");
		}
	})

}

function remember(){
	var remFlag = $("#remember").is(':checked');
	if(remFlag==true){
		$("#remFlag").val(1);
	}else{
		$("#remFlag").val(0);
	}
}

function checkUser(){
	var username=$("#username").val();
	var password=$("#password").val();
	var remFlag=$("#remFlag").val();
	if(username == "" ){
		alert("用户名不能为空");
		return false;
	}
	if(password == "" ){
		alert("密码不能为空");
		return false;
	}else{
		checkAuth(username,password,remFlag);
	}
}

function checkAuth(username,password,remFlag) {
	var user = {"userName":username,"passWord":password,"remFlag":remFlag};
	var userInfo = JSON.stringify(user);
	$.ajax({
		url:"/user/login",
		type:"POST",
		async:false,
		data:userInfo,
		contentType:'application/json',
		success:function(data){
			if(data.code==200){
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

function registerPage(){
	window.location.href = "/register.html";
}