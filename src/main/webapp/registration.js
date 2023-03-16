function clearErrorMessage() {
	document.getElementById("errorMsgEmployeeId").innerHTML = "";
	document.getElementById("errorMsgEmployeeName").innerHTML = "";
	document.getElementById("errorMsgDOB").innerHTML = "";
	document.getElementById("errorMsgDesignation").innerHTML = "";
	document.getElementById("errorMsgCurrentCTC").innerHTML = "";	
}
function validcheck() { 
	var employeeid = document.getElementById("employeeid").value;
	var employeename = document.getElementById("employeename").value;
	var employeedob = document.getElementById("employeedob").value;
	var employeedesignation = document.getElementById("employeedesignation").value;
	var employeeSalary = document.getElementById("employeeSalary").value;
	var employeeSalary = document.getElementById("employeeMobileno").value;

	if (employeeid == "" || employeeid == null) {
		document.getElementById("errorMsgEmployeeId").innerHTML = "please enter Id";
		return false;
	} else if (employeename == "" || employeename == null) {
		document.getElementById("errorMsgEmployeeName").innerHTML = "please enter Name";
		return false;
	} else if (employeedob == "" || employeedob == null) {
		document.getElementById("errorMsgDOB").innerHTML = "please enter DOB";
		return false;
	} else if (employeedesignation == "" || employeedesignation == null
			|| employeedesignation == "Select an Option") {
		document.getElementById("errorMsgDesignation").innerHTML = "please enter Designation";
		return false;
	} else if (employeeSalary == "" || employeeSalary == null) {
		document.getElementById("errorMsgCurrentCTC").innerHTML = "please enter CurrentCTC";
		return false;
	} else if (employeeMobileno == "" || employeeMobileno == null) {
		document.getElementById("errorMsgEmployeeMobileno").innerHTML = "please enter Mobile Number";
		return false;
	}else {
		return true;
	}

}