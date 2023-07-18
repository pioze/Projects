function emailvalidation(){
    var check = document.getElementById("Username").value;
    var checkpass = document.getElementById("Password").value;

    if (check==null||check==""||checkpass==null||checkpass==""){
        document.getElementById("usertest").innerText="Must fill the deatils!";
        return false;
    }
}

function on(element1) {
    element1.src="./images/menu1.png";
}

function off(element) {
    element.src = "./images/menu.png";
}

function loadServices() {
      var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
          processServices(xhttp);
        }
      }
      xhttp.open("GET", "services.json", true);
      xhttp.send();
    }

    function processServices(xhttp) {
      var servicesObj = JSON.parse(xhttp.responseText);
      displayServices(servicesObj.services);
    }

    function displayServices(services) {
      var serviceNameDropdown = document.getElementById("serviceName");
      services.forEach(function(service) {
        var option = document.createElement("option");
        option.value = service.name;
        option.textContent = service.name;
        serviceNameDropdown.appendChild(option);
      });
    }

    loadServices();
    
  