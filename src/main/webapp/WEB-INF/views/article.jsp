<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><!--
////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//                  佛祖保佑       永不宕机     永无BUG           //
////////////////////////////////////////////////////////////////////
-->
<head>
		<meta charset="UTF-8">
		<meta name="Generator" content="花怜">
		<meta name="Author" content="花怜">
		<meta name="Keywords" content="花怜">
		<meta name="Description" content="花怜">
		<title>花怜小屋</title>
		<link href="../../kuzwlu/header.css" rel="stylesheet" type="text/css" />
	<link href="../../kuzwlu/body.css" rel="stylesheet" type="text/css" />
	<link href="../../kuzwlu/footer.css" rel="stylesheet" type="text/css" />
	<script src="../../JQ/jquery-2.1.0.js"></script>
	<script src="../../JQ/kuzwlu.js"></script>
	<link rel="icon" href="../../img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="../../css/sinaFaceAndEffec.css" />
	<script src="../../js/jquery-3.3.1.min.js"></script>
	<script src="../../js/kuzwlu.js"></script>
	<script type="text/javascript" src="../../js/sliders.js"></script>
	<link rel="stylesheet" href="../../sweetalert/example/buttons.css">
	<link rel="stylesheet" href="../../fontawesome/css/font-awesome.min.css">
	<script src="../../sweetalert/lib/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="../../sweetalert/dist/sweetalert2.min.js"></script>
	<link rel="stylesheet" href="../../sweetalert/dist/sweetalert2.min.css">
	</head>
	<style>
		#message{
			font-size: 20px;
    		color: #48AE15;
    		border: 1px solid rgb(230, 230, 230);
		}
		.messagetext{
			background-color: #eaeaea7a;
			border-radius: 5px;
			color: #1567ae;
			 margin-left: 10px;
    		 margin-right: 10px;
   			 font-size: 16px;
   			 border: 1px solid #99999969;
   			 margin-bottom: 20px;
		}
		.messagetext>img{
			float: left;
    		width: 45px;
    		border-radius: 15%;
    		margin: 5px 5px 5px 5px;
		}	
		#mecontent{
			width: 608.5px;
			max-width: 608.5px;
		}
		.replaytext{
		border-radius: 5px;
			    margin: 5px 10px 0px 50px;
			    color: #ae1515;
   			 font-size: 16px;
   			 border: 1px solid #99999969;
		}
		.replaytext>img{
			float: left;
    		width: 45px;
    		border-radius: 15%;
    		margin: 5px 5px 5px 5px;
		}
		#articlenews{
			outline: rgb(230, 230, 230) solid 1px;
			font-size:15px;
		}
		#articlenews>span{
			margin-left: 15px;
		}
		#articlenews>span>a{
			font-size:13px;
			color: #03A9F4;
		}
		#artitle{
			margin: 5px 5px 5px 0px;
   			font-size: 25px;

		}
		#contenttext{
			margin:20px;
		}
		.messagetext p img {
    		width: 23px;
		}
		#pageone,#pagetwo,#pagethere{
			font-size: 18px;
    		color: #7ea5de;
		}
		#user{
			margin-left: 25px;
		}
		#contenttext a img{width: 630px;}
		#contenttext>p{margin:20px;}
		#messagetext img{
			width:23px;
		}
		#remove img{
			width:690px;
		}
	</style>
  
  <body>
   <!--播放器引用-->
		<div id="fuck">
			<div id="header">
				<div class="header-main">
					<a class="header-logo" href="#" title="花怜小屋" target="_blank">
						<img class="header-logo" src="../../img/header-logo.png">
					</a>
					<ul class="list">
						<li class="on">
							<a href="../1">首页</a>
						</li>
						<li>
							<a href="category.html">分类</a>
						</li>
						<li>
							<a href="post.html">动态</a>
						</li>
						<li>
							<a href="link.html">友链</a>
						</li>
						<li>
							<a href="guestbook.html">留言</a>
						</li>
						<li>
							<a href="login.html">登录</a>
						</li>
					</ul>
					<div class="header-search">
						<form action="search.html" method="get">
							<input type="text" placeholder="请输入搜索内容！" autocomplete="off" name="keywords" />
							<button type="submit" class="search">
				</button>
						</form>
					</div>
					<div class="dropdown">
						<li>
							<a class="dropbtn" href="find.html">发现
								<div class="btn2"></div>
							</a>
						</li>
						<div class="dropdown-content">
							<a href="#">可以</a>
							<a href="#">自动</a>
							<a href="#">添加</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="lunbo"></div>
		<div class="body">
			<div class="auto">
				<div class="main" id="main">
					<div class="main-news">
						<div class="main-box"></div>
						<div class="main-new">最新</div>
					</div>
					<div id="topnews">
					<div id="remove">
						${requestScope.articleList.arcontent }
					</div>
					
				  </div>
				  
					 <!-- <span id="thepage" >
					  	<span align="left" valign="top" class="fenye" style="text-align: center;">
					  	<p id="pagethere" style="color: #7ea5de;">${requestScope.nextpage }</p>
					  	<p id="pageone">${requestScope.nowpage }/${requestScope.maxpage } 页</p>
					  	<p id="pagetwo" style="margin: 20px 20px 40px 20px;">
					  	<a onclick="home('${requestScope.maxpage }','1')" onFocus="this.blur()" style="color: #7ea5de;">首页</a>&nbsp;&nbsp;
					  	<a onclick="up('${requestScope.maxpage }','${requestScope.nowpage }')" onFocus="this.blur()" style="color: #7ea5de;">上一页</a>&nbsp;&nbsp;
						<a onclick="next('${requestScope.maxpage }')" onFocus="this.blur()" style="color: #7ea5de;" >下一页</a>&nbsp;&nbsp;
					  	<a onclick="end('${requestScope.maxpage }','${requestScope.nowpage }')" onFocus="this.blur()" style="color: #7ea5de;">尾页</a>&nbsp;&nbsp;
					  	</p>
					  	</span> -->
					  </span>
				</div>
				<div id="sidebar">
					<div id="author">
						<div class="main-news">
							<div class="main-box"></div>
							<div class="main-new">关于博主</div>
						</div>
						<div class="post-box authorname">
							<div class="authorimg"></div>
							<div class="QQ">
								<a href="https://wpa.qq.com/msgrd?v=3&uin=1726539504&site=qq&menu=yes" target="_blank"><img src="https://q2.qlogo.cn/headimg_dl?dst_uin=1726539504&amp;spec=100" onerror="whenQQError(this)" /></a>
							</div>
							<!--调用一言api-->
							<div class="yiyan">
								<div id="hitokoto">亲，莫得网了，刷新试试！</div>
							</div>
							<div class="authorrss">
								<a href="index.html">文章:${requestScope.pageSize}</a>
								<a  href="category.html">分类:${fn:length(requestScope.catalogs)}</a>
								<a href="guestbook.html">留言:9</a>
								<a href="#tag">标签:15</a>
							</div>
						</div>
					</div>
					<div id="tag">
						<div class="main-news">
							<div class="main-box"></div>
							<div class="main-new">热门标签</div>
						</div>
						<div class="sidebarname card post-box">
							<a href="#">JAVA</a>
							<a href="#">学习</a>
							<a href="#">福利</a>
							<a href="#">资源</a>
							<a href="#">软件</a>
							<a href="#">开发</a>
							<a href="#">QAQ</a>
							<a href="#">QAQ</a>
						</div>
					</div>
					<div id="looking">
						<div class="main-news2">
							<div class="main-box"></div>
							<div class="main-new">随机看看</div>
						</div>
						<!--还没想好做什么-->
						<pre class="sidebarname card post-box">						
    《春晓》   
 孟浩然
  春眠不觉晓，处处闻啼鸟。
  夜来风雨声，花落知多少。
						</pre>
					</div>
					<div id="ad">
						<div class="main-news2">
							<div class="main-box"></div>
							<div class="main-new">广告招租</div>
						</div>
						<pre class="sidebarname card post-box">
							
    《江雪》   
 柳宗元
  千山鸟飞绝，万径人踪灭。
  孤舟蓑笠翁，独钓寒江雪。
						</pre>
					</div>
				</div>
			</div>
		</div>
		
		<div id="footer">
			<div class="footer-mian">
				<div class="allright">
					© 2019
					<a href="https://npm7.com" target="_blank">花怜小屋</a>
					ALL RIGHTS RESERVED.
				</div>
				<div class="theme">
					POWERED BY
					<a href="https://qqgg.xyz" target="_blank">HUA</a> &
					<a href="https://qqgg.xyz" target="_blank">LIAN</a>, THEME BY
					<a href="https://github.com/vircloud/ArmXMod" target="_blank">ARMX</a> &
					<a href="https://vircloud.net/" target="_blank">VIRCLOUD</a>.
				</div>
				<div class="beian">
					<a href="http://beian.miit.gov.cn/publish/query/indexFirst.action" target="_blank"><img src="../../img/beian.png" /></a>
					<a href="http://beian.miit.gov.cn/publish/query/indexFirst.action" target="_blank">赣ICP备19008669号-2</a>
				</div>
			</div>
		</div>
		<div id="dtop">
			<div class="bottom">
				<a href="#fuck"><img src="../../img/top.png"/></a>
			</div>
			<div class="bottom">
				<a href="#footer"><img src="../../img/bottom.png"/></a>
			</div>
		</div>
	</body>

</html>
