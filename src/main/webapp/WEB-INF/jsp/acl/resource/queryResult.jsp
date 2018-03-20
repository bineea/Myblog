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
</div>