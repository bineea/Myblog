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
<!-- ================== END PAGE LEVEL JS ================== -->



<script>
	$(document).ready(function() {
		var rootMenuJson = ${rootMenu};
		
		$("#jstree-default").jstree({
			'core':{
				'data':{
					'url':'${rootUrl}app/acl/resource/loadResource',
					'dataType':'json',
					'data':function(node){
						return { "id" : node.id };
					}
				},
				'themes':{
					'responsive':false
				}
			},
			"types": {
	            "default": {
	                "icon": "fa fa-folder text-warning fa-lg"
	            },
	            "file": {
	                "icon": "fa fa-file text-inverse fa-lg"
	            },
	            "link": {
	            	"icon": "fa fa-link fa-lg text-primary"
	            }
	        },
	        "plugins": ["types"]
		});

		$('#jstree-default').on("changed.jstree", function (e, data) {
		    //触发查询form表单提交
			console.log("The selected nodes are:");
		    console.log(data.selected);
		});
	});
	
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
                        <div class="alert alert-info fade in">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            AutoFill gives an Excel like option to a DataTable to click and drag over multiple cells,
                            filling in information over the selected cells and incrementing numbers as needed.
                            Try to mouseover and drag over any table column below.
                        </div>
                        <div class="panel-toolbar ">
                        	<button type="button" class="btn btn-info m-r-5 m-b-5">添加主栏目</button>
                        	<button type="button" class="btn btn-info m-r-5 m-b-5">添加子栏目</button>
                        	<button type="button" class="btn btn-info m-r-5 m-b-5">添加菜单</button>
                        	<button type="button" class="btn btn-info m-r-5 m-b-5">添加非菜单</button>
                        	<form class="form-horizontal form-inline" modelAttribute="queryModel"  id="listForm" name="listForm" method="post" action="${rootUrl}app/acl/resource/manage">
	                        	<div class="form-group m-5">
                                    <label class="control-label">资源名称:</label>
                                    <input type="text" class="form-control" placeholder="资源名称" />
                                </div>
                                <div class="form-group m-5">
									<label class="control-label">资源类型:</label>
									<select id="menuType" name="menuType" class="form-control">
										<option value="">----</option>
										<option value="COLUMN" style="display: none">栏目菜单</option>
										<option value="MENU">菜单</option>
										<option value="NOT_MENU">非菜单</option>
									</select>
								</div>
                                <input type="hidden" id="id" name="id" value="root"></input>
								<input type="hidden" id="resourceType" name="resourceType" value=""></input>
	                        	<button type="button" class="btn btn-info m-r-5 m-b-5">查询</button>
	                        	<button type="button" class="btn btn-default m-r-5 m-b-5">重置</button>
                        	</form>
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