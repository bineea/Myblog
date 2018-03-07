<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>My Blog | 资源管理</title>

<%@ include file="/WEB-INF/jsp/common/include.jsp"%>
<%@ include file="/WEB-INF/jsp/common/sidebarInit.jsp"%>
<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<link href="${rootUrl}assets/plugins/jstree/dist/themes/default/style.min.css" rel="stylesheet" />
<!-- ================== END PAGE LEVEL JS ================== -->

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script src="${rootUrl}assets/plugins/jstree/dist/jstree.min.js"></script>
<script src="${rootUrl}assets/js/ui-tree.demo.min.js"></script>
<!-- ================== END PAGE LEVEL JS ================== -->



<script>
	$(document).ready(function() {
		var rootMenuJson = ${rootMenu};
		
		$("#jstree-default").jstree({
			'core':{
				'data':{
					'url':'',
					'dataType':'json',
					'data':function(node){
						return { "id" : node.id };
					}
				}
			}
		});
		
		TreeView.init();
	});
	
	function toTree(menuJson) {
		
	}
</script>

</head>
<body>
<!-- begin #page-loader -->
	<div id="page-loader" class="fade in"><span class="spinner"></span></div>
	<!-- end #page-loader -->
	
	<!-- begin #page-container -->
	<div id="page-container" class="fade page-sidebar-fixed page-header-fixed">
		<%@ include file="/WEB-INF/jsp/common/head.jsp"%>

		<%@ include file="/WEB-INF/jsp/common/sidebar.jsp"%>
		
		<!-- begin #content -->
		<div id="content" class="content">
			<!-- begin page-header -->
			<h1 class="page-header">资源管理 <small>My place,My rule</small></h1>
			<!-- end page-header -->
			<!-- begin row -->
			<div class="row">
			    <!-- begin col-3 -->
			    <div class="col-md-3">
	                <div id="jstree-default">
	                    <ul>
	                    </ul>
	                </div>
			    </div>
			    <!-- end col-3 -->
			    
			    <!-- begin col-9 -->
			    <div class="col-md-9">
                    <!-- begin panel -->
                    <div class="panel panel-inverse">
                        <div class="panel-heading">
                            <div class="panel-heading-btn">
                                <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
                                <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i class="fa fa-repeat"></i></a>
                                <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                                <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
                            </div>
                            <h4 class="panel-title">资源管理</h4>
                        </div>
                        <div class="panel-body">
                            <table id="data-table" class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>名称</th>
                                        <th>样式</th>
                                        <th>菜单类型</th>
                                        <th>URL</th>
                                        <th>请求方式</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                   
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- end panel -->
			    </div>
			    <!-- end col-9 -->
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