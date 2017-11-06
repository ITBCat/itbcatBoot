<!--semantic-->
<script src="/static/dist/semantic.min.js"></script>
<!--semantic-->
<script src="/static/plugins/cookie/js.cookie.js"></script>
<script src="/static/plugins/nicescrool/jquery.nicescroll.min.js"></script>

<script data-pace-options='{ "ajax": false }' src="/static/plugins/pacejs/pace.js"></script>
<script src="/static/plugins/lobibox/js/notifications.js"></script>
<script src="/static/js/main.js"></script>
<script src="/static/js/customjs/custom-tooltip.js"></script>
<script>
    $(document).ready(function() {
        $('.navwrap').visibility({
            type: 'fixed'
        });
    });

    $('.ui.menu a.item').on('click', function () {
        $(this).addClass('active').siblings().removeClass('active');
    })

</script>
<script>
    $('.ui.reward').click( function () {
        $('.ui.modal').modal({
            inverted: true,
            blurring: false
        }).modal('show');
    })
    //Tooltip page and some tooltip trigger function
    function popupactions() {
        $("input").popup({
            on: "focus"
        });

        $("a").popup({
            on: "hover"
        });

        $(".ui.button").popup({
            on: "click"
        });
        $(".ui.image").popup();
        $(".ui.card").popup();
        $(".icon.link").popup();
        $(".avt").popup({
            position: "top center"
        });
        $('.custom.button').popup({
            popup: $('.custom.popup'),
            on: 'click'
        });
    }

    function notify(type,title,msg,img) {
        Lobibox.notify(type, {
            size: 'normal',
            rounded: false,
            delayIndicator: true,
            msg: msg,
            icon: true,
            title: title,
            showClass: 'fadeInDown',
            hideClass: 'zoomOut',
            sound: false,
            img: img,
            delay: 5000
        });
    }
</script>