<!DOCTYPE html>
<html lang="zh-CN">

<!-- Mirrored from telatkaya.com/stagb/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Apr 2017 16:00:22 GMT -->
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta content="initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" name="viewport" />
    <title>绑定账号 - ITBC</title>
    <!-- Site Properities -->
    <meta name="generator" content="Visual Studio 2015" />
    <meta name="description" content="Stagb Admin Template" />
    <meta name="keywords" content="html5, ,semantic,ui, library, framework, javascript,jquery,template,blog,stagb,template" />
    <link href="/static/dist/semantic.min.css" rel="stylesheet" />
    <link href="/static/css/main.css" rel="stylesheet" />
    <link rel="icon" type="image/png" href="/static/i.png" />
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

                        <div id="form1" class="ui form">

                            <h5 class="ui header center aligned">
                                您还没有绑定账号，请先绑定。
                            </h5>
                            <form action="/oauth/register" class="ui form form15" method="post">
                                <input name="oauthId" value="${oAuthInfo.oAuthId}" type="text" hidden="hidden">
                                <input name="oauthType" value="${oAuthInfo.oAuthType}" type="text" hidden="hidden">
                                <input name="oauthUserName" value="${oAuthInfo.user.username}" type="text" hidden="hidden">
                                <div class="field">
                                    <label>
                                        邮箱:
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
                                    <label>
                                        确认密码:
                                    </label>
                                    <div class="ui fluid icon input">
                                        <input name="repassword" id="u_pass" type="password" autocomplete="off" style="width:100%!important;min-width:100%;width:100%;">
                                        <i class="icon key"></i>
                                    </div>
                                </div>
                                <div class="field">
                                    <button type="submit" class="ui blue right labeled icon button fluid">
                                        绑定
                                        <i class="icon spy"></i>
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/static/js/jquery-2.1.4.min.js"></script>
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