function confirmToDelete() {
    return confirm("Are you sure to delete?");
}

function confirmOnEdit() {
    return confirm("Do you like to edit?");
}

function validateRegisterForm() {

    document.getElementById("errMsg").style.display = "none";
    document.getElementById("errMsgSSN").style.display = "none";
    document.getElementById("errMsgName").style.display = "none";
    document.getElementById("errMsgFamily").style.display = "none";
    document.getElementById("errMsgMajor").style.display = "none";

    var ssn = document.getElementById("ssn").value;
    var fname = document.getElementById("fname").value;
    var family = document.getElementById("family").value;
    var major = document.getElementById("major").value;
    if (ssn == "" && fname == "" && family == "" && major == "") {
        document.getElementById("errMsg").style.display = "block";
        document.getElementById("errMsg").innerText = "* All form fields must be filled";
    } else {

        if (ssn == "") {
            document.getElementById("errMsgSSN").style.display = "block";
            document.getElementById("errMsgSSN").innerText = "* SSN value must be filled";
        } else if (isNaN(ssn) || ssn.length !== 4){
            document.getElementById("errMsgSSN").style.display = "block";
            document.getElementById("errMsgSSN").innerText = "* SSN value must be a number with 4 digit";
        }
        else if (fname == "") {
            document.getElementById("errMsgName").style.display = "block";
        } else if (family == "") {
            document.getElementById("errMsgFamily").style.display = "block";
        } else if (major == "") {
            document.getElementById("errMsgMajor").style.display = "block";
        } else {
            return true;
        }
    }
    return false;
}

function validateForm() {
    document.getElementById("errMsg").style.display = "none";

    var data = document.getElementById("ssn").value;
    if (data == "") {
        document.getElementById("errMsg").style.display = "block";
        document.getElementById("errMsg").innerText = "* SSN value must be filled";
    }
    else if (isNaN(data) || data.length !== 4){
        document.getElementById("errMsg").style.display = "block";
        document.getElementById("errMsg").innerText = "* SSN value must be a number with 4 digit";
    }
    else {
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
