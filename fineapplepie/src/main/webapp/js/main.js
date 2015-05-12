var speed = 3;
var shipdirection = -1;
var shipInterval = 0;
var shiningInterval = 0;
var maxwidth = $(window).width();
var cloudpos = [{x:$(window).width()-Math.floor(Math.random()*800),y:Math.floor(Math.random()*200)+97,
		speed:Math.random()*2.5,width:219,height:97},
		{x:$(window).width()-Math.floor(Math.random()*800),y:Math.floor(Math.random()*200)+66,
		speed:Math.random()*2.5,width:128,height:66},
		{x:$(window).width()-Math.floor(Math.random()*800),y:Math.floor(Math.random()*200)+34,
		speed:Math.random()*2.5,width:51,height:34},
		{x:$(window).width()-Math.floor(Math.random()*800),y:Math.floor(Math.random()*200)+49,
		speed:Math.random()*2.5,width:88,height:49},
		{x:$(window).width()-Math.floor(Math.random()*800),y:Math.floor(Math.random()*200)+12,
		speed:Math.random()*2.5,width:219,height:97}];

$(function(){
	var cloudArry = [$("#cloud1"),$("#cloud2"),$("#cloud3"),$("#cloud4"),$("#cloud5")];
	timer = setInterval(function(){			
		for(var i = 0;i < 5 ;i++){
			if(cloudpos[i].x < -(cloudpos[i].width)){
				if(maxwidth < $(window).width()){maxwidth = $(window).width();}
				cloudpos[i].x = maxwidth;
				cloudpos[i].y = Math.floor(Math.random()*200) +  cloudpos[i].height;
				cloudpos[i].speed = 1.6 + Math.random()*0.9;
			}
				cloudpos[i].x -= cloudpos[i].speed;
			cloudArry[i].css("left",cloudpos[i].x+"px");
			cloudArry[i].css("top",cloudpos[i].y+"px");
		}

		//ship
		
		var ship = $('#ship');				
		var height = (ship.css("top").replace("px","") * 1);
		if(shipdirection == -1){  				
			height -= 0.12;
			ship.css("top",height+"px");
			if(height < 696){
				shipdirection = 1;
				ship.css("left","999px");
			}
		}else if(shipdirection == 1){
			height += 0.12;
			ship.css("top",height+"px");
			if(height > 700){ 
				shipdirection = -1;
				ship.css("left","1000px");
			}					
		}
		
		//shining
		var shining1 = $("#shining1");
		var shining2 = $("#shining2");
		var shining3 = $("#shining3");

		shiningInterval++;
		if(shiningInterval >3){
			shiningInterval = 0;
			if(shining1.css("display") == "none"){
				shining1.css("display","");
				shining2.css("display","none");
				shining3.css("display","");
			}else if(shining2.css("display") == "none"){
				shining1.css("display","");
				shining2.css("display","");
				shining3.css("display","none");
			}
			else{				
				shining1.css("display","none");
				shining2.css("display","");
				shining3.css("display","");
			}
		}
		
		}, 60);

});
function hoverEvent(){
	$("#logo").hover(
		function(){$(this).attr("src","imgs/merzee_bling.png");},
		function(){$(this).attr("src","imgs/merzee_white.png");}
	);
	
	$(".menu").hover(
		function(){$(this).css("text-shadow","0px 0px 8px #ffffff");},
		function(){$(this).css("text-shadow","");});
};

function manAction(){
		$("#manon").children("img").css("display","none");
		$("#manoff").children("img").css("display","");
}
function womanAction() {
    $("#womanon").children("img").css("display", "none");
    $("#womanon2").children("img").css("display", "none");
    $("#womanoff").children("img").css("display", "");
}

