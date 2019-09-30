var app = (()=>{
	return {
		init : (ctx)=>{
			playerService.login();
			$('#a_join').click(()=>{
				alert('회에원가아이입');
				location.assign(ctx+'/player.do?page=join');
			});
			$('#back').click(()=>{
				alert('집으로 가라...!!!');
				location.assign(ctx+'/player.do?page=login');
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
		login: ()=>{
			$('#login_form_button').click(()=>{
				if($('#username').val()==='' || $('#userpass').val()===''){
					alert('입력한 아이디 값:'+$('#username').val()+'입력한 비번 값  : ' + $('#userpass').val() +'값없음');	
				}else{
					alert('입력한 아이디 값:'+$('#username').val()+'입력한 비번 값  : ' + $('#userpass').val() + '값있음');
					$('#login_form').attr('action', '/jee-soccer/player.do');
					$('#login_form').submit();
				}
			});
		}
	};
})();