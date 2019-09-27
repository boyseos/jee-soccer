var app = (()=>{
	return {
		init : (ctx)=>{
			$('#login_form').submit(()=>{
				alert('form태그 크을리익... 크...으....ㄹ.......ㅣ....ㄱ!');
			});
			$('#a_join').click(()=>{
				alert('회에원가아이입');
				location.assign(ctx+'/player.do?page=join');
			});
			$('#back').click(()=>{
				alert('집으로 가라...!!!');
				location.assign(ctx+'/player.do?page=login');
			});
		}
	};
})();