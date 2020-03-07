<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主要内容区main</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/css.css" type="text/css" rel="stylesheet" />
	<link href="css/main.css" type="text/css" rel="stylesheet" />
	<link rel="shortcut icon" href="images/main/favicon.ico" />
	<link rel="stylesheet" href="sweetalert/example/buttons.css">
	<link rel="stylesheet" href="fontawesome/css/font-awesome.min.css">
	<script src="sweetalert/lib/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="sweetalert/dist/sweetalert2.min.js"></script>
	<link rel="stylesheet" href="sweetalert/dist/sweetalert2.min.css">
	<style>
	body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
	#searchmain{ font-size:12px;}
	#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
	#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
	#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
	#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
	#search a.add{ background:url(images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
	#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
	#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
	#main-tab th{ font-size:12px; background:url(images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
	#main-tab td{ font-size:12px; line-height:40px;}
	#main-tab td a{ font-size:12px; color:#548fc9;}
	#main-tab td a:hover{color:#565656; text-decoration:underline;}
	.bordertop{ border-top:1px solid #ebebeb}
	.borderright{ border-right:1px solid #ebebeb}
	.borderbottom{ border-bottom:1px solid #ebebeb}
	.borderleft{ border-left:1px solid #ebebeb}
	.gray{ color:#dbdbdb;}
	td.fenye{ padding:10px 0 0 0; text-align:right;}
	.bggray{ background:#f9f9f9}
	
	</style>
  </head>
  
  <body>
	<!--main_top-->
	<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
	  <tr>
	    <td width="99%" align="left" valign="top">您的位置：用户管理</td>
	  </tr>
	  <tr>
	    <td align="left" valign="top">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
	  		<tr>
	   		 <td width="90%" align="left" valign="middle">
		         <form method="get" action="manager/search">
		         <span>管理员：</span>
		         <input type="hidden" name="page" value="1"/>
		         <input type="text" name="managername" placeholder="请输入用户名" class="text-word">
		         <input name="" type="submit" value="查询" class="text-but">
		         </form>
	         </td>
	  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="background/main_info.jsp" target="mainFrame" onFocus="this.blur()" class="add">新增管理员</a></td>
	  		</tr>
		</table>
	    </td>
	  </tr>
	  <tr>
	    <td align="left" valign="top">
	    
	    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
	      <tr>
	        <th align="center" valign="middle" class="borderright">编号</th>
	        <th align="center" valign="middle" class="borderright">帐号</th>
	        <th align="center" valign="middle" class="borderright">密码</th>
	        <th align="center" valign="middle" class="borderright">用户状态</th>
	        <th align="center" valign="middle">操作</th>
	      </tr>
	      <c:forEach items="${requestScope.managerList}" var="p">
	  	  	<tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
	        <td align="center" valign="middle" class="borderright borderbottom">${p.managerid }</td>
	        <td align="center" valign="middle" class="borderright borderbottom">${p.managername }</td>
	        <td align="center" valign="middle" class="borderright borderbottom">${p.passwd }</td>
	        <td align="center" valign="middle" class="borderright borderbottom">${p.matate }</td>
	        <td align="center" valign="middle" class="borderbottom">
	        	<a href="manager/findByManagerId/${p.managerid }" target="mainFrame" onFocus="this.blur()" class="add">编辑</a>
	        	<span class="gray">&nbsp;|&nbsp;</span>
	        	<a target="mainFrame" onFocus="this.blur()" class="add" onclick="del('${p.managerid}')"/>删除</a>
	        	</td>
	      	</tr>
	      	</c:forEach>
	    </table></td>
	    </tr>
	    <tr>
	    <td align="left" valign="top" class="fenye"><a href="manager/search?page=1&managername=${requestScope.managername }" target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;
	    <c:choose>
	    	<c:when test="${requestScope.startPage ==1 }">
	    		<a href="manager/search?page=1&managername=${requestScope.managername }" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
	    	</c:when>
	    	<c:otherwise>
	    		<a href="manager/search?page=${requestScope.startPage - 1 }&managername=${requestScope.managername }" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
	    	</c:otherwise>
	    </c:choose>
	    <c:choose>
	    	<c:when test="${requestScope.startPage >= lastPage }">
	    		<a href="manager/search?page=${requestScope.startPage}&managername=${requestScope.managername }" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
	    	</c:when>
	    	<c:otherwise>
	    		<a href="manager/search?page=${requestScope.startPage + 1 }&managername=${requestScope.managername }" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
	    	</c:otherwise>
	    </c:choose>
	    <a href="manager/search?page=${requestScope.lastPage}&managername=${requestScope.managername }" target="mainFrame" onFocus="this.blur()">尾页</a></td>
	  </tr>
	</table>  
	<script type="text/javascript">
		function del(id){
			swal({
				title: '确定删除吗',
				text: "您将无法恢复该数据",
				type: 'warning',
				showCancelButton: true,
				confirmButtonColor: '#3085d6',
				cancelButtonColor: '#d33',
				confirmButtonText: '删除',
				cancelButtonText: '取消',
				confirmButtonClass: 'btn btn-success',
				cancelButtonClass: 'btn btn-danger',
				buttonsStyling: false
				}).then(function(isConfirm) {
				if (isConfirm === true) {
					window.location.href='manager/delete/'+id;
					swal(
					  '删除成功',
					  '',
					  'success'
					);
				} else if (isConfirm === false) {
					swal(
					  '已取消',
					  '',
					  'error'
					);
				} else {
				// Esc, close button or outside click
				// isConfirm is undefined
				}
				})
		}
     </script>
  </body>
</html>
