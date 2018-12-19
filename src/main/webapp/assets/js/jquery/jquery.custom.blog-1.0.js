;(function($,window,document,undefined){
    $.extend({
		/**************************************************************************
		 * 
		 * 处理分页
		 * 
		 *************************************************************************/ 
		_bindPager: function($searchPager) {
			// 添加分页样式
			var $this = this,
				currentPage = window.parseInt($searchPager.find("#page_current_page").text(),10),
				totalPages = window.parseInt($searchPager.find("#page_total_page").text(),10),
				totalElements = window.parseInt($searchPager.find("#page_total_element").text(),10);
			//当没有查询到数据或返回数据异常的时候，页面显示0条记录，1页，当前页在第1页。
			if(isNaN(totalPages) || totalPages < 2 ||isNaN(currentPage) || currentPage < 0 ||
					isNaN(totalElements) || totalElements <= 0){
				$("#page_pager", this.currentTarget).hide();
			}else{
				$("#page_pager", this.currentTarget)
					.each(function() {
					var $ul = $("<ul class='pagination m-t-0 m-b-0'>");
					var $li_prev = $("<li ><a href='javascript:;' value='"+(currentPage-1)+"'>Prev</a></li>").appendTo($ul);
					if(currentPage === 0){
						$li_prev.addClass("disabled").find("a");
					}
					var startPoint = 0,endPoint = 4;
					if(currentPage > 2){
						startPoint = currentPage -2;
						endPoint = currentPage +2;
					}
					if(endPoint >= totalPages){
						startPoint = totalPages -4;
						endPoint = totalPages -1;
					}
					if(startPoint < 0){
						startPoint = 0;
					}
					for(var point = startPoint;point<=endPoint;point++){
						var $li_point = $("<li ><a href='javascript:;' value='"+point+"'>"+(point+1)+"</a></li>").appendTo($ul);
						if(point === currentPage){
							$li_point.addClass("active").find("a");
						}
					}
					var $li_next = $("<li ><a href='javascript:;' value='"+(currentPage + 1)+"'>Next</a></li>").appendTo($ul); 
					if(currentPage === totalPages){
						$li_next.addClass("disabled").find("a");
					}
					$(this).html($ul);
				}).show();
			}
		},
		
		/**************************************************************************
		 * 
		 * 处理列表
		 * 
		 *************************************************************************/
		_handleSearchReasult: function($responseText) {
			var hasText = $responseText.find("#page_query ul").children().size() > 0;
			if(hasText) {
				var $ubody=$responseText.find("#page_query");
				$('#data_result').empty().append($ubody.html());
			}
			else {
				$('#data_result').empty()
				.append("<div class='data-not-found'>没有检索到符合条件的数据！</div>");
			}
		},
		
		/**************************************************************************
		 * 
		 * 显示loading
		 * 
		 *************************************************************************/
		showLoading: function() {
			$loadingDiv = $("#page_loader");
			if(!$loadingDiv.length) {
				var html = '<div id="page_loader" class="fade in" style="filter:alpha(opacity=60);opacity:0.6;">'
						 +		'<span class="spinner"></span>'
						 + '</div>';
				$loadingDiv=$(html).prependTo(document.body);
			}
		},
		
		/**************************************************************************
		 * 
		 * 隐藏loading
		 * 
		 *************************************************************************/
		hideLoading: function() {
			$("#page_loader").addClass("hide");
		},
		
	});
    
    //查询
    $.fn.manage = function(options) {
    	this.ajaxSubmit({
			type: "post", //提交方式 
	        success: function (responseText, status, xhr) { //提交成功的回调函数
	        	var $responseText = $(responseText);
	        	//处理分页
	        	$._bindPager($responseText.find("#page_query_pager"));
	        	//显示列表
	        	$._handleSearchReasult($responseText);
	        },
	        error: function (xhr, status, error) {
	        	$.showWarnMsg("系统异常，请稍后重试！");
	        }
		});
    }
})(jQuery,window,document);