define([],function () {
	var me;
	function renderTo(render){
		if(!me.menuBar){
			me.menuBar = $('<div class="leftMenu"><div class="title"><div class="icon"></div>功能导航</div></div>');
			me.menuBar.appendTo($('.conBox'));
			me.menuBar.data('show',false).css('height',$(document.body).height()-130);
			me.menuBar.click(function(e){
				if(e.target.tagName == 'A' && $(e.target).data('data').attributeMap.menuItemUrl != '无' && $(e.target).data('data').attributeMap.menuItemUrl != null && $(e.target).data('data').attributeMap.menuItemUrl != ""){
					var record = $(e.target).data('data'),
					subSys = $(e.target).data('subSys');
					var prefix = '';
					if(subSys.subSysIp){
						prefix = 'http://'+subSys.subSysIp+':'+subSys.subSysPort+'/'+(subSys.loadPage||'')+(subSys.loadPage?'/':'');
					}else{
						prefix = webRoot;
					}
					me.openUrl(prefix+record.attributeMap.menuItemUrl,record.attributeMap.menuItemName,record.attributeMap.menuItemId);
				}else if(e.target.tagName == 'A'){
					$(e.target).parent().find('ul').first().toggle();
					$(e.target).parent().find('p').first().toggleClass('dec');
				}
			});
		}
	};
	function loadItems(itemId,subSys){
		me.menuBar.html('<div class="title"><div class="icon"></div>功能导航</div>');
//		$.post(webRoot+'base/getGeneralTree.do?tableName=menu_item',{
//						paramMap: $.toJSON({
//								subSysId:itemId,
//								sqlKey:'com.ztesoft.web.common.db.dao.mapper.GeneralTreeMapper.menuTree',
//								rootId:-1,
//								valueField:'menuItemId',
//								displayField:'menuItemName'
//							})
//						},
		$.post(webRoot+'sysconfig/menuitem/queryMenuTree.do',{subSysId:itemId},
		function(records){
			if(records && records.children.length>0){
				records = records.children;
//				records = records.children[0].children;
				//console.log(records);
				(function platformTree(res,box,lev){
					var $ul=$('<ul></ul>');
					if(lev==0){
						var $table = $('<table id="treeTable" width="100%" border="0" cellpadding="0" cellspacing="0"></table>')
						var $tr = $('<tr></tr>');
						var $td = $('<td></td>');
						$td.append($ul);
						$tr.append($td);
						$table.append($tr);
						box.append($table);
					}else{
						$ul.hide()
						box.append($ul);
					}
					for(var i = 0; i < res.length; i++){
						lev = i ;
						var child = res[i].children
						if( i == res.length-1 ){
							if(child.length){
								if(lev == 0){
									if(res[i].attributeMap.menuItemUrl == '无' || res[i].attributeMap.menuItemUrl == '' || res[i].attributeMap.menuItemUrl == null){
										$li = $('<li class="last"><p class="add dec"></p><a href="javascript:void(0)" class="noflow">'+res[i].text+'</a></li>');
									}else{
										$li = $('<li class="last"><p class="add dec"></p><a href="javascript:void(0)">'+res[i].text+'</a></li>');
									}
								}else{
									if(res[i].attributeMap.menuItemUrl == '无' || res[i].attributeMap.menuItemUrl == '' || res[i].attributeMap.menuItemUrl == null){
										$li = $('<li class="last"><p class="add"></p><a href="javascript:void(0)" class="noflow">'+res[i].text+'</a></li>');
									}else{
										$li = $('<li class="last"><p class="add"></p><a href="javascript:void(0)">'+res[i].text+'</a></li>');
									}
								}
							}else{
								if(res[i].attributeMap.menuItemUrl == '无' || res[i].attributeMap.menuItemUrl == '' || res[i].attributeMap.menuItemUrl == null){
									$li = $('<li class="last"><a href="javascript:void(0)" class="noflow">'+res[i].text+'</a></li>');
								}else{
									$li = $('<li class="last"><a href="javascript:void(0)">'+res[i].text+'</a></li>');
								}
							}
						}else{
							if(child.length){
								if(lev == 0 ){
									if(res[i].attributeMap.menuItemUrl == '无' || res[i].attributeMap.menuItemUrl == '' || res[i].attributeMap.menuItemUrl == null){
										$li = $('<li><p class="add dec"></p><a href="javascript:void(0)" class="noflow">'+res[i].text+'</a></li>');
									}else{
										$li = $('<li><p class="add dec"></p><a href="javascript:void(0)">'+res[i].text+'</a></li>');
									}
								}else{
									if(res[i].attributeMap.menuItemUrl == '无' || res[i].attributeMap.menuItemUrl == '' || res[i].attributeMap.menuItemUrl == null){
										$li = $('<li><p class="add"></p><a href="javascript:void(0)" class="noflow">'+res[i].text+'</a></li>');
									}else{
										$li = $('<li><p class="add"></p><a href="javascript:void(0)">'+res[i].text+'</a></li>');
									}
								}
							}else{
								if(res[i].attributeMap.menuItemUrl == '无' || res[i].attributeMap.menuItemUrl == '' || res[i].attributeMap.menuItemUrl == null){
									$li = $('<li><a href="javascript:void(0)" class="noflow">'+res[i].text+'</a></li>');
								}else{
									$li = $('<li><a href="javascript:void(0)">'+res[i].text+'</a></li>');
								}
								
							}
						}
						$ul.append($li);
						$li.find('a').data('data',res[i]);
						$li.find('a').data('subSys',subSys);
						if(child.length){
							arguments.callee(child,$li,lev);
						}
						if($('.leftMenu').find('ul').first().height() > $('.leftMenu').height()-45){
							$('.leftMenu').css({overflow:'auto'});
						}else{
							$('.leftMenu').css({overflow:''})
						}
					}
				})(records,$('.leftMenu'),0)
				
				$('.leftMenu .add').click(function(){
					$(this).toggleClass('dec');
					$(this).parent().find('ul').first().toggle();
				});
				
			}
		});
	}
	return me = {
		renderTo:renderTo,
		openUrl:function(){},
		reload:function(itemId,subSys,firstInit){
			renderTo($(document.body));
			loadItems(itemId,subSys);
			if(firstInit){
				var prefix = '';
				if(subSys.subSysIp){
					prefix = 'http://'+subSys.subSysIp+':'+subSys.subSysPort+'/'+(subSys.loadPage||'')+(subSys.loadPage?'/':'');
				}else{
					prefix = webRoot;
				}
				me.openUrl(prefix+subSys.beginPage,subSys.subSysName,'SUB_SYS_M'+subSys.subSysId);
			}
			return me;
		},
		hide:function(){
			me&&me.menuBar&&me.menuBar.hide();
			return me;
		},
		show:function(){
			me.menuBar.show();
			return me;
		}
	}
});