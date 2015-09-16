<%@ page isELIgnored="true" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- .aside -->
<aside class="bg-light b-r aside-md hidden-print" id="nav">
	<section class="vbox">
		<section class="w-f scrollable">
			<div class="slim-scroll" data-height="auto"
				data-disable-fade-out="true" data-distance="0" data-size="5px"
				data-color="#333333">
				<!-- nav -->
				<nav class="nav-primary hidden-xs">
					<ul class="nav">
						<li class="active"><a
							href="<%=request.getContextPath()%>/index.html" class="active">
								<i class="fa fa-home icon"> <b class="bg-primary"></b>
							</i> <span>Trang chá»§</span>
						</a></li>
						<sec:authorize access="hasRole('ROLE_CUSTOMER')">
						<li><a href="<%=request.getContextPath()%>/tu-van-khach-hang.html">
								<i class="fa fa-comments icon"> <b class="bg-primary"></b>
							</i> <span>TÆ° váº¥n khÃ¡ch hÃ ng</span>
						</a></li>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_NEWS')">
						<li><a href="#pages"> <i class="fa fa-cogs icon"> <b
									class="bg-primary"></b>
							</i> <span class="pull-right"> <i
									class="fa fa-angle-down text"></i> <i
									class="fa fa-angle-up text-active"></i>
							</span> <span>Quáº£n lÃ½ tin tá»©c</span>
						</a>
							<ul class="nav lt">
								<li><a href="<%=request.getContextPath()%>/quan-ly-bai-viet.html">
								<i class="fa fa-angle-right">
							</i> <span>BÃ i viáº¿t</span>
						</a></li>
								<li><a
									href="<%=request.getContextPath()%>/quan-ly-chuyen-muc.html"> <i
										class="fa fa-angle-right"></i> <span>ChuyÃªn má»¥c</span>
								</a></li>
							</ul></li>
							</sec:authorize>
							
						<%-- <li><a href="<%=request.getContextPath()%>/contact.html">
								<i class="fa fa-comments icon"> <b class="bg-primary"></b>
							</i> <span>Pháº£n há»i khÃ¡ch hÃ ng</span>
						</a></li> --%>
						<sec:authorize access="hasRole('ROLE_USER')">
						<li><a href="<%=request.getContextPath()%>/quan-ly-nguoi-dung.html">
								<i class="fa fa-comments icon"> <b class="bg-primary"></b>
								</i> <span>Quáº£n lÃ½ tÃ i khoáº£n</span>
								</a></li>
							</sec:authorize>	
						<%-- <li><a href="#pages"> <i class="fa fa-cogs icon"> <b
									class="bg-primary"></b>
							</i> <span class="pull-right"> <i
									class="fa fa-angle-down text"></i> <i
									class="fa fa-angle-up text-active"></i>
							</span> <span>Quáº£n trá» há» thá»ng</span>
						</a>
							<ul class="nav lt">
								<li><a href="<%=request.getContextPath()%>/quan-ly-nguoi-dung.html">
										<i class="fa fa-angle-right"></i> <span>Quáº£n lÃ½ tÃ i
											khoáº£n</span>
								</a></li>
								<li><a
									href="<%=request.getContextPath()%>/group/index.html"> <i
										class="fa fa-angle-right"></i> <span>Quáº£n lÃ½ nhÃ³m ngÆ°á»i
											sá»­ dá»¥ng</span>
								</a></li>
							</ul></li> --%>
						<sec:authorize access="hasRole('ROLE_CONTACT')">
						<li><a href="<%=request.getContextPath()%>/quan-ly-thong-tin-lien-he.html">
								<i class="fa fa-comments icon"> <b class="bg-primary"></b>
							</i> <span>LiÃªn há»</span>
						</a></li>
						</sec:authorize>
						<li><a href="http://uchi.com.vn/" target="blank"> <i
								class="fa fa-question-circle icon"> <b class="bg-primary"></b>
							</i> <span>Trá»£ giÃºp</span>
						</a></li>
					</ul>
				</nav>
				<!-- / nav -->
			</div>
		</section>
		<footer class="footer lt hidden-xs b-t b-light">
			<div id="chat" class="dropup">
				<section class="dropdown-menu on aside-md m-l-n">
					<section class="panel bg-white">
						<header class="panel-heading b-b b-light">Active chats</header>
						<div class="panel-body animated fadeInRight">
							<p class="text-sm">No active chats.</p>

							<p>
								<a href="#" class="btn btn-sm btn-default">Start a chat</a>
							</p>
						</div>
					</section>
				</section>
			</div>
			<div id="invite" class="dropup">
				<section class="dropdown-menu on aside-md m-l-n">
					<section class="panel bg-white">
						<header class="panel-heading b-b b-light">
							John <i class="fa fa-circle text-success"></i>
						</header>
						<div class="panel-body animated fadeInRight">
							<p class="text-sm">No contacts in your lists.</p>

							<p>
								<a href="#" class="btn btn-sm btn-facebook"><i
									class="fa fa-fw fa-facebook"></i> Invite from Facebook</a>
							</p>
						</div>
					</section>
				</section>
			</div>
			<a href="#nav" data-toggle="class:nav-xs"
				class="pull-right btn btn-sm btn-default btn-icon"> <i
				class="fa fa-angle-left text"></i> <i
				class="fa fa-angle-right text-active"></i>
			</a>
		</footer>
	</section>
</aside>
<!-- /.aside -->
