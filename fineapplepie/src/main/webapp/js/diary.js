window.onload = function() {
	reloadDiary();
	slide();
};

function reloadDiary() {
	diaryDao.listDiary(function(diaryList) {
		if (diaryList == null) {
			return;
		}
		var slideInner = $("#slideInner");
		//clearDiary();
		for(var i in diaryList) {
			slideInner.append( createDiv(diaryList[i]) );
		}
	});
}

function createDiv(diary) {
    var div = $("<div/>").addClass('slide');
	//div.append(createIMG(diary.getDry_photo, function(event) {
   //		diaryDao.detailDiary(function(diary) {
			
	//		}, diary.getDry_id);
	//}, diary.getDry_id));
	div.append($('<img/>').attr({ src: diary.dry_photo, alt: diary.dry_name, width: '200px', height: '200px' }));
	return div;
}

function clearDiary() {
	$(".slide").remove();
}

function clearForm() {
	$('#studentForm')[0].reset();
	//$('#cancelBtn').trigger('click');
	$('#addBtn').css('display', '');
	$('#updateBtn').css('display', 'none');
}

function createIMG(value, listener, pk) {
	var img = $("<img/>");
	$("<a></a>", {
		'href': "#",
		"pk": pk
	}).click(listener).append(img.attr('src', value));
	
	return img;
}












