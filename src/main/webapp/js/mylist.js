function loadSeries(){
	var user=window.sessionStorage.getItem("user");
	var password=window.sessionStorage.getItem("password");
		$.getJSON("/thirdapp/restservices/customerseries/"+user+"+"+password, function(data){
			$.each(data, function(i, series){
				$("#series").append(
				"<tr><td><center><a href=series/"+series.id+".html><img src=img/"+series.id+".jpg border=3 style=width:100%;></img></a></center>&emsp;</td>"
				+"<td><center><b>"+series.title+"</b></center><br></td>"
				+"<td><center>"+Statusify(series.id,series.personalstatus)+"</center></td>"
				+"<td><center>"+series.episodes+"</center></td>"
				+"<td><center>"+Stringify(series.id,series.score)+"</center></td>"
				+"<td><center>"+series.start+"</center></td>"
				+"<td><center>"+series.end+"</center></td>"
				+"<td><center>"+Checkbox(series.email, user, series.id)+"</center><br></td>"
				+"<td><input type=button value=Unfollow data-custid="+user+" data-seriesid="+series.id+"></td></tr>");
			});

	});
}
function Statusify(s,st){
	var result="<select onChange=\"UpdateStatus("+s+",this.value)\">";
	if(st=="PTW"){
		result+="<option value=\"PTW\" selected>Plan to Watch</option>"+
		"<option value=\"CW\">Currently Watching</option>"+
		"<option value=\"OH\">On Hold</option>"+
		"<option value=\"CMP\">Completed</option>"+
		"<select>"
	}
	if(st=="OH"){
		result+="<option value=\"PTW\">Plan to Watch</option>"+
		"<option value=\"CW\">Currently Watching</option>"+
		"<option value=\"OH\" selected>On Hold</option>"+
		"<option value=\"CMP\">Completed</option>"+
		"<select>"
	}
	if(st=="CW"){
		result+="<option value=\"PTW\" selected>Plan to Watch</option>"+
		"<option value=\"CW\" selected>Currently Watching</option>"+
		"<option value=\"OH\">On Hold</option>"+
		"<option value=\"CMP\">Completed</option>"+
		"<select>"
	}
	if(st=="CMP"){
		result+="<option value=\"PTW\" selected>Plan to Watch</option>"+
		"<option value=\"CW\">Currently Watching</option>"+
		"<option value=\"OH\">On Hold</option>"+
		"<option value=\"CMP\" selected>Completed</option>"+
		"<select>"
	}
	return result;
}
function Stringify(s,sc){
	var result="<div class=\"select_box\"><select onChange=\"UpdateScore("+s+",this.value)\">"+
	"<option value=10>(10) Masterpiece</option>"+
	"<option value=9>(9) Amazing</option>"+
	"<option value=8>(8) Very Good</option>"+
	"<option value=7>(7) Good</option>"+
	"<option value=6>(6) Fine</option>"+
	"<option value=5>(5) Average</option>"+
	"<option value=4>(4) Bad</option>"+
	"<option value=3>(3) Very Bad</option>"+
	"<option value=2>(2) Horrible</option>"+
	"<option value=1>(1) Appalling</option>"+
	"<option value=0>No Rating</option>"+
	"</select>";
	result=result.replace("value="+sc+">","selected=\"selected\" value="+sc+">");
	return result;
} 
function Checkbox(e,c,s){
	if(e=="Yes"){
		return "<label class=\"container\"><input type=checkbox id=email"+s+" data-custid="+c+" data-seriesid="+s+" checked><span class=\"checkmark\"></span></label>";
	}
	else{
		return "<label class=\"container\"><input type=checkbox id=email"+s+" data-custid="+c+" data-seriesid="+s+"><span class=\"checkmark\"></span></label>";
		}
}

function UpdateScore(s,sc){
	var user=window.sessionStorage.getItem("user");
	var password=window.sessionStorage.getItem("password");
    var seriesid = s;
    var score=sc;
    var intscore=parseInt(score);

	$.ajax({
	    cache: false,
	    type: "PUT",
	    url: "/thirdapp/restservices/customerseries/score",
	    data: "customer="+user+"&password="+password+"&series="+seriesid+"&score="+intscore,
	    dataType: "HTML",
	    success: function (data) {
	    	alert("Your score for this series has been adjusted!");
	    },
	    error: function (xhr, ajaxOptions, thrownError) {
	    }
	  });
}
function UpdateStatus(s,st){
	var user=window.sessionStorage.getItem("user");
	var password=window.sessionStorage.getItem("password");
    var seriesid = s;
    var status=st;
    console.log(st);

	$.ajax({
	    cache: false,
	    type: "PUT",
	    url: "/thirdapp/restservices/customerseries/status",
	    data: "customer="+user+"&password="+password+"&series="+seriesid+"&status="+st,
	    dataType: "HTML",
	    success: function (data) {
	    	alert("Your current status for this series has been adjusted!");
	    },
	    error: function (xhr, ajaxOptions, thrownError) {
	    }
	  });
}
$("#series").on('click', 'input[type=button]', function () {
   var custid = $(this).data('custid');
   var seriesid = $(this).data('seriesid');
   var uri = "/thirdapp/restservices/customerseries/delete/" + custid+"+"+seriesid;
   console.log("ready")
   $.ajax(uri, { 
       type: "delete", 
       success: function(response) {
           $("#response").text("Customer deleted!");
           alert("This Series has been removed from your list!");
           location.reload();
       },
       error: function(response) {
           $("#response").text("Could not delete customer!");
       }
   });
});

$("#series").on('click', 'input[type=checkbox]', function () {
	var user=window.sessionStorage.getItem("user");
    if(!$(this).is(':checked')){
    	   var custid = $(this).data('custid');
    	    var seriesid = $(this).data('seriesid');
    	    var email="No";
    	    console.log(custid+"+"+seriesid);
    		console.log(email);
    		
    		var uri = "/thirdapp/restservices/customerseries/email/"+user+"+"+seriesid+"+"+email;
    		console.log

    		    $.ajax(uri, { 
    		        type: "put", 
    		        success: function(response) {
    		        	alert("Email Notifications for this Series have been disabled!");
    		            $("#response").text("Customer saved!");
    		        },
    		        error: function(response) {
    		            $("#response").text("Could not update customer!");
    		        }
    		    }); 
    }else{
        console.log('checked');
    var custid = $(this).data('custid');
    var seriesid = $(this).data('seriesid');
    var email="Yes";
    console.log(custid+"+"+seriesid);
	console.log(email);
	
	var uri = "/thirdapp/restservices/customerseries/email/"+user+"+"+seriesid+"+"+email;

	    $.ajax(uri, { 
	        type: "put", 
	        success: function(response) {
	        	alert("Email Notifications for this Series have been enabled!");
	            $("#response").text("Customer saved!");
	        },
	        error: function(response) {
	            $("#response").text("Could not update customer!");
	        }
	    }); 
}
}); 

loadSeries()
if (sessionStorage.getItem("user") !== null || sessionStorage.getItem("password") !==null){
	document.getElementById("logout").style.removeProperty("display")
	document.getElementById("login").style.display="none";
}else{
	 alert("You need to be logged in to view your personal list.");
	 window.location = "login.html";
}