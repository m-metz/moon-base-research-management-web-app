function loaduser(){
    document.getElementById("userid").innerHTML= "Userid: "+ sessionStorage.getItem('id');
    document.getElementById("title").innerHTML= "" + sessionStorage.getItem('title');
    document.getElementById("name").innerHTML= "Name: " + sessionStorage.getItem('name');
}