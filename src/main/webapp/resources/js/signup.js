$(document).ready(function() { // jQuery 시작
	// signup.ftl에 있는 signup_btn에 대한 이벤트 정의 (클릭 시 아래 것들이 실행되도록)
	$('#signup_btn').click(function() {
		console.log("Sign up clicked");

		// signup.ftl에서 입력된 signup_username과 signup_password의 값을 username과
		// password라는 변수에 담기
		var username = $('#signup_username').val();
		var password = $('#signup_password').val();

		if (!username || !password) {
			alert("This field is mandatory.");
			return;
		}

		// param 객체에 담는데 첫 번째 username은 DB쪽 column name, 뒤쪽은 위에서 만든 변수
		var param = {
			username : username,
			password : password
		}

		$.ajax({
			url : "/user", // RestControllerToInsertOneUser의 매핑값
									// /user에서 시작하여 아래 명령문 실행
			method : "POST",
			dataType : 'json',
			contentType : 'application/json',
			data : JSON.stringify(param)
		}).then(function(data) {
			alert("Success");
			console.log(data);
			window.location.href = '/login'; // /myapp/login으로 이동 (ControllerToDisplayFtl)
		}, function(err) {
			alert("Sign up failed");
		});
		return false;
	});
});