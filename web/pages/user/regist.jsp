<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>尚硅谷会员注册页面</title>
		<%@include file="/pages/common/head.jsp"%>
		<script type="text/javascript">
			//页面加载完成之后
			$(function () {
				$("#username").blur(function () {
					var username=this.value;
					$.getJSON("http://localhost:8080/book_war_exploded/userServlet","action=ajaxExistUsername&username="+username,function (data) {
						if (data.ExistUsername)
							$("span.errorMsg").text("用户名已存在");
						else $("span.errorMsg").text("用户名可用！");
					})
				})

				$("#code_img").click(function () {
					this.src="kaptcha.jpg?d="+new Date();
				})


				$("#sub_btn").click(function () {
					//验证用户名
					var userName=$("#username").val();
					//创建正则表达式对象
					var s=/^\w{5,12}$/;
					if (!s.test(userName)) {
						$("span.errorMsg").text("用户名不合法");
						return false;
					}

					var password=$("#password").val();
					//创建正则表达式对象
					var passwordPat=/^\w{5,12}$/;
					if (!passwordPat.test(password)) {
						$("span.errorMsg").text("密码不合法");
						return false;
					}

					var repwd=$("#repwd").val();
					//创建正则表达式对象
					var repwdPat=/^\w{5,12}$/;
					if (!repwdPat.test(repwd) && repwdPat!=password) {
						$("span.errorMsg").text("确认密码与密码不一致");
						return false;
					}

					//^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$
					var email=$("#email").val();
					//创建正则表达式对象
					var emailPat=/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
					if (!emailPat.test(email)) {
						$("span.errorMsg").text("邮箱不合法");
						return false;
					}

					var code=$("#code").val();
					//去掉空格后
					var code1 = $.trim(code);
					//创建正则表达式对象
					if (code1==null || code1 =="") {
						$("span.errorMsg").text("验证码不能为空");
						return false;
					}



					$("span.errorMsg").text("");

				})


			})



		</script>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
	</head>
	<body>
		<div id="login_header">

		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${requestScope.msg}</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="register">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username" value="${requestScope.username}" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email" value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 80px;" name="code" id="code"/>
									<img alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 150px" id="code_img">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />

								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>>
	</body>
</html>