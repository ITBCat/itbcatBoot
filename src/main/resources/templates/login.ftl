<!DOCTYPE html>
<html lang="zh-CN">

<!-- Mirrored from telatkaya.com/stagb/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Apr 2017 16:00:22 GMT -->
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta content="initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" name="viewport" />
    <title>登录 - ITBC</title>
    <!-- Site Properities -->
    <meta name="generator" content="Visual Studio 2015" />
    <meta name="description" content="Stagb Admin Template" />
    <meta name="keywords" content="html5, ,semantic,ui, library, framework, javascript,jquery,template,blog,stagb,template" />
    <link href="/static/dist/semantic.min.css" rel="stylesheet" />
    <link href="/static/css/main.css" rel="stylesheet" />
    <link rel="icon" type="image/png" href="/static/favicon.png" />
    <script src="/static/js/jquery-2.1.4.min.js"></script>
</head>
<body>
    <div class="ui container" style="padding-top:10%">
        <div class="ui grid center aligned">
            <div class="row">
                <div class="sixteen wide tablet six wide computer column">
                <#if msg??>
                    <div class="ui error message">
                        <i class="close icon" onclick="hideMsg()"></i>
                        <div class="header">
                            错误信息
                        </div>
                        ${msg}
                    </div>
                </#if>
                    <div class="ui left aligned segment">
                            <h1 class="ui header center aligned">
                                <img src="/static/logo.png" alt="ITBC" style="width: 224px;height: 60px;" class="ui image">
                            </h1>
                            <form class="ui form form13" action="/login" method="post">
                                <div class="field">
                                    <label>
                                        邮箱或用户名:
                                    </label>
                                    <div class="ui fluid icon input">
                                        <input name="username" id="u_name" type="email" autocomplete="off" style="width:100%!important;min-width:100%;width:100%;">
                                        <i class="icon mail outline"></i>
                                    </div>
                                </div>
                                <div class="field">
                                    <label>
                                        密码:
                                    </label>
                                    <div class="ui fluid icon input">
                                        <input name="password" id="u_pass" type="password" autocomplete="off" style="width:100%!important;min-width:100%;width:100%;">
                                        <i class="icon key"></i>
                                    </div>
                                </div>
                                <div class="field">

                                    <button type="submit" class="ui teal right labeled icon button fluid">
                                        登录
                                        <i class="icon sign in"></i>
                                    </button>

                                    <a class="ui blue right labeled icon button fluid" href="/register">
                                        注册
                                        <i class="icon spy"></i>
                                    </a>
                                </div>
                            </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="/static/dist/semantic.min.js"></script>

    <script src="/static/js/customjs/custom-validation.js"></script>
    <script>
        var colors = ["#F25F5C", "#247BA0", "#8e44ad", "#ED6A5A", "#32936F", "#2c3e50", "#E83F6F", "#32936F", "#2E294E"];
        var rand = Math.floor(Math.random() * colors.length);
        $('body').css("background-color", colors[rand]);
        /**
         * 隐藏消息
         */
        function hideMsg() {
            $('.message').hide();
        }
    </script>
</body>

<!-- Mirrored from telatkaya.com/stagb/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Apr 2017 16:00:22 GMT -->
</html>