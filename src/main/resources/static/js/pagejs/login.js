window.onload=function(){
	verifyCode()
}

function verifyCode(){
	document.getElementById("verifyCode").src = timestamp("/user/verifyCode");
}

function timestamp(url) {
    var getTimestamp = new Date().getTime();
    if (url.indexOf("?") > -1) {
        url = url + "&timestamp=" + getTimestamp
    } else {
        url = url + "?timestamp=" + getTimestamp
    }
    return url;
};

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
	var code=$("#code").val();
	var remFlag=$("#remFlag").val();
	if(username == "" ){
		alert("用户名不能为空");
		return false;
	}
	if(password == "" ){
		alert("密码不能为空");
		return false;
	}else{
		checkAuth(username,password,code,remFlag);
	}
}

function checkAuth(username,password,code,remFlag) {
	var user = {"userName":username,"passWord":password,"code":code,"remFlag":remFlag};
	var userInfo = JSON.stringify(user);
	$.ajax({
		url:"/user/login",
		type:"POST",
		async:false,
		data:userInfo,
		contentType:'application/json',
		success:function(data){
			if(data.code==200){
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

function registerPage(){
	window.location.href = "/register.html";
}