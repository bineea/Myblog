<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/include.jsp"%>
<tbody>
	<c:forEach items="${pagn}" var="model"  varStatus="voStatus">
		<%@ include file="row.jsp"%>
	</c:forEach>
</tbody>