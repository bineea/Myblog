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
					var $ul = $("<ul class='pagination m-t-0 m-b-10 pull-right'>");
					var $li_prev = $("<li ><a href='javascript:;' class='pager_item' value='"+(currentPage-1)+"'>«</a></li>").appendTo($ul);
					if(currentPage === 0){
						$li_prev.addClass("disabled").find("a").removeClass("pager_item");
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
						var $li_point = $("<li ><a href='javascript:;' class='pager_item' value='"+point+"'>"+(point+1)+"</a></li>").appendTo($ul);
						if(point === currentPage){
							$li_point.addClass("active").find("a").removeClass("pager_item");
						}
					}
					var $li_next = $("<li ><a href='javascript:;' class='pager_item' value='"+(currentPage + 1)+"'>»</a></li>").appendTo($ul); 
					if(currentPage === totalPages){
						$li_next.addClass("disabled").find("a").removeClass("pager_item");
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
			var hasText = $responseText.find("#page_query tbody").children().size() > 0;
			if(hasText) {
				var $tbody=$responseText.find("#page_query tbody");
				$('#data-table').find("> tbody").empty().append($tbody.html());
			}
			else {
				$('#data-table').find("> tbody").empty()
				.append("<tr><td colspan='15' ><div class='taiji_not_found'>没有检索到符合条件的数据！</div></td></tr>");
			}
		},
		
		/**************************************************************************
		 * 
		 * 处理分页跳转
		 * 
		 *************************************************************************/
		_handlePageClick: function(pageclickednumber) {
			// 分页标签点击处理
			var $pageNo = $("input[name='pageNo']", this.currentTarget);
			if ($pageNo.attr("name")) {
				// 如果pageNo存在，则直接修改其值
				$pageNo.val(pageclickednumber);
			} else {
				// 否则，创建pageNo，并追加到form标签下。
				$pageNo = $(
				"<input type='text' id='pageNo' name='pageNo'/>")
				.val(pageclickednumber)
				.appendTo($("#pageQueryForm"), this.currentTarget);
			}
			// 提交表单
			$("#pageQueryForm", this.currentTarget).trigger("submit");
		},
		
		/**************************************************************************
		 * 
		 * 显示模态框
		 * 
		 *************************************************************************/
		_showModel: function(options, data) {
			
		},
		
		/**************************************************************************
		 * 
		 * 关闭模态框
		 * 
		 *************************************************************************/
		_hideModel: function(options) {
			$(".modal-open>.modal.in:last").modal("hide");
		},
		
		/**************************************************************************
		 * 
		 * 
		 * 
		 *************************************************************************/
	});
    
})(jQuery,window,document);