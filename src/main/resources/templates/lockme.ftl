<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from telatkaya.com/stagb/lockme.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Apr 2017 16:00:22 GMT -->
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <link rel="icon" type="image/png" href="/static/favicon.png" />
    <!-- Site Properities -->
    <meta name="generator" content="Visual Studio" />
    <title>Lock Me | ITBC Admin</title>
    <meta name="description" content="Stagb Admin Template" />
    <meta name="keywords" content="html5, ,semantic,ui, library, framework, javascript,jquery,admin,template" />
    <meta name="description" content="A button indicates a possible user action" />
    <meta name="keywords" content="html5, ui, library, framework, javascript" />
    <link href="/static/dist/semantic.min.css" rel="stylesheet" />
    <link href="/static/css/main.css" rel="stylesheet" />
</head>
<body class="lockme">
    <div class="ui container" style="padding-top:10%">
        <div class="ui grid center aligned">
            <div class="row">
                <div class="sixteen wide tablet six wide computer column">
                    <img class="ui tiny centered circular image" src="/static/img/avatar/people/Hershell.png" alt="label-image" />
                    <h5 class="ui header inverted">Savie F. Grimes</h5>
                    <form action="/login" method="post">
                        <div class="field" hidden="hidden">
                            <div class="ui fluid icon input">
                                <input name="username" id="u_name" value="${username}" type="email" autocomplete="off">
                                <i class="icon mail outline"></i>
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui action input">
                                <input name="password" id="u_pass" type="password" autocomplete="off">
                                <button type="submit" class="ui teal right labeled icon button">
                                    解锁
                                    <i class="icon key"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="/static/js/jquery-2.1.4.min.js"></script>
    <script>
        var colors = ["#F25F5C", "#247BA0", "#8e44ad", "#ED6A5A", "#32936F", "#2c3e50", "#E83F6F", "#32936F", "#2E294E"];
        var rand = Math.floor(Math.random() * colors.length);
        $('body').css("background-color", colors[rand]);
        $(function() {
            if (window.history && window.history.pushState) {
                $(window).on('popstate', function () {
                    window.history.pushState('forward', null, '#');
                    window.history.forward(1);
                });
            }
            window.history.pushState('forward', null, '#'); //在IE中必须得有这两行
            window.history.forward(1);
        })
        document.oncontextmenu=function(){return false;}
        document.onkeydown=function(event){
            var e = event || window.event || arguments.callee.caller.arguments[0];
            if(e && e.keyCode==116){
                return false;
            }
        }
    </script>
</body>

<!-- Mirrored from telatkaya.com/stagb/lockme.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Apr 2017 16:00:23 GMT -->
</html>