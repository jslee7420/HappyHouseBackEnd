<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- template vendor 제공 코드 -->
<jsp:include page="setting.jsp"/>

<!-- css files(페이지별 css 파일 여기에) -->
<!-- <link rel="stylesheet" type="text/css" href=""/> -->

<!-- js files(페이지별 js 파일 여기에) -->
<script type="text/javascript" src="/js/join.js"></script>


</head>
<body>
<!-- 네비게이션 파트 include -->
<jsp:include page="navbar.jsp"/>

<div id="wrapper">
<!-- start -->
	<main id="main">
        <section class="container">
            <div id="box_title">
                <h2>회원가입</h2>
            </div>
            <form class="box-border" id ="frmRegister">
                <div class="form-box">
                    <div class="form-group row rowItem">
                        <div class="col-md-2 labelText">
                            <label for="userId">아이디</label>
                        </div>
                        <div class="col-md-4">
                            <input
                                type="text"
                                class="form-control pr-4 "
                                id="userId"
                                name="userId"
                            />
                            <div id="idresult" class="mt-1"></div>
                        </div>
                    </div>
                    <div class="form-group row rowItem">
                        <div class="col-md-2">
                            <label for="userPw">비밀번호</label>
                        </div>
                        <div class="col-md-4">
                            <input type="password"
                            class="form-control pr-4 " 
                            id="userPw" 
                            name="userPw" />
                        </div>
                    </div>
                    <div class="form-group row rowItem">
                        <div class="col-md-2">
                            <label for="pwdcheck">비밀번호 확인</label>
                        </div>
                        <div class="col-md-4">
                            <input type="password"
                            class="form-control pr-4 " 
                            id="pwdcheck" 
                            name="pwdcheck" />
                        </div>
                    </div>
                    <div class="form-group row rowItem">
                        <div class="col-md-2">
                            <label for="userName">이름</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text"
                            class="form-control pr-4 "
                            id="userName"
                            name="userName" />
                        </div>
                    </div>
                    <div class="form-group row rowItem">
                        <div class="col-md-2">
                            <label for="userAddress">주소</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text"
                            class="form-control pr-4 "
                            id="userAddress"
                            name="userAddress" />
                        </div>
                    </div>
                    <div class="form-group row rowItem">
                        <div class="col-md-2">
                            <label for="userTel">전화번호</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text"
                            class="form-control pr-4 "
                            id="userTel"
                            name="userTel" />
                        </div>
                    </div>
                </div>
                <div class="btn-center">
                    <div id="userJoinBtn" class="btn btn-outline-primary">가입하기</div>
                </div>
            </form>
        </section>

    </main><!-- End #main -->



<!-- end -->
<!-- footer include -->
<jsp:include page="footer.jsp"/>
</div>

<!-- 이외에 스크립트 파일들 여기서 include -->


<!-- template vendor 제공 코드 -->
<jsp:include page="setting2.jsp"/>
</body>
</html>