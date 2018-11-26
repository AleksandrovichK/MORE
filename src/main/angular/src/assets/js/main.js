$(document).ready(function() {
    $("body").on('click', '.itemnav', function(){
        $(".hor-items").find(".itemnav").removeClass("active");
        $(this).addClass("active");
    });

    // Sidebar Scroll START

    $('body').on('mousewheel', '.sidebar', function(e){
        if(e.originalEvent.wheelDelta / 120 > 0) {
                if( $(this).position().top<70){
                x = $(this).position().top + 30;
                $(this).css("top",x);
            }
        } else {
            // h = $('.sidebar').height() / -3;
            h = -2000;
            if( $(this).position().top>h){
                x = $(this).position().top - 30;
                $(this).css("top",x);
            }
        }
    });

    var lastY;

    $('body').bind('touchstart', '.sidebar', function (e){
        lastY = e.originalEvent.touches[0].clientY;
    });

    $('body').bind('touchmove', '.sidebar', function (e){
        var currentY = e.originalEvent.touches[0].clientY;
        if(currentY > lastY){
            m = currentY - lastY;
            // moved down
            if( $(this).position().top<70){
                x = $(this).position().top + m;
                $(this).css("top",x);
            }
        }else if(currentY < lastY){
            // moved up
            m = lastY - currentY;
            h = -2000;
            if( $(this).position().top>h){
                x = $(this).position().top - m;
                $(this).css("top",x);
            }
        }
        lastY = currentY;
    });

    $('body').bind('touchend', '.sidebar', function (e){
        if( $(this).position().top>70){
            $(this).css("top",70);
        }
    });

    // Sidebar Scroll END

    // Menu With icon START

    var curAsideBtn;

    $('body').on('click', '.aside-btn', function(){
        curAsideBtn = $(this);
        curAsideMenu = curAsideBtn.next('.aside-menu');
        if( $('.aside').hasClass('side-close') ) {
            if (curAsideBtn.hasClass('activated')){
                curAsideBtn.removeClass("activated");
            } else
            {
                $(".aside").find(".aside-btn").removeClass("activated");
                $(".aside").find(".aside-menu").collapse("hide");
                var text = "<li class='name'>" + curAsideBtn.find("span").text() + "</li>";
                curAsideMenu.prepend( (curAsideMenu.has("li.name").length ? "": text) );
                curAsideBtn.addClass("activated");
            };
        };
    });

    $(document).mouseup(function (e) {
        var div = $(curAsideBtn);
        var menu = div.next('.aside-menu');
        if (div.hasClass("activated")) {
            if (!div.is(e.target) && div.has(e.target).length === 0) {
                // menu.collapse("hide");
                div.removeClass("activated");

            }
        }
    });

    // Menu With icon END

  UIkit.component('modal', UIkit.component('modal').extend({
    data: {
      container: false
    }
  }));
});

function toggleMenu(){
    var aside = $(".aside");
    aside.find(".aside-btn").removeClass("activated");
    aside.find(".aside-menu").collapse("hide");
    aside.toggleClass('side-close');
    aside.hasClass('side-close') && aside.find(".sidebar").css("top", 70);
}
