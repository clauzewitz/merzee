window.onload = function() {
	var xhr = $.createRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) {
			if (xhr.status == 200) {
				var ajaxResult = JSON.parse(xhr.responseText).ajaxResult;
				if (ajaxResult.status == "ok") {
					var studentList = ajaxResult.result;
					var studentTable = document.getElementById("studentTable");
					for(var i in studentList) {
						studentTable.appendChild( createTR(studentList[i]) );
					}
				} else {
					alert(ajaxResult.result);
				}
			}
		}
	};
	xhr.open('GET', 'list.do', true);
	xhr.send();
};

function createTR(student) {
	var tr = document.createElement("tr");
	tr.appendChild( createTD(student.no));
	tr.appendChild( createTD(student.name, function(event){
		var xhr = $.createRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) {
				if (xhr.status == 200) {
					var ajaxResult = JSON.parse(xhr.responseText).ajaxResult;
					if (ajaxResult.status == "ok") {
						var student = ajaxResult.result;
						document.getElementById("no").value = student.no;
						document.getElementById("name").value = student.name;
						document.getElementById("mobile").value = student.mobile;
						document.getElementById("email").value = student.email;
						document.getElementById("address").value = student.address;
						document.getElementById("working").value = student.working;
						if(student.gender == 0){
							document.getElementById("female").checked = true;
							document.getElementById("male").checked = false;
						} else { 
							document.getElementById("female").checked = false;
							document.getElementById("male").checked = true;
						}
					} else {
						alert(ajaxResult.result);
					}
				}
			}
		};
		xhr.open('GET', 'detail.do?no=' + this.getAttribute("pk"), true);
		xhr.send();
		
		event.preventDefault(); // 해당 태그의 기본 행동을 막는다.
	}, student.no));
	tr.appendChild( createTD(student.mobile));
	tr.appendChild( createTD(student.email));
	tr.appendChild( createTD(student.working));
	tr.appendChild( createTD("삭제", "delete.do?no=" + student.no));
	return tr;
}

function createTD(value, listener, pk) {
	var td = document.createElement("td");
	if (listener == undefined) {
		td.innerHTML = value;
		
	} else {
		var a = document.createElement("a");
		a.href = "http://www.naver.com";
		a.innerHTML = value;
		a.setAttribute("pk", pk);
		$.registerEventListener(a, 'click', listener);
		td.appendChild(a);
	}
	return td;
}












