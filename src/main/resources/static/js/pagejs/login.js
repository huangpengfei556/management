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
    		   alert("登录成功"); 
    	   }else{
    		   alert("验证错误");
    	   }
       },
       error:function(){
    	   alert("请求错误");
       }
});
}

function checkAuth1(username,password){
	  var userList = new Array();  
	userList.push({username: "zhangsan",password: "332"});  
	//var userList = [{username: "李四",password: "123"},{username: "张三",password: "332"}];  
	var user = {"userName":username,"passWord":password};
    var userInfo = JSON.stringify(user);
    console.log(userInfo);
    alert(1);
    $.ajax({
        "url":"/user/login",
        "type":"POST",
        "data":JSON.stringify(userList),
        "dataType" : 'json',
        "cache":false,
        "async":false,
        "contentType":'application/json',
        success:function(data){
            console.log(data);
            alert("request success ! ");
        }

    })
	/*$.ajax({
		url:"/user/login",
		type:"POST",
		dataType : 'json',
		data:userInfo,
		success:function(date){
			alert(13);
		},
		error:function(data){
			alert(14);
		}
			
	})*/
	
}