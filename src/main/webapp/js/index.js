$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

if (sessionStorage.getItem("user") !== null || sessionStorage.getItem("password") !==null){
	document.getElementById("logout").style.removeProperty("display")
	document.getElementById("login").style.display="none";
}


function loadlatest(){
		$.getJSON("/thirdapp/restservices/series/latest?batch="+0, function(data){
			$.each(data, function(i, series){
				$("#series1").append(
				"<div class=seriesimage style=width:12%;float:left;padding:8px>"+
				   "<a href=series/"+series.id+".html><img src=img/"+series.id+".jpg alt=Sandwich style=width:100%></a>"+
			      "<h3>"+series.title+"</h3></div>");
			});

	});
}
function loadpopular(){
	$.getJSON("/thirdapp/restservices/series/popular?batch="+0, function(data){
		$.each(data, function(i, series){
			$("#series2").append(
			"<div class=seriesimage style=width:12%;float:left;padding:8px>"+
			   "<a href=series/"+series.id+".html><img src=img/"+series.id+".jpg alt=Sandwich style=width:100%></a>"+
		      "<h3>"+series.title+"</h3></div>");
		});

});
}
function loadtop(){
	$.getJSON("/thirdapp/restservices/series/top?batch="+0, function(data){
		$.each(data, function(i, series){
			$("#series3").append(
			"<div class=seriesimage style=width:12%;float:left;padding:8px>"+
			   "<a href=series/"+series.id+".html><img src=img/"+series.id+".jpg alt=Sandwich style=width:100%></a>"+
		      "<h3>"+series.title+"</h3></div>");
		});

});
}
loadlatest()
loadpopular()
loadtop()

$("#series").on('click', 'input[type=button]', function () {
       var custid = $(this).data('custid');
       var seriesid = $(this).data('seriesid');
    	    var data = { "CustomerID": custid, "SeriesID": seriesid }
    	    var JSONdata = JSON.stringify(data);
    	    console.log(data);
    	    $.post("/thirdapp/restservices/customerseries", JSONdata, function(response) {
    	        $("#response").text(JSON.stringify(response));
    	        alert("This Series has been added to your list!");
    	    }); 
    	});