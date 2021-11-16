$(document).ready(function () {
	// 로그인
    $("#loginBtn").click(function () {
    	if (!$("#userId").val()) {
            alert("아이디 입력!!!");
            return;
        } else if (!$("#userPw").val()) {
            alert("비밀번호 입력!!!");
            return;
        } else {
            login();
        }
    });
});

function login() {
	let loginInfo = JSON.stringify({
		"userId" : $("#userId").val(), 
		"userPw" : $("#userPw").val()
	});
	$.ajax({
		url:'/user/login',  
		type:'POST',
		contentType:'application/json;charset=utf-8',
		data: loginInfo,
		success:function(){
			window.location.href = "/";
		},
		error:function(xhr ,status, error){
			console.log(xhr.status);
     		if(xhr.status==400){
     			$("#loginResult").text("아이디 또는 비밀번호를 확인하세요.").removeClass('text-primary').removeClass('text-danger').addClass('text-dark');
      		} else{
      			console.log("status : " + xhr.status + "\tmsg : " + error);
      		}
		}
	});
};

