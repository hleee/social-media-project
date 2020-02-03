$(document).ready(function() {
	$('#login_btn').click(function() {
		console.log("login clicked!!!");

		var username = $('#login_username').val();
		var password = $('#login_password').val();

		if (!username || !password) {
			alert("This field is mandatory.");
			return;
		}

		var param = {
			username : username,
			password : password
		}

		$.ajax({
			url : "/auth", // 프런트 쪽 /auth에서 시작
			method : "POST",
			dataType : 'json',
			contentType : 'application/json',
			data : JSON.stringify(param)
		}).then(function(data) {
			document.cookie = "accesstoken=" + data.data.token;
			document.cookie = "userId=" + data.data.userId;
			window.location.href = '/'; // 루트 주소인 localhost:8090/myapp/로 이동
		}, function(err) {
			alert("Please check the information again.");
			window.location.reload();
		});
		return false;
	});
});