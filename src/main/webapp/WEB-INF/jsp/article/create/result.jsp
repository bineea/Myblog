<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="expires" content="0" />
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

<!-- ================== BEGIN PAGE LEVEL CSS ================== -->
<link href="${rootUrl}assets/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" />
<!-- ================== END PAGE LEVEL CSS ================== -->

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script src="${rootUrl}assets/plugins/bootstrap-select/bootstrap-select.min.js"></script>
<!-- ================== END PAGE LEVEL JS ================== -->

</head>
<body>
	<div class="modal-body">
		<div style="text-align:center;">
			<img src="${rootUrl }assets/img/success.png" alt="提交成功" style="width:20%;" />
			<c:if test="${contentStatus eq 'NORMAL' }">
				<h1>发布成功</h1>
				<p>成功发布文章《${contentTitle }》</p>
			</c:if>
			<c:if test="${contentStatus eq 'TEMPORARY' }">
				<h1>暂存成功</h1>
				<p>成功暂存文章《${contentTitle }》</p>
			</c:if>
		</div>
	</div>
	<div class="modal-footer">
		<a href="javascript:;" class="btn btn-inverse btn-sm">管理文章</a>
		<a href="javascript:;" class="btn btn-inverse btn-sm">查看文章</a>
		<a href="javascript:;" class="btn btn-default btn-sm" data-dismiss="modal">根本停不下来</a>
	</div>
</body>
</html>