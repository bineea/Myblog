<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/include.jsp"%>

<script>
	$(document).ready(function() {
			var menus = <%=session.getAttribute("roleMenu")%>;
			$("#test").append(toMenuHtml(menus));
	});
	
	function toMenuHtml(menus) {
		var menuHtml = '';
		for(var i=0; i<menus.length; i++) {
			if(menus[i].column) {
				menuHtml += '<li class="has-sub">'
							+	'<a href="javascript:;">'
							+   '<b class="caret pull-right"></b>'
							+   '<i class="fa fa-laptop"></i>'
							+   '<span>' + menus[i].resource.name + '</span>'
						    + 	'</a>'
							+	'<ul class="sub-menu">';
				menuHtml += toMenuHtml(menus[i].columnMenu);
				menuHtml +=	'</ul>'
							+'</li>';
			}
			else {
				menuHtml += '<li><a href="' + menus[i].resource.url + '">' + menus[i].resource.name + '</a></li>';
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
		<ul class="nav" id="test">
			<li class="nav-header">Navigation</li>
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