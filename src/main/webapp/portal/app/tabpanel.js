define(['app/menuBar','app/utils'],function (bar,utils) {
	var offsetLeft = 0;
	var menuitems = {};
	var selectedSubSysId = -1;
	var selectItemIndex = {};
	var offsetLeftObj = {};
	var minWidth;
	var rightClickTabId ; // 鼠标右击tab的时候获取当前tab的id  用于tab右击菜单使用
	var baseUrl ;
//	var homePageMenus;
// tab nav 滚动时自适应宽度
	function tabAutoWidth(){	
		$('.tabpannel .toright,.tabpannel .toleft').unbind('mouseenter');
		var bodywidth = $(document.body).width();
		var tabsboxWidth = parseInt((bodywidth-210-70)/106)*106;
		var tabpannelWidth = tabsboxWidth + 66 ;
		$('.tabpannel').width(tabpannelWidth);
		$('.tabpannel .tabsbox').width(tabsboxWidth);
		var tabItemsNum = $('.tabpannel .tabs li').length;
		$('.tabpannel .tabs').width(tabItemsNum*106);
		if( tabItemsNum*106 > tabsboxWidth ){
			//$('.tabpannel .toleft').hide();
			$('.tabpannel').mouseenter(function(){
				if( parseInt($('.tabpannel .tabs').css('left')) != tabsboxWidth-tabItemsNum*106){$('.tabpannel .toright').show()}
				if( parseInt($('.tabpannel .tabs').css('left')) < 0 ){$('.tabpannel .toleft').show()}
			});
			$('.tabpannel').mouseleave(function(){
				$('.tabpannel .toright,.tabpannel .toleft').hide(300);
			});
			$('.tabpannel .toright').mouseenter(function tabToright(){
				$('.tabpannel .toleft').show();
				var tabsLeftCss = parseInt($('.tabpannel .tabs').css('left'));
				if( tabsLeftCss == tabsboxWidth-tabItemsNum*106 ) {$('.tabpannel .toright').hide();$('.tabpannel .tabs').animate().stop();return;}
				if($('.tabpannel .tabs').is(":animated")) return;
				$('.tabpannel .tabs').animate({'left':tabsLeftCss-106},function(){$('.tabpannel .toright').mouseenter(tabToright())});
			})
			$('.tabpannel .toleft').mouseenter(function tabToleft(){
				$('.tabpannel .toright').show();
				var tabsLeftCss = parseInt($('.tabpannel .tabs').css('left'));
				if( tabsLeftCss == 0 ){$('.tabpannel .toleft').hide();$('.tabpannel .tabs').animate().stop();return;}
				if($('.tabpannel .tabs').is(":animated")) return;
				$('.tabpannel .tabs').animate({'left':tabsLeftCss+106},function(){$('.tabpannel .toleft').mouseenter(tabToleft())});
			})
			$('.tabpannel .toright,.tabpannel .toleft').mouseleave(function(){
				var tabsLeftCss = parseInt($('.tabpannel .tabs').css('left'));
				$('.tabpannel .tabs').animate({'left':Math.round(tabsLeftCss/106)*106},function(){
					tabsLeftCss = parseInt($('.tabpannel .tabs').css('left'));
					//console.log(tabsLeftCss)
					if(tabsLeftCss > -106 ){
						$('.tabpannel .toleft').hide();
					}
					if(tabsLeftCss == tabsboxWidth-tabItemsNum*106){
						$('.tabpannel .toright').hide();
					}
				}).stop();
				return;
			})
		}else{
			$('.tabpannel .tabs').animate('left','0');
			$('.tabpannel .toright,.tabpannel .toleft').hide();
		}
	}

	function iniFirstTab(redraw){
		var $tab = $('.tabpannel .tabs');
		var needOpenUrl = true;
		if(redraw){
			$tab.empty();
		}
		var $item = $('<li id="SUB_SYS_-1"><p class="tabicon"><img src="'+webRoot+'portal/resource/theme/blue/images/icon/WDGZ.png" width="52" height="52"/></p><p class="tabname">我的关注</p></li>');
		$item.data('index',0);
		$item.data('itemId',-1);
		if(selectedSubSysId == -1){
			$item.addClass('current');
		}
		$tab.append($item);
		
		$.post(webRoot+'index/tabPanel.do',function(records){
			var homePageMenus = {};
			for(var i=1;i<records.length+1;i++){
				var record = records[i-1];
				var $item = $('<li id="SUB_SYS_'+ record.subSysId +'"><p class="tabicon"><img src="'+webRoot+'base/randSubSysImage.do?iconName='+record.iconName+'&iconPath='+record.iconPath+'"/></p><p class="tabname">'+record.subSysName+'</p></li>');
				$item.data('index',i);
				$item.data('itemId',record.subSysId);
				$item.data('record',record);
				if(redraw && selectedSubSysId == record.subSysId){
					$item.addClass('current');
					needOpenUrl = false;
				}
				$tab.append($item);
				homePageMenus[record.subSysId] = 1;
			}
			window.homePageMenus = homePageMenus;
			items = $('.tabpannel .tabs li');
			//首次初始化
			if(!redraw){
				bar.openUrl(webRoot+'myAttention.jsp',"我的关注",-1);
			}else if(needOpenUrl){	//用户个性化配置后，刷新界面，且原先选中的子系统不在个性化配置之内
				firstTabClickHandler(null,true);
			}
			$tab.find('li').click(function(){
				firstTabClickHandler($(this).data('record'),true);
			})
			//鼠标移过的效果
			$('.tabpannel .tabs li').mouseover(function(){//鼠标移过的效果
				if(!$(this).hasClass('current')){
					$(this).addClass('hover');
				}
			});
			$('.tabpannel .tabs li').mouseout(function(){//鼠标移过的效果
				if($(this).hasClass('hover')){
					$(this).removeClass('hover');
				}
			});
			tabAutoWidth();
		});
	}
	$(window).on('resize',function(){
		$('.tabpannel .tabs').css('left','0');
		$('.tabpannel .toleft').hide();
		tabAutoWidth();// tab nav 滚动时自适应宽度
	})
	
	window.openUrlqq = bar.openUrl = function(url,name,id){
		var $mainIframe = $('.mainFrame');
		var menu = $mainIframe.find('#URL_'+id).length;
		var $loadMask=$('.load_mask');
		$loadMask.css({display:'none'});
		if(menu == 0 && offsetLeft+(StringUtils.GetLength(name)*15) > minWidth){
			return alert('当前打开的菜单项过多，请关闭一些菜单项再试！');
		}
		$mainIframe.children().hide();
		$('.subTabs .item').removeClass('itemClick');
		selectItemIndex[selectedSubSysId] = id;
		//如果已经打开，直接显示相应的iframe
		if(menu > 0){
			$mainIframe.find('#URL_'+id).show();
		}
		else{//没有则创建 二级tab菜单、iframe
			if(!menuitems[selectedSubSysId]){
				//offsetLeft = 0;
				menuitems[selectedSubSysId] = [];
			}
			var menuObj = {url:url,name:name,id:id};
			menuitems[selectedSubSysId].push(menuObj);
			if(id!=-1&&(id+'').indexOf('SUB_SYS_M')==-1){
				var $secondItem = $('<div class="item" id="item_'+id+'">'+name+'</div>');
				offsetLeft += StringUtils.GetLength(name)*9.5 + 50;
			}else{
				var $secondItem = $('<div class="item firstItem" id="item_'+id+'">'+name+'</div>');
				offsetLeft += StringUtils.GetLength(name)*9.5 + 36;
			}
			if(id!=-1&&(id+'').indexOf('SUB_SYS_M')==-1){
				//除了第一格tab（我的关注）其余二级tab都需要有关闭按钮
				var $close = $('<div class="close"></div>');
				$secondItem.append($close);
				$close.click(function(e){
					$mainIframe.find('#URL_'+id).remove();
					$(this).parent().remove();
					offsetLeft = 0;//重新计算tab之间的相对距离，距离最左边清零
					var $secondItems = $('.subTabs').find('.item:visible');
					$secondItems.each(function(index,item){//以此计算tab距离
					//	$(item).css({left:offsetLeft});
						offsetLeft+=$(item).outerWidth()+7;
					});
					offsetLeft = offsetLeft;
					offsetLeftObj[selectedSubSysId] = offsetLeft;
					if($close.parent().attr('class').indexOf('itemClick')!=-1){
						var lastItem = $secondItems.last();
						lastItem.addClass('itemClick');//最后一格tab激活选中状态
						selectItemIndex[selectedSubSysId] = lastItem.data('record').id;
						$mainIframe.find('#URL_'+lastItem.data('record').id).show();//相应的iframe显示
					}
				});
			}
			$secondItem.data('record',{url:url,id:id,name:name});
			$secondItem.click(function(){//二级tab被点击时候，切换tab
				var record = $(this).data('record');
				bar.openUrl(record.url,record.name,record.id);
			});
			$secondItem.mousedown(function(e){//鼠标点击监听事件 e==3的时候即右击tab的时候，会获取tab上元素的id 放置在预定义好的变量以供后面关闭、关闭其他、关闭所有使用
				if(e.which == 3) {
					rightClickTabId = e.currentTarget.id ;
					var id = rightClickTabId.substring(5) ;
					$secondItem.click();//右击触发选中事件
					//该data为右击菜单要显示的数据
					var refreshMenu = {
				           	 text:"刷新",
				        	 func:function(){
				        		 var id = rightClickTabId.substring(5) ; 
				        		 $iframe = $("#URL_"+id);
				     			 $iframe.prop("src",$iframe.prop("src")); // jquery 强制刷新iframe页面
				        	 }
				           };
				    var closeMenu = {
			            	 text:"关闭",
			            	 func:function(){
			            		 var id = rightClickTabId.substring(5) ; 
			            		 if(id == -1) {
			            			 return ;
			            		 }
			            		 $mainIframe.find('#URL_'+id).remove();
			            		 var isItemClick = $("#"+rightClickTabId).attr('class').indexOf('itemClick') ;
			            		 $("#"+rightClickTabId).remove();
			            		 offsetLeft = 0;//重新计算tab之间的相对距离，距离最左边清零
			 					 var $secondItems = $('.subTabs').find('.item:visible');
			 					 $secondItems.each(function(index,item){//以此计算tab距离
			 						offsetLeft+=$(item).outerWidth()+7;
			 					 });
			 					 offsetLeft = offsetLeft;
			 					 offsetLeftObj[selectedSubSysId] = offsetLeft;
			 					 if(isItemClick != -1){
			 						var lastItem = $secondItems.last();
			 						lastItem.addClass('itemClick');//最后一格tab激活选中状态
			 						$mainIframe.find('#URL_'+lastItem.data('record').id).show();//相应的iframe显示
			 					 }
			            	 }
			             };	
				    var closeOthersMenu = {
							 text:"关闭其他",
							 func:function(){
								 var $secondItems = $('.subTabs').find('.item:visible');
								 $secondItems.each(function(index,item){//以此计算tab距离
									 var $item = $(item);
									 if(item.id != "item_-1" && item.id != rightClickTabId) {
										 
										 var id = (item.id).substring(5) ; 
					            		 $mainIframe.find('#URL_'+id).remove();
					            		 var isItemClick = $(item).attr('class').indexOf('itemClick') ;
					            		 $(item).remove();
					            		 offsetLeft = 0;//重新计算tab之间的相对距离，距离最左边清零
					 					 var $secondItems = $('.subTabs').find('.item:visible');
					 					 $secondItems.each(function(index,item2){//以此计算tab距离
					 						offsetLeft+=$(item2).outerWidth()+7;
					 					 });
					 					 offsetLeft = offsetLeft;
					 					 offsetLeftObj[selectedSubSysId] = offsetLeft;
					 					 if(isItemClick != -1){
					 						var lastItem = $secondItems.last();
					 						lastItem.addClass('itemClick');//最后一格tab激活选中状态
					 						$mainIframe.find('#URL_'+lastItem.data('record').id).show();//相应的iframe显示
					 					 }
									 }
									 
				 				 });
							 }
						};
				      var closeAllMenu = {
								 text:"关闭所有",
								 func:function(){
									 var $secondItems = $('.subTabs').find('.item:visible');
									 $secondItems.each(function(index,item){//以此计算tab距离
										 var $item = $(item);
										 if(item.id != "item_-1") {
											 var id = (item.id).substring(5) ; 
						            		 $mainIframe.find('#URL_'+id).remove();
						            		 var isItemClick = $(item).attr('class').indexOf('itemClick') ;
						            		 $(item).remove();
						            		 offsetLeft = 0;//重新计算tab之间的相对距离，距离最左边清零
						 					 var $secondItems = $('.subTabs').find('.item:visible');
						 					 $secondItems.each(function(index,item2){//以此计算tab距离
						 						offsetLeft+=$(item2).outerWidth()+7;
						 					 });
						 					 offsetLeft = offsetLeft;
						 					 offsetLeftObj[selectedSubSysId] = offsetLeft;
						 					 if(isItemClick != -1){
						 						var lastItem = $secondItems.last();
						 						lastItem.addClass('itemClick');//最后一格tab激活选中状态
						 						$mainIframe.find('#URL_'+lastItem.data('record').id).show();//相应的iframe显示
						 					 }
										 }
										 
					 				 });
								 }
							};
				    var data = new Array();
				    if(id == -1) {
						data.push([refreshMenu]);
						data.push([closeOthersMenu]);
					}else{
						data.push([refreshMenu]);
						data.push([closeMenu]);
						data.push([closeOthersMenu]);
						data.push([closeAllMenu]);
					}
				    $.smartMenu.remove();
				    $secondItem.smartMenu(data);//对tab绑定右击菜单事件  使用时需要引入右击菜单的jquery-smartMenu.js文件
				}
			});
			$('.subTabs').append($secondItem);//将二级tab添加到secondTab上
			var $iframe = $('<iframe src=""  id="URL_'+id+'" frameborder="no"   border="no"></iframe>').css({width:'100%',height:'100%'});
			$iframe.appendTo($mainIframe);
//			setTimeout(function(){
//				if($loadMask.css('display')=='none'&&$loadMask.data('load')!=true){
					$loadMask.css({display:'block'});
//				}
//			},1000);
			$iframe.attr('src',webRoot+'index/sendRedirect.do?strURL='+url);//打开url用页面跳转，做权限控制
			$iframe.load(function(){
				$loadMask.css({display:'none'});
				//$(this).css({width: '100%',height: '100%'});//满mainDiv展示iframe内容
			});
		}
		$('.subTabs').find('#item_'+id).addClass('itemClick');//加上选中效果
		//如果用户点击的是“我的关注”，且“我的关注”未正常初始化，则需要重新初始化
		if(id == -1 && window.KeyInfoCollectList && !window.KeyInfoCollectList.initialized){
			window.KeyInfoCollectList.iniView();
		}
	};
	
	//菜单项配置
	$('.header .menuSeting').mouseenter(function(){
		$(this).css({'width':'124px'});
		$(this).find('div').show();
	});
	$('.header .menuSeting').mouseleave(function(){
		$(this).css({'width':'36px'});
		$(this).find('div').hide()
	});
	$('.menuSetWindow .closeMenuSet').click(function(){
		$('.menuSetWindow').hide(300);
	});
	$('.menuSetWindow .winCon .menuSetOkBtn').click(function(){
		var data = $(".showIconBox li").map(function() { return $(this).attr('id')}).get();
		if(data.length == 0){
			alert("请至少选择一个子系统！");
			return;
		}
		var reqObj = {};
		reqObj.subSysIds = data.join(",");
		$.post(webRoot+'/subsysconf/staffsubsysconf/batchAdd.do',reqObj,function(result){
			window.firstTabChanged = true;
			iniFirstTab(true);
			$('.menuSetWindow').hide(300);
			window.myViewPanel.iniContent();
		});
	})
	var MenuIconPOST = true;
	$('.header .menuSeting').click(function(){
			$('.menuSetWindow').css('margin-top',-($('.menuSetWindow').height()/2)).toggle(300);
			var $showMenuIconBox = $('.showIconBox');
			var $willShowIconBox = $('.willShowIconBox');
			if(MenuIconPOST){
				$.post(webRoot+'index/tabPanel.do',function(records){
					for(var i=0;i<records.length;i++){
						var record = records[i]
						var $item = $('<li id="'+ record.subSysId +'"><p class="img"><img src="'+webRoot+'base/randSubSysImage.do?iconName='+record.iconName+'&iconPath='+record.iconPath+'" width="42" height="42" /></p><p class="iconname">'+record.subSysName+'</p><p class="act"></p></li>');
						$showMenuIconBox.append($item);
					}
					reBindIconClick();
				})
				$.post(webRoot+'index/loadSubSys.do',function(records){
					var homePageMenus = window.homePageMenus;
					for(var i=0;i<records.length;i++){
						var record = records[i];
						if(!homePageMenus[record.subSysId]){
							var $item = $('<li id="'+ record.subSysId +'"><p class="img"><img src="'+webRoot+'base/randSubSysImage.do?iconName='+record.iconName+'&iconPath='+record.iconPath+'" width="42" height="42" /></p><p class="iconname">'+record.subSysName+'</p><p class="act"></p></li>');
							$willShowIconBox.append($item);
						}
					}
					reBindIconClick();
				})
				dragfun();
				MenuIconPOST = false ;
			}
			
			function dragfun(){
				$(".showIconBox, .willShowIconBox").dragsort({
					dragSelector:"li",
					dragBetween:true,
					dragEnd:saveOrder, //拖拽后执行的function
					placeHolderTemplate: "<li class='placeHolder'></li>"
				});
			}
			function saveOrder() {
//				var data = $(".showIconBox li").map(function() { return $(this).attr('id')}).get();
//				$("input[name=MenuSortOrder]").val(data.join("|"));
				reBindIconClick();
			};
			function reBindIconClick(){
				$('.showIconBox .img,.showIconBox .act').unbind('click');
				$('.willShowIconBox .img,.willShowIconBox .act').unbind('click');
				$('.showIconBox .img,.showIconBox .act').click(function(){
					var itemClone = $(this).parent('li').clone();
					$(this).parent('li').hide(200,'',function(){
						$(this).remove();
						$('.willShowIconBox').append(itemClone);
						saveOrder();
					})
				})
				$('.willShowIconBox .img,.willShowIconBox .act').click(function(){
					var itemClone = $(this).parent('li').clone();
					$(this).parent('li').hide(200,'',function(){
						$(this).remove();
						$('.showIconBox').append(itemClone);
						saveOrder();
					})
				})
			}

	})
	
	return {
		renderTo:function(render){
			
			var $secondTab = $('.subTabs .sysMenus');
			var $manager = $('.platformMng');
			var $managerTarget = $('.platformMngPop');
			var $mark;
			iniFirstTab();
			function closeManger(){
				$manager.removeClass('platformMngHover');
				$('.platformMngPop').hide();
				$mark.hide();
				$manager.data('show',!$manager.data('show'));
			}
			function closeManger2(){
				$mark2.hide();
				$('input[name=password]').val("");
				$('input[name=password2]').val("");
				$('input[name=password3]').val("");
				$('.alert .error').html('');
				$psdUpdate.data('show',false);
				return false;
			}
			function submit(){
				var $password = $('input[name=password]');
				var $password2 = $('input[name=password2]');
				var $password3 = $('input[name=password3]');
				var password = $password.val().replace(/^\s+|\s+$/g, '');
				var password2 = $password2.val().replace(/^\s+|\s+$/g, '');
				var password3 = $password3.val().replace(/^\s+|\s+$/g, '');
				if (password == '') {
					 $('.alert .error').html('请输入原密码！');
                    $password.focus(); 
                    return ;
                }
                if (password2 == '') {
                	$('.alert .error').html('请输入新密码！');
                    $password2.focus(); 
                    return ;
                }
                if (password3 == '') {
                	$('.alert .error').html('确认新密码！');
                    $password3.focus(); 
                    return;
                }
                var reg = /^[a-zA-Z0-9`\-=\\\[\];',.\/\~\!@#$%\^&\*()_\+|\?><":\{\}]*$/;
                var re = new RegExp(reg);
                if (!re.test(password) || !re.test(password2) || !re.test(password3)) {
                    alert("密码：包含字母（A-Z）大小写敏感；数字（0-9）；特殊字符（`、-、=、\、[、]、;、'、,、.、/、~、!、@、#、$、%、^、&、*、(、)、_、+、|、?、>、<、\"、:、{、}）");
                    return;
                }
                var password= MD5(password);
				if(userSession.staff.password != password){
					$('.alert .error').html('原密码错误！');
					return ;
				}
				if(password2 != password3){
					$('.alert .error').html('您输入的新密码不一致！');
					return;
				}
				var password2 = MD5(password2);
				var reqObj = {};
				reqObj.staffId = userSession.staff.staffId;
				reqObj.password = password2;
				$.post(webRoot+'/privilege/stafft/update.do',reqObj,function(result){
					$('.alert .error').html('密码修改成功！');
					userSession.staff.password = password2;
					setTimeout(closeManger2,1000);
				});
			}
			function rebindSizeLeftMenuOnHide(){
				//重新绑定resize				
				$(window).unbind('resize');
				minWidth = $(".subTabs").width() - $('.subTabs .sysMenus').width() - 15;
				$(".conBox,.mainBox").css({height:$(document.body).height()-128,width:$(document.body).width()})
				$('.mainBox').css({'margin-left':0});
				$('.mainFrame,.mainFrame iframe').css({width:$('.mainBox').width(),height:$(document.body).height()-167});
				$('.platformMngPop').css({left:$('.platformMng').offset().left,top:$('.platformMng').offset().top+38});
				$('.leftMenu').css('height',$(document.body).height()-173);
				//
				tabAutoWidth();// tab nav 滚动时自适应宽度
				$(window).on('resize',function(){
					minWidth = $(".subTabs").width() - $('.subTabs .sysMenus').width() - 15;
					$(".conBox,.mainBox").css({height:$(document.body).height()-128,width:$(document.body).width()})
					$('.platformMngPop').css({left:$('.platformMng').offset().left,top:$('.platformMng').offset().top+38});
					$('.mainFrame,.mainFrame iframe').css({width:$('.mainBox').width(),height:$(document.body).height()-167});
					$('.leftMenu').css('height',$(document.body).height()-173);
					$('.tabpannel .tabs').css('left','0');
					tabAutoWidth();// tab nav 滚动时自适应宽度
				});
				//重新绑定resize
			}				
			function rebindSizeLeftMenuOnShow(){
				//重新绑定resize				
				$(window).unbind('resize');
				minWidth = $(".subTabs").width() - $('.subTabs .sysMenus').width() - 145;
				$(".mainBox").css({height:$(document.body).height()-128,width:$(document.body).width()-148,'margin-left':148})
				$('.mainFrame,.mainFrame iframe').css({width:$('.mainBox').width(),height:$(document.body).height()-167});
				$('.leftMenu').css('height',$(document.body).height()-173);
				tabAutoWidth();// tab nav 滚动时自适应宽度
				$(window).on('resize',function(){
					//tab nav 自适合宽度
					bodywidth = $(document.body).width();
					var tabsboxWidth = parseInt((bodywidth-210-70)/106)*106;
					var tabpannelWidth = tabsboxWidth + 66 ;
					$('.tabpannel').width(tabpannelWidth);
					$('.tabpannel .tabsbox').width(tabsboxWidth);

					minWidth = $(".subTabs").width() - $('.subTabs .sysMenus').width() - 145;
					$(".conBox,.mainBox").css({height:$(document.body).height()-128,width:$(document.body).width()});
					$(".mainBox").css({height:$(document.body).height()-128,width:$(document.body).width()-148});
					$('.mainFrame,.mainFrame iframe').css({width:$('.mainBox').width(),height:$(document.body).height()-167});
					$('.platformMngPop').css({left:$('.platformMng').offset().left,top:$('.platformMng').offset().top+38});
					$('.leftMenu').css('height',$(document.body).height()-173);
					$('.tabpannel .tabs').css('left','0');
					$('.tabpannel .toleft').hide();
					tabAutoWidth();// tab nav 滚动时自适应宽度
				});
				//重新绑定resize				
			}				
			$('.leftMenuClose').click(function(){
				if($(this).hasClass('leftMenuOpen')){
					$('.leftMenu').show();
					$(this).removeClass('leftMenuOpen');
					rebindSizeLeftMenuOnShow();			
				}else{
					$('.leftMenu').hide();
					$(this).addClass('leftMenuOpen');
					rebindSizeLeftMenuOnHide();		
				}
			})
			window.firstTabClickHandler = function firstTabClickHandler(record,isSelected){
				$('.load_mask').css({display:'none'});
				//如果选中的一级子系统图标为我的关注，则隐藏菜单栏；否则重新加载菜单栏数据，并显示
				var subSysId = -1;
				if(record){
					subSysId = record.subSysId
				}
				if(subSysId == selectedSubSysId){
					return;
				}
				changeSubSys(subSysId,isSelected);
				window.selectedSubSysId = subSysId;
				var firstInit = true;
				if(menuitems[subSysId]){
					firstInit = false;
				}
				if(isSelected){
					var $item = $("#SUB_SYS_"+ subSysId);
				}
				if(isSelected && items.index($item)==0){
					bar.hide();
					$('.leftMenuClose').hide();
					rebindSizeLeftMenuOnHide();
				}
				else{
					bar.reload(record.subSysId,record,firstInit).show();
					$('.leftMenuClose').removeClass('leftMenuOpen').show();
					rebindSizeLeftMenuOnShow();
				}
			}
			function changeSubSys(subSysId,isSelected){
				rebindSizeLeftMenuOnHide();
				items.removeClass('current');
				var $item = $('.tabpannel .tabs').find('#SUB_SYS_' + subSysId);
				if(isSelected){
					$item.addClass('current');//一级菜单选中效果
				}
				//保存上一个子系统的当前偏移量
				offsetLeftObj[selectedSubSysId] = offsetLeft;
				selectedSubSysId = subSysId;
				//初始化当前子系统的偏移量
				if(offsetLeftObj[selectedSubSysId]){
					offsetLeft = offsetLeftObj[selectedSubSysId];
				}else{
					offsetLeft = 0;
				}
				$('.subTabs').find('.item').hide();
				if(menuitems[selectedSubSysId]){
					var subMenus = menuitems[selectedSubSysId];
					var selectId = selectItemIndex[selectedSubSysId];
					var $mainIframe = $('.mainFrame');
					$mainIframe.children().hide();
					var $secondTab = $('.subTabs');
					for (var i = 0; i < subMenus.length; i++) {
						var id = subMenus[i].id;
						$secondTab.find('#item_'+id).show();
						if(id == selectId){
							$mainIframe.find('#URL_'+id).show();
							$secondTab.find('#item_'+id).addClass('itemClick');//加上选中效果
							//如果用户点击的是“我的关注”，且“我的关注”未正常初始化，则需要重新初始化
							if(id == -1 && window.KeyInfoCollectList && !window.KeyInfoCollectList.initialized){
								window.KeyInfoCollectList.iniView();
							}
						}
					}
				}
			}
			
			$manager.click(function(){
				if(!$manager.data('show')){
					$manager.addClass('platformMngHover');
					//$manager.find('.manager').removeClass('manager_unclick');
					if($managerTarget.html()=='' || $managerTarget.html()==null){
						$managerTarget.css({width:$manager.outerWidth()-2,left:$manager.offset().left,top:$manager.offset().top+38});
//						$.post(webRoot+'base/getGeneralTree.do?tableName=menu_item',{
//										paramMap: $.toJSON({
//												subSysId:-1,
//												sqlKey:'com.ztesoft.web.common.db.dao.mapper.GeneralTreeMapper.menuTree',
//												rootId:-1,
//												valueField:'menuItemId',
//												displayField:'menuItemName'
//											})
//										},
						$.post(webRoot+'sysconfig/menuitem/queryMenuTree.do',{subSysId:-1},
						function(records){
							if(!records){
								return;
							}
							records = records.children;
//							records = records.children[0].children;
							var LastNode = records.length-1;
							for(var i=0;i<records.length;i++){
								var record = records[i];
								if( i == LastNode ){
									$group = $('<div class="node nodeLast">'+record.text+'</div>');
								}else{
									$group = $('<div class="node">'+record.text+'</div>');
								}
								$managerTarget.append($group);
								var $nodeChilds =$('<div class="nodeChilds"></div>');
								$managerTarget.append($nodeChilds);
								//var childrens = record.children;
								var childrens = record.children;
								var LastChild = childrens.length-1;	
								for(var j=0;j<childrens.length;j++){
									if( j == LastChild ){ 
										var $item = $('<div class="child childLast">'+childrens[j].text+'</div>');
									}else{
										var $item = $('<div class="child">'+childrens[j].text+'</div>');
									}
									$item.data('data',childrens[j]);
									$nodeChilds.append($item);
									if(i!=0)$nodeChilds.hide();
									if(i==0)$nodeChilds.prev().addClass('nodeClick');
								}
							}
							$('.platformMngPop .node').click(function(){
								$('.platformMngPop .node').not($(this)).removeClass('nodeClick')
								$('.platformMngPop .nodeChilds').not($(this).next()).hide();
								$(this).toggleClass('nodeClick');
								$(this).next().toggle();
							});
							$('.platformMngPop .nodeChilds .child').click(function(){
								if($(this).data('data').attributeMap.menuItemUrl){
									var tempChange = false;
									if(selectedSubSysId != -1){
										//为了避免用户点击菜单管理中的其他菜单切换子系统时，我的关注错误初始化，此处临时切换一下我的关注的初始化状态
										if(window.KeyInfoCollectList && !window.KeyInfoCollectList.initialized){
											window.KeyInfoCollectList.initialized = true;
											tempChange = true;
										}
										changeSubSys(-1,true);
										bar.hide();
										$('.leftMenuClose').hide();
									}
									rebindSizeLeftMenuOnHide();
									if(tempChange){
										window.KeyInfoCollectList.initialized = false;
									}
									bar.openUrl(webRoot+$(this).data('data').attributeMap.menuItemUrl,$(this).data('data').attributeMap.menuItemName,$(this).data('data').attributeMap.menuItemId);
								}
								closeManger();
							});
						});
						if(!$mark){
							$mark = $('<div class=mark></div>');
							$mark.click(closeManger);
							$mark.appendTo(document.body);
							//$managerTarget.appendTo(document.body);
						}
					}
					$managerTarget.show();
					$mark.show();
					$manager.data('show',!$manager.data('show'));
				}
				else{
					closeManger();
				}
			});
			$secondTab.append($manager);
			$psdUpdate = $('.pswChg');
			var $psdUpdateTarget;
			$psdUpdate.click(function(){
				if (!$psdUpdate.data('show')) {
					if(!$psdUpdateTarget){
	                    $mark2 = $('<div class=mark></div>');
	                    $mark2.click(function(e) {
                            if (e.target.className.indexOf('close') != -1 || e.target.className == 'mark' || e.target.className == 'changepswCancel') {
                               return closeManger2();
                            }
                            if (e.target.className.indexOf('changepswOk') != -1) {
                                submit();
                            }
                        });
	                    $mark2.appendTo(document.body);
	                    $psdUpdateTarget = $('<div class="alert"><a class="close" href="javascript:void(0);">关闭</a></div>');
						var $ul = $('<ul></ul>');
						$ul.append('<li><i>原密码：</i><input type="password" name="password" placeholder="输入原密码" autocomplete="off"/></li><li><i>新密码：</i><input type="password" name="password2" placeholder="输入新密码"/></li><li><i>确认密码：</i><input type="password" name="password3" placeholder="再次输入新密码"/></li>');
						$psdUpdateTarget.append($ul);
						$psdUpdateTarget.append('<div class="error"></div><div align="center"><a class="changepswOk" href="javascript:void(0);">确 认</a><a class="changepswCancel" href="javascript:void(0);">取 消</a></div>');
						$mark2.append($psdUpdateTarget);
					}
	                $mark2.show();
	                $psdUpdate.data('show', true);
                }
			});
			//$secondTab.append($psdUpdate);
			$logout = $('.logout');
			$logout.click(function(){
				if (window.confirm("确认要退出系统吗?")) {
					window.top.location.href = webRoot+'index/logout.do';
				}
			});
			//$secondTab.append($logout);
			$user = $('.sysManager');
			$user.html(userSession.staff.staffName||'用户');
			minWidth = $(".subTabs").width() - $('.subTabs .sysMenus').width() - 15;
			//$secondTab.append($user);
			var $mainFrame = $('.mainFrame');
			//$mainFrame.appendTo(render);
			var loadMask=$('<div class="load_mask"><img src="'+webRoot+'portal/resource/theme/blue/images/portal/loading.gif" width="146" height="95"></div>');
			loadMask.appendTo(render);
		}
	}
});