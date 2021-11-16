$(document).ready(function () {
	var isId = false;
	// 아이디 중복검사
	$("#userId").keyup(function () {
		var ckid = $("#userId").val();
		if(ckid.length < 4 || ckid.length > 16) {
			$("#idresult").text("아이디는 4자 이상 16자 이하입니다.").removeClass('text-primary').removeClass('text-danger').addClass('text-dark');
			isId = false;
		} else {
			$.ajax({
            	url: '/user/' + ckid,
              	type: 'GET',
              	success: function () {
            		$("#idresult").text(ckid + "는 사용가능합니다.").removeClass('text-dark').removeClass('text-danger').addClass('text-primary');
            		isId = true;
              	}, 
              	error: function(request, status, error) {
              		if(request.status==409){
              			$("#idresult").text(ckid + "는 사용할 수 없습니다.").removeClass('text-dark').removeClass('text-primary').addClass('text-danger');
              			isId = false;
              		} else{
              			console.log("status : " + request.status + "\tmsg : " + error);
              		}
              	}
			});//ajax
		}
	}); 
	
	// 회원가입
    $("#userJoinBtn").click(function () {
        if (!$("#userName").val()) {
            alert("이름 입력!!!");
            return;
        } else if (!isId) {
            alert("아이디 확인!!!");
            return;
        } else if (!$("#userPw").val()) {
            alert("비밀번호 입력!!!");
            return;
        } else if ($("#userPw").val() != $("#pwdcheck").val()) {
            alert("비밀번호 확인!!!");
            return;
        } else if (!$("#userAddress").val()) {
            alert("주소 입력!!!");
            return;
        } else if (!$("#userTel").val()) {
            alert("전화번호 입력!!!");
            return;
        } else {
            register();
        }
    });
});

function register() {
	let userInfo = JSON.stringify({
		"userId" : $("#userId").val(), 
		"userPw" : $("#userPw").val(), 
		"userName" : $("#userName").val(),
		"userAddress" : $("#userAddress").val(),
		"userTel" : $("#userTel").val()
	});
	$.ajax({
		url:'/user',  
		type:'POST',
		contentType:'application/json;charset=utf-8',
		data: userInfo,
		success:function(){
			alert("회원 가입 완료!!");
			window.location.href = "/user/login";
		},
		error:function(request, status, error){
			console.log("status : " + request.status + "\tmsg : " + error);
		}
	});
};

