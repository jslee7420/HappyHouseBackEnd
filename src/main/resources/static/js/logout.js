$(document).ready(function () {
	// ๋ก๊ทธ์์
    $("#user_logout").click(function () {
    	$.ajax({
    		url:'/user/logout',  
    		type:'POST',
    		success:function(){
    			window.location.href = "/";
    		},
    		error:function(request, status, error){
    			console.log("status : " + request.status + "\tmsg : " + error);
    		}
    	});
    });
});

