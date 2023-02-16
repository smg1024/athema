/**
 * 
 */


function getdata(email) {
	$.ajax({
		type: 'POST',
		url:'/member/checkemail',
		data: {'email':email},
		success: function(data){
			if(data > 0) {
				alert("이미 가입된 회원입니다.");
				$('.mem_id').focus();
			} else {
				alert("사용 가능합니다.");
				$('#email_hiddenChk').attr("value", "Y")
				$('#email_check').hide();
				$('#id_check').show();
			}
		}
	});
};


$(document).ready(function(){
	
	$('.mem_name').blur(function(){
		var name = $(this).val();
		if (name == '') {
			$(this).focus();
			$('#span_name').text("이름을 입력하세요");
		} else {
			$('#span_name').text('');			
		}
	});
	
	$('.mem_id').keyup(function(){
		$('#email_check').show();
		$('#id_check').hide();
		var id = $(this).val();
		var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
		if (reg.test(id)) {
			$('#span_id').text('');
		} else {
			$('#span_id').text("올바른 이메일 형식을 입력하세요");
		}
	});
	
	$('#email_check').click(function(){
		var email = $('.mem_id').val();
		if ($('#span_id').text() != '') {
			alert("올바른 이메일 형식을 입력하세요");
			return;
		} else {
			getdata(email);
		}
	});
		
	
	$('.mem_pwd').keyup(function(){
		var pwd = $(this).val();
		var reg = /^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,15}$/;
		if (reg.test(pwd)) {
			$('#span_pwd').text('');
		} else {
			$('#span_pwd').text("알파벳, 숫자, 특수문자를 각 1개 이상 포함하여 6~15자 이내로 입력하세요.");
		}
	});	
	
	$('.mem_pwd_confirm').change(function(){
		var pwd_con = $(this).val();
		var pwd = $('.mem_pwd').val();
		if(pwd_con == pwd) {
			$('#span_pwd_confirm').text("비밀번호가 일치합니다.");
			$('#span_pwd_confirm').css("color","green");
		} else {
			$('#span_pwd_confirm').text("비밀번호가 일치하지 않습니다.");
		}
	});
	
	$('.mem_nick').on('keyup',function(){
		var reg = /[0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
		var v = $('.mem_nick').val();
		if (reg.test(v)) {
			$('.mem_nick').val(v.replace(reg,''));
		}
	});
	
	$('#mem_tel').keyup(function() {
		$(this).val($(this).val().replace(/[^0-9]/g,"").replace(/([0-9]{3})+([0-9]{4})+([0-9]{4})/, "$1-$2-$3").replace("--","-"))
	});
});