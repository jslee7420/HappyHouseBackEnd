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
<script type="text/javascript" src="/js/login.js"></script>


</head>
<body>
<!-- 네비게이션 파트 include -->
<jsp:include page="navbar.jsp"/>

<div id="wrapper">
<!-- start -->
	<main id="main">
        <section class="container">
            <div id="box_title">
                <h2>로그인</h2>
            </div>
            <form id="frmLogin" class="box-border align-items-center">
                <div class="form-box">
                    <div class="form-group row rowItem">
                        <div class="col-md-2">
                            <label for="userId">아이디</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control pr-4" id="userId" name="userId" />
                        </div>
                    </div>
                    <div class="form-group row rowItem">
                        <div class="col-md-2">
                            <label for="userPw">비밀번호</label>
                        </div>
                        <div class="col-md-4">
                            <input type="password" class="form-control pr-4" id="userPw" name="userPw" />
                        </div>
                    </div>
                    <div id="loginResult" class="form-group row rowItem"></div>
                </div>
                <div class="btn-center">
                    <div id="loginBtn" class="btn btn-outline-primary margin-right">로그인</div>
                    <div id="pwBtn" class="btn btn-outline-secondary">비밀번호 찾기</div>
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