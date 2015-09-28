<%@ page language="java" import="java.text.*,java.util.*"
	pageEncoding="UTF-8"%>

<%@include file="/common/common.inc.jsp"%>

<html>
<head>
<title>ExtJs4 笔记（4） Ext.XTemplate 模板</title>
<script type="text/javascript">
Ext.onReady(function(){
	var data = {
		name : '张三',
		job : 'C#程序员',
		company : '惠普',
		email : 'zhangsan@163.com',
		address : '武汉市洪山区光谷软件园',
		city : '武汉',
		state : '正常',
		zip : '430000',
		drinks : [ '绿茶', '红酒', '咖啡' ],
		friends : [ {
			name : '李四',
			age : 6,
			like : '鲜花'
		}, {
			name : '王五',
			age : 26,
			like : '足球'
		}, {
			name : '赵六',
			age : 81,
			like : '游戏'
		} ]
	};
	
	//使用标签tpl和操作符for
	var tpl = new Ext.XTemplate(
	      '<table cellpadding=0 cellspacing=0 border=1 width=400px>',
	      '<tr><td colspan=2 align=center><b>{name}的个人资料</b></td></tr>',
	      '<tr><td>姓名：</td><td>{name}</td></tr>',
	      '<tr><td>工作：</td><td>{job}</td></tr>',
	      '<tr><td>公司：</td><td>{company}</td></tr>',
	      '<tr><td>地址：</td><td>{address}</td></tr>',
	      '<tr><td>喜好饮品：</td><td>{drinks}</td></tr>',
	      '<tr><td>他的好友：</td><td>',
	      '<tpl for="friends">',
	      '<p>{name}：{age}岁</p>',
	      '</tpl></td></tr>',
	      '</table>'
	);
	tpl.overwrite(Ext.get("div1"), data);
	
	
	
	
	//在子模板的范围内访问父元素对象
	var tp2 = new Ext.XTemplate(
	 '<tpl for="friends">',
	 '<p>{name}是{parent.name}的好友。</p>',
	  '</tpl>'
	);
	tp2.overwrite(Ext.get("div2"), data);
	
	
	
	
	//数组元素索引和简单运算支持
	var tp3 = new Ext.XTemplate(
	 '<tpl for="friends">',
	     '<p>{#}、一年后,{name}的年龄是：{age+1}</p>',
	  '</tpl>'
	);
	tp3.overwrite(Ext.get("div3"), data);
	
	
	
	//自动渲染单根数组
	var tp4 = new Ext.XTemplate(
	 '喜好饮品：<tpl for="drinks">',
	 ' {.}',
	  '</tpl>'
	);
	tp4.overwrite(Ext.get("div4"), data);
	

	
	
	//条件逻辑判断
	var tp5 = new Ext.XTemplate(
	 '<table cellpadding=0 cellspacing=0 border=1 width=400px>',
	 '<tr><td>他的好友：</td><td>',
	 '<tpl for="friends">',
	     '<tpl if="age < 18"><p>{name}：[未成年]</p></tpl>',
	     '<tpl if="age >= 18"><p>{name}：{age}岁</p></tpl>',
	 '</tpl></td></tr>',
	 '</table>'
	);
	tp5.overwrite("div5", data);
	
	
	
	
	
	// 即时执行任意的代码
	var tp6 = new Ext.XTemplate(
			'当前日期：{[new Date().toLocaleDateString()]}',
			'<table cellpadding=1 cellspacing=1 border=1 width=400px>',
			'<tpl for="friends"><tr>',
			'<tpl if="xindex == 1"><td rowspan={[xcount]}>他的好友：</td></tpl>',
			'<td>{["姓名：" + values.name + "，年龄：" + values.age + "，"+ (values.like=="鲜花"?"是个女孩":"是个男孩")]}</td>',
			'</tr></tpl>', '</table>');
	tp6.overwrite("div6", data);
	
	

	var tpData = {"baseInfo":{"name":"Mir.xu","aliaName":"smile","sex":"男","nation":"中国","birthDate":"1991","idCardNum"
		:"1234342398732987398","photoGif":"a.gif","nativePlaceNation":"中国","nativePlaceProvince":"厦门","nativePlaceDetailAddress"
		:"望海路108号","birthPlaceNation":"中国","birthPlaceProvince":"湖南省","birthPlaceDetailAddress":"益阳市沅江县","idCardIssuneOffice"
		:"沅江市派出所","idCardExciptyTime":"10","liveAddress":"厦门双十","policeStation":"厦门思明派出所","nativePlace":"厦门湖里区",
		"householdRegisterProviceAddress":"湖南省","householdRegisterDetailAddress":"沅江市"},"familyInfoList"
		:[],"migrateInfo":{"timeAndResultForMigrateLocal":"smile forever,hhaha","timeAndResultForMigrateNative"
		:"xm","timeAndResultForMigrateOtherPlace":" 你猜"}};
	
    var tpTest = new Ext.XTemplate(
    		'<div class="" id="allDiv">',
    		'	<div id="titleDiv">',
    		'		<h1>本市户籍人口信息</h1>',
    		'	</div>',
    		'	<div id="part1Div">',
    		'		<h1>人员基本信息</h1>',
    		'	</div>',
    		'	<div id="part1Table">',
    		'		<table class="tbl" width=90%>',
    		'			<tr>',
    		'				<td>姓名</td>',
    		'				<td>{[values.baseInfo.name]}</td>',
    		'				<td>曾用名</td>',
    		'				<td>{[values.baseInfo.aliaName]}</td>',
    		'				<td>性别</td>',
    		'				<td>{[values.baseInfo.sex]}</td>',
    		'				<td colspan=2 rowspan=6><img alt="照片"',
    		'					src="{[values.baseInfo.photoGif]}"></td>',
    		'			</tr>',
    		'			<tr>',
    		'				<td>民族</td>',
    		'				<td>{[values.baseInfo.nation]}</td>',
    		'				<td>出生日期</td>',
    		'				<td>{[values.baseInfo.birthDate]}</td>',
    		'				<td>公民身份证号码</td>',
    		'				<td>{[values.baseInfo.idCardNum]}</td>',
    		'			</tr>',
    		'			<tr>',
    		'				<td>&nbsp;&nbsp;</td>',
    		'				<td>国家(地区)</td>',
    		'				<td colspan=2>省市县(区)</td>',
    		'				<td colspan=2>详址</td>',
    		'			</tr>',
    		'			<tr>',
    		'				<td>籍贯</td>',
    		'				<td>{[values.baseInfo.nativePlaceNation]}</td>',
    		'				<td colspan=2>{[values.baseInfo.nativePlaceProvince]}</td>',
    		'				<td colspan=2>{[values.baseInfo.nativePlaceDetailAddress]}</td>',
    		'			</tr>',
    		'			<tr>',
    		'				<td>出生地</td>',
    		'				<td>{[values.baseInfo.birthPlaceNation]}</td>',
    		'				<td colspan=2>{[values.baseInfo.birthPlaceProvince]}</td>',
    		'				<td colspan=2>{[values.baseInfo.birthPlaceDetailAddress]}</td>',
    		'			</tr>',
    		'			<tr>',
    		'				<td>身份证签发机关</td>',
    		'				<td colspan=2>{[values.baseInfo.idCardIssuneOffice]}</td>',
    		'				<td colspan=1>身份证有效期限</td>',
    		'				<td colspan=2>{[values.baseInfo.idCardExciptyTime]}</td>',
    		'			</tr>',
    		'			<tr>',
    		'				<td>住址</td>',
    		'				<td colspan=7>{[values.baseInfo.liveAddress]}</td>',
    		'			</tr>',
    		'			<tr>',
    		'				<td>派出所</td>',
    		'				<td colspan=7>{[values.baseInfo.policeStation]}</td>',
    		'			</tr>',
    		'		</table>',
    		'	</div>',
    	  '',
    		'	<div id="part2Div">',
    		'		<h1>家庭关系及联系人信息</h1>',
    		'	</div>',
    		'	<div id="part2Table">',
    		'		<table class="tbl" width=90%>',
    		'			<tr>',
    		'				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>',
    		'				<td>关系</td>',
    		'				<td>公民身份证号码</td>',
    		'				<td>姓名</td>',
    		'				<td>证件种类</td>',
    		'				<td>证件号码</td>',
    		'				<td>外文姓</td>',
    		'				<td>外文名</td>',
    		'				<td>联系电话</td>',
    		'			</tr>',
    		'			<tpl for="familyInfoList">',
    		'			<tr>',
    		'				<td>{relationType}</td>',
    		'				<td>{relationShip}</td>',
    		'				<td>{idCardNum}</td>',
    		'				<td>{name}</td>',
    		'				<td>{certificateType}</td>',
    		'				<td>{certificateNum}</td>',
    		'				<td>{foreignLastName}</td>',
    		'				<td>{foreignFirstName}</td>',
    		'				<td>{telephoneNum}</td>',
    		'			</tr>',
    		'			</tpl>',
    		'		</table>',
    		'	</div>',
    	  '',
    		'	<div id="part3Div">',
    		'		<h1>迁移信息</h1>',
    		'	</div>',
    		'	<div id="part3Table">',
    		'		<table class="tbl" width=90%>',
    		'			<tr>',
    		'				<td>何时何因由何地迁来本市(县)</td>',
    		'				<td colspan=7>{[values.migrateInfo.timeAndResultForMigrateLocal]}</td>',
    		'			</tr>',
    		'			<tr>',
    		'				<td>何时何因由何地迁来本址</td>',
    		'				<td colspan=7>{[values.migrateInfo.timeAndResultForMigrateLocal]}</td>',
    		'			</tr>',
    		'			<tr>',
    		'				<td>何时何因迁往何地</td>',
    		'				<td colspan=7>{[values.migrateInfo.timeAndResultForMigrateOtherPlace]}</td>',
    		'			</tr>',
    		'		</table>',
    		'	</div>',
    	  '',
    		'	<div id="part3Div">',
    		'		<h1>以上查询信息仅作为.............. 操作单位：XXXX 操作人：XX 打印日期：{[new Date().toLocaleDateString()]}</h1>',
    		'	</div>',
    		'</div>'
    		);
    //tpTest.overwrite(Ext.get("divTest"), tpData);
    
    	var config = {
            url : '/information/queryCZRKinfo.do',
            params : {
            
            },
            callback : function(data){
            	console.log("ddddddd");
            	//console.log(Ext.decode(data));
            	//重写绑定模板 
				//tp1.overwrite(changzhuWin.down('panel').getEl(), tpData);
            	tpTest.overwrite(Ext.get("divTest"),data);
            	console.log("eeeeeeee");
            }
        };

        ExtUtils.doAjax(config);
	
});
</script>
</head>
<body>

	<h1>使用标签tpl和操作符for</h1>
	<div class="content" id="div1"></div>
	<br><br><br>
	<h1>在子模板的范围内访问父元素对象</h1>
	<div class="content" id="div2"></div>
	<br><br><br>
	<h1>数组元素索引和简单运算支持</h1>
	<div class="content" id="div3"></div>
	<br><br><br>
	<h1>自动渲染单根数组</h1>
	<div class="content" id="div4"></div>
	<br><br><br>
	<h1>条件逻辑判断</h1>
	<div class="content" id="div5"></div>
	<br><br><br>
	<h1>即时执行任意的代码</h1>
	<div class="content" id="div6"></div>
	<br><br><br>
	<h1>模板成员函数</h1>
	<div class="content" id="div7"></div>
	<h1>详细信息</h1>
	<div class="content" id="divTest"></div>
	
</body>
</html>




