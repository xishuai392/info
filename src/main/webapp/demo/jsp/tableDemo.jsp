<%@ page language="java" import="java.text.*,java.util.*"
	pageEncoding="UTF-8"%>

<%@include file="/common/common.inc.jsp"%>

<html>
<head>
<title>Table Ext.XTemplate 模板</title>
<script type="text/javascript">
	Ext.onReady(function() {
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

	});
</script>
</head>
<body>

	<div class="" id="allDiv">
		<div id="titleDiv">
			<h1>本市户籍人口信息</h1>
		</div>
		<div id="part1Div">
			<h1>人员基本信息</h1>
		</div>
		<div id="part1Table">
			<table class="tbl" width=90%>
				<tr>
					<td>姓名</td>
					<td>{[values.baseInfo.name]}</td>
					<td>曾用名</td>
					<td>{[values.baseInfo.aliaName]}</td>
					<td>性别</td>
					<td>{[values.baseInfo.sex]}</td>
					<td colspan=2 rowspan=6><img alt="照片"
						src="{[values.baseInfo.photoGif]}"></td>
				</tr>
				<tr>
					<td>民族</td>
					<td>{[values.baseInfo.nation]}</td>
					<td>出生日期</td>
					<td>{[values.baseInfo.birthDate]}</td>
					<td>公民身份证号码</td>
					<td>{[values.baseInfo.idCardNum]}</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;</td>
					<td>国家(地区)</td>
					<td colspan=2>省市县(区)</td>
					<td colspan=2>详址</td>
				</tr>
				<tr>
					<td>籍贯</td>
					<td>{[values.baseInfo.nativePlaceNation]}</td>
					<td colspan=2>{[values.baseInfo.nativePlaceProvince]}</td>
					<td colspan=2>{[values.baseInfo.nativePlaceDetailAddress]}</td>
				</tr>
				<tr>
					<td>出生地</td>
					<td>{[values.baseInfo.birthPlaceNation]}</td>
					<td colspan=2>{[values.baseInfo.birthPlaceProvince]}</td>
					<td colspan=2>{[values.baseInfo.birthPlaceDetailAddress]}</td>
				</tr>
				<tr>
					<td>身份证签发机关</td>
					<td colspan=2>{[values.baseInfo.idCardIssuneOffice]}</td>
					<td colspan=1>身份证有效期限</td>
					<td colspan=2>{[values.baseInfo.idCardExciptyTime]}</td>
				</tr>
				<tr>
					<td>住址</td>
					<td colspan=7>{[values.baseInfo.liveAddress]}</td>
				</tr>
				<tr>
					<td>派出所</td>
					<td colspan=7>{[values.baseInfo.policeStation]}</td>
				</tr>
			</table>
		</div>

		<div id="part2Div">
			<h1>家庭关系及联系人信息</h1>
		</div>
		<div id="part2Table">
			<table class="tbl" width=90%>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>关系</td>
					<td>公民身份证号码</td>
					<td>姓名</td>
					<td>证件种类</td>
					<td>证件号码</td>
					<td>外文姓</td>
					<td>外文名</td>
					<td>联系电话</td>
				</tr>
				<tpl for="familyInfoList">
				<tr>
					<td>{relationType}</td>
					<td>{relationShip}</td>
					<td>{idCardNum}</td>
					<td>{name}</td>
					<td>{certificateType}</td>
					<td>{certificateNum}</td>
					<td>{foreignLastName}</td>
					<td>{foreignFirstName}</td>
					<td>{telephoneNum}</td>
				</tr>
				</tpl>
			</table>
		</div>

		<div id="part3Div">
			<h1>迁移信息</h1>
		</div>
		<div id="part3Table">
			<table class="tbl" width=90%>
				<tr>
					<td>何时何因由何地迁来本市(县)</td>
					<td colspan=7>{[values.migrateInfo.timeAndResultForMigrateLocal]}</td>
				</tr>
				<tr>
					<td>何时何因由何地迁来本址</td>
					<td colspan=7>{[values.migrateInfo.timeAndResultForMigrateLocal]}</td>
				</tr>
				<tr>
					<td>何时何因迁往何地</td>
					<td colspan=7>{[values.migrateInfo.timeAndResultForMigrateOtherPlace]}</td>
				</tr>
			</table>
		</div>

		<div id="part3Div">
			<h1>以上查询信息仅作为.............. 操作单位：XXXX 操作人：XX 打印日期：{[new Date().toLocaleDateString()]}</h1>
		</div>

	</div>
</body>
</html>




