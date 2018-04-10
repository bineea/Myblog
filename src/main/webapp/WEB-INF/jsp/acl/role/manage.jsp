<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>My Blog | 角色管理</title>

<%@ include file="/WEB-INF/jsp/common/include.jsp"%>
<%@ include file="/WEB-INF/jsp/common/sidebarInit.jsp"%>
<script>
	$(document).ready(function() {
		$("#pageQueryForm").ajaxSubmit({
			type: "post", //提交方式 
	        success: function (responseText, status, xhr) { //提交成功的回调函数
	        	var $responseText = $(responseText);
	        	//处理分页
	        	$._bindPager($responseText.find("#page_query_pager"));
	        	//显示列表
	        	$._handleSearchReasult($responseText);
	        },
	        error: function (xhr, status, error) {
	        	$.showWarnMsg("系统异常，请稍后重试！");
	        }
		});
		
		$("#data-table").on("click", ".config_op", function() {
			$.ajax({
				url: this.href,
				success: function(data, textStatus, jqXHR) {
					$._showModal({},data);
				},
				error:function(XMLHttpRequest, textStatus, errorThrown) {
					$.showWarnMsg("系统异常，请稍后重试！");
				}
			});
			return false;
		});
	});
</script>
</head>
<body>
	<!-- begin #page-container -->
	<div id="page-container" class="fade page-sidebar-fixed page-header-fixed">
		<%@ include file="/WEB-INF/jsp/common/head.jsp"%>

		<%@ include file="/WEB-INF/jsp/common/sidebar.jsp"%>
		
		<!-- begin #content -->
		<div id="content" class="content">
			<!-- begin page-header -->
			<h1 class="page-header">角色管理 <small>My place,My rule</small></h1>
			<!-- end page-header -->
			<!-- begin row -->
			<div class="row">
			    <!-- begin col-12 -->
			    <div class="col-md-12">
                    <!-- begin panel -->
                    <div class="panel panel-inverse">
                        <div class="panel-heading">
                            <div class="panel-heading-btn">
                                <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
                                <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i class="fa fa-repeat"></i></a>
                                <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                                <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
                            </div>
                            <h4 class="panel-title">角色管理</h4>
                        </div>
                        <div id="myManager" class="panel-toolbar">
                        	<a id="addRole" href="${rootUrl }app/acl/role/addRole" class="btn btn-inverse btn-sm m-r-5 m-b-5">添加角色</a>
                        	<form:form class="form-horizontal form-inline" modelAttribute="queryModel"  id="pageQueryForm" name="pageQueryForm" method="post" action="${rootUrl}app/acl/role/manage">
	                        	<div class="form-group m-5">
                                    <label class="control-label">角色名称:</label>
                                    <input name="name" type="text" class="form-control" placeholder="角色名称" />
                                </div>
	                        	<button type="submit" class="btn btn-inverse btn-sm m-r-5 m-b-5">查询</button>
                        	</form:form>
                        </div>
                        <div class="panel-body">
                            <table id="data-table" class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>名称</th>
                                        <th>系统自带</th>
                                        <th>备注</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
								</tbody>
                            </table>
                            <div id="page_pager">
						    </div>
                        </div>
                    </div>
                    <!-- end panel -->
			    </div>
			    <!-- end col-12 -->
			</div>
			<!-- end row -->
			
		</div>
		<!-- end #content -->
		
		<!-- begin scroll to top btn -->
		<a href="javascript:;" class="btn btn-icon btn-circle btn-success btn-scroll-to-top fade" data-click="scroll-top"><i class="fa fa-angle-up"></i></a>
		<!-- end scroll to top btn -->
	</div>
	<!-- end page container -->
</body>
</html>