function humandisplay(){
	$("#manon").children("img").css("display","none");
		$("#manoff").click(function(){
			if($("#manoff").children("img").css("display") == "none"){return false;}
			$("#manon").children("img").css("display","");
			$("#manoff").children("img").css("display","none");
			setTimeout(manAction,500);
		});
        
		$("#womanon").children("img").css("display", "none");
		$("#womanon2").children("img").css("display", "none");
		$("#womanoff").click(function () {
		    if ($("#womanoff").children("img").css("display") == "none") { return false; }
		    var ran = Math.floor(Math.random() * 2);
		    if (ran == 0) {
		        $("#womanon").children("img").css("display", "");
		        $("#womanoff").children("img").css("display", "none");
		    } else if (ran == 1) {
		        $("#womanon2").children("img").css("display", "");
		        $("#womanoff").children("img").css("display", "none");
		    }
		setTimeout(womanAction, 500);
	});
};
function umbrelladisplay(){
	$("#umbrellaon").children("img").css("display", "none");
		$("#umbrella").click(function () {
		    if ($("#umbrellaoff").children("img").css("display") == "none") {  // �����ִٸ�
		        $("#umbrellaon").children("img").css("display", "none");
		        $("#umbrellaoff").children("img").css("display", "");
		    } else if ($("#umbrellaon").children("img").css("display") == "none") {  // �����ִٸ�
		        $("#umbrellaon").children("img").css("display", "");
		        $("#umbrellaoff").children("img").css("display", "none");
		    }
		    return false;
		});
};
function joinDialog(){
	$("#join_dialog").dialog({
		  autoOpen: false,width: 500,
		 height: 600,position: [400,100],
		  modal: true
	});
	$("#join_dialog").dialog().parents(".ui-dialog").find(".ui-dialog-titlebar").remove();
	$("#joinText").click(function(){
		clearForm();
		$("#join_dialog").dialog("open");
	});
	$("#join_close").click(function(){
		$("#join_dialog").dialog("close");
	});
	
};
function loginDialog(){
	$("#login_dialog").dialog({
		  autoOpen: false,width: 500,
		 height: 350,position: [400,250],
		  modal: true
	});
	$("#login_dialog").dialog().parents(".ui-dialog").find(".ui-dialog-titlebar").remove();
	$("#loginText").click(function(){
	    $("#login_dialog").dialog("open");	    
	});

	$("#login_close").click(function(){
	    $("#login_dialog").dialog("close");
	    clearSession();
	});
};
function loginCheck() {
    if(($('#EmailForm').val() != '') && ($('#PasswordForm').val() != '')) {
		setSession();
		document.login_form.submit();
	} else if($('#EmailForm').val() == '') {
		alert("아이디를 입력해주세요.");
		document.login_form.email.focus();
	} else if($('#PasswordForm').val() == '') {
		alert("비밀번호를 입력해주세요.");
		document.login_form.passwd.focus();
	} else {
		alert("아이디를 입력해주세요.");
		document.login_form.email.focus();
	} 
};

function setSession() {
    sessionStorage.setItem("userEmail", $('#EmailForm').val());
}

function clearSession() {
    sessionStorage.setItem("userEmail", '');
}


