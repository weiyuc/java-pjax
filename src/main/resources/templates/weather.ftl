<html>
	<head>
		<title>${city!''}天气</title>
		<link rel='stylesheet' href='/css/weather.css'/>
		<link rel='stylesheet' href='/js/nprogress/nprogress.css'/>
		<script src='/js/nprogress/nprogress.js'></script>
	</head>
	<body>
		<header>
			<span><a href="/weather/北京">北京</a></span>
			<span><a href="/weather/天津">天津</a></span>
			<span><a href="/weather/上海">上海</a></span>
			<span><a href="/weather/重庆">重庆</a></span>
		</header>
		<section>
			<div class="container" id="container">
				${weather!''}
			</div>
		</section>
		<footer class="footer">
			<h3>数据由 wthrcdn.etouch.cn 提供</h3>
		</footer>
	</body>
	<script type="text/javascript" src="/js/jquery/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="/js/jquery/jquery.pjax.js"></script>
	<script type="text/javascript">
		$.pjax({
			selector: 'a',
			container: '#container',
			show: 'fade',
			cache: false,
			storage: false,
			timeout : 0,
			titleSuffix: '天气',
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