/**
 * @license Copyright (c) 2003-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
// 上传图片
//	config.filebrowserImageUploadUrl = "/myblog/app/article/image/upload";
	
	config.language = 'zh-cn';
	config.filebrowserBrowseUrl = '/myblog/assets/plugins/ckfinder/ckfinder.html';
	config.filebrowserImageBrowseUrl = '/myblog/assets/plugins/ckfinder/ckfinder.html?Type=Images';
	config.filebrowserFlashBrowseUrl = '/myblog/assets/plugins/ckfinder/ckfinder.html?Type=Flash';
	config.filebrowserUploadUrl = '/myblog/assets/plugins/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
	config.filebrowserImageUploadUrl = '/myblog/assets/plugins/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';
	config.filebrowserFlashUploadUrl = '/myblog/assets/plugins/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash';
	config.filebrowserWindowHeight = '50%';// CKFinder浏览窗口高度,默认值70%，也可以赋像素值如：1000
	config.filebrowserWindowWidth = '70%';// CKFinder浏览窗口宽度,默认值80%，也可以赋像素值
};
