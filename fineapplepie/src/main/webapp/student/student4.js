window.onload = function() {
	//$('#form').load('studentform4.html');
	
	$('#form').load('studentform4.html',function(){
		//clearForm();
		$('#updateBtn').css('display', 'none');
	});
		
	
	reloadStudentTable();		
	$(document).on('click', '#addBtn',function(){
		$.post('add.do', 
			{
				name: $('#name').value(),
				mobile: $('#mobile').value(),
				email: $('#email').value(),
				address: $('#address').value(),
				working: $('#working').value(),
				gender: $('input:radio[name=gender]:checked').val()
			},
			function(data) {
				if(data.ajaxResult.status == "ok"){
					reloadStudentTable();
					clearForm();
				}else{
					alert("학생 등록 실패");
				}
			}
			,'json');
	});
	
		
	$(document).on('click','#cancelBtn',function(){
		clearForm();
	});
	
	
	$(document).on('click','#updateBtn',function(){
		$.post('update.do', {			
			no: encodeURIComponent($('#no').val()),			
			name: encodeURIComponent($('#name').val()),			
			mobile: encodeURIComponent($('#mobile').val()),			
			email: encodeURIComponent($('#email').val()),
			address: encodeURIComponent($('#address').val()),
			working: $('#working').val(),
			gender: $('input:radio[name=gender]:checked').val()
			},
			function(data) {
				if(data.ajaxResult.status == "ok"){
					reloadStudentTable();
					clearForm();
				}else{
					alert("학생을 변경할수 없음..");
				}
			}
		);
	},'json');	
};

function reloadStudentTable() {
	$.getJSON('list.do', function(data) {
			if (data.ajaxResult.status == "ok"){
				clearStudentTable();
				var studentList = data.ajaxResult.result;
				var studentTable = $("#studentTable");
				for(var i in studentList) {
					studentTable.append( createTR(studentList[i]) );
				}
			} else {
				alert(data.result);
			}
		});
}

function createTR(student) {
	var tr = $("<tr></tr>").addClass('studentRow');
	tr.append( createTD(student.no));
	tr.append( createTD(student.name, function(event){
		$.getJSON('detail.do?no=' + student.no, function(data) {
			if(data.ajaxResult.status == 'ok'){
			var student = data.ajaxResult.result;
				$("#no").val(student.no);
				$("#name").val(student.name);
				$("#mobile").val(student.mobile);
				$("#email").val(student.email);
				$("#address").val(student.address);				
				$("#working option[value ="+student.working+"]")[0].selected = true;
				
				if(student.working == false){
					$('#working #option[value = true]');
					$("#working option[]").prop("selected", "selected");
					$("#working option:eq(1)").remove("selected");
				}else{
					$("#working option:eq(0)").prop("selected", "selected");
					$("#working option:eq(1)").remove("selected");
				}				
				
				if(student.gender == 0){
					$("#female")[0].checked = true;
					$("#male")[0].checked = false;
				} else {
					$("#female")[0].checked = false;
					$("#male")[0].checked = true;
				}
				
				$('#addBtn').css('display', "none");
				$('#updateBtn').css('display', "");
				
				}else{
					alert("학생정보를 찾을수 없습니다.");
				}
			});
		
		event.preventDefault(); // 해당 태그의 기본 행동을 막는다.
	}, student.no));
	
	tr.append( createTD(student.mobile));
	tr.append( createTD(student.email));
	tr.append( createTD(student.working));
	
	tr.append( createTD("삭제", function(event){
		$.getJSON('delete.do?no=' + student.no, function(result) {
			if(data.ajaxResult.status == 'ok'){	
			reloadStudentTable();
			
		}else{
			alert("삭제 실패..");
		}}
		);
		event.preventDefault(); // 해당 태그의 기본 행동을 막는다.
	}, student.no));
	return tr;
}

function clearStudentTable() {
	var trList = $(".studentRow");
	trList.remove();
}

function clearForm() {
	$('studentForm')[0].reset();
	//$('#cancelBtn').trigger('click');
	$('#addBtn').css('display','');
	$('#updateBtn').css('display','none');
}

function createTD(value, listener, pk) {
	var td = $("<td/>");
	if (listener == undefined) {
		if ((typeof value) == "boolean") {
			td.html( value ? "T" : "F" );
		} else {	td.text( value );	}		
	} else {
		$("<a></a>", {
			'href': "#",
			'pk' : pk
		}).html( value ).click(listener).appendTo(td);		
	}
	return td;
}
