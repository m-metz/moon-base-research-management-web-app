function loaduser(){
    document.getElementById("userid").innerHTML= "Userid: "+ sessionStorage.getItem('id');
    document.getElementById("title").innerHTML= "" + sessionStorage.getItem('title');
    document.getElementById("name").innerHTML= "Name: " + sessionStorage.getItem('name');
}

function showPersonnel(s){

    if (s === undefined){
        var url = "http://localhost:8080/api/v1/personnel";
    }
    else{
        var url = "http://localhost:8080/api/v1/personnel/sorted";
    }
    
    fetch(url).then(res => res.json()).then(personnelList => fillTablePersonnel(personnelList));
}


function fillTablePersonnel(personnelList){
    var strTable= `<table class="table table-striped">
                        <thead>
                            <th> Personnel_Id</th>
                            <th> Name </th>
                            <th> Country </th>
                        </thead>
                        
                        <tbody>`;

    for (i=0; i<personnelList.length; i++){
        let personnel = personnelList[i];
        
        strTable = strTable + `<tr>
                                    <td> ${personnel.personnelId} </td>
                                    <td> ${personnel.name} </td>
                                    <td> ${personnel.country} </td>
                                </tr>`;

    }

    strTable = strTable + `</tbody>
                            </table>`;

    document.getElementById("placeHolder").className = "col-6 col-sm-5";
    document.getElementById("placeHolder").innerHTML = strTable;

}

function showProjects(){

    var url = "http://localhost:8080/api/v1/project";

    
    fetch(url).then(res => res.json()).then(projectList => fillTableProject(projectList));
}


function fillTableProject(projectList){
    var strTable= `<table class="table table-striped">
                        <thead>
                            <th> Project_Id</th>
                            <th> Name </th>
                            <th> Moon Manager Id</th>
                            <th> Moon Manager Name</th>
                            <th> Earth Manager Id</th>
                            <th> Earth Manager Name</th>
                            <th> Building </th>
                        </thead>
                        
                        <tbody>`;

    for (i=0; i<projectList.length; i++){
        let project = projectList[i];
        
        strTable = strTable + `<tr>
                                    <td> ${project.projectId} </td>
                                    <td> ${project.name} </td>
                                    <td> ${project.moonManager.personnelId} </td>
                                    <td> ${project.moonManager.name} </td>
                                    <td> ${project.earthManager.personnelId} </td>
                                    <td> ${project.earthManager.name} </td>
                                    <td> ${project.building.name} </td>
                                </tr>`;

    }

    strTable = strTable + `</tbody>
                            </table>`;

    document.getElementById("placeHolder").className = "mt-3";
    document.getElementById("placeHolder").innerHTML = strTable;

}

function showAddPersonnel(){

    var add = `<h2 class="h2 text-center">Please enter details for adding new Personnel  </h2> 
                    <div class="input-group mb-3 w-25 mx-auto">
                    <span class="input-group-text" id="label1">Name: </span>
                    <input type="text" class="form-control" id="pname" aria-describedby="apname">
                     <span class="input-group-text" id="label2">Country: </span>
                    <input type="text" class="form-control" id="pcountry" aria-describedby="apcountry">
                    </div>
                <div class="text-center"><button type="button" class= "btn btn-primary" onclick="addUser()">Add User</button></div>`

                document.getElementById("placeHolder").className = "mt-3";
                document.getElementById("placeHolder").innerHTML = add;          
}

    function addUser(){
    var pname = document.getElementById("pname").value;
    var country = document.getElementById("pcountry").value;

    var url = "http://localhost:8080/api/v1/personnel/add";

    var msgBody = {
        name : pname,
        country : country
    };

    var header = {
        method: "POST",
        body : JSON.stringify(msgBody),
        headers : {
            "content-type": "application/json"
        }
    };

    fetch(url, header).then(res =>{

        if (res.status == 200){
            res.json().then(person=> {
                    let text ="<b>Personnel id:</b> " + person.personnelId + "<br><b>Name</b>: " + person.name + "<br><b>Country</b>: " + person.country;
                    document.getElementById("modalLabel").innerHTML = "New Personnel Information";
                    document.getElementById("modalText").innerHTML = text;
                    $("#managerModal").modal("show");
                })
        }
        else{
            res.json().then(error =>{
                alert(error.message);
            });
        }
    });
    
    }

    function showAssignProject(){

        var add = `<h2 class="h2 text-center">Please enter details for enrolling into a new project </h2> 
                        <div class="input-group mb-3 w-25 mx-auto">
                        <span class="input-group-text" id="label1">Personnel Id: </span>
                        <input type="text" class="form-control" id="pid" aria-describedby="apid">
                         <span class="input-group-text" id="label2">Project Id: </span>
                        <input type="text" class="form-control" id="pProjId" aria-describedby="apProjId">
                        </div>
                    <div class="text-center"><button type="button" class= "btn btn-primary" onclick="enrollUser()">Enroll User</button></div>`
    
                    document.getElementById("placeHolder").className = "mt-3";
                    document.getElementById("placeHolder").innerHTML = add;          
    }
    
        function enrollUser(){
        var pname = document.getElementById("pname").value;
        var country = document.getElementById("pcountry").value;
    
        var url = "http://localhost:8080/api/v1/personnel/add";
    
        var msgBody = {
            name : pname,
            country : country
        };
    
        var header = {
            method: "POST",
            body : JSON.stringify(msgBody),
            headers : {
                "content-type": "application/json"
            }
        };
    
        fetch(url, header).then(res =>{
    
            if (res.status == 200){
                res.json().then(person=> {
                        let text ="<b>Personnel id:</b> " + person.personnelId + "<br><b>Name</b>: " + person.name + "<br><b>Country</b>: " + person.country;
                        document.getElementById("modalLabel").innerHTML = "New Personnel Information";
                        document.getElementById("modalText").innerHTML = text;
                        $("#managerModal").modal("show");
                    })
            }
            else{
                res.json().then(error =>{
                    alert(error.message);
                });
            }
        });
        
        }