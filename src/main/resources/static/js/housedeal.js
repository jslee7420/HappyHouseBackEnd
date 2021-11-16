let colorArr = ['table-primary','table-success','table-danger'];

$(document).on("click", "#aptSearchBtn", function() {
	$.get(root + "/housedeal/apts/dongs/" + $("#dong").val()
			,function(data, status){
				$("tbody").empty();
				$.each(data, function(index, vo) {
					let str = `
						<tr class="${colorArr[index%3]}">
						<td>${vo.aptCode}</td>
						<td>${vo.aptName}</td>
						<td>${vo.sidoName} ${vo.gugunName} ${vo.dongName} ${vo.jibun}</td>
						<td>${vo.buildYear}</td>
						<td>${vo.recentPrice}</td>
					`;
					$("tbody").append(str);
				});
				displayMarkers(data);
			}
			, "json"
	);
});

$(document).on("click", "#aptSearchBtn", function(){
	$.get(root + "/housedeal/apts/dongs/" + $("#dong").val()
		,function(data, status){
			$("div#houseInfo").empty();
			$.each(data, function(index, info) {
				console.log(info);
				//  href='#houseDealDescModal'
				let str = "<div id='info' class='info col-md-6 col-lg-4 mb-4' data-toggle='modal' href='#houseDealDescModal'>"
		           + "<div class='property-entry h-100'>"
		           + "<img src='img/apt.png' alt='Image' class='img-fluid'>"
		           + "<div class='p-4 property-body'> "
		           + "<input type='hidden' name=aptCode value='"+info.aptCode+"'>"
		           + "<h3 class='property-title'>"+info.aptName+"</h3>" 
		           + "<span class='property-location d-block mb-3'><span class='property-icon icon-room'></span>"+info.sidoName+" " +info.gugunName+" " +info.dongName+" "+info.jibun+"</span>"
		           + "</div></div></div>";
				$("div#houseInfo").append(str);
			});//each
		}//function
		, "json"
	);//get
});

$(document).on("click", ".info", function(){
	$.get(root + "/housedeal/apts/" + $(this).children("div").children("div").children("input").val()
		,function(data, status){
			$("div#houseDeal").empty();
			$.each(data, function(index, deal) {
				console.log(deal);
				let str = '<div class="media-body">'
					+ '<h6 class="media-heading">거래일: '+deal.dealYear+'.'+deal.dealMonth+'.'+deal.dealDay+'</h6>'
					+ '<h6 class="media-heading">거래구분: '+deal.type+'</h6>'
					+ '<h6 class="media-heading">거래금액:'+deal.dealAmount+'만원</h6>'
					+ '<h6 class="media-heading">전용면적: '+deal.area+'</h6>'
					+ '<h6 class="media-heading">층수:'+ deal.floor +'층</h6><hr>'
					+ '</div>';
				$("div#houseDeal").append(str);
			});//each
		}//function
		, "json"
	);//get
});


/*
$(document).on("click", "#aptSearchBtn", function() {
	var param = {
			serviceKey:'FC+Br87Pqh0SwON0pGJAWliVxCBos9m36EwvJEyaggXwTtnUwpJvnRGuVzB1U+a7zoKzhRMBUGa0rVGpT9yo3Q==',
			pageNo:encodeURIComponent('1'),
			numOfRows:encodeURIComponent('10'),
			LAWD_CD:encodeURIComponent($("#gugun").val()),
			DEAL_YMD:encodeURIComponent('202110')
	};
	
	$.get('http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev'
			,param
			,function(data, status){
				var items = $(data).find('item');
				var jsonArray = new Array();
				items.each(function() {
					var jsonObj	= new Object();
					jsonObj.aptCode = $(this).find('일련번호').text();
					jsonObj.aptName = $(this).find('아파트').text();
					jsonObj.dongCode = $(this).find('법정동읍면동코드').text();
					//jsonObj.dongName = $(this).find('').text();
					//jsonObj.sidoName = $(this).find('').text();
					//jsonObj.gugunName = $(this).find('').text();
					jsonObj.buildYear = $(this).find('건축년도').text();
					jsonObj.jibun = $(this).find('지번').text();
					jsonObj.recentPirce = $(this).find('거래금액').text();
						
					jsonObj = JSON.stringify(jsonObj);
					//String 형태로 파싱한 객체를 다시 json으로 변환
					jsonArray.push(JSON.parse(jsonObj));
				});
				console.log(jsonArray);
				//displayMarkers(jsonArray);
			}
			, "xml"
	);
	/* var xhr = new XMLHttpRequest();
	var url = 'http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev';
	var queryParams = '?' + encodeURIComponent('serviceKey') + '='+encodeURIComponent(' API KEY ');
	queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); 
	queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); 
	queryParams += '&' + encodeURIComponent('LAWD_CD') + '=' + encodeURIComponent($("#gugun").val()); 
	queryParams += '&' + encodeURIComponent('DEAL_YMD') + '=' + encodeURIComponent('202110'); 
	xhr.open('GET', url + queryParams);
	xhr.onreadystatechange = function () {
	    if (this.readyState == 4) {
	    	console.log(this.responseXML);
	        alert('Status: '+this.status+'nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'nBody: '+this.responseText);
	    }
	};

	xhr.send(''); */
//});