<html>
	<head>
		<title>test</title>
		<style type="text/css">
			.container {
				width: 800px;
				height: 300px;
				border: 1px solid #777777;
				margin: auto;
				margin-top: 10px;
			}
		</style>
		<link rel='stylesheet' href='/lib/nprogress/nprogress.css'/>
		<script src='/lib/nprogress/nprogress.js'></script>
	</head>
	<body>
		<div>
			<div class="select">
				<div class="normal-select">
					<span>
						地域：
					</span>
					<ul>
						<li><a href="/index/北京">北京</a></li>
						<li><a href="/index/天津">天津</a></li>
						<li><a href="/index/上海">上海</a></li>
						<li><a href="/index/重庆">重庆</a></li>
					</ul>
				</div>
			</div>
			<div class="container" id="container">
				${area!''}
			</div>
		</div>
	</body>
	<script type="text/javascript" src="/lib/jquery/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="/lib/jquery/jquery.pjax.js"></script>
	<script type="text/javascript">
		$.pjax({
			selector: 'a',
			container: '#container',
			show: 'fade',
			cache: false,
			storage: false,
			timeout : 0,
			filter: function(){},
			callback: function(status){
				var type = status.type;
	            switch(type){
	                case 'success':;break; //正常
	                case 'cache':;break; //读取缓存 
	                case 'error': ;break; //发生异常
	                case 'hash': ;break; //只是hash变化
	            }
			}
    	});
    	NProgress.configure({ showSpinner: false });
		$('#container').bind('pjax.start', function(){
       		NProgress.start();
	    })
	    $('#container').bind('pjax.end', function(){
	        NProgress.done();
	    })
	</script>
</html>