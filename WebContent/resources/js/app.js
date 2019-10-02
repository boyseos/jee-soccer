var app = (()=>{
	return {
		init : (ctx)=>{
			playerService.login(ctx);
			playerService.join(ctx);			
			playerService.move_join(ctx);
			playerService.sql02(ctx);
			$('#back').click(()=>{
				alert('집으로 가라...!!!');
				location.assign(ctx+'/facade.do?page=login');
			});
			$('#sql_querry_form').submit(()=>{
			});
			
		}
	};
})();

var player = (()=>{
	var _playerId
	, _playerName, _teamId
	, _ePlayerName,_nickName,_joinYyyy,_position
	, _backNo, _nation, _brithDate, _solar, _height, _weight;
	var setPlayerId = (playerId)=>{this._playerId = playerId;}
	var setSolar = (solar)=>{this._solar = solar;}
	var getPlayerId = ()=>{return this._playerId;}
	var getSolar = ()=>{return this._solar;}
	return {
		setPlayerId : setPlayerId,
		setSolar : setSolar,
		getPlayerId : getPlayerId,
		getSolar : getSolar
	};
})();


var playerService = (()=>{
	return {
		login: (ctx)=>{
			$('#login_form_button').click(()=>{
				if($('#login_username').val()==='' || $('#login_userpass').val()===''){
					alert('입력한 아이디 값:'+$('#login_username').val()+'입력한 비번 값  : ' + $('#login_userpass').val() +'값없음');	
				}else{
					alert('입력한 아이디 값:'+$('#login_username').val()+'입력한 비번 값  : ' + $('#login_userpass').val() + '값있음');
					$('#login_form').attr('action', ctx+'/player.do');
					$('#login_form').attr('method','get');
					$('#login_form').submit();
				}
			});
		},
		join: (ctx)=>{
			$('#join_form_button').click(()=>{
				if($('#join_username').val()==='' || $('#join_userpass').val()===''){
					alert('입력한 아이디 값:'+$('#join_username').val()+'입력한 비번 값  : ' + $('#join_userpass').val() +'값없음');	
				}else{
					alert('입력한 아이디 값:'+$('#join_username').val()+'입력한 비번 값  : ' + $('#join_userpass').val() + '값있음');
					$('#join_form').attr('action', ctx+'/player.do');
					$('#join_form').attr('method','POST');
					$('#join_form').submit();
				}
			});
		},
		sql02: (ctx)=>{
			$('#sql02_button').click(()=>{
				alert('sadf');
				location.assign(ctx+'/player.do?action=sql&page=Sql_02&qr=result');
			});
		},
		move_join : (ctx)=>{
			$('#a_join').click(()=>{
				alert('회에원가아이입');
				location.assign(ctx+'/facade.do?page=join');
			});
		}
	};
})();