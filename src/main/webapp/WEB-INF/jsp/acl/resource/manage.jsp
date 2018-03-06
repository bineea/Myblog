<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>资源管理</title>

<%@ include file="/WEB-INF/jsp/common/include.jsp"%>

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<link href="${rootUrl}assets/plugins/jstree/dist/themes/default/style.min.css" rel="stylesheet" />
<!-- ================== END PAGE LEVEL JS ================== -->

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script src="${rootUrl}assets/plugins/jstree/dist/jstree.min.js"></script>
<script src="${rootUrl}assets/js/ui-tree.demo.min.js"></script>
<!-- ================== END PAGE LEVEL JS ================== -->

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
			<!-- begin breadcrumb -->
			<ol class="breadcrumb pull-right">
				<li><a href="javascript:;">Home</a></li>
				<li><a href="javascript:;">Dashboard</a></li>
				<li class="active">Dashboard v2</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">Dashboard v2 <small>header small text goes here...</small></h1>
			<!-- end page-header -->
			<!-- begin row -->
			<div class="row">
			    <!-- begin col-3 -->
			    <div class="col-md-3">
	                <div id="jstree-default">
	                    <ul>
	                        <li data-jstree='{"opened":true}' >
	                            Root node 1
	                            <ul>
	                                <li data-jstree='{"opened":true, "selected":true }'>Initially Selected</li>
	                                <li>Folder 1</li>
	                                <li>Folder 2</li>
	                                <li>Folder 3</li>
	                                <li data-jstree='{"opened":true}' >
	                                    Initially open
	                                    <ul>
	                                        <li data-jstree='{"disabled":true}' >Disabled node</li>
	                                        <li>Another node</li>
	                                    </ul>
	                                </li>
	                                <li data-jstree='{ "icon" : "fa fa-warning fa-lg text-danger" }'>custom icon class (fontawesome)</li>
	                                <li data-jstree='{ "icon" : "fa fa-link fa-lg text-primary" }'><a href="http://www.jstree.com">Clickable link node</a></li>
	                            </ul>
	                        </li>
	                        <li>Root node 2</li>
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
                            <h4 class="panel-title">DataTable - Autofill</h4>
                        </div>
                        <div class="alert alert-info fade in">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            AutoFill gives an Excel like option to a DataTable to click and drag over multiple cells,
                            filling in information over the selected cells and incrementing numbers as needed.
                            Try to mouseover and drag over any table column below.
                        </div>
                        <div class="panel-body">
                            <table id="data-table" class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>Rendering engine</th>
                                        <th>Browser</th>
                                        <th>Platform(s)</th>
                                        <th>Engine version</th>
                                        <th>CSS grade</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="odd gradeX">
                                        <td>Trident</td>
                                        <td>Internet Explorer 4.0</td>
                                        <td>Win 95+</td>
                                        <td>4</td>
                                        <td>X</td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>Trident</td>
                                        <td>Internet Explorer 5.0</td>
                                        <td>Win 95+</td>
                                        <td>5</td>
                                        <td>C</td>
                                    </tr>
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
	<script>
		$(document).ready(function() {
			App.init();
			TreeView.init();
		});
	</script>
</body>
</html>