function login(){
    var userid= document.getElementById("userId").value;

    var url = `http://localhost:8080/api/v1/personnel/title/personnel=${userid}`;
    
    var header = {
        method: "GET",
        headers : {
            "content-type": "application/json"
        }
    };

    fetch(url, header).then(res => checkTitle(res));

    function checkTitle(res){
        if (res.status === 200){
            res.json().then(title=> {
                
                sessionStorage.setItem('title', title);
                let url1 = `http://localhost:8080/api/v1/personnel/id=${userid}`;
                fetch(url1, header).then(res => loguser(res));
            })
                
        }
        else{
            res.json().then(error =>{
                alert(error.message);
            });
             
        }
    }
    
    function loguser(res){
        res.json().then(user =>{
            if(res.status == 200){
                sessionStorage.setItem('name', user.name);
                sessionStorage.setItem('id', user.id);
                if(sessionStorage.getItem('title') != "Moon Researcher"){
                    window.location("manager.html");
                }
                else{
                    window.location("researcher.html");
                }
            }
        });
        

    }


}