function logout(){
	$.ajax({
		"url":"/user/logout",
		"type":"POST",
		"async":false,
		success:function(data){
			window.location.href = "/login.html";
		}
	})
}

$(function () {
	var id = GetQueryString("id");
	$("#0").addClass("active");
	if(id!=0 && id!=null){
		$("#0").removeClass("active");
	}
	initnavmenu();
	$("#main").on('click',"li",function(){
		var count=$(this).index();
		var id=$(this).attr("id");
	})
})

//初始化加载菜单栏
function initnavmenu(){
	var id = GetQueryString("id");
	$.ajax({
		"url":"/index/columns",
		"type":"POST",
		"async":false,
		success:function(data){
			console.log(data);
			var _data = data.data; //由于后台传过来的json有个data，在此重命名
			var html = "";
			for (var e in _data) {
				if(_data[e].id==id){
					html += '<li id="'+_data[e].id+'" class="mianIndex active"><a href="'+_data[e].href+'?id='+_data[e].id+'">'+_data[e].name+'</a></li>'
				}
				else{
					html += '<li id="'+_data[e].id+'" class="mianIndex"><a href="'+_data[e].href+'?id='+_data[e].id+'">'+_data[e].name+'</a></li>'
				}
			}
			$("#main").append(html); //渲染
		},
		error:function(){
			alert("初始化失败");
		}
	})
}

function GetQueryString(name){
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)return  unescape(r[2]); return null;
}

