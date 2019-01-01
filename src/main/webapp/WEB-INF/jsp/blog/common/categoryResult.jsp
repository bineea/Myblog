<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>

<div>
<div id="query_result">
	<!-- begin sidebar-list -->
	<ul class="sidebar-list">
		<c:forEach items="${queryResult}" var="data"  varStatus="voStatus">
			<li><a href="#">Sports (20)</a></li>
		</c:forEach>
	</ul>
	<!-- end sidebar-list -->
</div>
</div>