function loaduser(){
    document.getElementById("userid").innerHTML= "Userid: "+ sessionStorage.getItem('id');
    document.getElementById("title").innerHTML= "" + sessionStorage.getItem('title');
    document.getElementById("name").innerHTML= "Name: " + sessionStorage.getItem('name');
}

function logout(){
    window.location="index.html";
    sessionStorage.clear();
}

function showViewProjects(){

    var id = sessionStorage.getItem('id');

    var url = `http://localhost:8080/api/v1/personnel/project/personnel=${id}`;

    
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
                                    <td> ${project.moonManager?.personnelId} </td>
                                    <td> ${project.moonManager?.name} </td>
                                    <td> ${project.earthManager?.personnelId} </td>
                                    <td> ${project.earthManager?.name} </td>
                                    <td> ${project.building.name} </td>
                                </tr>`;

    }

    strTable = strTable + `</tbody>
                            </table>`;

    document.getElementById("placeHolder").className = "mt-3";
    document.getElementById("placeHolder").innerHTML = strTable;

}