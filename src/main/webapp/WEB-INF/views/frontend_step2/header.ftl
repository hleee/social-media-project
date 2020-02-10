<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="/">twitpresso</a>
		<#if user??>
		<div class="row">
			<button class="btn btn-secondary mx-3" id="create_btn" data-toggle="modal"
			data-target="#create_post_modal">Create post</button>
			<button class="btn" id="header_logout_btn">Log out</button>
		</div>
		<#else>
		<div class="row">
			<a href="/signup"><button class="btn btn-secondary mr-3" id="header_signup_btn">Sign up</button></a>
			<a href="/login"><button class="btn btn-secondary" id="header_login_btn">Log in</button></a>
		</div>
		</#if>
	</div>
</nav>