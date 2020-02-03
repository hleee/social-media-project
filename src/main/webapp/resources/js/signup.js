$(document).ready(function() {
	$('#signup_btn').click(function() {
		console.log("Sign up clicked");

		var username = $('#signup_username').val();
		var password = $('#signup_password').val();

		if (!username || !password) {
			alert("This field is mandatory.");
			return;
		}

		var param = {
			username : username,
			password : password
		}

		$.ajax({
			url : "/myapp/signup", // /signup에서 시작하여
			method : "POST",
			dataType : 'json',
			contentType : 'application/json',
			data : JSON.stringify(param)
		}).then(function(data) {
			alert("Success");
			window.location.href = '/login'; // /login으로 이동
		}, function(err) {
			alert("Sign up failed");
		});
		return false;
	});
});