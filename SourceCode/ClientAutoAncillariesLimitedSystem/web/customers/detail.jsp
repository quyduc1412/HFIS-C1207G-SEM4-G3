<%-- 
    Document   : detail
    Created on : Jul 1, 2014, 11:22:51 AM
    Author     : Mr.HamHo
--%>

<html>
<head>
    
    <%@taglib prefix="s" uri="/struts-tags"%>
	<meta charset="UTF-8">
	<title>Blog - Car Repair Shop Website Template</title>
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<!--[if lt IE 9]>
		<link rel="stylesheet" type="text/css" href="css/ie.css">
	<![endif]-->
</head>
<body>
	<div id="header">
		<div>
			<a href="index.html" class="logo"><img src="images/logo.png" alt=""></a>
			<form action="index.html">
				<input type="text" name="search" id="search" value="">
				<input type="submit" name="searchBtn" id="searchBtn" value="">
			</form>
		</div>
		<div class="navigation">
			<ul>
				<li>
					<a href="index.html">home</a>
				</li>
				<li>
					<a href="about.html">about</a>
					<ul>
						<li>
							<a href="team.html">the team</a>
						</li>
						<li>
							<a href="testimonials.html">testimonials</a>
						</li>
						<li>
							<a href="gallery.html">gallery</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="services.html">services</a>
					<ul>
						<li>
							<a href="services.html">engine maintenance</a>
						</li>
						<li>
							<a href="services.html">wheel allignment</a>
						</li>
						<li>
							<a href="services.html">air condition services</a>
						</li>
						<li>
							<a href="services.html">transmission</a>
						</li>
						<li>
							<a href="promo.html">promos &amp; discounts</a>
						</li>
					</ul>
				</li>
				<li class="selected">
					<a href="blog.html">blog</a>
				</li>
				<li>
					<a href="contact.html">contact</a>
				</li>
				<li class="booking">
					<a href="booking.html">book an appointment</a>
				</li>
			</ul>
		</div>
	</div>
	<div id="body">
		<div class="content">
			<div class="section">
				<div class="blog">
					<div class="article">
                                   
                                    <div>
                                         <a href="#" class="figure"><img src='../upload/<s:property value="item.thumbnail"/>' width="169" height="152" alt=""></a>
                                        <h3><s:property value="item.name" /></h3>
                                        <p><s:property value="item.description" /></p>
                                        <p><s:property value="item.typeItem.nameType" /></p>
                                        <p><s:property value="item.price" /></p>
                                        <input type="submit" name="BtnComment" id="Btncomment" value="Order"/>
                                    </div>
					</div>
					<div class="comment">
						<h4>one comment</h4>
						<div>
							<a href="#" class="figure"><img src="images/janedoe.jpg" alt="">jane doe</a>
							<p>
								<span>july 27, 2023</span> This is a comment. Nunc sed porta neque. Sed dui elit, condimentum venenatis pretium ut, pellentesque eget nulla. Nulla facilisi. <a href="#" class="reply">reply</a>
							</p>
						</div>
					</div>
					<div class="commentForm">
						<h4>leave a comment</h4>
						<form action="index.html">
							<div>
								<label for="name"> <span>name</span>
									<input type="text" name="name" id="name">
								</label>
								<label for="email"> <span>email</span>
									<input type="text" name="email" id="email">
								</label>
							</div>
							<label for="comment"> <span>comment</span>
								<textarea name="comment" id="comment"></textarea>
							</label>
							<input type="submit" name="Btncomment" id="Btncomment" value="">
						</form>
					</div>
				</div>
			</div>
			<div class="sidebar">
				<div class="categories">
					<h3>categories</h3>
					<ul>
						<li>
							<a href="blog-single.html">customize</a>
						</li>
						<li>
							<a href="http://www.freewebsitetemplates.com/">freewebsite templates</a>
						</li>
						<li>
							<a href="http://www.freewebsitetemplates.com/">free web design</a>
						</li>
					</ul>
				</div>
				<div class="post">
					<h3>popular blog posts</h3>
					<ul>
						<li>
							<a href="blog-single.html" class="figure"><img src="images/girl-calling.jpg" alt=""></a>
							<div>
								<span><a href="blog-single.html">Lorem ipsum dolor sit amet</a></span>
								<p>
									Sed id enim sit amet ante gravida tincidunt iaculis...
								</p>
							</div>
						</li>
						<li>
							<a href="blog-single.html" class="figure"><img src="images/man2.jpg" alt=""></a>
							<div>
								<span><a href="blog-single.html">Morbi luctus iaculis congue</a></span>
								<p>
									Nullam tempor ultrices risus at rutrum...
								</p>
							</div>
						</li>
						<li>
							<a href="blog-single.html" class="figure"><img src="images/gentleman.jpg" alt=""></a>
							<div>
								<span><a href="blog-single.html">Suspendisse vel faucibus sapien</a></span>
								<p>
									Integer metus nunc...
								</p>
							</div>
						</li>
						<li>
							<a href="blog-single.html" class="figure"><img src="images/castle2.jpg" alt=""></a>
							<div>
								<span><a href="blog-single.html">Phasellus eu vulputate risus</a></span>
								<p>
									Nulla sagittis viverra erat id placerat...
								</p>
							</div>
						</li>
					</ul>
				</div>
				<div class="archives">
					<h3>archive</h3>
					<ul>
						<li>
							<a href="blog-single.html">june 2023</a>
						</li>
						<li>
							<a href="blog-single.html">may 2023</a>
						</li>
						<li>
							<a href="blog-single.html">april 2023</a>
						</li>
						<li>
							<a href="blog-single.html">march 2023</a>
						</li>
						<li>
							<a href="blog-single.html">february 2023</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<div>
			<div class="contact">
				<h3>contact information</h3>
				<ul>
					<li>
						<b>address:</b> <span>426 Grant Street Pine Hill, TX 75652</span>
					</li>
					<li>
						<b>phone:</b> <span>903-889-6313</span>
					</li>
					<li>
						<b>fax:</b> <span>903-889-6313</span>
					</li>
					<li>
						<b>email:</b> <span><a href="http://www.freewebsitetemplates.com/misc/contact">info@carrepairshop.com</a></span>
					</li>
				</ul>
			</div>
			<div class="tweets">
				<h3>recent tweets</h3>
				<ul>
					<li>
						<a href="#">Fusce ut massa magna, quis aliquam justo. In hac habitasse platea dictumst.<span>1 day ago</span></a>
					</li>
					<li>
						<a href="#">Fusce ut massa magna, quis aliquam justo.<span>2 days ago</span></a>
					</li>
				</ul>
			</div>
			<div class="posts">
				<h3>recent blog post</h3>
				<ul>
					<li>
						<a href="#">Fusce Ut Massa Magna</a>
					</li>
					<li>
						<a href="#">Quis Aliquam Justo</a>
					</li>
					<li>
						<a href="#">In Hac Habitasse Platea</a>
					</li>
					<li>
						<a href="#">Vestibulum Volutpat Turpis Eu Leo Eleifend Et Adipiscing </a>
					</li>
				</ul>
			</div>
			<div class="connect">
				<h3>stay in touch</h3>
				<p>
					Donec tempor, ipsum quis imperdiet, sapien sapien iaculis elit, at malesuada nulla nibh vel eros.
				</p>
				<ul>
					<li id="facebook">
						<a href="http://freewebsitetemplates.com/go/facebook/">facebook</a>
					</li>
					<li id="twitter">
						<a href="http://freewebsitetemplates.com/go/twitter/">twitter</a>
					</li>
					<li id="googleplus">
						<a href="http://freewebsitetemplates.com/go/googleplus/">googleplus</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="section">
			<p>
				&copy; this is the copyright area
			</p>
			<ul>
				<li>
					<a href="index.html">home</a>
				</li>
				<li>
					<a href="about.html">about</a>
				</li>
				<li>
					<a href="services.html">services</a>
				</li>
				<li>
					<a href="blog.html">blog</a>
				</li>
				<li>
					<a href="contact.html">contact</a>
				</li>
				<li>
					<a href="booking.html">book an appointment</a>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>