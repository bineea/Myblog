<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>

<script>
	$(document).ready(function() {
			var allMenus = <%=session.getAttribute("roleMenu")%>;
			$("#sidebarNav").append(toMenuHtml(allMenus, true));
			$("#${currentResource.id}").parents("#sidebarNav li").andSelf().addClass("active");
	});
	
	function toMenuHtml(allMenus, hasLogo) {
		var menuHtml = '';
		for(var i=0; i<allMenus.length; i++) {
			if(allMenus[i].column) {
									  menuHtml += '<li class="has-sub" id="' + allMenus[i].resource.id + '">'
											   +	'<a href="javascript:;">';
				allMenus[i].hasColumns ? menuHtml += 		'<b class="caret pull-right"></b>' : menuHtml;
							hasLogo ? menuHtml += 		'<i class="' + allMenus[i].resource.logoStyle + '"></i>' : menuHtml;
									  menuHtml += 		'<span>' + allMenus[i].resource.name + '</span>'
											   + 	'</a>';
				allMenus[i].hasColumns ? menuHtml += 	'<ul class="sub-menu">'
											   +		toMenuHtml(allMenus[i].columnMenu, false)
											   +	'</ul>'
											   +'</li>' 
									: menuHtml;
			}
			else {
				menuHtml += '<li id="' + allMenus[i].resource.id + '"><a href="${rootUrl }' + allMenus[i].resource.url + '">' + allMenus[i].resource.name + '</a></li>';
			}
		}
		return menuHtml;
	}
</script>


<!-- begin #sidebar -->
<div id="sidebar" class="sidebar">
	<!-- begin sidebar scrollbar -->
	<div data-scrollbar="true" data-height="100%">
		<!-- begin sidebar user -->
		<ul class="nav">
			<li class="nav-profile">
				<div class="image">
					<a href="javascript:;"><img src="${rootUrl }assets/img/user-13.jpg" alt="头像" /></a>
				</div>
				<div class="info">
					${loginUser.loginName}
					<small>My place,My rule</small>
				</div>
			</li>
		</ul>
		<!-- end sidebar user -->
		<!-- begin sidebar nav -->
		<ul class="nav" id="sidebarNav">
			<li class="nav-header">Navigation</li>
			<li class="has-sub">
				<a href="${rootUrl }app/index?myMenuId=index">
				    <b class="pull-right"></b>
				    <i class="fa fa-home"></i>
				    <span>首页</span>
			    </a>
			</li>
<!-- 	        begin sidebar minify button -->
<!-- 			<li><a href="javascript:;" class="sidebar-minify-btn" data-click="sidebar-minify"><i class="fa fa-angle-double-left"></i></a></li> -->
<!-- 	        end sidebar minify button -->
		</ul>
		<!-- end sidebar nav -->
	</div>
	<!-- end sidebar scrollbar -->
</div>
<div class="sidebar-bg"></div>
<!-- end #sidebar -->