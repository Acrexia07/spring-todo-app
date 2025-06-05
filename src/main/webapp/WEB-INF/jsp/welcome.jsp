<html>
    <head>
		<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
		<title>Welcome Page</title>
    </head>

    <body>
    	<%@ include file="common/navigation.jspf" %>
    	<div class="container">
    		<header>
    			<h1> Welcome ${name}! </h1>
    		</header>
    		<hr>
    		<section>
    			Manage your Todo tasks
    			<a href="main-page">
    			    <button type="button">Proceed</button>
    			</a>
    		</section>
    	</div>
<%@ include file="common/footer.jspf" %>
