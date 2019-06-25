function homepage() {
    window.location.href = "/myblog";
}

function articalDetail(id) {
    var url = "artical-view?id=" + id;
    window.location.href = url;
}

function bookDetail(id) {
    var url = "books-view?id=" + id;
    window.open(url);
}

function categoriesShow(id) {
    var url = "categories?id=" + id;
    window.location.href = url;
}

function musicplayer() {
    var url = "musicplayer";
    window.open(url);
}


function showCategories(id) {
    var url;
    if(id == undefined){
        url = "categories";
    }else{
        url = "categories?id=" + id;
    }
    window.location.href = url;
}

function showArchive(date) {
    var url;
    if(date == undefined){
        url = "archives";
    }else{
        url = "archives?date=" + date;
    }
    window.location.href = url;
}

function showTopic(id) {
    var url;
    if(id == undefined){
        url = "topics";
    }else{
        url = "topics?id=" + id;
    }
    window.location.href = url;
}

function showBooks() {
    var url = "books";
    window.location.href = url;
}

function showAboutme() {
    var url = "me";
    window.location.href = url;
}

function showTransfer() {
    var url = "transfer";
    window.location.href = url;
}

function visitWebsite(url) {
    window.open = url;
}

$(function () {
    $("[data-toggle='popover']").popover({
        trigger: 'manual',
        placement: 'bottom', //placement of the popover. also can use top, bottom, left or right
        //title : '<div style="text-align:center; color:black; text-decoration:none; font-size:14px;">我的信息</div>', //this is the top title bar of the popover. add some basic css
        html: 'true', //needed to show html of course
        content: content(), //this is the content of the html box. add the image here or anything you want really.
        animation: false
    }).on("mouseenter", function () {
        var _this = this;
        $(this).popover("show");
        $(this).siblings(".popover").on("mouseleave", function () {
            $(_this).popover('hide');
        });
    }).on("mouseleave", function () {
        var _this = this;
        setTimeout(function () {
            if (!$(".popover:hover").length) {
                $(_this).popover("hide")
            }
        }, 100);
    });
});

function content() {
    var data = $("<div>" +
        "<div style='margin-top: 3px;margin-bottom: 3px;'>" +
        "<i class='glyphicon glyphicon-user' style='color: darkgray;font-style: italic'><a href='' target=''>&nbsp;我的关注</a></i>" +
        "</div> " +
        "<div style='margin-top: 3px;margin-bottom: 3px;'>" +
        "<i class='glyphicon glyphicon-star' style='color: darkgray;font-style: italic'><a href='' target=''>&nbsp;我的收藏</a></i>" +
        "</div>" +
        "<div style='margin-top: 3px;margin-bottom: 3px;'>" +
        "<i class='glyphicon glyphicon-home' style='color: darkgray;font-style: italic'><a href='' target=''>&nbsp;个人中心</a></i>" +
        "</div>" +
        "<div style='margin-top: 3px;margin-bottom: 3px;'>" +
        "<i class='glyphicon glyphicon-log-out' style='color: darkgray;font-style: italic'><a href='' target=''>&nbsp;退出</a></i>" +
        "</div>" +
        "</div>");
    return data;
}




