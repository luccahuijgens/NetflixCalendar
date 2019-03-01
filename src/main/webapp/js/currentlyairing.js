function loadSeries(batch,row){
		$.getJSON("/thirdapp/restservices/series/airing?batch="+batch, function(data){
			$.each(data, function(i, series){
				$("#series"+row).append(
				"<div class=seriesimage style=width:20%;float:left;padding:8px>"+
				   "<a href=series/"+series.id+".html><img src=img/"+series.id+".jpg alt=Sandwich style=width:100%></a>"+
			      "<h3>"+series.title+"</h3></div>");
			});

	});
}
loadSeries(0,1)
loadSeries(5,2)
loadSeries(10,3)

if (sessionStorage.getItem("user") !== null || sessionStorage.getItem("password") !==null){
	document.getElementById("logout").style.removeProperty("display")
	document.getElementById("login").style.display="none";
}