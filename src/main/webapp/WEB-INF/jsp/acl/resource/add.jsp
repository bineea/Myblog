<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="expires" content="0" />
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script>
$(document).ready(function() {
	$('#myForm').ajaxForm({
		type: "post", //提交方式 
		complete: function(xhr) {
			$._hideModal();
		},
		success: function(responseText, status, xhr){
			$._handleTableData(responseText, "add");
		},
		error: function(xhr, status, error) {
			
		}
	});
});
</script>
</head>
<body>
	<div class="modal-header">
	  	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  	<h4 class="modal-title">添加资源</h4>
	</div>
	<form:form modelAttribute="addModel" id="myForm" name="myForm" cssClass="form-horizontal" action="${rootUrl }app/acl/resource/addResource" method="post">
	<div class="modal-body">
         <input type="hidden" id="menuId" name="menuId" />
         <c:if test="${!isRootMenu }">
         <div class="form-group">
             <label class="col-md-3 control-label">所属上级资源</label>
             <div class="col-md-7">
                 <input name="parentName" type="text" class="form-control" disabled />
             </div>
         </div>
         </c:if>
		 <div class="form-group">
             <label class="col-md-3 control-label">资源名称</label>
             <div class="col-md-7">
                 <input name="name" type="text" class="form-control" placeholder="资源名称" />
             </div>
         </div>
         <div class="form-group">
             <label class="col-md-3 control-label">URL</label>
             <div class="col-md-7">
                 <input name="url" type="text" class="form-control" placeholder="URL" />
             </div>
         </div>
         <div class="form-group">
             <label class="col-md-3 control-label">请求方式</label>
             <div class="col-md-7">
                 <select name="requestMethod" class="form-control">
                 	<option value=""></option>
                    <option value="GET">GET</option>
                    <option value="POST">POST</option>
                 </select>
             </div>
         </div>
         <div class="form-group">
             <label class="col-md-3 control-label">菜单类型</label>
             <div class="col-md-7">
                <form:select path="menuType" class="form-control" >
                	<form:option value="">全部</form:option>
					<form:options items="${menuTypes}" itemLabel="value"/>
				</form:select>
             </div>
         </div>
         <div class="form-group">
             <label class="col-md-3 control-label">序号</label>
             <div class="col-md-7">
                 <input name="list" type="text" class="form-control" placeholder="排序号" />
             </div>
         </div>
         <div class="form-group">
             <label class="col-md-3 control-label">样式</label>
             <div class="col-md-7">
                 <input name="logoStyle" type="text" class="form-control" placeholder="样式" />
             </div>
         </div>
	</div>
	<div class="modal-footer">
	  	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
	  	<button type="submit" class="btn btn-inverse btn-sm">保存</button>
	</div>
	</form:form>
</body>
</html>