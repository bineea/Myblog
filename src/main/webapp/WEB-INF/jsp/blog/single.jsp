<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>

<li>
    <!-- begin post-left-info -->
    <div class="post-left-info">
        <div class="post-date">
            <span class="day">03</span>
            <span class="month">SEPT</span>
        </div>
        <div class="post-likes">
            <i class="fa fa-heart-o"></i>
            <span class="number">520</span>
        </div>
    </div>
    <!-- end post-left-info -->
    <!-- begin post-content -->
    <div class="post-content">
        <!-- begin post-image -->
        <div class="post-image post-image-with-carousel">
            <!-- begin carousel -->
            <div id="carousel-post" class="carousel slide" data-ride="carousel">
                <!-- begin carousel-indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-post" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-post" data-slide-to="1"></li>
                    <li data-target="#carousel-post" data-slide-to="2"></li>
                </ol>
                <!-- end carousel-indicators -->
                <!-- begin carousel-inner -->
                <div class="carousel-inner">
                    <div class="item active">
                        <a href="post_detail.html"><img src="${rootUrl}assets/img/post1.jpg" alt="" /></a>
                    </div>
                    <div class="item">
                        <a href="post_detail.html"><img src="${rootUrl}assets/img/post2.jpg" alt="" /></a>
                    </div>
                    <div class="item">
                        <a href="post_detail.html"><img src="${rootUrl}assets/img/post3.jpg" alt="" /></a>
                    </div>
                </div>
                <!-- end carousel-inner -->
                <!-- begin carousel-control -->
                <a class="left carousel-control" href="#carousel-post" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                </a>
                <a class="right carousel-control" href="#carousel-post" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                </a>
                <!-- end carousel-control -->
            </div>
            <!-- end carousel -->
        </div>
        <!-- end post-image -->
        <!-- begin post-info -->
        <div class="post-info">
            <h4 class="post-title">
                <a href="post_detail.html">Bootstrap Carousel Blog Post</a>
            </h4>
            <div class="post-by">
                Posted By <a href="#">admin</a> <span class="divider">|</span> <a href="#">Sports</a>, <a href="#">Mountain</a>, <a href="#">Bike</a> <span class="divider">|</span> 2 Comments
            </div>
            <div class="post-desc">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis elit dolor, elementum ut ligula ultricies, 
                aliquet eleifend risus. Vivamus ut auctor sapien. Morbi at nibh id lorem viverra commodo augue dui, in pellentesque odio tempor.
                 Etiam lobortis vel enim vitae facilisis. Suspendisse ac faucibus diam, non malesuada nisl. Maecenas vel aliquam eros, sit amet gravida lacus. 
                 nteger dictum, nulla [...]
            </div>
        </div>
        <!-- end post-info -->
        <!-- begin read-btn-container -->
        <div class="read-btn-container">
            <a href="post_detail.html">Read More <i class="fa fa-angle-double-right"></i></a>
        </div>
        <!-- end read-btn-container -->
    </div>
    <!-- end post-content -->
</li>