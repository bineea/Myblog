<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
	
<tr>
	<td>${data.list }</td>
	<td>${data.name }</td>
	<td>${data.logoStyle }</td>
	<td>${data.menuType.value }</td>
	<td>${data.url }</td>
	<td>${data.requestMethod }</td>
	<td>
		<a>修改</a>
		<a>删除</a>
	</td>
</tr>