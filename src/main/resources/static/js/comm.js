$(document).ready(function() {
    //tab
    $('.tab_buttons li').mousemove(function() {
        $(this).addClass('newscurrent').siblings().removeClass('newscurrent');
        $('.newstab>div:eq(' + $(this).index() + ')').show().siblings().hide();
    });

});
