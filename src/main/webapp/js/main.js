function confirmToDelete() {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#04aa83',
        cancelButtonColor: '#ed5e68',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            document.getElementById("delete-student").click();
            Swal.fire(
                'Deleted!',
                'Your file has been deleted.',
                'success'
            )
        }
    })
    return false
}

function confirmOnEdit() {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#04aa83',
        cancelButtonColor: '#ed5e68',
        confirmButtonText: 'Yes, edit it!'
    }).then((result) => {
        if (result.isConfirmed) {
            document.getElementById("edit-student").click();
            Swal.fire(
                'Edited!',
                'Your field has been modified.',
                'success'
            )
        }
    })
    return false}

function validateForm() {
    var data = document.getElementById("ssn").value;
    if (data == "" || data.length < 4) {
        document.getElementById("errMsg").style.display = "block";
    } else {
        //ajax
        sendAsyncDataToRestService();
    }
    return false;
}

function sendAsyncDataToRestService() {

    var data = document.getElementById("ssn").value;
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/student-find-by-ssn.do?ssn=" + data, true);




   //callback functions

    xhr.onreadystatechange = function () {
        document.getElementById("error-msg").style.display = "none";
        document.getElementById("st-table").style.display = "none";

        if (xhr.readyState == 4 && xhr.status == 200) {
            var student = xhr.responseText;
            console.log(JSON.parse(student))
            console.log(student)
            var studentData = JSON.parse(student);
            document.getElementById("st-table").style.display = "block";
            document.getElementById("id").innerText = studentData.id;
            document.getElementById("name").innerText = studentData.name;
            document.getElementById("family").innerText = studentData.family;
            document.getElementById("major").innerText = studentData.major;
            document.getElementById("ssnn").innerText = studentData.ssn;
        }if(xhr.readyState == 4 && xhr.status == 500){
            var errorMessage = xhr.responseText;
            document.getElementById("error-msg").style.display = "block";
            document.getElementById("error-msg").innerText = errorMessage;
        }


    }

    xhr.send("ssn=" + data);



}
