var studentDao = {
	listStudent: function(callback) {
		$.getJSON('list.do', function(data) {
			if (data.ajaxResult.status == "ok"){
				clearStudentTable();
				callback( data.ajaxResult.result );
			} else {
				callback( null );
			}
		});
	}, 
	detailStudent: function(callback, no) {
		$.getJSON('detail.do?no=' + no, function(data) {
			if (data.ajaxResult.status == "ok") {
				callback(data.ajaxResult.result);
			} else {
				callback(null);
			}
		});
	},
	deleteStudent: function(callback, no) {
		$.getJSON('delete.do?no=' + no, function(data) {
			if (data.ajaxResult.status == "ok") {
				callback("ok");
			} else {
				callback(null);
			}
		});
	},
	updateStudent: function(callback, student) {
		$.post('update.do', {
				no: student.no,
				name: student.name,
				mobile: student.mobile,
				email: student.email,
				address: student.address,
				working: student.working,
				gender: student.gender
			},	
			function(data) {
				if (data.ajaxResult.status == "ok") {
					callback("ok");
				} else {
					callback(null);
				}
			},
			'json'
		);
	},
	addStudent: function(callback, student) {
		$.post('add.do', {
				name: student.name,
				mobile: student.mobile,
				email: student.email,
				address: student.address,
				working: student.working,
				gender: student.gender
			},	
			function(data) {
				if (data.ajaxResult.status == "ok") {
					callback("ok");
				} else {
					callback(null);
				}
			},
			'json'
		);
	}
};







