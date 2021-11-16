<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- ======= Top Bar ======= -->
  <section id="topbar" class="d-none d-lg-block">
    <div class="container">
      <div class="user_maintainer bx-pull-right">
        <div class="before_login" style="display: none">
          <a href="/user/join" class="user_join">회원가입</a>
          <a href="/user/login" class="user_login">로그인</a>
        </div>
        <div class="after_login" style="display: none">
          <a href="/user/profile" class="user_profile">회원정보</a>
          <a id="user_logout" class="user_logout">로그아웃</a>
        </div>
      </div>
    </div>
  </section>
  
  <!-- ======= Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container d-flex align-items-center">
  
      <div class="logo mr-auto">
        <h1 class="text-light"><a href="/">Happy<span>House</span></a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
      </div>
  
      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <li class="active"><a href="#header">Home</a></li>
          <li><a href="#">공지사항</a></li>
          <li><a href="#">오늘의 뉴스</a></li>
          <li><a href="#">관심지역 설정</a></li>
          <li><a href="#">관심지역 살펴보기</a></li>
        </ul>
      </nav><!-- .nav-menu -->
  
    </div>
  </header><!-- End Header -->
  
<script type="text/javascript" src="/js/loginCheck.js"></script>
<script type="text/javascript" src="/js/logout.js"></script>