<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- template vendor 제공 코드 -->
<jsp:include page="setting.jsp"/>

<!-- css files(페이지별 css 파일 여기에) -->
<link rel="stylesheet" type="text/css" href="css/apt.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- js files(페이지별 css 파일 여기에) -->
<!-- <script src=""/> -->

</head>
<body>
<!-- 네비게이션 파트 include -->
<jsp:include page="navbar.jsp"/>

<div id="wrapper">
<!-- start -->
<!-- ======= Hero Section ======= -->
        <section id="hero">
            <div class="hero-container">
                <div id="heroCarousel" class="carousel slide carousel-fade" data-ride="carousel">
    
                    <ol class="carousel-indicators" id="hero-carousel-indicators"></ol>
    
                    <div class="carousel-inner" role="listbox">
    
                        <!-- Slide 1 -->
                        <div class="carousel-item active" style="background-image: url(assets/img/slide/home1.jpeg);">
                            <div class="carousel-container">
                                <div class="carousel-content">
                                    <h2 class="animate__animated animate__fadeInDown">Welcome to <span>HappyHouse</span></h2>
                                    <p class="animate__animated animate__fadeInUp card-content">HappyHouse에서 원하는 집을 찾아보세요!</p>
                                </div>
                            </div>
                        </div>
    
                        <!-- Slide 2 -->
                        <div class="carousel-item" style="background-image: url(assets/img/slide/home2.jpeg);">
                            <div class="carousel-container">
                                <div class="carousel-content">
                                    <h2 class="animate__animated animate__fadeInDown">지역별로 엄선된 매물</h2>
                                    <p class="animate__animated animate__fadeInUp card-content">지역별 필터를 이용하여 원하는 매물을 찾으세요!</p>
                                </div>
                            </div>
                        </div>
    
                        <!-- Slide 3 -->
                        <div class="carousel-item" style="background-image: url(assets/img/slide/home3.jpeg);">
                            <div class="carousel-container">
                                <div class="carousel-content">
                                    <h2 class="animate__animated animate__fadeInDown">아파트, 주택에 대한 구체적인 정보</h2>
                                    <p class="animate__animated animate__adeInUp card-content">이미지와 함께 제공되는 상세한 매물 정보들을 얻어보세요!</p>
                                </div>
                            </div>
                        </div>
    
                    </div>
    
                    <a class="carousel-control-prev" href="#heroCarousel" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon ri-arrow-left-line" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
    
                    <a class="carousel-control-next" href="#heroCarousel" role="button" data-slide="next">
                        <span class="carousel-control-next-icon ri-arrow-right-line" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
    
                </div>
            </div>
        </section><!-- End Hero -->
    
        <section id="index_section">
	        <div class="container">
	        	<div class="card col-sm-12 mt-1" style="min-height: 850px;">
				<div class="card-body">
					시도 : 
					<select id="sido">
						<option value="0">선택</option>
					</select>
					구군 : 
					<select id="gugun">
						<option value="0">선택</option>
					</select>
					읍면동 : 
					<select id="dong">
						<option value="0">선택</option>
					</select>
					<button class="btn btn-outline-primary btn-sm mx-2 px-3" id="aptSearchBtn">검색</button>
					<table class="table mt-2">
						<colgroup>
							<col width="100">
							<col width="160">
							<col width="*">
							<col width="120">
							<col width="120">
						</colgroup>	
						<thead>
							<tr>
								<th>번호</th>
								<th>아파트이름</th>
								<th class="text-center">주소</th>
								<th>건축연도</th>
								<th>최근거래금액</th>
							</tr>
						</thead>
						<tbody id="searchResult"></tbody>
					</table>
				<div id="map" style="width:100%;height:500px;"></div>
				</div>
				
				<jsp:include page="houseModal.jsp"></jsp:include>
				
				</div>
	        </div>
		</section>

<!-- end -->
<!-- footer include -->
<jsp:include page="footer.jsp"/>
</div>

<!-- 이외에 스크립트 파일들 여기서 include -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1fda1de0a051ddf9f0fff2c82fe04521&libraries=services"></script>
<script type="text/javascript" src="js/map.js"></script>
<script type="text/javascript" src="js/address.js"></script>
<!-- <script type="text/javascript" src="js/housedeal.js"></script> -->

<!-- template vendor 제공 코드 -->
<jsp:include page="setting2.jsp"/>
</body>
</html>