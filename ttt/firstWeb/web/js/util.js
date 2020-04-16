var js = $.extend({}, js);/* 定义全局对象，类似于命名空间或包的作用 */

$.extend($.fn.validatebox.defaults.rules, {
	eqPassword : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '密码不一致！'
	}
});

$.extend($.fn.validatebox.defaults.rules, {
	equalsImgCode : {
		validator : function(value, imgCode) {
			return value == imgCode;
		},
		message : ''
	}
});

js.dialog = function(options) {
	var opts = $.extend({
		modal : true,
		onClose : function() {
			$(this).dialog('destroy');
		}
	}, options);
	return $('<div/>').dialog(opts);
};

/**
 * @author EasyUI
 * 
 * 增加formatString功能
 * 
 * 使用方法：util.fs('字符串{0}字符串{1}字符串','第一个变量','第二个变量');
 * 
 * @returns 格式化后的字符串
 */
js.fs = function(str) {
	for (var i = 0; i < arguments.length - 1; i++) {
		str = str.replace("{" + i + "}", arguments[i + 1]);
	}
	return str;
};

js.iconData = [ {
	value : '',
	text : '默认'
}, {
	value : 'icon-add',
	text : 'icon-add'
}, {
	value : 'icon-edit',
	text : 'icon-edit'
}, {
	value : 'icon-remove',
	text : 'icon-remove'
}, {
	value : 'icon-save',
	text : 'icon-save'
}, {
	value : 'icon-cut',
	text : 'icon-cut'
}, {
	value : 'icon-ok',
	text : 'icon-ok'
}, {
	value : 'icon-no',
	text : 'icon-no'
}, {
	value : 'icon-cancel',
	text : 'icon-cancel'
}, {
	value : 'icon-reload',
	text : 'icon-reload'
}, {
	value : 'icon-search',
	text : 'icon-search'
}, {
	value : 'icon-print',
	text : 'icon-print'
}, {
	value : 'icon-help',
	text : 'icon-help'
}, {
	value : 'icon-undo',
	text : 'icon-undo'
}, {
	value : 'icon-redo',
	text : 'icon-redo'
}, {
	value : 'icon-back',
	text : 'icon-back'
}, {
	value : 'icon-sum',
	text : 'icon-sum'
}, {
	value : 'icon-tip',
	text : 'icon-tip'
} ];

js.changeTheme = function(themeName) {
	var $easyuiTheme = $('#easyuiTheme');
	var url = $easyuiTheme.attr('href');
	var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
	$easyuiTheme.attr('href', href);
	var $iframe = $('iframe');
	if ($iframe.length > 0) {
		for (var i = 0; i < $iframe.length; i++) {
			var ifr = $iframe[i];
			$(ifr).contents().find('#easyuiTheme').attr('href', href);
		}
	}
	;
	$.cookie('easyuiThemeName', themeName, {
		expires : 7,
		path : '/'
	});
};

var createGridHeaderContextMenu = function(e, field) {
	e.preventDefault();
	var grid = $(this);/* grid本身 */
	var headerContextMenu = this.headerContextMenu;/* grid上的列头菜单对象 */
	var okCls = 'tree-checkbox1';// 选中
	var emptyCls = 'tree-checkbox0';// 取消
	if (!headerContextMenu) {
		var tmenu = $('<div style="width:100px;"></div>').appendTo('body');
		var fields = grid.datagrid('getColumnFields');
		for (var i = 0; i < fields.length; i++) {
			var fildOption = grid.datagrid('getColumnOption', fields[i]);
			if (!fildOption.hidden) {
				$('<div iconCls="' + okCls + '" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(tmenu);
			} else {
				$('<div iconCls="' + emptyCls + '" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(tmenu);
			}
		}
		headerContextMenu = this.headerContextMenu = tmenu.menu({
			onClick : function(item) {
				var field = $(item.target).attr('field');
				if (item.iconCls == okCls) {
					grid.datagrid('hideColumn', field);
					$(this).menu('setIcon', {
						target : item.target,
						iconCls : emptyCls
					});
				} else {
					grid.datagrid('showColumn', field);
					$(this).menu('setIcon', {
						target : item.target,
						iconCls : okCls
					});
				}
			}
		});
	}
	headerContextMenu.menu('show', {
		left : e.pageX,
		top : e.pageY
	});
};
$.fn.datagrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;
$.fn.treegrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;