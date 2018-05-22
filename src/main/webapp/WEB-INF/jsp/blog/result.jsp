<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>

<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>

<div>
<div id="page_query">
	<!-- begin post-list -->
	<ul class="post-list">
	    <c:forEach items="${queryResult}" var="data"  varStatus="voStatus">
			<%@ include file="single.jsp"%>
		</c:forEach>
	</ul>
	<!-- end post-list -->
	
	<div class="section-container">
	    <!-- begin pagination -->
	    <div class="pagination-container text-center">
	        <ul class="pagination m-t-0 m-b-0">
	            <li class="disabled"><a href="javascript:;">Prev</a></li>
	            <li class="active"><a href="javascript:;">1</a></li>
	            <li><a href="javascript:;">2</a></li>
	            <li><a href="javascript:;">3</a></li>
	            <li><span class="text">...</span></li>
	            <li><a href="javascript:;">1797</a></li>
	            <li><a href="javascript:;">Next</a></li>
	        </ul>
	    </div>
	    
	    <div id="page_query_pager">
		    <label id="page_current_page">${currentPage}</label>
		    <label id="page_total_page">${totalPages}</label>
		    <label id="page_total_element">${totalElements}</label>
		</div>
	    <!-- end pagination -->
	</div>
</div>
</div>