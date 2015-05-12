var diaryDao = {
	listDiary: function(callback) {
		$.getJSON('merzeelist.do', function(data) {
		console.log(data.ajaxResult.result);
			if (data.ajaxResult.status == "ok"){
				//clearDiary();
				callback( data.ajaxResult.result );
			} else {
				callback( null );
			}
		});
	}, 
};