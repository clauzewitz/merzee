window.onload = function() {
	$('#updateBtn').style.display = "none";
	reloadStudentTable(); 
	$('#addBtn').click(function(){
		$.ajax('add.do', {
			method: 'POST',
			data: {
				name: encodeURIComponent($('#name').value),
				mobile: encodeURIComponent($('#mobile').value),
				email: encodeURIComponent($('#email').value),
				address: encodeURIComponent($('#address').value),
				working: $('#working').value,
				gender: $('#female').checked ? 0 : 1
			},
			success: function(result) {
				reloadStudentTable();
				clearForm();
			}
		});
	});
	$('#cancelBtn').click(function(){
		clearForm();
	});
	$('#updateBtn').click(function(){
		$.ajax('update.do', {
			method: 'POST',
			data: {
				no: encodeURIComponent($('#no').value),
				name: encodeURIComponent($('#name').value),
				mobile: encodeURIComponent($('#mobile').value),
				email: encodeURIComponent($('#email').value),
				address: encodeURIComponent($('#address').value),
				working: $('#working').value,
				gender: $('#female').checked ? 0 : 1
			},
			success: function(result) {
				reloadStudentTable();
				clearForm();
			}
		});
	});
};

function reloadStudentTable() {
	$.ajax('list.do', {
		method: 'GET',
		success: function(result) {
			clearStudentTable();
			var studentList = result;
			var studentTable = $("#studentTable");
			for(var i in studentList) {
				studentTable.appendChild( createTR(studentList[i]) );
			}
		}
	});
}

function createTR(student) {
	var tr = $("<tr>");
	tr.appendChild( createTD(student.no));
	tr.appendChild( createTD(student.name, function(event){
		$.ajax('detail.do?no=' + student.no, {
			method: 'GET', 
			success: function(result) {
				var student = result;
				$("#no").value = student.no;
				$("#name").value = student.name;
				$("#mobile").value = student.mobile;
				$("#email").value = student.email;
				$("#address").value = student.address;
				$("#working").value = student.working;
				if(student.gender == 0){
					$("#female").checked = true;
					$("#male").checked = false;
				} else { 
					$("#female").checked = false;
					$("#male").checked = true;
				}
				$('#addBtn').style.display = "none";
				$('#updateBtn').style.display = "";
			}
		});
		event.preventDefault(); // 해당 태그의 기본 행동을 막는다.
	}, student.no));
	
	tr.appendChild( createTD(student.mobile));
	tr.appendChild( createTD(student.email));
	tr.appendChild( createTD(student.working));
	tr.appendChild( createTD("삭제", function(event){
		$.ajax('delete.do?no=' + student.no, {
			method: 'GET', 
			success: function(result) {
				reloadStudentTable();
			}
		});
		event.preventDefault(); // 해당 태그의 기본 행동을 막는다.
	}, student.no));
	return tr;
}

function clearStudentTable() {
	var trList = $("tr");
	var studentTable = $("#studentTable"); 
	for (var i = (trList.length - 1); i > 0; i--) {
		studentTable.removeChild(trList[i]);
	}
}

function clearForm() {
	$('#studentForm').reset();
	$('#addBtn').style.display = "";
	$('#updateBtn').style.display = "none";
}

function createTD(value, listener, pk) {
	var td = $("<td>");
	if (listener == undefined) {
		td.innerHTML = value;
		
	} else {
		var a = $("<a>");
		a.href = "http://www.naver.com";
		a.innerHTML = value;
		a.setAttribute("pk", pk);
		//a.on('click', listener);
		a.click(listener);
		td.appendChild(a);
	}
	return td;
}












