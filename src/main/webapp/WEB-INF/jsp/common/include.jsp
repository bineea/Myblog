<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="true"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- ================== BEGIN BASE CSS STYLE ================== -->
<link href="/Myblog/assets/plugins/jquery-ui/themes/base/minified/jquery-ui.min.css" rel="stylesheet" />
<link href="/Myblog/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="/Myblog/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
<link href="/Myblog/assets/css/animate.min.css" rel="stylesheet" />
<link href="/Myblog/assets/css/style.min.css" rel="stylesheet" />
<link href="/Myblog/assets/css/style-responsive.min.css" rel="stylesheet" />
<link href="/Myblog/assets/css/theme/default.css" rel="stylesheet" id="theme" />
<!-- ================== END BASE CSS STYLE ================== -->

<!-- ================== BEGIN PAGE LEVEL CSS STYLE ================== -->
<link href="/Myblog/assets/plugins/jquery-jvectormap/jquery-jvectormap.css" rel="stylesheet" />
<link href="/Myblog/assets/plugins/bootstrap-calendar/css/bootstrap_calendar.css" rel="stylesheet" />
<link href="/Myblog/assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" />
<link href="/Myblog/assets/plugins/morris/morris.css" rel="stylesheet" />
<!-- ================== END PAGE LEVEL CSS STYLE ================== -->

<!-- ================== BEGIN BASE JS ================== -->
<script src="/Myblog/assets/plugins/pace/pace.min.js"></script>
<!-- ================== END BASE JS ================== -->

<!-- ================== BEGIN BASE JS ================== -->
<script src="/Myblog/assets/plugins/jquery/jquery-1.9.1.min.js"></script>
<script src="/Myblog/assets/plugins/jquery/jquery-migrate-1.1.0.min.js"></script>
<script src="/Myblog/assets/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
<script src="/Myblog/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
	<script src="/Myblog/assets/crossbrowserjs/html5shiv.js"></script>
	<script src="/Myblog/assets/crossbrowserjs/respond.min.js"></script>
	<script src="/Myblog/assets/crossbrowserjs/excanvas.min.js"></script>
<![endif]-->
<script src="/Myblog/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="/Myblog/assets/plugins/jquery-cookie/jquery.cookie.js"></script>
<!-- ================== END BASE JS ================== -->

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script src="/Myblog/assets/plugins/morris/raphael.min.js"></script>
<script src="/Myblog/assets/plugins/morris/morris.js"></script>
<script src="/Myblog/assets/plugins/jquery-jvectormap/jquery-jvectormap.min.js"></script>
<script src="/Myblog/assets/plugins/jquery-jvectormap/jquery-jvectormap-world-merc-en.js"></script>
<script src="/Myblog/assets/plugins/bootstrap-calendar/js/bootstrap_calendar.min.js"></script>
<script src="/Myblog/assets/plugins/gritter/js/jquery.gritter.js"></script>
<script src="/Myblog/assets/js/dashboard-v2.min.js"></script>
<script src="/Myblog/assets/js/apps.min.js"></script>
<!-- ================== END PAGE LEVEL JS ================== -->

<c:url value="/" var="rootUrl" scope="application"></c:url>
<c:if test="${fn:contains(rootUrl,';jsession')}">
	<c:set value="${fn:split(rootUrl,';')[0] }" var="rootUrl" scope="application"/>	
</c:if>