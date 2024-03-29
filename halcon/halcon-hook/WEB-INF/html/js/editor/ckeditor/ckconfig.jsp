<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.util.WebKeys"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portlet.journal.model.JournalStructure"%>
<%@ page import="com.liferay.portal.kernel.util.ContentTypes" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%
String cssPath = ParamUtil.getString(request, "cssPath");
String cssClasses = ParamUtil.getString(request, "cssClasses");
String languageId = ParamUtil.getString(request, "languageId");

String cssPathTheme=ParamUtil.getString(request, "cssPathTheme");

response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

%>
var templateId=document.getElementById('_15_templateId');

if (!CKEDITOR.stylesSet.get('liferayStyles')) {
	CKEDITOR.addStylesSet(
		'liferayStyles',
		[

		// Block Styles

		{name: 'Normal', element: 'p'},
		{name: 'Heading 1', element: 'h1'},
		{name: 'Heading 2', element: 'h2'},
		{name: 'Heading 3', element: 'h3'},
		{name: 'Heading 4', element: 'h4'},

		// Special classes

		{name: 'Preformatted Text', element:'pre'},
		{name: 'Cited Work', element:'cite'},
		{name: 'Computer Code', element:'code'},

		// Custom styles

		{name: 'Info Message', element: 'div', attributes: {'class': 'portlet-msg-info'}},
		{name: 'Alert Message', element: 'div', attributes: {'class': 'portlet-msg-alert'}},
		{name: 'Error Message', element: 'div', attributes: {'class': 'portlet-msg-error'}}
		]
	);
}

CKEDITOR.config.bodyClass = 'html-editor <%= HtmlUtil.escapeJS(cssClasses) %>';

CKEDITOR.config.contentsCss = ['<%= HtmlUtil.escapeJS(cssPath) %>/main.css','<%= HtmlUtil.escapeJS(cssPathTheme) %>/custom.css'];

CKEDITOR.config.entities = false;

CKEDITOR.config.height = 265;

CKEDITOR.config.language = '<%= HtmlUtil.escapeJS(languageId) %>';

CKEDITOR.config.stylesCombo_stylesSet = 'liferayStyles';

CKEDITOR.config.extraPlugins = 'plantilla_detalle_producto'; //registering the plugin

CKEDITOR.config.toolbar_editInPlace = [
	['Styles'],
	['Bold', 'Italic', 'Underline', 'Strike'],
	['Subscript', 'Superscript', 'SpecialChar'],
	['Undo', 'Redo'],
	['SpellChecker', 'Scayt'],
	['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent'], ['Source', 'RemoveFormat'],
];

CKEDITOR.config.toolbar_email = [
	['FontSize', 'TextColor', 'BGColor', '-', 'Bold', 'Italic', 'Underline', 'Strike'],
	['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
	['SpellChecker', 'Scayt'],
	'/',
	['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'SelectAll', 'RemoveFormat'],
	['Source'],
	['Link', 'Unlink'],
	['Image']
];

CKEDITOR.config.toolbar_liferay = [
	['Styles', 'FontSize', '-', 'TextColor', 'BGColor'],
	['Bold', 'Italic', 'Underline', 'Strike'],
	['Subscript', 'Superscript'],
	'/',
	['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'SelectAll', 'RemoveFormat'],
	['Find', 'Replace', 'SpellChecker', 'Scayt'],
	['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent'],
	['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
	'/',
	['Source'],
	['Link', 'Unlink', 'Anchor'],
	['Image', 'Flash', 'Table', '-', 'Smiley', 'SpecialChar']
];

/*Modificamos este para el Journal Article*/
if(templateId!=null){
	if(templateId.value!=""){
	CKEDITOR.config.toolbar_liferayArticle = [
		['Styles', 'FontSize', '-', 'TextColor', 'BGColor'],
		['Bold', 'Italic', 'Underline', 'Strike'],
		['Subscript', 'Superscript'],
		'/',
		['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'SelectAll', 'RemoveFormat'],
		['Find', 'Replace', 'SpellChecker', 'Scayt'],
		['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
		['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
		'/',
		['Source'],
		['Link', 'Unlink', 'Anchor'],
		['Image', 'Flash', 'Table', '-', 'Smiley', 'SpecialChar', 'LiferayPageBreak'],
		['plantilla_detalle_producto'] /*Componente adicional para el Editor de Liferay*/
	];
	}else{
	
	CKEDITOR.config.toolbar_liferayArticle = [
		['Styles', 'FontSize', '-', 'TextColor', 'BGColor'],
		['Bold', 'Italic', 'Underline', 'Strike'],
		['Subscript', 'Superscript'],
		'/',
		['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'SelectAll', 'RemoveFormat'],
		['Find', 'Replace', 'SpellChecker', 'Scayt'],
		['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
		['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
		'/',
		['Source'],
		['Link', 'Unlink', 'Anchor'],
		['Image', 'Flash', 'Table', '-', 'Smiley', 'SpecialChar', 'LiferayPageBreak']
	];
	}
}