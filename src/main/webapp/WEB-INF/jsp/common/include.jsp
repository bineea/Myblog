<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8" session="true"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- ================== BEGIN BASE CSS STYLE ================== -->
<link href="${rootUrl}assets/plugins/jquery-ui/themes/base/minified/jquery-ui.min.css" rel="stylesheet" />
<link href="${rootUrl}assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="${rootUrl}assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
<link href="${rootUrl}assets/css/animate.min.css" rel="stylesheet" />
<link href="${rootUrl}assets/css/style.min.css" rel="stylesheet" />
<link href="${rootUrl}assets/css/style-responsive.min.css" rel="stylesheet" />
<link href="${rootUrl}assets/css/theme/default.css" rel="stylesheet" id="theme" />
<!-- ================== END BASE CSS STYLE ================== -->

<!-- ================== BEGIN BASE JS ================== -->
<script src="${rootUrl}assets/plugins/pace/pace.min.js"></script>
<!-- ================== END BASE JS ================== -->

<!-- ================== BEGIN BASE JS ================== -->
<script src="${rootUrl}assets/plugins/jquery/jquery-1.9.1.min.js"></script>
<script src="${rootUrl}assets/plugins/jquery/jquery-migrate-1.1.0.min.js"></script>
<script src="${rootUrl}assets/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
<script src="${rootUrl}assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
	<script src="${rootUrl}assets/crossbrowserjs/html5shiv.js"></script>
	<script src="${rootUrl}assets/crossbrowserjs/respond.min.js"></script>
	<script src="${rootUrl}assets/crossbrowserjs/excanvas.min.js"></script>
<![endif]-->
<script src="${rootUrl}assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${rootUrl}assets/plugins/jquery-cookie/jquery.cookie.js"></script>
<script src="${rootUrl}assets/js/apps.min.js"></script>
<!-- ================== END BASE JS ================== -->

<c:url value="/" var="rootUrl" scope="application"></c:url>
<c:if test="${fn:contains(rootUrl,';jsession')}">
	<c:set value="${fn:split(rootUrl,';')[0] }" var="rootUrl" scope="application"/>	
</c:if>
