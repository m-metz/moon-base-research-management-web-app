function loaduser(){
    document.getElementById("userid").innerHTML= "Userid: "+ sessionStorage.getItem('id');
    document.getElementById("title").innerHTML= "" + sessionStorage.getItem('title');
    document.getElementById("name").innerHTML= "Name: " + sessionStorage.getItem('name');
}

function logout(){
    window.location="index.html";
    sessionStorage.clear();
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

    if (pname === "" || country === ""){
        alert("Please insert Name and Contry to Perform Registration")
        return;
    }

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

function showDeletePersonnel(){
    var del = `<h2 class="h2 text-center">Please enter id of Personnel you want to delete </h2> 
                <div class="input-group mb-3 w-25 mx-auto">
                <span class="input-group-text" id="label1">Id: </span>
                <input type="text" class="form-control" id="pid" aria-describedby="apid">
                </div>
            <div class="text-center"><button type="button" class= "btn btn-primary" onclick="delUser()">Del User</button></div>`

document.getElementById("placeHolder").className = "mt-3";
document.getElementById("placeHolder").innerHTML = del;    

}

function delUser(){
    var pid = document.getElementById("pid").value;

    if (pid === sessionStorage.getItem('id')){
        alert("Operation Canceled! You can't delete your own user.");
        return;
    }

    var url = `http://localhost:8080/api/v1/personnel/delete=${pid}`;


    var header = {
        method: "DELETE",
        headers : {
            "content-type": "application/json"
        }
    };

    fetch(url, header).then(res =>{

        if (res.status == 200){
                    document.getElementById("modalLabel").innerHTML = "Delete Operation";
                    document.getElementById("modalText").innerHTML = "Personnel with id: " + pid + " deleted.";
                    $("#managerModal").modal("show");
        }
        else{
            res.json().then(error =>{
                alert(error.message);
            });
        }
    });

}

function showUpdatePersonnel(){
        var update = `<h2 class="h2 text-center">Please enters the fields you want to update:  </h2> 
                        <div class="input-group mb-3 w-25 mx-auto">
                        <span class="input-group-text" id="label0">Id: </span>
                        <input type="text" class="form-control" id="pid" aria-describedby="apid">
                        <span class="input-group-text" id="label1">Name: </span>
                        <input type="text" class="form-control" id="pname" aria-describedby="apname">
                         <span class="input-group-text" id="label2">Country: </span>
                        <input type="text" class="form-control" id="pcountry" aria-describedby="apcountry">
                        </div>
                    <div class="text-center"><button type="button" class= "btn btn-primary" onclick="updateUser()">Update User</button></div>`
    
                    document.getElementById("placeHolder").className = "mt-3";
                    document.getElementById("placeHolder").innerHTML = update;          
}

function updateUser(){
    const pid =document.getElementById("pid").value;
    if (pid === ""){
        alert("Please inform Personnel id");
        return;
    }
    var pname = document.getElementById("pname").value;
    var country = document.getElementById("pcountry").value;

    if (pname === "" && country != ""){
        var url = `http://localhost:8080/api/v1/personnel/update=${pid}?country=${country}`;
    }
    else if (country === "" && pname != ""){
        var url = `http://localhost:8080/api/v1/personnel/update=${pid}?name=${pname}`;
    }
    else if (pname != "" && country != ""){
        var url = `http://localhost:8080/api/v1/personnel/update=${pid}?name=${pname}&country=${country}`;
    }
    else{
        alert("Please inform the field(s) you want to update");
        return;
    }

    var header = {
        method: "PATCH",
        headers : {
            "content-type": "application/json"
        }
    };

    fetch(url, header).then(res =>{

        if (res.status == 200){
            res.json().then(user =>{
                document.getElementById("modalLabel").innerHTML = "Update Operation";
                document.getElementById("modalText").innerHTML = "Personnel with id: " + pid + " updated.";
                $("#managerModal").modal("show");
                if (pid === sessionStorage.getItem("id")){
                    sessionStorage.setItem('name', user.name);
                    document.getElementById("name").innerHTML= "Name: " + sessionStorage.getItem('name');

                }
            });
                    
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
        var pid = document.getElementById("pid").value;
        var project = document.getElementById("pProjId").value;
    
        var url = `http://localhost:8080/api/v1/personnel/personnel=${pid}/registerProject=${project}`;
    
        var header = {
            method: "PATCH",
            headers : {
                "content-type": "application/json"
            }
        };
    
        fetch(url, header).then(res =>{

            if (res.status == 200){
                        document.getElementById("modalLabel").innerHTML = "Assign Operation";
                        document.getElementById("modalText").innerHTML = "Personnel with id: " + pid + " assigned to project with id: " + project + " .";
                        $("#managerModal").modal("show");
            }
            else{
                res.json().then(error =>{
                    alert(error.message);
                });
            }
        });
        
    }

    function showRemoveProject(){

        var add = `<h2 class="h2 text-center">Please enter details for enrolling into a new project </h2> 
                        <div class="input-group mb-3 w-25 mx-auto">
                        <span class="input-group-text" id="label1">Personnel Id: </span>
                        <input type="text" class="form-control" id="pid" aria-describedby="apid">
                         <span class="input-group-text" id="label2">Project Id: </span>
                        <input type="text" class="form-control" id="pProjId" aria-describedby="apProjId">
                        </div>
                    <div class="text-center"><button type="button" class= "btn btn-primary" onclick="unenrollUser()">Unenroll User</button></div>`
    
                    document.getElementById("placeHolder").className = "mt-3";
                    document.getElementById("placeHolder").innerHTML = add;          
    }
    
    function unenrollUser(){
        var pid = document.getElementById("pid").value;
        var project = document.getElementById("pProjId").value;
    
        var url = `http://localhost:8080/api/v1/personnel/personnel=${pid}/removeProject=${project}`;
    
        var header = {
            method: "DELETE",
            headers : {
                "content-type": "application/json"
            }
        };
    
        fetch(url, header).then(res =>{

            if (res.status == 200){
                        document.getElementById("modalLabel").innerHTML = "Assign Operation";
                        document.getElementById("modalText").innerHTML = "Personnel with id: " + pid + " unassigned from project with id: " + project + " .";
                        $("#managerModal").modal("show");
            }
            else{
                res.json().then(error =>{
                    alert(error.message);
                });
            }
        });
        
    }

function showPersonnelProjects(){
    var project =   `<h2 class="h2 text-center">Please enter Personnel id to see current projects:  </h2> 
                        <div class="input-group mb-3 w-25 mx-auto">
                        <span class="input-group-text" id="label0">Id: </span>
                        <input type="text" class="form-control" id="pid" aria-describedby="apid">
                        </div>
                    <div class="text-center"><button type="button" class= "btn btn-primary" onclick="personnelProject()">Show Projects</button></div>`

    document.getElementById("placeHolder").className = "mt-3";
    document.getElementById("placeHolder").innerHTML = project;          
}

function personnelProject(){
    var pid = document.getElementById("pid").value;
    if (pid === ""){
        alert("Please insert Personnel id");
        return;

    }
    var url = `http://localhost:8080/api/v1/personnel/project/personnel=${pid}`;

    
    fetch(url).then(res => {
        if (res.status === 200){
            res.json().then(projectList => fillTablePersonProject(projectList));
        }
        else{
            res.json().then(error =>{
                alert(error.message);
            });
        }
    });
        
}

function fillTablePersonProject(projectList){
    var strTable= `<table class="table table-striped">
                        <thead>
                            <th> Project_Id</th>
                            <th> Name </th>
                        </thead>
                        
                        <tbody>`;

    for (i=0; i<projectList.length; i++){
        let project = projectList[i];
        
        strTable = strTable + `<tr>
                                    <td> ${project.projectId} </td>
                                    <td> ${project.name} </td>
                                </tr>`;

    }

    strTable = strTable + `</tbody>
                            </table>`;

    document.getElementById("placeHolder").className = "col-6 col-sm-5";
    document.getElementById("placeHolder").innerHTML = strTable;

}
function showProjectName(){
    var project =   `<h2 class="h2 text-center">Please enter Project name:  </h2> 
                        <div class="input-group mb-3 w-25 mx-auto">
                        <span class="input-group-text" id="label0">Project Name: </span>
                        <input type="text" class="form-control" id="pname" aria-describedby="aname">
                        </div>
                    <div class="text-center"><button type="button" class= "btn btn-primary" onclick="searchProject()">Search Project</button></div>`

    document.getElementById("placeHolder").className = "mt-3";
    document.getElementById("placeHolder").innerHTML = project;          
}

function searchProject(){
    var pname = document.getElementById("pname").value;

    if (pname === ""){
        alert("Please inform a Project Name!");
        return;
    }
    
    var url = `http://localhost:8080/api/v1/project/name=${pname}`;

    
    fetch(url).then(res => {
        if (res.status === 200){
            res.json().then(projec => fillTableOneProject(projec));
        }
        else{
            res.json().then(error =>{
                alert(error.message);
            });
        }
    });
}

function fillTableOneProject(project){
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
        
        strTable = strTable + `<tr>
                                    <td> ${project.projectId} </td>
                                    <td> ${project.name} </td>
                                    <td> ${project.moonManager.personnelId} </td>
                                    <td> ${project.moonManager.name} </td>
                                    <td> ${project.earthManager.personnelId} </td>
                                    <td> ${project.earthManager.name} </td>
                                    <td> ${project.building.name} </td>
                                </tr>`;

    strTable = strTable + `</tbody>
                            </table>`;

    document.getElementById("placeHolder").className = "mt-3";
    document.getElementById("placeHolder").innerHTML = strTable;

}