$(function() {
	$('form').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			username : {
				message : '用户名验证失败',
				validators : {
					notEmpty : {
						message : '用户名不能为空'
					},
					stringLength:{
						min:6,
						message:'至少需要6位'
					}
				}
			},
			password : {
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
					stringLength : {
						min:6,
						message : '至少需要6位'
					}
				}
			},
			nickname : {
				message : '昵称验证失败',
				validators : {
					notEmpty : {
						message : '昵称不能为空'
					}
				}
			},
		}
	});
});