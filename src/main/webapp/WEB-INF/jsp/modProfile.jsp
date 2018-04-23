<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="expires" content="0" />
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">

<script>
	$(document).ready(function() {
		$('#myForm').ajaxForm({
			type: "post", //提交方式 
			complete: function(xhr) {
				$._hideModal();
			},
			success: function(responseText, status, xhr){
				if(xhr.getResponseHeader($.Constans.RESPONSE_HEADER_ERROR)){
					$.showMsg(responseText.msg);
				}else if(xhr.getResponseHeader($.Constans.RESPONSE_HEADER_NOTE)){
					$.showMsg(new Base64().decode(xhr.getResponseHeader($.Constans.RESPONSE_HEADER_NOTE)));
				}
			},
			error: function(xhr, status, error) {
				$.showMsg("系统异常，请稍后重试！");
			}
		});
		
		$("#profilePic").change(function(event){
			var files = event.target.files, file;
		    if (files && files.length > 0) {
		        // 获取目前上传的文件
		        file = files[0];// 文件大小校验的动作
		        if(file.size > 1024 * 1024 * 2) {
		            alert('图片大小不能超过 2MB!');
		            return false;
		        }
		        // 获取 window 的 URL 工具
		        var URL = window.URL || window.webkitURL;
		        // 通过 file 生成目标 url
		        var imgURL = URL.createObjectURL(file);
		        //用attr将img的src属性改成获得的url
		        $("#picture").attr("src",imgURL);
		        // 使用下面这句可以在内存中释放对此 url 的伺服，跑了之后那个 URL 就无效了
		        // URL.revokeObjectURL(imgURL);
		    }
		});
	});
	function changePic(){
		$("#profilePic").click();
	}
</script>
</head>
<body>
	<div class="modal-header">
	  	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  	<h4 class="modal-title">Edit Profile</h4>
	</div>
	<form:form modelAttribute="userInfoModel" id="myForm" name="myForm" enctype="multipart/form-data" cssClass="form-horizontal" action="${rootUrl }app/modProfile" method="post">
	<div class="modal-body">
		 <!-- begin profile-container -->
            <div class="profile-container">
                <!-- begin profile-section -->
                <div class="profile-section">
                    <!-- begin profile-left -->
                    <div class="profile-left">
                        <!-- begin profile-image -->
                        <div class="profile-image">
                            <img id="picture" src="assets/img/profile-cover.jpg" />
                            <i class="fa fa-user hide"></i>
                        </div>
                        <!-- end profile-image -->
                        <div class="m-b-10">
                            <a href="javascript:;" onclick="changePic()" class="btn btn-warning btn-block btn-sm">Change Picture</a>
                            <input id="profilePic" type="file" name="profilePic" style="display:none;" class="form-control" accept="image/gif, image/jpeg, image/jpg, image/png" />
                        </div>
                    </div>
                    <!-- end profile-left -->
                    <!-- begin profile-right -->
                    <div class="profile-right">
                        <!-- begin profile-info -->
                        <div class="profile-info">
                            <!-- begin table -->
                            <div class="table-responsive">
                                <table class="table table-profile">
                                    <thead>
                                        <tr>
                                            <th colspan="2"  style="text-align:center;">
                                                <h4>HI</h4>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="highlight">
                                            <td class="field" style="vertical-align: middle;">昵称</td>
                                            <td><input name="name" type="text" class="form-control" placeholder="昵称" /></td>
                                        </tr>
                                        <tr>
                                            <td class="field" style="vertical-align: middle;">邮箱</td>
                                            <td><input name="email" type="email" class="form-control" placeholder="邮箱" /></td>
                                        </tr>
                                        <tr>
                                            <td class="field" style="vertical-align: middle;">性别</td>
                                            <td>
                                                 <select name="male" class="form-control">
								                 	<option value="">请选择...</option>
								                    <option value="MALE">男</option>
								                    <option value="FEMALE">女</option>
								                    <option value="NEUTER">要你管</option>
								                 </select>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!-- end table -->
                        </div>
                        <!-- end profile-info -->
                    </div>
                    <!-- end profile-right -->
                </div>
                <!-- end profile-section -->
            </div>
			<!-- end profile-container -->
	</div>
	<div class="modal-footer">
	  	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
	  	<button type="submit" class="btn btn-inverse btn-sm">保存</button>
	</div>
	</form:form>
</body>
</html>