window.onload = function() {
	$('#form').load('StudentForm5.html');
	reloadStudentTable();
	$(document).on('click', '#addBtn', function(){
		studentDao.addStudent(function(result) {
				if (result == null) {
					alert('학생을 등록할 수 없습니다!');
					return;
				}
				reloadStudentTable();
				clearForm();
			}, {
				name: encodeURIComponent($('#name').val()),
				mobile: encodeURIComponent($('#mobile').val()),
				email: encodeURIComponent($('#email').val()),
				address: encodeURIComponent($('#address').val()),
				working: $('#working').val(),
				gender: $('input:radio[name=gender]:checked').val()
			}
		);
	});
	$(document).on('click', '#cancelBtn', function(){
		clearForm();
	});
	$(document).on('click', '#updateBtn', function(){
		studentDao.updateStudent(function(result) {
				if (result == null) {
					alert('학생정보를 변경할 수 없습니다!');
					return;
					}
				reloadStudentTable();
				clearForm();
			}, {
				no: $('#no').val(),
				name: encodeURIComponent($('#name').val()),
				mobile: encodeURIComponent($('#mobile').val()),
				email: encodeURIComponent($('#email').val()),
				address: encodeURIComponent($('#address').val()),
				working: $('#working').val(),
				gender: $('input:radio[name=gender]:checked').val()
			}
		);
	});
};

function reloadStudentTable() {
	studentDao.listStudent(function(studentList) {
		if (studentList == null) {
			alert("학생목록을 가져오지 못했습니다!");
			return;
		}
		var studentTable = $("#studentTable");
		for(var i in studentList) {
			studentTable.append( createTR(studentList[i]) );
		}
	});
}

function createTR(student) {
	var tr = $("<tr/>").addClass('studentRow');
	tr.append( createTD(student.no));
	tr.append( createTD(student.name, function(event){
		studentDao.detailStudent(function(student) {
			if (student == null) {
				alert("학생정보를 찾을 수 없습니다!");
				return;
			}
			$("#no").val( student.no );
			$("#name").val( student.name );
			$("#mobile").val( student.mobile );
			$("#email").val( student.email );
			$("#address").val( student.address );
			$("#working option[value=" + student.working + "]")[0].selected = true;
			if(student.gender == 0){
				$("#female")[0].checked = true;
				$("#male")[0].checked = false;
			} else { 
				$("#female")[0].checked = false;
				$("#male")[0].checked = true;
			}
			$('#addBtn').css('display', "none");
			$('#updateBtn').css('display', "");
		}, student.no);
		event.preventDefault(); // 해당 태그의 기본 행동을 막는다.
	}, student.no));
	
	tr.append( createTD(student.mobile));
	tr.append( createTD(student.email));
	tr.append( createTD(student.working));
	tr.append( createTD("삭제", function(event){
		studentDao.deleteStudent(function(result) {
			if (student == null) {
				alert("학생정보를 삭제할 수 없습니다!");
				return;
			}
			reloadStudentTable();
		}, student.no);
		event.preventDefault(); // 해당 태그의 기본 행동을 막는다.
	}, student.no));
	return tr;
}

function clearStudentTable() {
	var trList = $(".studentRow");
	trList.remove();
}

function clearForm() {
	$('#studentForm')[0].reset();
	//$('#cancelBtn').trigger('click');
	$('#addBtn').css('display', '');
	$('#updateBtn').css('display', 'none');
}

function createTD(value, listener, pk) {
	var td = $("<td/>");
	if (listener == undefined) {
		if ((typeof value) == "boolean") {
			td.html( value ? "T" : "F" );
		} else {
			td.text( value );
		}
		
	} else {
		$("<a></a>", {
			'href': "#",
			"pk": pk
		}).html( value ).click(listener).appendTo(td);
	}
	return td;
}












