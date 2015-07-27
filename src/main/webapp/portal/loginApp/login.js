define(function () {

	function submit(){

		var name = $('input[name=username]').val().replace(/^\s+|\s+$/g, '');

		var password = $('input[name=password]').val().replace(/^\s+|\s+$/g, '');

		var code = $('input[name=code]').val().replace(/^\s+|\s+$/g, '');		

		var reg =/^[a-zA-Z0-9]+[a-zA-Z0-9_]*[a-zA-Z0-9]+$/;

		var re = new RegExp(reg);

		var strs = name.split();

		if(strs[0]=='_'){


			$(".error").html("用户名不能以“_”开头");

			return;

		}

		else if(strs[strs.length-1]=='_'){

			$(".error").html("用户名不能以“_”结尾");

			return;

		}

		else {

			if(!new RegExp(/^[a-zA-Z0-9_]*$/).test(name)){

				$(".error").html("用户名只能数字、字母、下划线组成(禁止首尾)");

				return;

			}

		}

   		reg =/^[a-zA-Z0-9`\-=\\\[\];',.\/\~\!@#$%\^&\*()_\+|\?><":\{\}]*$/;

   		re = new RegExp(reg);

   		if(name==''){

			$(".error").html("用户名不能为空");

			$('input[name=username]').focus();

			return;

		}

   		if(password==''){

				$(".error").html("请输入密码");

				$('input[name=password]').focus();

				return;

   		}

   		if (!re.test(password)){

   			alert("密码：包含字母（A-Z）大小写敏感；数字（0-9）；特殊字符（`、-、=、\、[、]、;、'、,、.、/、~、!、@、#、$、%、^、&、*、(、)、_、+、|、?、>、<、\"、:、{、}）");

   			return;

   		}

   		if(!code){

			$(".error").html("请输入验证码");

			$('input[name=code]').focus();

			return;

   		}

		$.post(webRoot+'index/login.do',{loginName:name,password:MD5(password),randCode:code},function(result){

			if(!result.success){

				$(".error").html(result.msg);

				if(result.type==1){

					$('input[name=code]').focus();

				}

				else{

					$('input[name=username]').focus();

				}

				$('input[name=code]').val('');

				$('.randCodeImage').attr('src',webRoot+'base/randCodeImage.do?'+new Date().getTime());

			}

			else{

				$(".error").html(result.msg);

				var conditions = conditions||{expires: 365};

				$.cookie('name',name,conditions);

				window.location.href = webRoot+'portal/portal.jsp';

			}

		});

	}

	var me;

	return me = {

		submit:submit,

		show:function(){

			if($.mask==null||!$.mask.created){

				$.mask = $(".mask");

				$.mask.click(function(e){

					if(e.target.className=='close'||e.target.className=='mask'){

						$.mask.hide();

						me.isShow=false;

					}

					if(e.target.className.indexOf('loginBtn')!=-1){

						submit();

					}

				});


				$('.randCodeImage').click(function(){

					$(this).attr('src',webRoot+'base/randCodeImage.do?round='+new Date().getTime());

					$('input[name=code]').val('');

				});

				$.mask.created=true;

			}

			$.mask.show();

			var name = $.cookie('name');

			$('input[name=password]').keyup(function(){

				var password = $('input[name=password]').val().replace(/^\s+|\s+$/g, '');

				$('input[name=password]').val(password);

			});

			$('input[name=username]').keyup(function(){

				var name = $('input[name=username]').val().replace(/^\s+|\s+$/g, '');

				$('input[name=username]').val(name);

			});

			$('input[name=code]').keyup(function(){

				var name = $('input[name=code]').val().replace(/^\s+|\s+$/g, '');

				$('input[name=code]').val(name);

			});


			$(".error").html('');

			$('input[name=code]').val('');

			$('input[name=username]').val('');

			$('input[name=password]').val('');

			if(name){

				$('input[name=username]').val(name);

				$('input[name=password]').focus();

			}

			else{

				$('input[name=username]').focus();

			}

			$('.randCodeImage').attr('src',webRoot+'base/randCodeImage.do?'+new Date().getTime());

		}

	}

});

