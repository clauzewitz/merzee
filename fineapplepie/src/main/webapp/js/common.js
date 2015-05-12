function bitLibrary(value) {
	var element;
	
	if (value.charAt(0) == "#") {
		element = document.getElementById(value.substr(1));
	} else if (value.charAt(0) == "<") {
		var i = value.indexOf(">");
		element = document.createElement(value.substring(1, i));
	} else {
		element = document.getElementsByTagName(value);
	}
	
	element.on = function(event, listener){
		if (this.addEventListener) {
	        this.addEventListener(event, listener, false);
	    } else if (node.attachEvent) {
	        this.attachEvent('on' + event, listener);
	    }
	};
	
	element.click = function(listener) {
		this.on('click', listener);
	};
	
	return element;
}

var $ = bitLibrary;





// 호출 예)
/*
bitLibrary.ajax('detail.do?no=3', {
	method: 'GET',
	success: function(result){}
});
*/
bitLibrary.ajax = function(url, option) {
	var xhr = bitLibrary.createRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) {
			if (xhr.status == 200) {
				var ajaxResult = JSON.parse(xhr.responseText).ajaxResult;
				if (ajaxResult.status == "ok") {
					option.success(ajaxResult.result);
				} else {
					alert(ajaxResult.result);
				}
			}
		}
	};
	xhr.open(option.method, url, true);
	if (option.method.toUpperCase() == "POST") {
		console.log(option.data);
		xhr.setRequestHeader('Content-Type', 
				'application/x-www-form-urlencoded');
		xhr.send(bitLibrary.toParamString(option.data));
	} else {
		xhr.send();
	}
};



bitLibrary.createRequest = function() {
    var request;
    try {
        request = new XMLHttpRequest();
    } catch (exception) {
        try {
            request = new ActiveXObject('Msxml2.XMLHTTP');
        } catch (innerException) {
            request = new ActiveXObject('Microsoft.XMLHTTP');
        }
    }
    return request;
};

bitLibrary.registerEventListener = function(node, event, listener) {
    if (node.addEventListener) {
        // 파이어폭스, 크롬, 사파리, 오페라
        node.addEventListener(event, listener, false);
    } else if (node.attachEvent) {
        // 인터넷 익스플로러
        node.attachEvent('on' + event, listener);
    }
};

bitLibrary.toParamString = function(obj) {
	var result = "";
	for(var propName in obj) {
		if (result != "") 
			result += "&";
		result += propName + "=" + obj[propName];
	}
	return result;
};














