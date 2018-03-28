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
                <div class="col-md-9">
                    <!-- begin post-list -->
                    <ul class="post-list">
                        
                    </ul>
                    <!-- end post-list -->
                    
                    <div class="section-container">
                        <!-- begin pagination -->
                        <div class="pagination-container text-center">
                            <ul class="pagination m-t-0 m-b-0">
                                <li class="disabled"><a href="javascript:;">Prev</a></li>
                                <li class="active"><a href="javascript:;">1</a></li>
                                <li><a href="javascript:;">2</a></li>
                                <li><a href="javascript:;">3</a></li>
                                <li><span class="text">...</span></li>
                                <li><a href="javascript:;">1797</a></li>
                                <li><a href="javascript:;">Next</a></li>
                            </ul>
                        </div>
                        <!-- end pagination -->
                    </div>
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