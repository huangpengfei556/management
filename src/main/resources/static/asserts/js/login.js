


function login(){
	var username=$("#username").val();
	var password=$("#pwd").val();
	if(username==""||password==""){
		alert("用户名或密码不能为空");
	}
	else{
		loginRequest(username,password);
	}
}

function loginRequest(username,password){
	console.log(username);
	$.ajax({
		url:"/user/login1",
		type:"POST",
		data:{
			"username":username,
			"password":password
		},
		success:function(data){
			console.log(data);
			var d=[1,2,3,4]
			var sumhtml="";
			for(var i=0;i<d.length;i++){
				sumhtml+="<tr><td>"+i+"<td></tr>"
			}
		  $("#table").append(sumhtml);
//			if(data.status=="1"){
//				window.location.href="dashboard";
//			}
//			else{
//				alert("登录失败");
//			}
		}
		})
//	$.ajax({
//		url:"/user/login",
//		type:"POST",
//		data:{
//			"username":username,
//			"password":password
//		},
//		success:function(data){
//			if(data.status=="1"){
//				window.location.href="dashboard";
//			}
//			else{
//				alert("登录失败");
//			}
//		}
//	});
}