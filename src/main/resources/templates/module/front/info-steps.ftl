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
    <title>Info | ITBC Admin</title>
    <meta name="description" content="Stagb Admin Template" />
    <meta name="keywords" content="html5, ,semantic,ui, library, framework, javascript,jquery,admin,template" />
    <meta name="description" content="A button indicates a possible user action" />
    <meta name="keywords" content="html5, ui, library, framework, javascript" />
    <link href="/static/dist/semantic.min.css" rel="stylesheet" />
    <link href="/static/css/main.css" rel="stylesheet" />
</head>
<body>
    <div class="ui container">
        <div class="ui grid center aligned">
            <div class="row" style="margin-top: 15%;">
                <div class="sixteen wide tablet eleven wide computer column">
                    <div class="ui three top attached steps">
                        <div class="active step">
                            <i class="mail icon"></i>
                            <div class="content">
                                <div class="title">邮箱</div>
                                <div class="description">请务必填写正确的邮箱地址</div>
                            </div>
                        </div>
                        <div class="step">
                            <i class="payment icon"></i>
                            <div class="content">
                                <div class="title">Billing</div>
                                <div class="description">Enter billing information</div>
                            </div>
                        </div>
                        <div class="step">
                            <i class="info icon"></i>
                            <div class="content">
                                <div class="title">Confirm Order</div>
                                <div class="description">Verify order details</div>
                            </div>
                        </div>
                    </div>
                    <div class="ui attached segment" style="height: 30em;">
                        <div class="ui  large icon input" style="width:80%;margin-top: 10%;margin-right: -10em;">
                            <input name="username" id="_oauth_mail" placeholder="请输入邮箱..."  type="email" autocomplete="off" style="width:100%!important;min-width:100%;width:100%;">
                            <input name="username" id="_oauth_name" type="text" value="${oAuthInfo.user.username}" hidden="hidden">
                            <input name="username" id="_oauth_type" type="text" value="${oAuthInfo.oAuthType}" hidden="hidden">
                            <input name="username" id="_oauth_id" type="text" value="${oAuthInfo.oAuthId}" hidden="hidden">
                            <i class="icon mail outline"></i>
                        </div>
                        <button class="ui redli right labeled icon button" style="float: right;margin-top: 20em;margin-right: 2em;p">下一步 <i class="right chevron icon"></i></button>
                    </div>
                </div>
            </div>
        </div>
    </div>

<script src="/static/js/jquery-2.1.4.min.js"></script>
<script src="/static/dist/semantic.min.js"></script>
<script src="/static/js/customjs/custom-validation.js"></script>
<script>

</script>
</body>
</html>