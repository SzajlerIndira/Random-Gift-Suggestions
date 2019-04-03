function getGifts(str) {
    var xhttp;

    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("gifts-"+str).innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "http://localhost:60300/gifts", true);
    xhttp.send();
}