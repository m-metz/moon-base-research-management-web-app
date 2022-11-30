function returnTicket(){
    var ticketId = document.getElementById("ticketId").value;

    var url = "http://localhost:8080/api/v1/cancel/ticket=";

    url = url + ticketId;
    
    var header = {
        method: "PATCH",
        headers : {
            "content-type": "application/json"
        }
    };

    fetch(url, header).then(res => checkResponse(res));

    function checkResponse(res){
        if (res.status === 200){
            res.json().then(credit => {
                
                let text ="<b>Credit Number:</b> " + credit.creditId + "<br><b>Amount</b>: " + credit.amount + "<br><b>Expiry Date</b>: " + credit.expiryDate;
                document.getElementById("creditText").innerHTML = text;
                $("#ticketModal").modal("show");
            })
                
        }
        else{
            res.json().then(error =>{
                alert(error.message);
            });
             
        }
    }
    


}