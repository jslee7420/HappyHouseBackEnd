$(document).ready(function(){					
	$.get(root + "/address/sidos"
		,function(data, status){
			$.each(data, function(index, vo) {
				$("#sido").append("<option value='"+vo.sidoCode+"'>"+vo.sidoName+"</option>");
			});
		}
		, "json"
	);
});

$(document).on("change", "#sido", function() {
	$.get(root + "/address/sidos/" + $("#sido").val() + "/guguns"
			,function(data, status){
				$("#gugun").empty();
				$("#gugun").append('<option value="0">선택</option>');
				$.each(data, function(index, vo) {
					$("#gugun").append("<option value='"+vo.gugunCode+"'>"+vo.gugunName+"</option>");
				});
			}
			, "json"
	);
});

$(document).on("change", "#gugun", function() {
	$.get(root + "/address/sidos/" + $("#sido").val() + "/guguns/" + $("#gugun").val() + "/dongs"
			,function(data, status){
				$("#dong").empty();
				$("#dong").append('<option value="0">선택</option>');
				$.each(data, function(index, vo) {
					$("#dong").append("<option value='"+vo.dongCode+"'>"+vo.dongName+"</option>");
				});
			}
			, "json"
	);
});
