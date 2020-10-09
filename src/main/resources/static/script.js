   function showInput() {
    var settings = {
	"async": true,
	"crossDomain": true,
	"url": "https://realtor.p.rapidapi.com/finance/rates?loc=" + document.getElementById("zip").innerHTML,
	"method": "GET",
	"headers": {
		"x-rapidapi-host": "realtor.p.rapidapi.com",
		"x-rapidapi-key": "cbd883036amsha5013fa20dd478ep1d45a2jsn327f8d284020"
	}
}

$.ajax(settings).done(function (response) {
	console.log(response);
});

    };

