function handleFileSelect(evt) {
	var files = evt.target.files; // FileList object
	$('.thumb').remove();
    // Loop through the FileList and render image files as thumbnails.
    for (var i = 0, f; f = files[i]; i++) {

    // Only process image files.
    if (!f.type.match('image.*')) {
    	continue;
    }

    var reader = new FileReader();

    // Closure to capture the file information.
    reader.onload = (function (theFile) {
    	return function (e) {
    		// Render thumbnail.
    		//var span = document.createElement('span');
    		//span.innerHTML = ['<img class="thumb" src="', e.target.result,
    		//'" title="', escape(theFile.name), '"/>'].join('');
    		//document.getElementById('list').insertBefore(span, null);
    		$('#list').append($('<img/>').attr({ class: 'thumb', title: escape(theFile.name), src: e.target.result, width: '150px', height: '150px' }));
		console.log(e.target.result + "/" + theFile.name);
    	};
    })(f);

    // Read in the image file as a data URL.
    reader.readAsDataURL(f);
    }
}
document.addEventListener('DOMContentLoaded', function(){
	document.getElementById('files').addEventListener('change', handleFileSelect, false);
}, false);