function logout(){
	$.ajax({
		"url":"/user/logout",
		"type":"POST",
		"async":false,
		success:function(data){
			window.location.href = "/index.html";
		}
	})
}