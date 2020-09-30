var script = document.createElement('script');
script.src = 'https://code.jquery.com/jquery-3.4.1.min.js';
script.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script);


function customDate() {
  var customDates = document.getElementsByClassName('customDate');
  for (var i=0; i<customDates.length; i++) {
    var customDate = new Date(customDates[i].innerHTML);
    var year = customDate.getFullYear();
 var month = (customDate.getMonth()+1).toString().padStart(2, '0');
    var day = customDate.getDate().toString().padStart(2, '0');
    document.getElementsByClassName('customDate')[i].innerHTML = day+"/"+month+"/"+year;
  }
}

function hello(){
    console.log("sup bitch");
}