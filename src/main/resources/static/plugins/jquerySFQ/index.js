// JavaScript Document
$(".pic ul li").hover(function(){
	$(this).stop(true).animate({width:"600px"},1000).siblings().stop(true).animate({width:"100px"},1000);
});