function createDateSelectBox() {
    var today = new Date();//오늘날짜
    var currentYear = today.getFullYear();//오늘년도
    var currentMonth = today.getMonth() + 1;//오늘달
    var currentDay = today.getDate();//오늘일
    var today2 = new Date(currentYear, currentMonth, ""); //일자는 어딘지모름
    var intNum = 1950;
    var lastDay = 31;
    var year = $('#sYear');
    var month = $('#sMonth');
    var day = $('#sDay');
    $('.year_init').remove();
    for (var i = currentYear; i >= intNum; i--) {
        year.append($('<option/>').attr(({
            'value': i,
            'class': 'year_init'
        })).text(i));
    }
    $('.month_init').remove();
    for (var i = 1; i <= 12; i++) {
        var month_option = $('<option/>');
        if (i >= 1 && i < 10) {
            month_option.attr({
                'value': ('0' + i),
                'class': 'month_init'
            }).text('0' + i);
        } else {
            month_option.attr({
                'value': i,
                'class': 'month_init'
            }).text(i);
        }
        if (currentMonth == i) {
            month_option.attr('selected', true);
        }
        month.append(month_option);
    }
    $('.day_init').remove();
    for (var i = 1; i <= lastDay; i++) {
        var day_option = $('<option/>');
        if (i >= 1 && i < 10) {
            day_option.attr({
                'value': ('0' + i),
                'class': 'day_init'
            }).text('0' + i);
        } else {
            day_option.attr({
                'value': i,
                'class': 'day_init'
            }).text(i);
        }
        if (currentDay == i) {
            day_option.attr('selected', true);
        }
        day.append(day_option);
    }
}
function selectboxStyle(){
	$('select').selectstyle
		$.fn.extend({ //사용자정의함수
			selectstyle : function(options) { // 메소드명 : function(){}
			if(!$.browser.msie || ($.browser.msie&&$.browser.version>6)){
			return this.each(function() { // this:이 메소드를 호출하는 대상항목들 배열 this.each:대상항목배열루프
				var currentSelected = $(this).find(':selected'); 
				$(this).after('<span class="'+$(this).attr("class")+'_SelectBox"><span class="SelectBoxInner">'
				+currentSelected.text()+'</span></span>')
				.css({position:'absolute', opacity:0,fontSize:$(this).next().css('font-size')});
			
				var selectBoxSpan = $(this).next();
				var selectBoxWidth = parseInt($(this).width()) - parseInt(selectBoxSpan.css('padding-left')) 
									-parseInt(selectBoxSpan.css('padding-right'));   
				var selectBoxHeight = parseInt(selectBoxSpan.height()) + parseInt(selectBoxSpan.css('padding-top')) 
									+ parseInt(selectBoxSpan.css('padding-bottom'));
				var selectBoxSpanInner = selectBoxSpan.find(':first-child');
		  
				selectBoxSpan.css({display:'inline-block'});
				selectBoxSpanInner.css({width:selectBoxWidth, display:'inline-block'});
				var selectBoxHeight = parseInt(selectBoxSpan.height()) + parseInt(selectBoxSpan.css('padding-top')) + parseInt(selectBoxSpan.css('padding-bottom'));
				$(this).height(selectBoxHeight).change(function(){
					 selectBoxSpanInner.text($(this).find(':selected').text()).parent().addClass('changed');});
			});
		  }
		}
	});
	$('select').selectstyle();
};
function moveToScrollpos(index){
	var scrollpos = index * 150;		
	$('#inner_pic').animate({scrollLeft:scrollpos}, 'fast');
};
function displayprofile(){
	$("#prvpic").click(function(){
		/*var scroll = $("#inner_pic").attr("pos")*1-1;
		if(scroll < 0){
			scroll = 4;
		}
		$("#inner_pic").attr("pos",scroll+"");
		moveToScrollpos(scroll);*/
	
		
	});
	$("#nextpic").click(function(){
		var scroll = $("#inner_pic").attr("pos")*1+1;
		if(scroll > 4){
			scroll = 0;
		}
		$("#inner_pic").attr("pos",scroll+"");
		moveToScrollpos(scroll);
	});
	
};

function clearForm(){
	$("#email").val("");
	$("#password").val("");
	$("#con_password").val("");
	$("#name").val("");
	$("#nickname").val("");
	$("#phone").val("");
	$("select[name=sYear]").next().children().text($("select[name=sYear]").val());
	$("select[name=sMonth]").next().children().text($("select[name=sMonth]").val());
	$("select[name=sDay]").next().children().text($("select[name=sDay]").val());
	$("select[name=gender]").next().children().text(($("select[name=gender]").val()==0?"Female":"Male"));
};
function joinaction(){	
	var merzeemember = makejsonfromjoinform();
	var result = checkmemberdata(merzeemember);
	var str = "";
	if( result.success != true){		
		$("#short_txt").text(result.errorshort);
		$("#chk_err_msg").attr("title",result.errordetail);
		$("#chk_err_msg").css("display","");
		return false;
	}
	
	$.ajax({
		type: "POST",
		url: "merzeejoin.do",
		data: merzeemember,
		dataType: "json",
		success: function(data){
			 if(data.ajaxResult.status == "ok"){
				var myData = data.ajaxResult.result;
				alert(myData);
				$("#join_close").click();
				
			 }else{ //
				alert("가입실패 관리자에게 문의하세요..");
			 }
		},
		error: function() {
			alert("응답없음..");
		}
	});		
};

