<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/alogin.css" rel="stylesheet" type="text/css" />
	<script src="/project201903/js/jquery-3.3.1.min.js"></script>
	<link rel="stylesheet" href="sweetalert/example/buttons.css">
	<link rel="stylesheet" href="fontawesome/css/font-awesome.min.css">
	<script src="sweetalert/lib/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="sweetalert/dist/sweetalert2.min.js"></script>
	<link rel="stylesheet" href="sweetalert/dist/sweetalert2.min.css">
	
	<style>
	a{cursor: pointer;}
	#yes{
	width: 5px;
    height: 13px;
    border-color: rgba(117,200,43,1);
    border-style: solid;
    border-width: 0 2px 2px 0;
    transform: rotate(45deg);
    position: absolute;
    margin-left: -16px;
    margin-top: 9.5px;
	}
	#no:before{
		content: "";
	    width: 7px;
	    height: 7px;
	    border-color: rgb(200, 43, 43);
	    border-style: solid;
	    border-width: 0 2px 2px 0;
	    transform: rotate(45deg);
	    position: absolute;
	    margin-left: -16px;
	    margin-top: 11px;
	}
	#no:after{
		content: "";
	    width: 7px;
	    height: 7px;
	    border-color: rgb(200, 43, 43);
	    border-style: solid;
	    border-width: 0 2px 2px 0;
	    transform: rotate(-135deg);
	    position: absolute;
	    margin-left: -16px;
	    margin-top: 21px;
	}
	</style>
  </head>
  
	<body>
	<script>
	function a1(){
		$.ajax({
				type:'post',
				url:"ManagerAjax?type=code",
				data:{"codecheck":$("#codeinput").val()},
				success:function(data){
					$("#pspan").html = $('#pspan').html(data);
				}
			})
	}
	$(function(){
		
		$("#code").click(function () {
	            $(this).prop("src", "/project201903/CodesServlet?" + new Date().getTime());
	     });
	     $("#code").prop("src", "/project201903/CodesServlet?" + new Date().getTime());
	  })
	</script>
	    <form id="form1" runat="server" action="UserServlet" method="post" >
	    <input type="hidden" value="register" name="type">
	    <div class="Main" >
	        <ul>
	            <li class="top"></li>
	            <li class="top2"></li>
	            <li class="topA"></li>
	            <li class="topB"><span><img src="images/login/loginss.png" alt="" style="left:15px;top:15px;position:relative;" /></span></li>
	            <li class="topC"></li>
	            <li class="topD">
	                <ul class="login">
	                    <li><span class="left login-text" style="width: 60px;">用户名：</span> <span style="left">
	                        <input id="Text1" type="text" class="txt" name="username"/>  
	                     
	                    </span></li>
	                    <li><span class="left login-text" style="width: 60px;">密码：</span> <span style="left">
	                       <input id="Text2" type="password" class="txt" name="password" />  
	                    </span></li>
	                    <li><span class="left login-text" style="width: 60px;">确认密码：</span> <span style="left">
	                       <input  type="password" class="txt" name="password2" />  
	                    </span></li>
	                    <li style="position:absolute;width: 250px;"><span class="left login-text" style="width: 60px;">验证码：</span> <span style="left">
	                       	<input id="codeinput" type="text" class="txt" name="codes" style="width:80px;" onchange="a1()"/><span id="pspan"> </span> <img id="code" style="position: relative;top: 6px;left:10px;">
	                    </span></li>
	                </ul>
	            </li>
	            <li class="topE"></li>
	            <li class="middle_A"></li>
	            <li class="middle_B"></li>
	            <li class="middle_C"><span class="btn" ><input name="" type="submit" value="注册" style="background-color: #5cb85c;border: 0;margin-top: 50px;border-radius: 5px;width: 100px;height: 30;" /></span></li>
	            <li class="middle_D"></li>
	            <li class="bottom_A"></li>
	            <li class="bottom_B">花怜小屋&nbsp;&nbsp;<a href="https://www.npm7.com" target="_blank" style="text-decoration: none;color: #437ccf;">www.npm7.com</a></li>
	        </ul>
	    </div>
	    </form>
	    <script type="text/javascript">
	    var managername="${sessionScope.managername}";
	    var username="${sessionScope.username}";
		if(managername==''){
			box();
		}else if(username==''){
			box();
		}else{
			swal({
				  title: '您已登录',
				  text: '',
				  type: 'success',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  cancelButtonText: '进入首页',
				  confirmButtonText: '进入后台'
				}).then(function(isConfirm) {
				  if (isConfirm) {
					//swal('正在登录', '', 'success');
					window.location.href='background/index.jsp';
				  }else{
				  	window.location.href='';
				  }
				});
		}
	    function box(){
	    	swal({
					title: '条款和条件',
					input: 'checkbox',
					inputValue: 1,
					inputPlaceholder:
					'我同意条款和条件',
					confirmButtonText:
					'同意 <i class="fa fa-arrow-right></i>',
					inputValidator: function(result) {
					return new Promise(function(resolve, reject) {
					  if (result) {
						resolve();
					  } else {
						reject('您必须同意霸王条款和这些条件');
					  }
					});
					}
					}).then(function(result) {
					if (result) {
					swal({
					  type: 'success',
					  text: '您同意条款和条件 :)'
					});
					}
				})
			}
	    </script>
	</body>
</html>
