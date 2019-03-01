if (sessionStorage.getItem("user") !== null || sessionStorage.getItem("password") !==null){
	document.getElementById("logout").style.removeProperty("display")
	document.getElementById("login").style.display="none";
}else{
	 alert("You need to be logged in to view your agenda.");
	 window.location = "login.html";
}

function loadSeries(){
		var user=window.sessionStorage.getItem("user");
		var password=window.sessionStorage.getItem("password");
		var text7="";
		$.getJSON("/thirdapp/restservices/customerseries/"+user+"+"+password+"/Monday", function(data){
			$.each(data, function(i, series){
				text7+="<a href=series/"+series.id+".html><img src=img/"+series.id+".jpg alt=Sandwich style=width:25%;padding:8px;></a>"
			});
			text7+="<br><br>";
			if(text7=="<br><br>"){
				text7="There are no episodes airing today.<br><br>"
			}
			$("#monday").append(text7)
	});
		var text6="";
		$.getJSON("/thirdapp/restservices/customerseries/"+user+"+"+password+"/Tuesday", function(data){
			$.each(data, function(i, series){
				text6+="<a href=series/"+series.id+".html><img src=img/"+series.id+".jpg alt=Sandwich style=width:25%;padding:8px;></a>"
			});
			text6+="<br><br>";
			if(text6=="<br><br>"){
				text6="There are no episodes airing today.<br><br>"
			}
			$("#tuesday").append(text6)
	});
		var text5="";
		$.getJSON("/thirdapp/restservices/customerseries/"+user+"+"+password+"/Wednesday", function(data){
			$.each(data, function(i, series){
				text5+="<a href=series/"+series.id+".html><img src=img/"+series.id+".jpg alt=Sandwich style=width:25%;padding:8px;></a>"
			});
			text5+="<br><br>";
			if(text5=="<br><br>"){
				text5="There are no episodes airing today.<br><br>"
			}
			$("#wednesday").append(text5)
	});
		var text3="";
		$.getJSON("/thirdapp/restservices/customerseries/"+user+"+"+password+"/Friday", function(data){
			$.each(data, function(i, series){
				text3+="<a href=series/"+series.id+".html><img src=img/"+series.id+".jpg alt=Sandwich style=width:25%;padding:8px;></a>"
			});
			text3+="<br><br>";
			if(text3=="<br><br>"){
				text3="There are no episodes airing today.<br><br>"
			}
			$("#friday").append(text3)
			});	
		var text4="";
	$.getJSON("/thirdapp/restservices/customerseries/"+user+"+"+password+"/Thursday", function(data){
		$.each(data, function(i, series){
			text4+="<a href=series/"+series.id+".html><img src=img/"+series.id+".jpg alt=Sandwich style=width:25%;padding:8px;></a>"
		});
		text4+="<br><br>";
		if(text4=="<br><br>"){
			text4="There are no episodes airing today.<br><br>"
		}
		$("#thursday").append(text4)
});
		var text2="";
		$.getJSON("/thirdapp/restservices/customerseries/"+user+"+"+password+"/Saturday", function(data){
			$.each(data, function(i, series){
				text2+="<a href=series/"+series.id+".html><img src=img/"+series.id+".jpg alt=Sandwich style=width:25%;padding:8px;></a>"
			});
			text2+="<br><br>";
			if(text2=="<br><br>"){
				text2="There are no episodes airing today.<br><br>"
			}
			$("#saturday").append(text2)
	});
		var text="";
		$.getJSON("/thirdapp/restservices/customerseries/"+user+"+"+password+"/Sunday", function(data){
			$.each(data, function(i, series){
				text+="<a href=series/"+series.id+".html><img src=img/"+series.id+".jpg alt=Sandwich style=width:25%;padding:8px;></a>"
			});
			text+="<br><br>";
			if(text=="<br><br>"){
				text="There are no episodes airing today.<br><br>"
			}
			$("#sunday").append(text)
	});
}
loadSeries()

	var user=window.sessionStorage.getItem("user");
	$.getJSON("/thirdapp/restservices/customerseries/sendmail/"+user, function(data){
		if ( data.length == 0 ) {
			console.log("An error occured!")	
		}});