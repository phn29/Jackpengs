$(function(){
	//banner轮播效果
	jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold", autoPlay:true, autoPage:true, trigger:"click" });
	//新闻推荐滚动效果
	jQuery(".news_hot").slide({mainCell:".bd ul", autoPage:true, effect:"top", autoPlay:true, scroll:2, vis:2});
	//时间轴滚动条
	$("#tl_box").niceScroll({  
		cursorcolor:"#7f7f7f",
		cursoropacitymax:1,
		touchbehavior:false,
		cursorwidth:"10px",
		cursorborder:"0",
		cursorborderradius:"10px"
	});
	//新闻列表切换
	jQuery(".knowledge,.news_tab,.news,.shiti,.i_school").slide();
	//高校解读展示效果
	$(".mingdan .spe").each(function(){
		$(this).find("li").eq(0).addClass("on");
		$(this).find("li").each(function(){
			$(this).find("a").mouseenter(function(){
				$(this).parents("li").addClass("on").siblings().removeClass("on");
			})
		})
	});
	//城市封面页图片轮换效果
	/*鼠标移过，左右按钮显示*/
	jQuery(".h_news").hover(function(){ jQuery(this).find(".prev,.next").stop(true,true).fadeTo("show",0.2) },function(){ jQuery(this).find(".prev,.next").fadeOut() });
	/*SuperSlide图片切换*/
	jQuery(".h_news").slide({ mainCell:".pic",effect:"fold", autoPlay:true, delayTime:600, trigger:"click"});
	//修改轮播图图片路径
	$(".h_news .pic li img").each(function(){
		$(this).attr("src",function(i,origValue){
			return origValue.replace(/-lp/g,'');
		})
	});
	//分数志愿录取切换效果
	jQuery(".luqu").slide({ mainCell:".tab-bd-in", titCell:".tab-hd ul li", effect:"left", delayTime:400, interTime:4000, pnLoop:true, autoPlay:true, easing:"easeOutCubic" });
	//列表页加载更多
	$(".load_list li:gt(11)").hide();
	$(window).scroll(function(){
		var scrollTop = $(window).scrollTop();
		var height = $(".i_logo_search").outerHeight()+$(".nav_wrap").outerHeight()+$(".content").outerHeight();
		if($(".l_city").length>0){
			if(scrollTop < 2800 && scrollTop > 1450){
				$('.load_list li:lt(21)').show();
				if($(".load_list li").length<=21){
					$(".load").hide();
					$(".mpage").show();
				}
			}else if(scrollTop > 2800){
				$('.load_list li:gt(20)').show();
				$(".load").hide();
				$(".mpage").show();
			}
		}else if(!$(".l_city").length>0){
			if(scrollTop < 2600 && scrollTop > 1250){
				$('.load_list li:lt(21)').show();
				if($(".load_list li").length<=21){
					$(".load").hide();
					$(".mpage").show();
				}
			}else if(scrollTop > 2600){
				$('.load_list li:gt(20)').show();
				$(".load").hide();
				$(".mpage").show();
			}
		}
		
	});
	if($(".load_list li").length<=12){
		$(".load").hide();
		$(".mpage").show();
	}
	//自定义函数
	var winHref = window.location.href;
	function changeHref(obj,txt,link){
		if(winHref.match("beijing")){
			$(obj).attr("href","/beijing"+link);
			$(txt).text("北京");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("shaanxi")){
			$(obj).attr("href","/shaanxi"+link);
			$(txt).text("陕西");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("zhejiang")){
			$(obj).attr("href","/zhejiang"+link);
			$(txt).text("浙江");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("hunan")){
			$(obj).attr("href","/hunan"+link);
			$(txt).text("湖南");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("jiangsu")){
			$(obj).attr("href","/jiangsu"+link);
			$(txt).text("江苏");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("yunnan")){
			$(obj).attr("href","/yunnan"+link);
			$(txt).text("云南");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("guangxi")){
			$(obj).attr("href","/guangxi"+link);
			$(txt).text("广西");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("sichuan")){
			$(obj).attr("href","/sichuan"+link);
			$(txt).text("四川");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("shandong")){
			$(obj).attr("href","/shandong"+link);
			$(txt).text("山东");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("hubei")){
			$(obj).attr("href","/hubei"+link);
			$(txt).text("湖北");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("henan")){
			$(obj).attr("href","/henan"+link);
			$(txt).text("河南");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("tianjin")){
			$(obj).attr("href","/tianjin"+link);
			$(txt).text("天津");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("hebei")){
			$(obj).attr("href","/hebei"+link);
			$(txt).text("河北");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("shanxi")){
			$(obj).attr("href","/shanxi"+link);
			$(txt).text("山西");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("nameng")){
			$(obj).attr("href","/nameng"+link);
			$(txt).text("内蒙古");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("liaoning")){
			$(obj).attr("href","/liaoning"+link);
			$(txt).text("辽宁");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("jilin")){
			$(obj).attr("href","/jilin"+link);
			$(txt).text("吉林");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("heilongjiang")){
			$(obj).attr("href","/heilongjiang"+link);
			$(txt).text("黑龙江");
			$(".l_nav").addClass("hlj");
		}else
		if(winHref.match("anhui")){
			$(obj).attr("href","/anhui"+link);
			$(txt).text("安徽");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("shanghai")){
			$(obj).attr("href","/shanghai"+link);
			$(txt).text("上海");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("jiangxi")){
			$(obj).attr("href","/jiangxi"+link);
			$(txt).text("江西");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("fujian")){
			$(obj).attr("href","/fujian"+link);
			$(txt).text("福建");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("guangdong")){
			$(obj).attr("href","/guangdong"+link);
			$(txt).text("广东");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("hainan")){
			$(obj).attr("href","/hainan"+link);
			$(txt).text("海南");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("zhongqing")){
			$(obj).attr("href","/zhongqing"+link);
			$(txt).text("重庆");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("guizhou")){
			$(obj).attr("href","/guizhou"+link);
			$(txt).text("贵州");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("xicang")){
			$(obj).attr("href","/xicang"+link);
			$(txt).text("西藏");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("gansu")){
			$(obj).attr("href","/gansu"+link);
			$(txt).text("甘肃");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("ningxia")){
			$(obj).attr("href","/ningxia"+link);
			$(txt).text("宁夏");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("qinghai")){
			$(obj).attr("href","/qinghai"+link);
			$(txt).text("青海");
			$(".l_nav").addClass("com");
		}else
		if(winHref.match("xinjiang")){
			$(obj).attr("href","/xinjiang"+link);
			$(txt).text("新疆");
			$(".l_nav").addClass("com");
		}else{
			$(".l_nav").addClass("qg");
		}
	}
	//不同城市展示其相关链接
	$("a.cg").each(function(){
		var aHref = $(this).attr("href");    //获取a标签链接
		var i = aHref.indexOf("/");    //indexOf("/"): 获取a标签链接中第一个/的位置
		aHref = aHref.substring(i);
		changeHref(this,'',aHref);
	});
	$(".c_name").each(function(){
		changeHref('',this,'');
	});
	$(".com a").each(function(){
		var a = $(this).text();    //获取a标签链接
		a = a.substring(2);
    	$(this).text(a);
	});
	$(".hlj a").each(function(){
		$(this).text($(this).text().substring(3));
	});
	//当前导航添加样式
	$(".l_nav a,.class a,.kemu_nav a").each(function(){
		var childName = $(this).attr("href");
	    if(winHref.match(childName)){ 
	    	$(this).addClass("on").siblings().removeClass("on");
	    }
	});
	var adrTxt = $(".adr a").eq(1).text();
	$(".i_city a").each(function(){
		var childTxt = $(this).text();
		var childHref = $(this).attr("href");
		if($(".adr").length>0){
			if(childTxt.match(adrTxt)){
				$(this).addClass("on").siblings().removeClass("on");
			}
		}else{
			if(winHref.match(childHref)){ 
	    		$(this).addClass("on").siblings().removeClass("on");
	   		}
		}
	});
	//添加qq群
	
})