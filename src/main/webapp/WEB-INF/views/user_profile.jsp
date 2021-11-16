<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- template vendor 제공 코드 -->
<jsp:include page="setting.jsp"/>

<!-- css files(페이지별 css 파일 여기에) -->
<!-- <link rel="stylesheet" type="text/css" href=""/> -->

<!-- js files(페이지별 css 파일 여기에) -->
<!-- <script src=""/> -->


</head>
<body>
<!-- 네비게이션 파트 include -->
<jsp:include page="navbar.jsp"/>

<div id="wrapper">
<!-- start -->
	<main id="main">
        <section class="container">
            <div id="box_title">
                <h2>회원정보 확인</h2>
            </div>
            <form class="box-border align-items-center" id = "frmProfile">
                <div class="form-box">
                    <div class="form-group row rowItem">
                        <div class="col-md-2">
                            <label for="userId">아이디</label>
                        </div>
                        <div id="inputId" class="col-md-4">
                            <input type = "text" class = "form-control pr-4" id ="profile_userId" name ="userId" readonly>
                        </div>
                    </div>
                    <div class="form-group row rowItem">
                        <div class="col-md-2">
                            <label for="userPw">비밀번호</label>
                        </div>
                        <div id="inputPw" class="col-md-4">
	                        <input type="password" class= "form-control pr-4" id ="profile_userPw" name="userPw">
                        </div>
                    </div>
                    <div class="form-group row rowItem">
                        <div class="col-md-2">
                            <label for="pwdcheck">비밀번호 확인</label>
                        </div>
                        <div class="col-md-4">
                            <input type="password" class="form-control pr-4 " id="profile_pwdcheck" name="pwdcheck" />
                        </div>
                    </div>
                    <div class="form-group row rowItem">
                        <div class="col-md-2">
                            <label for="userName">이름</label>
                        </div>
                        <div id="inputName" class="col-md-4">
                        <input type = "text" class = "form-control pr-4" id = "profile_userName" name = "userName">
                        </div>
                    </div>
                    <div class="form-group row rowItem">
                        <div class="col-md-2">
                            <label for="userAddress">주소</label>
                        </div>
                        <div id="inputAddress" class="col-md-4">
                        <input type = "text" class = "form-control pr-4" id="profile_userAddress" name="userAddress">
                        </div>
                    </div>
                    <div class="form-group row rowItem">
                        <div class="col-md-2">
                            <label for="userTel">전화번호</label>
                        </div>
                        <div id="inputPhone" class="col-md-4">
                        <input type = "text" class = "form-control pr-4" id="profile_userTel" name ="userTel">
                        </div>
                    </div>
                </div>
                <div class="btn-center">
                    <div id="confirmBtn" class="btn btn-outline-primary margin-right">확인</div>
                    <div id="modifyBtn" class="btn btn-outline-secondary">회원정보 수정</div>
                    <div id="deleteBtn" class="btn btn-outline-info">회원 탈퇴</div>
                </div>
            </form>
        </section>
    </main><!-- End #main -->



<!-- end -->
<!-- footer include -->
<jsp:include page="footer.jsp"/>
</div>

<!-- 이외에 스크립트 파일들 여기서 include -->
<script type="text/javascript" src="/js/userInfo.js"></script>

<!-- template vendor 제공 코드 -->
<jsp:include page="setting2.jsp"/>
</body>
</html>