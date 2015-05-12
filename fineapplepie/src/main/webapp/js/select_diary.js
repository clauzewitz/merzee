var speed = 3;
var maxwidth = $(window).width();
var spongepos = [{x:$(window).width()-Math.floor(Math.random()*800),speed:Math.random()*2.5,width:12,height:28},
		{x:$(window).width()-Math.floor(Math.random()*800),speed:Math.random()*2.5,width:17,height:31},
		{x:$(window).width()-Math.floor(Math.random()*800),speed:Math.random()*2.5,width:16,height:31},
		{x:$(window).width()-Math.floor(Math.random()*800),speed:Math.random()*2.5,width:23,height:31},
		{x:$(window).width()-Math.floor(Math.random()*800),speed:Math.random()*2.5,width:15,height:29},
		{x:$(window).width()-Math.floor(Math.random()*800),speed:Math.random()*2.5,width:8,height:21},
		{x:$(window).width()-Math.floor(Math.random()*800),speed:Math.random()*2.5,width:20,height:16},
		{x:$(window).width()-Math.floor(Math.random()*800),speed:Math.random()*2.5,width:15,height:19}];

$(function(){
	var spongeArry = [$("#sponge1"),$("#sponge2"),$("#sponge3"),$("#sponge4"),$("#sponge5"),$("#sponge6"),$("#sponge7"),$("#sponge8")];
	timer = setInterval(function(){			
		for(var i = 0;i < 8 ;i++){
			if(spongepos[i].x < -(spongepos[i].width)){
				if(maxwidth < $(window).width()){maxwidth = $(window).width();}
				spongepos[i].x = maxwidth;
				spongepos[i].speed = 1.6 + Math.random()*0.9;
			}
			spongepos[i].x -= spongepos[i].speed;
			spongeArry[i].css("left",spongepos[i].x+"px");
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

//function chestAction() {
//    $("#cheston").children("img").css("display", "none");
//    $("#cheston2").children("img").css("display", "none");
//    $("#chestoff").children("img").css("display", "");
//}
function chestdisplay(){    
	$("#cheston").children("img").css("display", "none");
	$("#cheston2").children("img").css("display", "none");
	$("#chestoff").click(function () {
		if ($("#chestoff").children("img").css("display") == "none") { return false; }
		var ran = Math.floor(Math.random() * 2);
		if (ran == 0) {
			$("#cheston").children("img").css("display", "");
			$("#chestoff").children("img").css("display", "none");
		} else if (ran == 1) {
			$("#cheston2").children("img").css("display", "");
			$("#chestoff").children("img").css("display", "none");
		}
		setTimeout(chestAction, 500);
	});
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

$(document).ready(function(){
	document.onselectstart=function(){return false;}; //선택방지
	hoverEvent();
	//logoutDialog();
	displayprofile();
	createDialog();
	addDiary();
//	chestAction();
	chestdisplay();
	fishsetting($("#fish1movearea"), $("#fish1"), 36, 12); //1
	fishsetting($("#fish2movearea"), $("#fish2"), 20, 6);  //2
	fishsetting($("#fish3movearea"), $("#fish3"), 32, 10); //3
	fishsetting($("#fish4movearea"), $("#fish4"), 43, 16); //4
	fishsetting($("#fish5movearea"), $("#fish5"), 33, 12); //5
});

//다이어리 생성폼
function createDialog() {
    $("#add_dialog").dialog({
        autoOpen: false, width: 500,
        height: 350, position: [400, 250],
        modal: true
    });
    $("#add_dialog").dialog().parents(".ui-dialog").find(".ui-dialog-titlebar").remove();
    $("#add_dry").click(function () {
        $("#add_dialog").dialog("open");
    });
    $("#add_close").click(function () {
        $("#add_dialog").dialog("close");
    });
};

function logout() {
    location.href = "merzeelogout.do";
};

function addDiary() {
    //$('#add_dry').click(function () {
    //    var slideshow = $('#slideshow');
    //    var slide = $('<div/>').attr('class', 'slide');
    //    slide.append($('<img/>').attr('src', ''));
    //    slideshow.append(slide);
    //});
}

// function addaction() {
//     var merzeediary = makejsonfromjoinform();
//     var result = checkdata(merzeediary);
//     var str = "";
//     if (result.success != true) {
//         $("#short_txt").text(result.errorshort);
//         $("#chk_err_msg").attr("title", result.errordetail);
//         $("#chk_err_msg").css("display", "");
//         return false;
//     }
    
//     $.ajax({
//         type: "POST",
//         url: "merzeediary.do",
//         data: merzeediary,
//         dataType: "json",
//         success: function (data) {			
// 			if (data.ajaxResult.status == "ok") {
			
//                 var myData = data.ajaxResult.result;
//                 alert(myData);
//                 $("#add_close").click();

//             } else { //
//                 alert("생성실패 관리자에게 문의하세요..");
//             }
		
//         },
//         error: function () {
//             alert("응답없음..");
//         }
//     });
// };

//제이슨 형식
// function makejsonfromjoinform() {
//     console.log("ad");
//     var vdiary_name = $("#dry_name").val();
//     var today = new Date();//오늘날짜
//     var currentYear = today.getFullYear();
//     var currentMonth;
//     var tmp = today.getMonth() + 1;
//     if (tmp < 10) {
//         currentMonth = "0" + tmp;
//     } else {
//         currentMonth = tmp;
//     }
//     var currentDay;
//     if (today.getDate() < 10) {
//         currentDay = "0" + today.getDate();
//     } else {
//         currentDay = today.getDate();
//     }
//     var vopen_date = currentYear + "-" + currentMonth + "-" + currentDay;
//     var vdry_id = "";
//     vdry_id += vopen_date + (Math.floor(Math.random() * 100) + 1);
//     var vdry_photo = $("#files").val();
//     var vtype = $("select[name=type]").val();
    
//     return {
//         dry_id: vdry_id, open_date: vopen_date, dry_name: vdiary_name, email: sessionStorage.getItem("userEmail"),
//         type: vtype 
//     };
// };

//오류 검출
function formCheck() {
    if($('#dry_name').val() != '') {
		document.add_Dry.submit();
	} else {
		alert("다이어리 타이틀을 입력해주세요.");
		document.add_Dry.dry_name.focus();
	}
};

//클리어 폼
function clearForm() {
    $("#dry_name").val("");
    $("#files").val("");
    $(".thumb").remove();
    $("select[name=type]").val(['0']);
};

//*************** 고기고기 물고기 START ***************
$(function () {
    timer = setInterval(function () {
        fishaction();
    }, 60);
});

function fishaction() {
    var fish1area = $("#fish1movearea"); var fish1 = $("#fish1");
    var fish2area = $("#fish2movearea"); var fish2 = $("#fish2");
    var fish3area = $("#fish3movearea"); var fish3 = $("#fish3");
    var fish4area = $("#fish4movearea"); var fish4 = $("#fish4");
    var fish5area = $("#fish5movearea"); var fish5 = $("#fish5");

    //move..
    var dst1 = move(fish1, fish1.data("newx"), fish1.data("newy"));
    if ((dst1.dx < 1) && (dst1.dy < 1)) {
        makenextposition(fish1area, fish1, fish1.children("img").attr("src"));
    }
    var dst2 = move(fish2, fish2.data("newx"), fish2.data("newy"));
    if ((dst2.dx < 1) && (dst2.dy < 1)) {
        makenextposition(fish2area, fish2, fish2.children("img").attr("src"));
    }
    var dst3 = move(fish3, fish3.data("newx"), fish3.data("newy"));
    if ((dst3.dx < 1) && (dst3.dy < 1)) {
        makenextposition(fish3area, fish3, fish3.children("img").attr("src"));
    }
    var dst4 = move(fish4, fish4.data("newx"), fish4.data("newy"));
    if ((dst4.dx < 1) && (dst4.dy < 1)) {
        makenextposition(fish4area, fish4, fish4.children("img").attr("src"));
    }
    var dst5 = move(fish5, fish5.data("newx"), fish5.data("newy"));
    if ((dst5.dx < 1) && (dst5.dy < 1)) {
        makenextposition(fish5area, fish5, fish5.children("img").attr("src"));
    }
}

function move(fish, destx, desty) {  //100,100    150,170  일때 거리는 86.0232
    var fishSpeed = 1;
    var fromx = fish.css("left").replace("px", "") * 1;
    var fromy = fish.css("top").replace("px", "") * 1
    var dX = destx - fromx;	//델타x
    var dY = desty - fromy;	//델타y
    var radians = Math.atan2(dY, dX);
    var rotation = (radians * 180 / Math.PI);
    var velocityX = (Math.cos(radians) * fishSpeed);  //증가된x좌표의atan
    var velocityY = (Math.sin(radians) * fishSpeed);  //증가된y좌표의atan
    fromx += velocityX;
    fromy += velocityY;
    fish.css("left", fromx + "px");
    fish.css("top", fromy + "px");
    //닿았다 판정을 절대값 dx와 dy가 1보다 작을때로 판정하겠음
    //더좋은 알고리즘이 있으면 바꾸셈..
    return {
        dx: Math.abs(fromx - fish.data("newx"))
	, dy: Math.abs(fromy - fish.data("newy"))
    };
}

function makenextposition(fisharea, fish, src) {  //턴되었다..
    fish.data("oldx", fish.data("newx"));
    fish.data("oldy", fish.data("newy"));
    var newpos = getrandposarea(fisharea, fish.width(), fish.height());
    fish.data("newx", newpos.x);
    fish.data("newy", newpos.y);
    fish.data("dx", Math.abs(fish.data("oldx") - fish.data("newx")));
    fish.data("dy", Math.abs(fish.data("oldy") - fish.data("newy")));

    if (src == "imgs/fish1_1.png") {
        fish.children("img").attr("src", "imgs/fish1_2.png");
    } else if (src == "imgs/fish1_2.png") {
        fish.children("img").attr("src", "imgs/fish1_1.png");
    } else if (src == "imgs/fish2_1.png") {
        fish.children("img").attr("src", "imgs/fish2_2.png");
    } else if (src == "imgs/fish2_2.png") {
        fish.children("img").attr("src", "imgs/fish2_1.png");
    } else if (src == "imgs/fish3_1.png") {
        fish.children("img").attr("src", "imgs/fish3_2.png");
    } else if (src == "imgs/fish3_2.png") {
        fish.children("img").attr("src", "imgs/fish3_1.png");
    } else if (src == "imgs/fish4_1.png") {
        fish.children("img").attr("src", "imgs/fish4_2.png");
    } else if (src == "imgs/fish4_2.png") {
        fish.children("img").attr("src", "imgs/fish4_1.png");
    } else if (src == "imgs/fish5_1.png") {
        fish.children("img").attr("src", "imgs/fish5_2.png");
    } else if (src == "imgs/fish5_2.png") {
        fish.children("img").attr("src", "imgs/fish5_1.png");
    }
}

function fishsetting(fisharea, fish, ww, hh) {
    var pos = getrandposarea(fisharea, ww, hh);
    fish.css("left", pos.x + "px");  //처음위치x
    fish.css("top", pos.y + "px");	  //처음위치y
    fish.data("oldx", fish.css("left").replace("px", "") * 1);
    fish.data("oldy", fish.css("top").replace("px", "") * 1);
    var newpos = getrandposarea(fisharea, ww, hh);
    fish.data("newx", newpos.x);
    fish.data("newy", newpos.y);
    fish.data("dx", Math.abs(pos.x - newpos.x));
    fish.data("dy", Math.abs(pos.y - newpos.y));
}

function getrandposarea(area, fw, fh) { //44+1하고 17+1을 물고기 하나의 가로세로값
    //area가 있는 좌표를 더하면 안되고 현제의 자식이므로 길이값에 바로적용함!!
    return {
        x: Math.random() * (area.width() - fw),
        y: Math.random() * (area.height() - fh)
    };
}

$(document).tooltip();