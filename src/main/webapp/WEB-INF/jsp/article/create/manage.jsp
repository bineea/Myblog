<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>My Blog | 创建文章</title>

<%@ include file="/WEB-INF/jsp/common/include.jsp"%>
<%@ include file="/WEB-INF/jsp/common/sidebarInit.jsp"%>

<!-- ================== BEGIN PAGE LEVEL CSS STYLE ================== -->
<link href="${rootUrl}assets/plugins/dropify/dist/css/dropify.min.css" rel="stylesheet" />
<link href="${rootUrl}assets/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" />
<!-- ================== END PAGE LEVEL CSS STYLE ================== -->

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script src="${rootUrl}assets/plugins/dropify/dist/js/dropify.min.js"></script>
<script src="${rootUrl}assets/plugins/ckeditor/ckeditor.js"></script>
<script src="${rootUrl}assets/plugins/bootstrap-select/bootstrap-select.min.js"></script>
<!-- ================== END PAGE LEVEL JS ================== -->
<script>
	$(document).ready(function() {
		 $('.dropify').dropify();
		 $('.selectpicker').selectpicker('render');
		 
		 $('#publish').click(function() {
			 updateCkeditor();
			 handleForm($('#articleCreateForm'), '${rootUrl}app/article/create/publish', true);
		 });
		 
		 $('#draft').click(function() {
			 updateCkeditor();
			 handleForm($('#articleCreateForm'), '${rootUrl}app/article/create/draft', false);
		 });
		 
	});
	
	function handleSuccess() {
		
	}
	
	function handleForm(form, url, toClear) {
		var $files = $(":file",  $(form));
		if($files.size() === 0) {
			$(form).removeProp("enctype");
		} else {
			var filesSize = $files.size();
			$files.each(function() {
				if (!$(this).val()){
					filesSize--;
					$(this).prop("disabled", true);
				}
			});
			if(filesSize === 0){
				$(form).removeProp("enctype");
			}else{
				$(form).prop("enctype","multipart/form-data");
			}
		}
		
		$(form).ajaxSubmit({
			url: url,
			type: 'POST',
			success:function(responseText, status, xhr) {
				if(xhr.getResponseHeader($.Constans.RESPONSE_HEADER_ERROR)) {
					$.showWarnMsg(responseText.msg);
				} else if(xhr.getResponseHeader($.Constans.RESPONSE_HEADER_NOTE) && toClear) {
					$('#articleCreateForm')[0].reset();
					//jquery 没有reset方法，reset方法是DOM中的方法
					//document.getElementById("articleCreateForm").reset(); 
					CKEDITOR.instances.text.setData('');
					//其中‘text’是textarea的ID或NAME值
					$._showModal({size:"",backdrop:"static"},responseText);
				} else if(xhr.getResponseHeader($.Constans.RESPONSE_HEADER_NOTE) && !toClear) {
					//其中‘text’是textarea的ID或NAME值
					$._showModal({size:"",backdrop:"static"},responseText);
				}
			},
			error:function(xhr, status, error) {
				$.showWarnMsg("系统异常，请稍后重试！"); 
			},
		 });
		
		$(":file", $(form)).each(function() {
			$(this).prop("disabled", false);
		});
	}
	
	function updateCkeditor() {
		for (instance in CKEDITOR.instances) {
			CKEDITOR.instances[instance].updateElement();
		}
	}
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
			<h1 class="page-header">创建文章 <small>My place,My rule</small></h1>
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
                            <h4 class="panel-title">创建文章</h4>
                        </div>
                        <div id="myManager">
                        <form:form class="form-horizontal" modelAttribute="articleModel"  id="articleCreateForm" name="articleCreateForm" method="post" >
                        <div class="panel-toolbar">
                        	<div class="form-group m-5">
                                <input name="title" type="text" class="form-control" placeholder="请输入文章标题" />
                            </div>
                        </div>
                        <div class="panel-body">
							<textarea name="text" class="ckeditor" rows="20"></textarea>
                        </div>
                        <div class="panel-toolbar">
                            <div class="form-group m-5">
					            <label class="control-label" style="display: inline-block;margin: auto;">类别:</label>
					            <div style="min-width: 300px;max-width: 800px;margin: 10px;display: inline-block;">
									<select name="categoryIds" class="form-control selectpicker" data-size="10" data-live-search="true" data-style="btn-inverse " multiple data-selected-text-format="count>3" >
					                   <c:forEach items="${categorys}" var="category">
									   		<option value="${category.id}">${category.name}</option>
									   </c:forEach>
					                </select>
				                </div>
					        </div>
                            <div class="form-group m-5" >
                                <label class="control-label" style="display: inline-block;margin: auto;">封面:</label>
                                <div style="min-width: 500px;max-width: 800px;margin: 10px;display: inline-block;">
                                	<input name="cover" type="file" class="dropify" data-default-file="{$info.img|default=''}" data-allowed-file-extensions="jpg png jpeg gif" >
                                </div>
                            </div>
                            <div class="form-group m-5" >
                                <label class="control-label" style="display: inline-block;margin: auto;">摘要:</label>
                                <div style="min-width: 500px;max-width: 800px;margin: 10px;display: inline-block;">
                                	<textarea name="summany" rows="5" cols="64" style="border:2px solid #E5E5E5;padding: 10px;"></textarea>
                                </div>
                            </div>
                            <div class="form-group m-5" >
	                            <button id="publish" type="button" class="btn btn-inverse m-r-5 m-b-5" style="margin: auto 5px;">发布</button>
	                            <button id="draft" type="button" class="btn btn-inverse m-r-5 m-b-5" style="margin: auto 5px;">暂存</button>
                            </div>
                        </div>
                        </form:form>
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