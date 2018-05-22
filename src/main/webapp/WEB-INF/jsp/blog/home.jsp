<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>My blog</title>
<%@ include file="/WEB-INF/jsp/blog/common/include.jsp"%>
</head>
<body>
	<!-- begin #header -->
	<%@ include file="/WEB-INF/jsp/blog/common/head.jsp"%>
	<!-- end #header -->
	
	<!-- begin #content -->
    <div id="content" class="content">
        <!-- begin container -->
        <div class="container">
            <!-- begin row -->
            <div class="row row-space-30">
                <!-- begin col-9 -->
                <div id="page_pager" class="col-md-9">
                </div>
                <!-- end col-9 -->
                <!-- begin col-3 -->
               	<%@ include file="/WEB-INF/jsp/blog/common/sidebar.jsp"%>
                <!-- end col-3 -->
            </div>
            <!-- end row -->
        </div>
        <!-- end container -->
    </div>
    <!-- end #content -->
    
    <!-- begin #footer -->
    <%@ include file="/WEB-INF/jsp/blog/common/foot.jsp"%>
    <!-- end #footer -->
</body>
</html>