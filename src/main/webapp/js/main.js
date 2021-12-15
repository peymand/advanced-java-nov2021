function confirmToDelete() {
//     Swal.fire({
//         title: 'Are you sure?',
//         text: "You won't be able to revert this!",
//         icon: 'warning',
//         showCancelButton: true,
//         confirmButtonColor: '#04aa83',
//         cancelButtonColor: '#ed5e68',
//         confirmButtonText: 'Yes, delete it!'
//     }).then((result) = > {
//         if(result.isConfirmed
// )
//     {
//         document.getElementById("delete-student").click();
//         Swal.fire(
//             'Deleted!',
//             'Your file has been deleted.',
//             'success'
//         )
//     }
// })
    return false
}

function confirmOnEdit() {
//     Swal.fire({
//         title: 'Are you sure?',
//         text: "You won't be able to revert this!",
//         icon: 'warning',
//         showCancelButton: true,
//         confirmButtonColor: '#04aa83',
//         cancelButtonColor: '#ed5e68',
//         confirmButtonText: 'Yes, edit it!'
//     }).then((result) = > {
//         if(result.isConfirmed
// )
//     {
//         document.getElementById("edit-student").click();
//         Swal.fire(
//             'Edited!',
//             'Your field has been modified.',
//             'success'
//         )
//     }
// })
//     return false
}

function validateRegisterForm() {



    document.getElementById("errMsg").style.display = "none";
    document.getElementById("errMsgSSN").style.display = "none";
    document.getElementById("errMsgName").style.display = "none";
    document.getElementById("errMsgFamily").style.display = "none";
    document.getElementById("errMsgMajor").style.display = "none";
    document.getElementById("errMsgBook").style.display = "none";

    var ssn = document.getElementById("ssn").value;
    var fname = document.getElementById("fname").value;
    var family = document.getElementById("family").value;
    var major = document.getElementById("major").value;
    var book = document.getElementById("bookTextVar").value;

    if (ssn == "" && fname == "" && family == "" && major == "" && book == "") {
        document.getElementById("errMsg").style.display = "block";
        document.getElementById("errMsg").innerText = "* All form fields must be filled";
        return false;
    } else {

        if (ssn == "") {
            document.getElementById("errMsgSSN").style.display = "block";
            document.getElementById("errMsgSSN").innerText = "* SSN value must be filled";
            return false;
        } else if (isNaN(ssn) || ssn.length !== 4) {
            document.getElementById("errMsgSSN").style.display = "block";
            document.getElementById("errMsgSSN").innerText = "* SSN value must be a number with 4 digit";
            return false;
        } else if (fname == "") {
            document.getElementById("errMsgName").style.display = "block";
            return false;
        } else if (family == "") {
            document.getElementById("errMsgFamily").style.display = "block";
            return false;
        } else if (major == "") {
            document.getElementById("errMsgMajor").style.display = "block";
            return false;
        } else if (book == "") {
            document.getElementById("errMsgBook").style.display = "block";
            return false;
        } else {
            document.getElementById("register-student").style.display = "block";
            document.getElementById("validation-register-student").style.display = "none";
            var result = sendAsyncDataToRestService();
            return result;
        }
    }


}

function validateForm() {
    document.getElementById("errMsg").style.display = "none";

    var data = document.getElementById("ssn").value;
    if (data == "") {
        document.getElementById("errMsg").style.display = "block";
        document.getElementById("errMsg").innerText = "* SSN value must be filled";
    } else if (isNaN(data) || data.length !== 4) {
        document.getElementById("errMsg").style.display = "block";
        document.getElementById("errMsg").innerText = "* SSN value must be a number with 4 digit";
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

            var result = xhr.responseText;

            var resultJson = JSON.parse(student);
            if(resultJson.message == "OK"){
                return true;
            }
            else{
                document.getElementById("st-table").style.display = "block";
                document.getElementById("id").innerText = studentData.id;
                document.getElementById("name").innerText = studentData.name;
                document.getElementById("family").innerText = studentData.family;
                document.getElementById("major").innerText = studentData.major;
                document.getElementById("ssnn").innerText = studentData.ssn;
                //TODO: to show an error message which declare ssn in duplicate
                alert("ssn is duplicate")
                return false;
            }

        }
        if (xhr.readyState == 4 && xhr.status == 500) {
            var errorMessage = xhr.responseText;
            document.getElementById("error-msg").style.display = "block";
            document.getElementById("error-msg").innerText = errorMessage;
        }


    }

    xhr.send("ssn=" + data);


}

function openModal() {

    var modal = document.getElementById("myModal");
    modal.style.display = "block";

    var span = document.getElementsByClassName("close")[0];
    span.onclick = function () {
        modal.style.display = "none"
    }

    return false;

}

function sendBookDataToRegForm() {
    var modal = document.getElementById("myModal");


    var title = document.getElementById("title").value;
    var price = document.getElementById("price").value;

    if(title != "" || price != ""){
        var book = {"title": title, "price": price};
        var bookJson = JSON.stringify(book);
        document.getElementById("bookText").innerText = bookJson;
        document.getElementById("bookTextVar").value = bookJson;
        document.getElementById("errMsgBook").style.display = "none";
    }
    else{
        document.getElementById("bookText").innerText = "";
        document.getElementById("bookTextVar").value = "";
        document.getElementById("errMsgBook").style.display = "block";
    }

    modal.style.display = "none";
    return false;
}


window.onclick = function (event) {

    var modal = document.getElementById("myModal");
    if (event.target == modal) {
        modal.style.display = "none"

    }

}