$(document).ready(function () {
	$.ajax({
	    type: "GET",
	    url: "/user",
	    dataType : "json",
	    success: function (user) {
	    	$("#profile_userId").val(user.userId);
	    	$("#profile_userPw").val(user.userPw);
	    	$("#profile_pwdcheck").val(user.userPw);
	    	$("#profile_userName").val(user.userName);
	    	$("#profile_userAddress").val(user.userAddress);
	    	$("#profile_userTel").val(user.userTel);
	    },
	    error:function(request, status, error){
			console.log("status : " + request.status + "\tmsg : " + error);
		}
	});
	
	// 확인
	$("#confirmBtn").click(function() {
		window.location.href = "/";
	});
	
	// 회원 정보 수정
    $("#modifyBtn").click(function () {
	    if (!$("#profile_userPw").val()) {
	    	alert("비밀번호 입력!!!");
	    	return;
	    } else if ($("#profile_userPw").val() != $("#profile_pwdcheck").val()) {
	    	alert("비밀번호 확인!!!");
	    	return;
	    } else if (!$("#profile_userName").val()) {
            alert("이름 입력!!!");
            return;
	    } else if (!$("#profile_userAddress").val()) {
            alert("주소 입력!!!");
            return;
        } else if (!$("#profile_userTel").val()) {
            alert("전화번호 입력!!!");
            return;
        } else {
            updateUserInfo();
        }
    });
    
    $("#deleteBtn").click(function () {
    	if(confirm("정말 탈퇴 하시겠습니까?")){
    		deleteUserInfo();
    	}
    });
	
});

function updateUserInfo() {
	let userInfo = JSON.stringify({
		"userId" : $("#profile_userId").val(), 
		"userPw" : $("#profile_userPw").val(), 
		"userName" : $("#profile_userName").val(),
		"userAddress" : $("#profile_userAddress").val(),
		"userTel" : $("#profile_userTel").val()
	});
	$.ajax({
		url:'/user/' + $("#profile_userId").val(),  
		type:'PUT',
		contentType:'application/json;charset=utf-8',
		data: userInfo,
		success:function(){
			window.location.href = "/";
		},
		error:function(request, status, error){
			console.log("status : " + request.status + "\tmsg : " + error);
		}
	});
};

function deleteUserInfo() {
	$.ajax({
		url:'/user/' + $("#profile_userId").val(),  
		type:'DELETE',
		success:function(){
			console.log("회원 탈퇴가 완료되었습니다.");
			window.location.href = "/";
		},
		error:function(request, status, error){
			console.log("status : " + request.status + "\tmsg : " + error);
		}
	});
};
