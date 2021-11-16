$(document).ready(function () {
	$.ajax({
	    type: "GET",
	    url: "/user/login/check",
	    statusCode:{
	    	200: function(){
	    		$('.after_login').css('display', 'inline-block');
	    	},
	    	204: function(){
	    		$('.before_login').css('display', 'inline-block');
	    	}
	    },
	    error: function(request, status, error){
	        $('.before_login').css('display', 'inline-block');
			console.log("status : " + request.status + "\tmsg : " + error);
		}
	})
});

