onload=llamadaAjax;

function llamadaAjax() {     
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200){
            	console.log("Holiwis");
            	document.getElementById("sidebar").innerHTML = xhr.responseText;
            }          	
            else
            	document.getElementById("siderbar").innerHTML = "Error AJAX";
        }
    }
 
    var url = "COSA.jsp";
    xhr.open("GET", url);
    xhr.send();
}