function checkmemberdata(member){
	var returnvalue = {
			success : true, errorshort : "none", errordetail: "none"
		};

	for(var index in member){
		if(member[index].length < 1){
			returnvalue = resultmaker(false,"양식오류","완성되지 않은 양식이 있습니다.");
			return returnvalue;
		}
	}
	
	if(!((member.email.indexOf('@')>0) && (member.email.indexOf('.')>0)) ){
		returnvalue = resultmaker(false,"이메일오류", "이메일 형식이 잘못되었습니다.");
		return returnvalue;
	}
	if( member.email.length > 30){
		returnvalue = resultmaker(false, "이메일오류", "이메일은 30자 미만입니다.");
		return returnvalue;
	}
	if( member.password != member.con_password){
		returnvalue = resultmaker(false, "비밀번호 오류", "비밀번호 확인이 잘못되었습니다.");
		return returnvalue;
	}
	if( member.name.length > 30 || member.nickname.length > 30){
		returnvalue = resultmaker(false, "이름길이 오류", "이름 혹은 닉네임은 30자 미만입니다.");
		return returnvalue;
	}
	if( member.phone.length > 20){
		returnvalue = resultmaker(false, "핸드폰 번호 오류", "핸드폰 번호는 20자 미만입니다.");
		return returnvalue;
	}
	if( member.password.length > 30 || member.con_password.length > 30){
		returnvalue = resultmaker(false, "비밀번호 오류", "비밀번호 길이는 30자 미만입니다.");
		return returnvalue;
	}
	return returnvalue;
};

function resultmaker(b1, s1, s2){
	return { success : b1, errorshort : s1, errordetail : s2};
};

function makejsonfromjoinform(){
	var vemail = $("#email").val();
	var vpassword = $("#password").val();
	var vname = $("#name").val();
	var vcon_password = $("#con_password").val();
	var vnickname = $("#nickname").val();
	var vsYear = $("#sYear").val();
	var vsMonth = $("#sMonth").val();
	var vsDay = $("#sDay").val();
	var vbirth = vsYear+vsMonth+vsDay;
	var vgender  =$("select[name=gender]").val();
	var vphone = $("#phone").val();

	while(vphone.indexOf("-") > 0){
		vphone = vphone.replace("-","");
	}
	
	return {
		email : vemail,	password : vpassword, name : vname,
		con_password : vcon_password, nickname : vnickname, birth : vbirth,
		gender : vgender, phone : vphone
	};
};
function makeerrormsgarea(){
	$(".dialog_form").children("*").mousedown(function(){
		$("#short_txt").text("none");
		$("#chk_err_msg").attr("title","none");
		$("#chk_err_msg").css("display","none");
	});
	
	$("#chk_err_msg").css("display","none");
};
/*function moveFocus(next){
	if(event.keyCode == 9){
		document.getElementById(next).focus();
	}
};*/
$(document).ready(function(){
	document.onselectstart=function(){return false;}; //선택방지
	joinDialog();
	loginDialog();
	hoverEvent();
	humandisplay();
	umbrelladisplay();
	createDateSelectBox();
	selectboxStyle();	
	displayprofile();
	makeerrormsgarea();
    //moveFocus(next);
	clearSession();
});

$(document).tooltip();
