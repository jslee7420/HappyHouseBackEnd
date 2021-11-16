<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 주택 정보 검색 파트 -->
 <div class="site-section site-section-sm bg-light">
   <div class="container">
     <div id="houseInfo" class="row mb-5">
     </div>
   </div>
 </div>


<!-- houseDealDesc Modal 시작 -->
<div class="modal fade" id="houseDealDescModal">
  <div class="modal-dialog modal-md modal-dialog-centered">
    <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header">
        <h3 class="modal-title">거래정보</h3>
        <button class="close" data-dismiss="modal">&times;</button>
      </div>

      <form action="#" class="p-3 bg-white border">
        
        <!-- Modal body -->
        <div id="houseDeal" class="modal-body">
        </div>
        <!-- Modal footer -->
        <div class="modal-footer">
          <button class="btn btn-secondary text-white btn-block-md rounded-0" data-dismiss="modal">닫기</button>
        </div>

      </form>

    </div>
  </div>
</div>
<!-- houseDealDesc Modal 종료 -->    

<script type="text/javascript" src="js/housedeal.js"></script>