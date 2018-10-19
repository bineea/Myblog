<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>

<script>
	$(document).ready(function() {
		$('#blogQueryForm').ajaxForm({
			
		});
		
		$.ajax({
			
		});
		
		$.ajax({
			
		});
	});
</script>

<!-- begin col-3 -->
<div class="col-md-3">
	<!-- begin section-container -->
	<div class="section-container">
		<div class="input-group sidebar-search">
			<!-- 若翻页时，删除输入框内容，则为全文搜索。。。 -->
			<form:form id="blogQueryForm" name="blogQueryForm" method="post" action="${rootUrl}app/blog/">
			<input id="" name="" type="text" class="form-control" placeholder="Search blogs..." />
			<span class="input-group-btn">
				<button class="btn btn-inverse" type="submit"><i class="fa fa-search"></i></button>
			</span>
			</form:form>
		</div>
	</div>
	<!-- end section-container -->
	<!-- begin section-container -->
	<div class="section-container">
		<h4 class="section-title"><span>Categories</span></h4>
		<ul class="sidebar-list">
			<li><a href="#">Sports (20)</a></li>
			<li><a href="#">Outdoor Sports (45)</a></li>
			<li><a href="#">Indoor Sports (1,292)</a></li>
			<li><a href="#">Video Shooting (12)</a></li>
			<li><a href="#">Drone (229)</a></li>
			<li><a href="#">Uncategorized (1,482)</a></li>
		</ul>
	</div>
	<!-- end section-container -->
	<!-- begin section-container -->
	<div class="section-container">
		<h4 class="section-title"><span>Recent Post</span></h4>
		<ul class="sidebar-recent-post">
			<li>
				<div class="info">
					<h4 class="title"><a href="#">Lorem ipsum dolor sit amet.</a></h4>
					<div class="date">23 December 2015</div>
				</div>
			</li>
			<li>
				<div class="info">
					<h4 class="title"><a href="#">Vestibulum a cursus arcu.</a></h4>
					<div class="date">16 December 2015</div>
				</div>
			</li>
			<li>
				<div class="info">
					<h4 class="title"><a href="#">Nullam vel condimentum lectus. </a></h4>
					<div class="date">7 December 2015</div>
				</div>
			</li>
			<li>
				<div class="info">
					<h4 class="title"><a href="#">Proin in dui egestas libero posuere ullamcorper. </a></h4>
					<div class="date">20 November 2015</div>
				</div>
			</li>
			<li>
				<div class="info">
					<h4 class="title"><a href="#">Interdum et malesuada fames ac ante.</a></h4>
					<div class="date">5 November 2015</div>
				</div>
			</li>
		</ul>
	</div>
	<!-- end section-container -->
	<!-- begin section-container -->
	<div class="section-container">
		<h4 class="section-title"><span>Follow Us</span></h4>
		<ul class="sidebar-social-list">
			<li><a href="#"><i class="fa fa-facebook"></i></a></li>
			<li><a href="#"><i class="fa fa-twitter"></i></a></li>
			<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
			<li><a href="#"><i class="fa fa-instagram"></i></a></li>
		</ul>
	</div>
	<!-- end section-container -->
</div>
<!-- end col-3 -->