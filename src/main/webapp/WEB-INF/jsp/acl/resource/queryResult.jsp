<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<div>
<div id="page_query">
	<table>
		<tbody>
			<c:forEach items="${queryResult}" var="data"  varStatus="voStatus">
				<%@ include file="row.jsp"%>
			</c:forEach>
		</tbody>
	</table>
</div>
<div id="page_query_pager">
    <ul class="pagination m-t-0 m-b-10">
        <li class="disabled"><a href="javascript:;">«</a></li>
        <li class="active"><a href="javascript:;">1</a></li>
        <li><a href="javascript:;">2</a></li>
        <li><a href="javascript:;">3</a></li>
        <li><a href="javascript:;">4</a></li>
        <li><a href="javascript:;">5</a></li>
        <li><a href="javascript:;">»</a></li>
    </ul>
    
    <label id="page_current_page">${currentPage}</label>
    <label id="page_total_page">${totalPages}</label>
    <label id="page_total_element">${totalElements}</label>
</div>
</div>